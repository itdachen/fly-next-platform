package com.github.itdachen.admin.dashboard;

import com.github.itdachen.framework.context.annotation.IgnoreResponseAdvice;
import com.github.itdachen.security.client.WebAppClientConfig;
import com.github.itdachen.security.constants.SecurityConstants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description: 跳转到登录页面
 * Created by 王大宸 on 2022-09-25 15:51
 * Created with IntelliJ IDEA.
 */
@Controller
public class LoginController {

    private final Environment environment;
    private final WebAppClientConfig webAppClientConfig;

    public LoginController(WebAppClientConfig webAppClientConfig, Environment environment) {
        this.webAppClientConfig = webAppClientConfig;
        this.environment = environment;
    }

    @GetMapping("/login")
    public String login(ModelMap modelMap,
                        @RequestParam(required = false) String redirect_uri) {
        modelMap.put("platformName", webAppClientConfig.getName());
        modelMap.put("platformDescribe", webAppClientConfig.getRemarks());

        modelMap.put("copyrightYear", webAppClientConfig.getCopyrightYear());
        modelMap.put("clientName", webAppClientConfig.getName());
        modelMap.put("copyright", webAppClientConfig.getCopyright());
        modelMap.put("version", webAppClientConfig.getVersion());
        modelMap.put("issuer", webAppClientConfig.getIssuer());


        /* 登录认证地址 */
        String property = environment.getProperty("server.servlet.context-path");
        String targetUrl = "";
        if (null == property || "".equals(property) || "null".equals(property)) {
            targetUrl = StringUtils.isEmpty(redirect_uri) ? SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM : SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM + "?redirect_uri=" + redirect_uri;
        } else {
            targetUrl = StringUtils.isEmpty(redirect_uri) ? property + SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM : property + SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM + "?redirect_uri=" + redirect_uri;
        }

        modelMap.put("authForm", targetUrl);
        return "login";
    }

    @GetMapping("/favicon")
    @ResponseBody
    @IgnoreResponseAdvice
    public String favicon() {
        return "favicon";
    }

    @GetMapping("/favicon.ico")
    @ResponseBody
    @IgnoreResponseAdvice
    public String faviconICO() {
        return "favicon";
    }


}
