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
 * @date 2022-09-10 17:45
 * <p>
 * Redis配置类，配置Key的序列化器
 * 这里不使用Redis配置类，因为会有版本兼容问题导致无法自动装配（没有找到对应的bean）RedisConnectionFactory
 */
@Configuration
public class RedisConfig extends CachingConfigurerSupport {
    @Resource
    private
    RedisConnectionFactory connectionFactory;

    @Bean
    public RedisTemplate<Object, Object> redisTemplate(/*RedisConnectionFactory connectionFactory*/) {

        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();

        //默认的Key序列化器为：JdkSerializationRedisSerializer
        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setValueSerializer(new StringRedisSerializer())

        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
//        redisTemplate.setHashValueSerializer(new StringRedisSerializer())

        redisTemplate.setConnectionFactory(connectionFactory);

        return redisTemplate;
    }
}
