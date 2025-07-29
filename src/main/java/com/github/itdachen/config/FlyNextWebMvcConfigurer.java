package com.github.itdachen.config;

import com.github.itdachen.boot.autoconfigure.AppContextHelper;
import com.github.itdachen.boot.autoconfigure.oss.properties.OssLocalAutoconfigureProperties;
import com.github.itdachen.boot.security.interceptor.FlyWebSecurityInterceptor;
import com.github.itdachen.boot.security.matchers.IAuthorizeRequestMatchers;
import jakarta.servlet.MultipartConfigElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;


/**
 * web 配置
 *
 * @author 王大宸
 * @date 2024/4/16 22:44
 */
@Configuration
public class FlyNextWebMvcConfigurer implements WebMvcConfigurer {
    private static final Logger logger = LoggerFactory.getLogger(FlyNextWebMvcConfigurer.class);

    /* 不拦截路径 */
    private final IAuthorizeRequestMatchers authorizeRequestMatchers;
    private final FlyWebSecurityInterceptor flyWebSecurityInterceptor;
    private final OssLocalAutoconfigureProperties localAutoconfigureProperties;

    public FlyNextWebMvcConfigurer(@Lazy IAuthorizeRequestMatchers authorizeRequestMatchers,
                                   @Lazy FlyWebSecurityInterceptor flyWebSecurityInterceptor,
                                   @Lazy OssLocalAutoconfigureProperties localAutoconfigureProperties) {
        this.authorizeRequestMatchers = authorizeRequestMatchers;
        this.flyWebSecurityInterceptor = flyWebSecurityInterceptor;
        this.localAutoconfigureProperties = localAutoconfigureProperties;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
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
        registry.addInterceptor(flyWebSecurityInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(authorizeRequestMatchers.requestMatchers());
    }

//    @Override
//    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
//        resolvers.add(currentUserMethodArgumentResolver());
//    }
//
//    @Bean
//    public FlyUserDetailsMethodArgumentResolver currentUserMethodArgumentResolver() {
//        return new FlyUserDetailsMethodArgumentResolver();
//    }


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
     * 默认拦截器
     *
     * @author 王大宸
     * @date 2024/5/1 22:38
     * @return org.springframework.web.servlet.HandlerInterceptor
     */
//    @Bean
//    public FlyWebSecurityInterceptor flyWebSecurityInterceptor() {
//        return new FlyWebSecurityInterceptor();
//    }
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        String locationTemp = localAutoconfigureProperties.getDiskFolder();
        File tmpFile = new File(locationTemp);
        if (!tmpFile.exists()) {
            tmpFile.mkdirs();
        }
        factory.setLocation(locationTemp);
        return factory.createMultipartConfig();
    }

}
