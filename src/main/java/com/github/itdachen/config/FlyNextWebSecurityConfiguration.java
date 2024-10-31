package com.github.itdachen.config;

import com.github.itdachen.boot.security.config.WebSecurityConfigurerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
/**
 * 安全认证模块, 安全配置, 勿动
 * 引入 security-spring-boot-starter 模块, 安全认证集成模块
 *  https://zhuanlan.zhihu.com/p/708800025
 * @author 王大宸
 * @date 2024/4/29 22:19
 */
@Configuration
@EnableWebSecurity
// 开启方法权限注解, 这里必须设置 proxyTargetClass = true, 不然不生效
@EnableMethodSecurity(proxyTargetClass = true)
public class FlyNextWebSecurityConfiguration extends WebSecurityConfigurerAdapter {

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




}
