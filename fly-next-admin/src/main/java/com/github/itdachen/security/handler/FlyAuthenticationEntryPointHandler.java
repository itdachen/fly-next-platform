package com.github.itdachen.security.handler;

import com.github.itdachen.security.properties.SecurityBrowserProperties;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;

/**
 * Description: 匿名未登录的时候访问,需要登录的资源的调用类
 * Created by 王大宸 on 2022-09-23 16:42
 * Created with IntelliJ IDEA.
 */
public class FlyAuthenticationEntryPointHandler implements AuthenticationEntryPoint {

    private final SecurityBrowserProperties securityProperties;

    public FlyAuthenticationEntryPointHandler(SecurityBrowserProperties securityProperties) {
        this.securityProperties = securityProperties;
    }


    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authentication) throws IOException, ServletException {
        // 跳转到登录页面
        response.sendRedirect(securityProperties.getSignOutUrl());
    }
}
