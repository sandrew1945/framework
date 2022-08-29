package com.sandrew.bootsec.config.redis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

/**
 * FastDepRedis Register
 *
 * @author : louislivi
 */
@SuppressWarnings("unchecked")
public class BuryRedisRegister implements EnvironmentAware, ImportBeanDefinitionRegistrar
{

    private static final Logger logger = LoggerFactory.getLogger(BuryRedisRegister.class);
    private static Map<String, Object> registerBean = new ConcurrentHashMap<>();
    private static String STANDALONE = "standalone";
    private static final String SENTINEL = "sentinel";
    private Environment env;
    private Binder binder;

    /**
     * ImportBeanDefinitionRegistrar
     *
     * @param annotationMetadata     annotationMetadata
     * @param beanDefinitionRegistry beanDefinitionRegistry
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry)
    {
        // get all redis config
        Map<String, Map> multipleRedis;
        try
        {
            multipleRedis = binder.bind("bury.redis", Map.class).get();
        }
        catch (NoSuchElementException e)
        {
            logger.error("Failed to configure fastDep redis: 'bury.redis' attribute is not specified and no embedded redis could be configured.");
            return;
        }
        boolean onPrimary = true;
        for (String key : multipleRedis.keySet())
        {
            Map map = binder.bind("bury.redis." + key, Map.class).get();
            // GenericObjectPoolConfig
            GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
            try
            {
                RedisProperties.Pool pool = binder.bind("bury.redis." + key + ".lettuce.pool", RedisProperties.Pool.class).get();
                genericObjectPoolConfig.setMaxIdle(pool.getMaxIdle());
                genericObjectPoolConfig.setMaxTotal(pool.getMaxActive());
                genericObjectPoolConfig.setMinIdle(pool.getMinIdle());
                if (pool.getMaxWait() != null)
                {
                    genericObjectPoolConfig.setMaxWaitMillis(pool.getMaxWait().toMillis());
                }
            }
            catch (NoSuchElementException ignore)
            {
            }
            //LettuceConnectionFactory
            Supplier<LettuceConnectionFactory> lettuceConnectionFactorySupplier = () -> {
                LettuceConnectionFactory factory = (LettuceConnectionFactory) registerBean.get(key + "LettuceConnectionFactory");
                if (factory != null)
                {
                    return factory;
                }
                LettucePoolingClientConfiguration.LettucePoolingClientConfigurationBuilder builder = LettucePoolingClientConfiguration.builder();
                try
                {
                    Duration shutdownTimeout = binder.bind("bury.redis." + key + ".shutdown-timeout", Duration.class).get();
                    if (shutdownTimeout != null)
                    {
                        builder.shutdownTimeout(shutdownTimeout);
                    }
                }
                catch (NoSuchElementException ignore)
                {
                }
                LettuceClientConfiguration clientConfiguration = builder.poolConfig(genericObjectPoolConfig).build();
                // 验证是否为哨兵模式
                Map sentinelMap = (Map) map.get("sentinel");
                String mode = (null == sentinelMap) ? "standalone" : "sentinel";
                if (STANDALONE.equals(mode))
                {
                    factory = new LettuceConnectionFactory(getStandaloneConfig(map), clientConfiguration);
                }
                else
                {
                    factory = new LettuceConnectionFactory(getSentinelConfig(map), clientConfiguration);
                }
                registerBean.put(key + "LettuceConnectionFactory", factory);
                return factory;
            };
            LettuceConnectionFactory lettuceConnectionFactory = lettuceConnectionFactorySupplier.get();
            BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(LettuceConnectionFactory.class, lettuceConnectionFactorySupplier);
            AbstractBeanDefinition factoryBean = builder.getRawBeanDefinition();
            factoryBean.setPrimary(onPrimary);
            beanDefinitionRegistry.registerBeanDefinition(key + "LettuceConnectionFactory", factoryBean);
            // StringRedisTemplate
            GenericBeanDefinition stringRedisTemplate = new GenericBeanDefinition();
            stringRedisTemplate.setBeanClass(StringRedisTemplate.class);
            ConstructorArgumentValues constructorArgumentValues = new ConstructorArgumentValues();
            constructorArgumentValues.addIndexedArgumentValue(0, lettuceConnectionFactory);
            stringRedisTemplate.setConstructorArgumentValues(constructorArgumentValues);
            stringRedisTemplate.setAutowireMode(AutowireCapableBeanFactory.AUTOWIRE_BY_NAME);
            beanDefinitionRegistry.registerBeanDefinition(key + "StringRedisTemplate", stringRedisTemplate);
            // RedisTemplate
            GenericBeanDefinition redisTemplate = new GenericBeanDefinition();
            redisTemplate.setBeanClass(RedisTemplate.class);
            redisTemplate.getPropertyValues().add("connectionFactory", lettuceConnectionFactory);
            redisTemplate.setAutowireMode(AutowireCapableBeanFactory.AUTOWIRE_BY_NAME);
            beanDefinitionRegistry.registerBeanDefinition(key + "RedisTemplate", redisTemplate);
            logger.info("Registration redis ({}) !", key);
            if (onPrimary)
            {
                onPrimary = false;
            }
        }
        logger.info("Registration redis completed !");
    }

    private RedisStandaloneConfiguration getStandaloneConfig(Map propertiesMap)
    {
        if (null == propertiesMap)
        {
            throw new RuntimeException("redis配置错误");
        }
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName(String.valueOf(propertiesMap.get("host")));
        configuration.setPort(Integer.parseInt(String.valueOf(propertiesMap.get("port"))));
        configuration.setDatabase(Integer.parseInt(String.valueOf(propertiesMap.get("database"))));
        String password = String.valueOf(propertiesMap.get("password"));
        if (!StringUtils.isEmpty(password))
        {
            RedisPassword redisPassword = RedisPassword.of(password);
            configuration.setPassword(redisPassword);
        }
        return configuration;
    }

    private RedisSentinelConfiguration getSentinelConfig(Map propertiesMap)
    {
        RedisSentinelConfiguration config = new RedisSentinelConfiguration();
        String master = String.valueOf(((Map) propertiesMap.get("sentinel")).get("master"));
        String nodes = String.valueOf(((Map) propertiesMap.get("sentinel")).get("nodes"));
        String[] nodeArr = nodes.split(",");
        List<RedisNode> redisNodes = new ArrayList<>();

        Arrays.asList(nodeArr).stream().forEach(node -> {
            String[] parts = StringUtils.split(node, ":");
            Assert.state(parts.length == 2, "Must be defined as 'host:port'");
            RedisNode rn = new RedisNode(parts[0], Integer.valueOf(parts[1]));
            redisNodes.add(rn);
        });
        config.master(master);
        config.setSentinels(redisNodes);
        String password = String.valueOf(propertiesMap.get("password"));
        if (!StringUtils.isEmpty(password))
        {
            config.setPassword(RedisPassword.of(password));
        }
        config.setDatabase(Integer.parseInt(String.valueOf(propertiesMap.get("database"))));
        return config;
    }


    /**
     * init environment
     *
     * @param environment environment
     */
    @Override
    public void setEnvironment(Environment environment)
    {
        this.env = environment;
        // bing binder
        binder = Binder.get(this.env);
    }

}
