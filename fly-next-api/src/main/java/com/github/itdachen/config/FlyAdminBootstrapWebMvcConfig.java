package com.github.itdachen.config;

import com.github.itdachen.auth.service.IVerifyTicketTokenService;
import com.github.itdachen.framework.body.advice.handler.GlobalExceptionHandler;
import com.github.itdachen.framework.jjwt.JWTHelper;
import com.github.itdachen.framework.jjwt.config.SecretKeyConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * Description: SpringBoot Mvc
 * Created by 王大宸 on 2022-08-10 11:07
 * Created with IntelliJ IDEA.
 */
@Configuration
public class FlyAdminBootstrapWebMvcConfig implements WebMvcConfigurer {
    private static final Logger logger = LoggerFactory.getLogger(FlyAdminBootstrapWebMvcConfig.class);

    private final IVerifyTicketTokenService verifyTicketTokenService;

    public FlyAdminBootstrapWebMvcConfig(IVerifyTicketTokenService verifyTicketTokenService) {
        this.verifyTicketTokenService = verifyTicketTokenService;
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    @Bean
    public GlobalExceptionHandler getGlobalExceptionHandler() {
        logger.info("正在配置全局异常处理 ...");
        return new GlobalExceptionHandler();
    }


    /***
     * 拦截器配置
     *
     * @author 王大宸
     * @date 2022/9/25 16:28
     * @param registry registry
     * @return void
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(passMatchers());
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(userAuthRestMethodArgumentResolver());
    }

    @Bean
    public UserAuthRestMethodArgumentResolver userAuthRestMethodArgumentResolver() {
        return new UserAuthRestMethodArgumentResolver();
    }

    @Bean
    public UserAuthRestInterceptor authInterceptor() {
        return new UserAuthRestInterceptor(verifyTicketTokenService);
    }


//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        // 设置允许跨域的路由
//        registry.addMapping("/**")
//                // 设置允许跨域请求的域名
//                .allowedOriginPatterns("*")
//                // 是否允许证书（cookies）
//                .allowCredentials(true)
//                // 设置允许的方法
//                .allowedMethods("*")
//                // 跨域允许时间（秒）
//                .maxAge(18000L);
//    }

    /***
     * 指定项目账号加密策略
     *
     * @author 王大宸
     * @date 2022/10/16 13:55
     * @return org.springframework.security.crypto.password.PasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /***
     * 自定义不拦截路径
     *
     * @author 王大宸
     * @date 2023/4/15 16:59
     * @return java.lang.String[]
     */
    private String[] passMatchers() {
        return new String[]{
                "/oauth/token",
                "/oss/file/upload",
                "/upload/**"
        };
    }

}
