package com.github.itdachen.api;

import com.github.itdachen.api.service.AppSignService;
import com.github.itdachen.api.sign.SignUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * ApiSignTests
 *
 * @author 王大宸
 * @date 2024/11/3 12:55
 */
@SpringBootTest
public class ApiSignTests {

    @Autowired
    AppSignService signService;

    @Test
    void contextLoads() {
        String appId = "app1";
        long timeMillis = System.currentTimeMillis();
        String appSecret = signService.getAppKey(appId);
        String sign = SignUtils.signWithHmacSha1(appSecret, appId + "-" + appSecret + "-" + timeMillis);
        System.err.println("sign: " + sign);
        System.out.println("timeMillis = " + timeMillis);
        System.out.println("sign = " + sign);
    }

}
