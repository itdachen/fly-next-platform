package com.github.itdachen.api.controller;

import com.github.itdachen.api.service.AppSignService;
import com.github.itdachen.api.sign.SignUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * AppSignController
 *
 * @author 王大宸
 * @date 2024/11/3 12:54
 */
@Controller
@RequestMapping("/open/api")
public class AppSignController {
    private static final Logger logger = LoggerFactory.getLogger(AppSignController.class);


    @Autowired
    private AppSignService signService;

    @GetMapping("/verify")
    @ResponseBody
    public Object verify(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String appId = request.getHeader("appId");
        String timestamp = request.getHeader("timestamp");
        String sign = request.getHeader("sign");
        if (StringUtils.hasText(appId) && StringUtils.hasText(timestamp) && StringUtils.hasText(sign)) {
            if (LocalDateTime.now().compareTo(
                    LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.parseLong(timestamp)),
                            ZoneId.systemDefault()).plusMinutes(1L)) < 0) {
                String appKey = signService.getAppKey(appId);
                String originalSign = appId + "-" + appKey + "-" + timestamp;
                if (SignUtils.verify(appKey, originalSign, sign)) {
                    return true;
                } else {
                    logger.error("签名验证失败");
                }
            } else {
                logger.error("签名已过期");
            }
        } else {
            logger.error("签名信息不完整");
        }
        response.setStatus(401);
        return false;
    }

}
