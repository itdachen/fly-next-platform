package com.github.itdachen.security;

import com.github.itdachen.framework.security.websecurity.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Description: 安全认证模块, 安全配置, 勿动
 * 引入 fly-security 模块, 安全认证集成模块
 * Created by 王大宸 on 2023/02/07 10:57
 * Created with IntelliJ IDEA.
 */
@Configuration
// 添加 security 过滤器
@EnableWebSecurity
// 开启方法权限注解
@EnableMethodSecurity
public class WebSecurityConfiguration {

    private final IFlySecurityFormLogin securityFormLogin;
    private final IFlySecurityLogout logout;
    private final IFlySecurityAuthorizeHttpRequests authorizeHttpRequests;
    private final IFlySecurityCsrf securityCsrf;
    private final IFlySecurityRememberMe rememberMe;
    private final IFlySecuritySessionManagement sessionManagement;
    private final IFlySecurityExceptionHandling exceptionHandling;

    public WebSecurityConfiguration(IFlySecurityFormLogin securityFormLogin,
                                    IFlySecurityLogout logout,
                                    IFlySecurityAuthorizeHttpRequests authorizeHttpRequests,
                                    IFlySecurityCsrf securityCsrf,
                                    IFlySecurityRememberMe rememberMe,
                                    IFlySecuritySessionManagement sessionManagement,
                                    IFlySecurityExceptionHandling exceptionHandling) {
        this.securityFormLogin = securityFormLogin;
        this.logout = logout;
        this.authorizeHttpRequests = authorizeHttpRequests;
        this.securityCsrf = securityCsrf;
        this.rememberMe = rememberMe;
        this.sessionManagement = sessionManagement;
        this.exceptionHandling = exceptionHandling;
    }

    /***
     * 指定加密方式
     *
     * @author 王大宸
     * @date 2023/7/9 15:01
     * @return org.springframework.security.crypto.password.PasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    /***
     * WebSecurityConfigurerAdapter 被弃用, 替代方案: 申明 SecurityFilterChain 的Bean
     *
     * @author 王大宸
     * @date 2022/10/16 0:53
     * @param http http
     * @return org.springframework.security.web.SecurityFilterChain
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        /**
         * 表单登录
         */
        securityFormLogin.formLogin(http);

        /**
         * 请求认证
         */
        authorizeHttpRequests.authorizeHttpRequests(http);

        /**
         * 记住我
         */
        rememberMe.rememberMe(http);

        /**
         * session 管理
         */
        sessionManagement.sessionManagement(http);

        /**
         * 退出登录
         */
        logout.logout(http);

        /**
         * 错误处理
         */
        exceptionHandling.exceptionHandling(http);

        securityCsrf.csrf(http);

        return http.build();
    }


}
