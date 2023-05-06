package com.github.itdachen.security;


import com.github.itdachen.admin.service.impl.AdminSecurityUserDetailsService;
import com.github.itdachen.admin.service.impl.AdminUserDetailsPasswordService;
import com.github.itdachen.security.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.github.itdachen.security.constants.SecurityConstants;
import com.github.itdachen.security.handler.FlyAccessDeniedExceptionHandler;
import com.github.itdachen.security.matchers.IFilterMatchers;
import com.github.itdachen.security.properties.SecurityBrowserProperties;
import com.github.itdachen.security.rememberme.CustomJdbcPersistentTokenRepository;
import com.github.itdachen.security.validate.code.filter.ValidateCodeFilter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import javax.sql.DataSource;

/**
 * Description: 安全认证模块, 安全配置, 勿动
 * Created by 王大宸 on 2023/02/07 10:57
 * Created with IntelliJ IDEA.
 */
@Configuration
// 添加 security 过滤器
@EnableWebSecurity
@EnableConfigurationProperties(SecurityBrowserProperties.class)
// 开启方法权限注解
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration {
    /* 不需要认证的路径 */
    private final IFilterMatchers filterMatchers;
    /* 安全配置文件 */
    private final SecurityBrowserProperties securityProperties;
    private final DataSource dataSource;
    private final AdminSecurityUserDetailsService userDetailsService;
    private final AdminUserDetailsPasswordService adminUserDetailsPasswordService;
    /* 退出处理 */
    private final LogoutSuccessHandler logoutSuccessHandler;
    /* 登录成功处理 */
    private final AuthenticationSuccessHandler authenticationSuccessHandler;
    /* 登录失败处理 */
    private final AuthenticationFailureHandler authenticationFailureHandler;
    /* session 过期处理 */
    private final SessionInformationExpiredStrategy sessionInformationExpiredStrategy;
    /* session 失效处理 */
    private final InvalidSessionStrategy invalidSessionStrategy;
    /* 权限异常配置 */
    private final FlyAccessDeniedExceptionHandler accessDeniedExceptionHandler;
    /* 短信验证码登录 */
    private final SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;
    private final ValidateCodeFilter validateCodeFilter;

    public WebSecurityConfiguration(IFilterMatchers filterMatchers,
                                    SecurityBrowserProperties securityProperties,
                                    AuthenticationSuccessHandler authenticationSuccessHandler,
                                    AuthenticationFailureHandler authenticationFailureHandler,
                                    DataSource dataSource,
                                    AdminSecurityUserDetailsService userDetailsService,
                                    LogoutSuccessHandler logoutSuccessHandler,
                                    SessionInformationExpiredStrategy sessionInformationExpiredStrategy,
                                    InvalidSessionStrategy invalidSessionStrategy,
                                    FlyAccessDeniedExceptionHandler accessDeniedExceptionHandler,
                                    SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig,
                                    AdminUserDetailsPasswordService adminUserDetailsPasswordService,
                                    ValidateCodeFilter validateCodeFilter) {
        this.filterMatchers = filterMatchers;
        this.securityProperties = securityProperties;
        this.authenticationSuccessHandler = authenticationSuccessHandler;
        this.authenticationFailureHandler = authenticationFailureHandler;
        this.dataSource = dataSource;
        this.userDetailsService = userDetailsService;
        this.logoutSuccessHandler = logoutSuccessHandler;
        this.sessionInformationExpiredStrategy = sessionInformationExpiredStrategy;
        this.invalidSessionStrategy = invalidSessionStrategy;
        this.accessDeniedExceptionHandler = accessDeniedExceptionHandler;
        this.smsCodeAuthenticationSecurityConfig = smsCodeAuthenticationSecurityConfig;
        this.adminUserDetailsPasswordService = adminUserDetailsPasswordService;
        this.validateCodeFilter = validateCodeFilter;
    }

    /**
     * 获取AuthenticationManager（认证管理器），登录时认证使用
     */
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }

    /**
     * 允许抛出用户不存在的异常
     *
     * @return DaoAuthenticationProvider
     */
//    @Bean
//    public DaoAuthenticationProvider daoAuthenticationProvider() {
//        final DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setUserDetailsService(userDetailsService);
//        provider.setUserDetailsPasswordService(adminUserDetailsPasswordService);
//        provider.setHideUserNotFoundExceptions(false);
//        return provider;
//    }

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
        /* 短信验证码登录 */
        http.apply(smsCodeAuthenticationSecurityConfig);
        // .addFilterBefore(new SmsCodeAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)


        // http.addFilterAt(mobileAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        /* 表单登录 */
        http.formLogin(login -> login
                .loginPage(securityProperties.getSignInPage()) // 登录页面路径
                .loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM) // 登录访问后台认证地址
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler)
                .permitAll()
        );

        //  http.addFilterAt(smsCodeAuthenticationSecurityConfig, UsernamePasswordAuthenticationFilter.class);

        /* 授权请求控制 */
        http.authorizeHttpRequests()
                .requestMatchers(filterMatchers.matchers())
                .permitAll()
                .anyRequest().authenticated();

        /*
         * 记住我, 原理: 使用 Cookie 存储用户名, 过期时间, 以及一个 Hash
         *  Hash: md5 (用户名 + 过期时间 + 密码 + key), 如果中途改过密码, 则记住我失效
         */
        http.rememberMe(rememberMe -> rememberMe
                .alwaysRemember(securityProperties.getRememberMe().getAlwaysRemember())
                .key(securityProperties.getRememberMe().getRememberMeKey()) // 记住我加密 key
                .rememberMeCookieName(securityProperties.getRememberMe().getRememberMeCookieName()) // cookie 记住我 key,
                .rememberMeCookieDomain(securityProperties.getRememberMe().getRememberMeCookieDomain())
                .tokenValiditySeconds(securityProperties.getRememberMe().getRememberMeSeconds()) // 过期时间, 单位, 秒
                .tokenRepository(persistentTokenRepository())  // 指定token存储方式
                .authenticationSuccessHandler(authenticationSuccessHandler)
                .userDetailsService(userDetailsService) // 查询用户的接口
        );

        /* 退出登录 */
        http.logout(logout -> logout
                        // 退出登录访问地址
                        .logoutUrl(securityProperties.getLogout())
                        // 删除浏览器里面 cookie 里面的认证信息
                        .deleteCookies("JSESSIONID", "SESSION",
                                securityProperties.getRememberMe().getRememberMeCookieName()
                        )
                        // Handler 和 url 是互斥的,只能配置一个, 如果配置了 Handler 就会交给 Handler 来处理
                        .logoutSuccessHandler(logoutSuccessHandler)
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                // .logoutSuccessUrl(securityProperties.getSignInPage())   // 退出成功之后跳转地址
        );

        /* 权限异常配置 */
        http.exceptionHandling(handler -> handler
                .accessDeniedHandler(accessDeniedExceptionHandler)
        );

        /* session 管理 */
        http.sessionManagement()
                /*
                 * Spring Security下的枚举 SessionCreationPolicy, 管理session的创建策略
                 *   ALWAYS :总是创建HttpSession
                 *   IF_REQUIRED: Spring Security只会在需要时创建一个HttpSession
                 *   NEVER: Spring Security不会创建HttpSession，但如果它已经存在，将可以使用HttpSession
                 *   STATELESS: Spring Security永远不会创建HttpSession，它不会使用HttpSession来获取SecurityContext
                 */
                // .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                /* 会话失效 */
                .invalidSessionStrategy(invalidSessionStrategy)
                /* 限制同一账号最大同时在线 */
                .maximumSessions(securityProperties.getSession().getMaximumSessions())
                .maxSessionsPreventsLogin(securityProperties.getSession().getMaxSessionsPreventsLogin())
                /* 会话过期后的配置 */
                .expiredSessionStrategy(sessionInformationExpiredStrategy);

        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class);


        return http.csrf(AbstractHttpConfigurer::disable)
                // .cors(cors -> cors.configurationSource(corsConfigurationSource())) // 跨越配置
                .headers().frameOptions().sameOrigin()
                .and().build();
    }

    /***
     * 我们在 Spring Boot 中有几种其他方式配置 CORS ( 这里交给 nginx 去处理, Nginx 不配置跨越处理, 则放开这个 Bean )
     * 参见 https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc-cors
     * Mvc 的配置方式见 WebMvcConfig 中的代码
     *
     * @author 王大宸
     * @date 2022/10/16 0:59
     * @return org.springframework.web.cors.CorsConfigurationSource
     */
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        // 允许跨域访问的主机
//        configuration.setAllowedOrigins(Collections.singletonList(securityProperties.getRememberMe().getCorsCookieDomain()));
//        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
//        configuration.setAllowedHeaders(Collections.singletonList("*"));
//        configuration.addExposedHeader("X-Authenticate");
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }

    /***
     * configure(WebSecurity web) 已经弃用, 替代方案: 申明 WebSecurityCustomizer 的 Bean
     *
     * @author 王大宸
     * @date 2022/10/16 0:54
     * @return org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer
     */
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return web -> web.ignoring()
//                .antMatchers(filterMatchers.matchers())
//                .requestMatchers(PathRequest.toStaticResources().atCommonLocations());
//    }


    /***
     * 记住我 持久化指定保存 session 的方法
     *
     * @author 王大宸
     * @date 2022/9/23 16:56
     * @return org.springframework.security.web.authentication.rememberme.PersistentTokenRepository
     */
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
//        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
//        tokenRepository.setDataSource(dataSource);
//        return tokenRepository;

        final CustomJdbcPersistentTokenRepository tokenRepository = new CustomJdbcPersistentTokenRepository();
        tokenRepository.setDataSource(dataSource);
        return tokenRepository;
    }


    /***
     * 配置跨源访问(CORS)
     *
     * @author 王大宸
     * @date 2022/9/25 13:05
     * @return org.springframework.web.cors.CorsConfigurationSource
     */
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
//        return source;
//    }


}
