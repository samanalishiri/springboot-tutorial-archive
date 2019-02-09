package com.springboot.tutorial.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(20);
        poolConfig.setMinIdle(2);
        poolConfig.setMaxIdle(5);

        JedisConnectionFactory factory = new JedisConnectionFactory(poolConfig);
        return factory;
    }

    @Bean
    public StringRedisSerializer stringRedisSerializer() {
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        return stringRedisSerializer;
    }

    @Bean
    public Jackson2JsonRedisSerializer<Object> jacksonJsonRedisJsonSerializer() {
        Jackson2JsonRedisSerializer<Object> jacksonJsonRedisJsonSerializer = new Jackson2JsonRedisSerializer(Object.class);
        return jacksonJsonRedisJsonSerializer;
    }
    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        final RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(stringRedisSerializer());
        template.setHashKeySerializer(stringRedisSerializer());
        template.setValueSerializer(jacksonJsonRedisJsonSerializer());
        template.setHashValueSerializer(jacksonJsonRedisJsonSerializer());
        return template;
    }
}