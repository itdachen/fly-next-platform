package com.github.itdachen.dashboard;

import com.github.itdachen.boot.autoconfigure.security.properties.FlySecurityProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description: 错误页面访问目录
 * Created by 王大宸 on 2022-09-25 14:38
 * Created with IntelliJ IDEA.
 */
@Controller
@RequestMapping("/error")
public class FlyErrorController {
    private static final String PATH_PREFIX = "error";

    private final FlySecurityProperties securityBrowserProperties;

    public FlyErrorController(FlySecurityProperties securityBrowserProperties) {
        this.securityBrowserProperties = securityBrowserProperties;
    }


    @GetMapping("/401")
    public String error401(ModelMap modelMap) {
        modelMap.put("uri", securityBrowserProperties.getSignInPage());
        return PATH_PREFIX + "/401";
    }

    @GetMapping("/401401")
    public String error401401() {
        return PATH_PREFIX + "/401401";
    }

    @GetMapping("/403")
    public String error403(ModelMap modelMap) {
        modelMap.put("uri", securityBrowserProperties.getSuccessForwardUrl());
        return PATH_PREFIX + "/403";
    }

    @GetMapping("/404")
    public String error404(ModelMap modelMap) {
        modelMap.put("uri", securityBrowserProperties.getSuccessForwardUrl());
        return PATH_PREFIX + "/404";
    }

    @GetMapping("/500")
    public String error505(ModelMap modelMap) {
        modelMap.put("uri", securityBrowserProperties.getSuccessForwardUrl());
        return PATH_PREFIX + "/500";
    }

    @GetMapping("/404500")
    public String error404500(ModelMap modelMap) {
        modelMap.put("uri", securityBrowserProperties.getSuccessForwardUrl());
        return PATH_PREFIX + "/404500";
    }


}
