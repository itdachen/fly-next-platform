package com.github.itdachen.security;

import com.github.itdachen.framework.security.WebSecurityConfigurerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.context.DelegatingSecurityContextRepository;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.RequestAttributeSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;

/***
 * 安全认证模块, 安全配置, 勿动
 * 引入 fly-security 模块, 安全认证集成模块
 * @author 王大宸
 * @date 2023/02/07 10:57
 */
@Configuration
// 添加 security 过滤器
@EnableWebSecurity
// 开启方法权限注解
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {


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
     * WebSecurityConfigurerAdapter 被弃用, 替代方案: 申明 SecurityFilterChain 的 Bean
     *
     * @author 王大宸
     * @date 2022/10/16 0:53
     * @param http http
     * @return org.springframework.security.web.SecurityFilterChain
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        /**
         * 默认集成安全认证, 可从写 WebSecurityConfigurerAdapter 类中的方法
         */
        configure(http);

        http.securityContext((context) -> context
                .securityContextRepository(securityContextRepository())
        );

        /* 自定义手机号码登录 */
        //  http.apply(smsAuthenticationSecurityConfigurer);

        return http.build();
    }

//    @Bean
//    public SmsAuthenticationSecurityConfigurer phoneAuthenticationSecurityConfigurer() {
//        return new SmsAuthenticationSecurityConfigurer(authenticationSuccessHandler,
//                authenticationFailureHandler,
//                userDetailsService);
//    }


    @Bean
    public SecurityContextRepository securityContextRepository() {
        return new DelegatingSecurityContextRepository(
                new RequestAttributeSecurityContextRepository(), new HttpSessionSecurityContextRepository());
    }


}
