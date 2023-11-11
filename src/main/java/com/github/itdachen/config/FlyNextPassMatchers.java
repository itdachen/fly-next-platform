package com.github.itdachen.config;

import com.github.itdachen.framework.autoconfigure.security.properties.FlySecurityProperties;
import com.github.itdachen.framework.security.matchers.pass.IPassMatchers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 自定义不拦你的路径(不包括静态资源文件等)
 * Created by 王大宸 on 2023/04/15 16:54
 * Created with IntelliJ IDEA.
 */
@Service
public class FlyNextPassMatchers implements IPassMatchers {
    private final FlySecurityProperties securityProperties;

    public FlyNextPassMatchers(FlySecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }

    @Override
    public List<String> matchers() {
        List<String> matchers = securityProperties.getMatchers();
        if (null == matchers) {
            matchers = new ArrayList<>();
        }
        matchers.add("/oss/file/**");
        return matchers;
    }

}
