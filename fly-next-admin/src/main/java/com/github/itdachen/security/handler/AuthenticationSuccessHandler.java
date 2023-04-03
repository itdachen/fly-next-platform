package com.github.itdachen.security.handler;

import com.github.itdachen.security.constants.SecurityBrowserConstants;
import com.github.itdachen.security.properties.SecurityBrowserProperties;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description: 登录成功处理器
 * Created by 王大宸 on 2022-09-23 16:36
 * Created with IntelliJ IDEA.
 */
@Component("authenticationSuccessHandler")
public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationSuccessHandler.class);

    private final SecurityBrowserProperties securityProperties;

    public AuthenticationSuccessHandler(SecurityBrowserProperties securityProperties) {
        this.securityProperties = securityProperties;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        // 获取登录时,跟账号密码同时传入的其他信息,赋值给登录用户信息
//        String netType = request.getParameter("netType");
//        CurrentUser user = (CurrentUser) authentication.getPrincipal();
//        user.setType(netType);

        String redirect_uri = request.getParameter(SecurityBrowserConstants.REDIRECT_URI);
        String targetUrl = StringUtils.isEmpty(redirect_uri) ? securityProperties.getSuccessForwardUrl() : redirect_uri;

        // 登录成功之后跳转地址
        setAlwaysUseDefaultTargetUrl(true);
        setDefaultTargetUrl(targetUrl);

        super.onAuthenticationSuccess(request, response, authentication);
    }

}
