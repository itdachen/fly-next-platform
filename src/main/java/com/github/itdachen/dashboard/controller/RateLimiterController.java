package com.github.itdachen.dashboard.controller;

import com.github.itdachen.boot.rate.limiter.annotation.RedisRateLimiter;
import com.github.itdachen.boot.rate.limiter.annotation.RequestRateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 通过注解, 限流测试
 * Created by 王大宸 on 2023-07-03 14:21
 * Created with IntelliJ IDEA.
 */
@RestController
@RequestMapping("/rate/limiter")
public class RateLimiterController {
    private static final Logger logger = LoggerFactory.getLogger(RateLimiterController.class);

    /***
     * 单机版限流测试
     *
     * @author 王大宸
     * @date 2023/7/3 14:23
     * @return java.util.List<java.lang.String>
     */
    @RequestRateLimiter(key = "cachingTest", total = 1, timeout = 500, msg = "当前排队人数较多，请稍后再试！")
    @GetMapping("/caching/test")
    public List<String> cachingTest() {
        logger.info("------ 读取数据 ------");
        List<String> list = new ArrayList<>();
        list.add("蜡笔小新");
        list.add("哆啦A梦");
        list.add("四驱兄弟");

        return list;
    }

    /***
     * 分布式限流测试
     *
     * @author 王大宸
     * @date 2023/7/3 14:23
     * @return java.util.List<java.lang.String>
     */
    @RedisRateLimiter(key = "cachingTest", total = 2, msg = "当前排队人数较多，请稍后再试！")
    @GetMapping("/redis/caching/test")
    public List<String> redisCachingTest() {
        logger.info("------ 读取数据 ------");
        List<String> list = new ArrayList<>();
        list.add("蜡笔小新");
        list.add("哆啦A梦");
        list.add("四驱兄弟");

        return list;
    }

}
