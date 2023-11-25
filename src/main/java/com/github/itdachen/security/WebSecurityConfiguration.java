package com.github.itdachen.security;

import com.github.itdachen.framework.autoconfigure.security.constants.SecurityConstants;
import com.github.itdachen.framework.autoconfigure.security.properties.FlySecurityProperties;
import com.github.itdachen.framework.autoconfigure.security.properties.rememberme.FlySecurityRememberMeProperties;
import com.github.itdachen.framework.autoconfigure.security.properties.session.FlySecuritySessionProperties;
import com.github.itdachen.framework.security.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.github.itdachen.framework.security.details.AbstractSecurityUserDetailsService;
import com.github.itdachen.framework.security.handler.FlyAccessDeniedExceptionHandler;
import com.github.itdachen.framework.security.matchers.IFilterMatchers;
import com.github.itdachen.framework.security.validate.code.filter.ValidateCodeFilter;
import com.github.itdachen.framework.security.websecurity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration {

    @Autowired
    private RequestAuthorizationManager requestAuthorizationManager;
    @Autowired
    private IFilterMatchers filterMatchers;
    @Autowired
    private FlyAccessDeniedExceptionHandler accessDeniedExceptionHandler;
    @Autowired
    private ValidateCodeFilter validateCodeFilter;
    /* 短信验证码登录 */
    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;
    /* 登录成功处理 */
    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;
    /* 登录失败处理 */
    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;
    @Autowired
    private FlySecurityProperties securityProperties;
    @Autowired
    private LogoutSuccessHandler logoutSuccessHandler;
    @Autowired
    private FlySecurityRememberMeProperties rememberMeProperties;
    //    @Autowired
//    private FlySecurityRememberMeProperties rememberMeProperties;
//    /* 登录成功处理 */
//    @Autowired
//    private AuthenticationSuccessHandler authenticationSuccessHandler;
    @Autowired
    private AbstractSecurityUserDetailsService userDetailsService;
    @Autowired
    private PersistentTokenRepository persistentTokenRepository;
    @Autowired
    private FlySecuritySessionProperties sessionProperties;
    /* session 过期处理 */
    @Autowired
    private SessionInformationExpiredStrategy sessionInformationExpiredStrategy;
    /* session 失效处理 */
    @Autowired
    private InvalidSessionStrategy invalidSessionStrategy;

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
        //   securityFormLogin.formLogin(http);

        /* 验证码过滤器 */
        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class);

        /* 短信验证码登录 */
        http.apply(smsCodeAuthenticationSecurityConfig);

        /* 表单登录 */
        http.formLogin(login -> login
                .loginPage(securityProperties.getSignInPage()) // 登录页面路径
                .loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM) // 登录访问后台认证地址
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler)
                .permitAll()
        );

        /**
         * 请求认证
         */
        // authorizeHttpRequests.authorizeHttpRequests(http);

        /**
         * 记住我
         */
        //  rememberMe.rememberMe(http);

        http.rememberMe(rememberMe -> rememberMe
                .alwaysRemember(rememberMeProperties.getAlwaysRemember())
                .key(rememberMeProperties.getKey()) // 记住我加密 key
                .rememberMeCookieName(rememberMeProperties.getCookieName()) // cookie 记住我 key,
                .rememberMeCookieDomain(rememberMeProperties.getCookieDomain())
                .tokenValiditySeconds(rememberMeProperties.getSeconds()) // 过期时间, 单位, 秒
                .tokenRepository(persistentTokenRepository)  // 指定token存储方式
                .authenticationSuccessHandler(authenticationSuccessHandler)
                .userDetailsService(userDetailsService) // 查询用户的接口
        );

        /**
         * session 管理
         */
        // sessionManagement.sessionManagement(http);

        /* session 管理 */
        http.sessionManagement(session -> session
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
                .maximumSessions(sessionProperties.getMaximumSessions())
                .maxSessionsPreventsLogin(sessionProperties.getMaxSessionsPreventsLogin())
                /* 会话过期后的配置 */
                .expiredSessionStrategy(sessionInformationExpiredStrategy));

        /**
         * 退出登录
         */
        //  logout.logout(http);
        /* 退出登录 */
        http.logout(logout -> logout
                        // 退出登录访问地址
                        .logoutUrl(securityProperties.getLogout())
                        // 删除浏览器里面 cookie 里面的认证信息
                        .deleteCookies("JSESSIONID", "SESSION",
                                rememberMeProperties.getCookieName()
                        )
                        // Handler 和 url 是互斥的,只能配置一个, 如果配置了 Handler 就会交给 Handler 来处理
                        .logoutSuccessHandler(logoutSuccessHandler)
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                // .logoutSuccessUrl(securityProperties.getSignInPage())   // 退出成功之后跳转地址
        );

        /**
         * 错误处理
         */
        //  exceptionHandling.exceptionHandling(http);
        /* 权限异常配置 */
        http.exceptionHandling(handler -> handler
                .accessDeniedHandler(accessDeniedExceptionHandler)
        );

        //  securityCsrf.csrf(http);

        // RBAC 动态 url 认证

//        http.authorizeHttpRequests(authorize -> authorize
//                .anyRequest()
//                .authenticated()
//                .anyRequest()
//                .access(requestAuthorizationManager)
//        );


        http.authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(requestMatcher()).permitAll()
                        .anyRequest()
                        //                            .authenticated()
                        .access(requestAuthorizationManager)

//                .access((authentication, request) -> {
//
//                    Collection<? extends GrantedAuthority> authorities = authentication.get().getAuthorities();
//
//                    //表示请求的 URL 地址和数据库的地址是否匹配上了
//                    boolean isMatch = false;
//                    //获取当前请求的 URL 地址
//                    String requestURI = request.getRequest().getRequestURI();
//                    String method = request.getRequest().getMethod();
//                    System.err.println("method ==> " + method);
//                    System.err.println("requestURI ==> " + requestURI);
//
//
////                    List<MenuWithRoleVO> menuWithRole = menuService.getMenuWithRole();
////                    for (MenuWithRoleVO m : menuWithRole) {
////                        if (antPathMatcher.match(m.getUrl(), requestURI)) {
////                            isMatch = true;
////                            //说明找到了请求的地址了
////                            //这就是当前请求需要的角色
////                            List<Role> roles = m.getRoles();
////                            //获取当前登录用户的角色
////                            Collection<? extends GrantedAuthority> authorities = authentication.get().getAuthorities();
////                            for (GrantedAuthority authority : authorities) {
////                                for (Role role : roles) {
////                                    if (authority.getAuthority().equals(role.getName())) {
////                                        //说明当前登录用户具备当前请求所需要的角色
////                                        return new AuthorizationDecision(true);
////                                    }
////                                }
////                            }
////                        }
////                    }
//
//
//                    if (!isMatch) {
//                        //说明请求的 URL 地址和数据库的地址没有匹配上，对于这种请求，统一只要登录就能访问
//                        if (authentication.get() instanceof AnonymousAuthenticationToken) {
//                            return new AuthorizationDecision(false);
//                        } else {
//                            //说明用户已经认证了
//                            return new AuthorizationDecision(true);
//                        }
//                    }
//                    return new AuthorizationDecision(false);
//                })

        );

        http.csrf(AbstractHttpConfigurer::disable)
                // .cors(cors -> cors.configurationSource(corsConfigurationSource())) // 跨越配置
                .headers(header -> header
                        .frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin)
                );

        return http.build();
    }


    /***
     * SpringSecurity 不拦截的请求路径
     * 狗贼, 新版本不能直接填写访问路径
     *
     * @author 王大宸
     * @date 2023/8/3 23:03
     * @return org.springframework.security.web.util.matcher.AntPathRequestMatcher[]
     */
    private AntPathRequestMatcher[] requestMatcher() {
        List<String> list = filterMatchers.requestMatchers();
        List<AntPathRequestMatcher> requestMatchers = new ArrayList<>();
        for (String uri : list) {
            requestMatchers.add(new AntPathRequestMatcher(uri));
        }
        return requestMatchers.toArray(new AntPathRequestMatcher[0]);
    }


}
