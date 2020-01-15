package com.yangwulang.alibookstorewebuser.config;

import com.yangwulang.utils.RedisUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author yangwulang
 */
@Configuration
public class RedisConfig {
    /**
     * 获得redisTemplate并改变其序列化方式
     * @param redisTemplate springboot中已有的bean
     * @return redisTemplate
     */
    @Bean
    public RedisTemplate<?, ?> setRedisTemplate(RedisTemplate<?, ?> redisTemplate) {
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
        return redisTemplate;
    }

    @Bean
    public RedisUtils getInstance() {
        return new RedisUtils();
    }
}
