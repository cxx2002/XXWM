package com.cxx.reggie.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;

/**
 * @author 陈喜喜
 * @date 2022-09-10 17:03
 * <p>
 * Redis配置类，配置Key的序列化器
 * 这里不使用redis配置类，因为版本兼容问题会无法装配RedisConnectionFactory
 * 到时候就直接用StringRedisTemplate
 */
@Configuration
public class RedisConfig extends CachingConfigurerSupport {
    @Resource
    private
    RedisConnectionFactory connectionFactory;

    @Bean
    public RedisTemplate<Object, Object> redisTemplate() {

        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();

        //默认的Key序列化器为：JdkSerializationRedisSerializer
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //redisTemplate.setValueSerializer(new StringRedisSerializer())

        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        //redisTemplate.setHashValueSerializer(new StringRedisSerializer())

        redisTemplate.setConnectionFactory(connectionFactory);

        return redisTemplate;
    }
}
