package com.github.itdachen.dashboard;

import com.github.itdachen.boot.autoconfigure.app.AppInfoProperties;
import com.github.itdachen.boot.autoconfigure.security.constants.SecurityConstants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 跳转到登录页面
 *
 * @author 王大宸
 * @date 2024/4/16 22:45
 */
@Controller
public class LoginController {
    private final Environment environment;
    private final AppInfoProperties appInfoProperties;

    public LoginController(AppInfoProperties appInfoProperties, Environment environment) {
        this.appInfoProperties = appInfoProperties;
        this.environment = environment;
    }

    @GetMapping("/login")
    public String login(ModelMap modelMap, @RequestParam(required = false) String redirect_uri) {
        modelMap.put("platformName", appInfoProperties.getAppName());
        modelMap.put("platformDescribe", appInfoProperties.getRemarks());

        modelMap.put("copyrightYear", appInfoProperties.getYearly());
        modelMap.put("clientName", appInfoProperties.getAppName());
        modelMap.put("copyright", appInfoProperties.getCopyright());
        modelMap.put("version", appInfoProperties.getVersion());
        modelMap.put("issuer", appInfoProperties.getIssuer());

        /* 登录认证地址 */
        String contextPath = environment.getProperty("server.servlet.context-path");
        String targetUrl = "", smsTargetUrl = "";
        if (null == contextPath || "".equals(contextPath) || "null".equals(contextPath)) {
            targetUrl = StringUtils.isEmpty(redirect_uri) ? SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM : SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM + "?redirect_uri=" + redirect_uri;
            smsTargetUrl = StringUtils.isEmpty(redirect_uri) ? SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE : SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE + "?redirect_uri=" + redirect_uri;
        } else {
            targetUrl = StringUtils.isEmpty(redirect_uri) ? contextPath + SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM : contextPath + SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM + "?redirect_uri=" + redirect_uri;
            smsTargetUrl = StringUtils.isEmpty(redirect_uri) ? contextPath + SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE : contextPath + SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE + "?redirect_uri=" + redirect_uri;
        }

        modelMap.put("authForm", targetUrl);
        modelMap.put("smsAuthForm", smsTargetUrl);
        return "login2";
    }

}
