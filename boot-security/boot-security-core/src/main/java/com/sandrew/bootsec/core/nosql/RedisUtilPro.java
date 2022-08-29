package com.sandrew.bootsec.core.nosql;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RedisUtilPro
{
    @Resource
    private StringRedisTemplate esredisStringRedisTemplate;

    @Resource
    private StringRedisTemplate ssnredisStringRedisTemplate;

    @Resource
    private RedisTemplate esredisRedisTemplate;

    @Resource
    private RedisTemplate ssnredisRedisTemplate;

    public RedisTemplate redisTemplate(String name)
    {
        RedisTemplate redisTemplate;
        RedisSerializer<Object> redisSerializer = null;
        switch (name)
        {
            case "ssn":
                redisTemplate = ssnredisRedisTemplate;
                redisSerializer = new JdkSerializationRedisSerializer();
                break;
            default:
                redisTemplate = esredisRedisTemplate;
                Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
                ObjectMapper mapper = new ObjectMapper();
                mapper.registerModule(new JavaTimeModule());
                mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
                jackson2JsonRedisSerializer.setObjectMapper(mapper);
                redisSerializer = jackson2JsonRedisSerializer;
                break;
        }
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(redisSerializer);
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(redisSerializer);
        return redisTemplate;
    }

    public StringRedisTemplate stringRedisTemplate(String name)
    {
        StringRedisTemplate stringRedisTemplate;
        switch (name)
        {
            case "ssn":
                stringRedisTemplate = esredisStringRedisTemplate;
                break;
            default:
                stringRedisTemplate = ssnredisStringRedisTemplate;
                break;
        }
        stringRedisTemplate.setEnableTransactionSupport(true);
        return stringRedisTemplate;
    }
}
