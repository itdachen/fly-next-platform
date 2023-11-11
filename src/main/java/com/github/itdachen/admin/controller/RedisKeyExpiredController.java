package com.github.itdachen.admin.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * Description: Redis Key 过期监听测试
 * Created by 王大宸 on 2023-08-28 16:11
 * Created with IntelliJ IDEA.
 */
@RestController
@RequestMapping("/redis/key")
public class RedisKeyExpiredController {

    private final RedisTemplate<String, String> redisTemplate;

    public RedisKeyExpiredController(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /***
     * 添加一个 redis 数据, 默认过期时间: 20 秒
     *
     * @author 王大宸
     * @date 2023/8/28 16:15
     * @return java.lang.String
     */
    @GetMapping("/add")
    public String addKey(@RequestParam(defaultValue = "test_key", required = false)
                         String key) {
        redisTemplate.opsForValue().set(key, "123", 20, TimeUnit.SECONDS);
        return "OK";
    }

}
