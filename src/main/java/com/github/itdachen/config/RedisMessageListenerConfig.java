package com.github.itdachen.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

/**
 * Description: 开启 redis过期监听
 * Created by 王大宸 on 2023-08-28 16:05
 * Created with IntelliJ IDEA.
 */
@Configuration
@EnableCaching
public class RedisMessageListenerConfig {

    /***
     * 开启 redis过期监听
     * redis key 过期事件订阅需要
     *
     * @author 王大宸
     * @date 2023/8/28 16:26
     * @param redisConnectionFactory redisConnectionFactory
     * @return org.springframework.data.redis.listener.RedisMessageListenerContainer
     */
    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer(RedisConnectionFactory redisConnectionFactory) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory);
        return container;
    }

}
