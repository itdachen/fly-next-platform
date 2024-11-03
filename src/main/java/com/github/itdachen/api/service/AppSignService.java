package com.github.itdachen.api.service;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * AppSignService
 *
 * @author 王大宸
 * @date 2024/11/3 12:54
 */
@Service
public class AppSignService {

    private static final Map<String, String> APP_INFO = Map.of("app1", "sign1", "app2", "sign2");

    public String getAppKey(String appId) {
        String s = APP_INFO.get(appId);
        return s;
    }

}
