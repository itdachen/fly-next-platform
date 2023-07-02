package com.github.itdachen.security.handler;

import com.github.itdachen.dashboard.service.IAuthSuccessService;
import com.github.itdachen.security.constants.SecurityBrowserConstants;
import com.github.itdachen.security.properties.SecurityBrowserProperties;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Description: 登录成功处理器
 * Created by 王大宸 on 2022-09-23 16:36
 * Created with IntelliJ IDEA.
 */
@Component
public class FlyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    private static final Logger logger = LoggerFactory.getLogger(FlyAuthenticationSuccessHandler.class);

    private final SecurityBrowserProperties securityProperties;
    private final IAuthSuccessService authSuccessService;

    public FlyAuthenticationSuccessHandler(SecurityBrowserProperties securityProperties,
                                           IAuthSuccessService authSuccessService) {
        this.securityProperties = securityProperties;
        this.authSuccessService = authSuccessService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        // 获取登录时,跟账号密码同时传入的其他信息,赋值给登录用户信息
//        String netType = request.getParameter("netType");
//        CurrentUser user = (CurrentUser) authentication.getPrincipal();
//        user.setType(netType);

        /**
         * 登录记录入库
         */
        authSuccessService.onAuthenticationSuccess(request, authentication, request.getSession().getId());

        String redirect_uri = request.getParameter(SecurityBrowserConstants.REDIRECT_URI);
        String targetUrl = StringUtils.isEmpty(redirect_uri) ? securityProperties.getSuccessForwardUrl() : redirect_uri;



        // 登录成功之后跳转地址
        setAlwaysUseDefaultTargetUrl(true);
        setDefaultTargetUrl(targetUrl);

        super.onAuthenticationSuccess(request, response, authentication);
    }

}
