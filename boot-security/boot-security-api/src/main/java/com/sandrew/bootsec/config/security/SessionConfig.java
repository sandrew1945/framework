/**
 * Copyright (C), 2015-2022, 东北证券股份有限公司
 * FileName: SessionConfig
 * Author:   summer
 * Date:     2022/9/1 10:05
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 **/

package com.sandrew.bootsec.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.session.FlushMode;
import org.springframework.session.IndexResolver;
import org.springframework.session.SaveMode;
import org.springframework.session.Session;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;
import org.springframework.session.data.redis.RedisIndexedSessionRepository;

import javax.annotation.Resource;

/**
 * @ClassName SessionConfig
 * @Description
 * @Author summer
 * @Date 2022/9/1 10:05
 **/
@EnableSpringHttpSession
public class SessionConfig
{
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired(required = false)
    private IndexResolver<Session> indexResolver;

    @Qualifier("springSessionDefaultRedisSerializer")
    private RedisSerializer<Object> defaultRedisSerializer;

    @Resource
    private RedisTemplate ssnredisRedisTemplate;


    @Bean
    public RedisIndexedSessionRepository sessionRepository() {
        ssnredisRedisTemplate.setKeySerializer(new StringRedisSerializer());
        ssnredisRedisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        ssnredisRedisTemplate.setHashKeySerializer(new StringRedisSerializer());
        ssnredisRedisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer());
        RedisIndexedSessionRepository sessionRepository = new RedisIndexedSessionRepository(ssnredisRedisTemplate);
        sessionRepository.setApplicationEventPublisher(this.applicationEventPublisher);
        if (this.indexResolver != null) {
            sessionRepository.setIndexResolver(this.indexResolver);
        }

        if (this.defaultRedisSerializer != null) {
            sessionRepository.setDefaultSerializer(this.defaultRedisSerializer);
        }

        sessionRepository.setFlushMode(FlushMode.ON_SAVE);
        sessionRepository.setSaveMode(SaveMode.ON_SET_ATTRIBUTE);
        return sessionRepository;
    }
}
