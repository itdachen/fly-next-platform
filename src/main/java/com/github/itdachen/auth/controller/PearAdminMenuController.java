package com.github.itdachen.auth.controller;

import com.github.itdachen.auth.entity.PearAdminRoute;
import com.github.itdachen.auth.service.IPearAdminService;
import com.github.itdachen.boot.autoconfigure.app.AppInfoProperties;
import com.github.itdachen.framework.context.BizContextHandler;
import com.github.itdachen.framework.context.annotation.IgnoreResponseAdvice;
import com.github.itdachen.framework.context.userdetails.UserInfoDetails;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Pear Admin Layui 后台获取菜单
 *
 * @author 王大宸
 * @date 2024/4/23 23:15
 */
@Controller
@RequestMapping("/pear")
public class PearAdminMenuController {

    @Autowired
    private IPearAdminService pearAdminService;
    @Autowired
    private AppInfoProperties appInfoProperties;

    @GetMapping("/admin/menu")
    @ResponseBody
    @IgnoreResponseAdvice
    public List<PearAdminRoute> pearAdminMenu(HttpServletRequest request) {
        UserInfoDetails userDetails = BizContextHandler.getUserDetails();
        return pearAdminService.pearAdminMenu(request, appInfoProperties.getAppId(), userDetails);
    }

}
