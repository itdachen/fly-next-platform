package com.github.itdachen.config;

import com.github.itdachen.boot.security.interceptor.BrowserInterceptor;
import com.github.itdachen.boot.security.matchers.IFilterMatchers;
import com.github.itdachen.boot.security.resolvers.CurrentUserMethodArgumentResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
    /* 不拦截路径 */
    private final IFilterMatchers filterMatchers;

    public FlyAdminBootstrapWebMvcConfig(IFilterMatchers filterMatchers) {
        this.filterMatchers = filterMatchers;
    }

//    @Bean
//    public GlobalExceptionHandler getGlobalExceptionHandler() {
//        logger.info("正在配置全局异常处理 ...");
//        return new GlobalExceptionHandler();
//    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
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
                .excludePathPatterns(filterMatchers.requestMatchers());
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(currentUserMethodArgumentResolver());
    }

    @Bean
    public CurrentUserMethodArgumentResolver currentUserMethodArgumentResolver() {
        return new CurrentUserMethodArgumentResolver();
    }

    @Bean
    public BrowserInterceptor authInterceptor() {
        return new BrowserInterceptor();
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


}
