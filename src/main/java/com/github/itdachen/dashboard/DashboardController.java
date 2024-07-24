package com.github.itdachen.dashboard;

import com.github.itdachen.auth.service.IHomePageService;
import com.github.itdachen.boot.autoconfigure.app.AppInfoProperties;
import com.github.itdachen.framework.context.BizContextHandler;
import com.github.itdachen.framework.context.permission.PermissionInfo;
import com.github.itdachen.framework.context.userdetails.UserInfoDetails;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * DashboardController
 *
 * @author 王大宸
 * @date 2024/4/16 23:33
 */
@Controller
public class DashboardController {

    private final AppInfoProperties appInfoProperties;
    private final IHomePageService homePageService;

    public DashboardController(AppInfoProperties appInfoProperties,
                               IHomePageService homePageService) {
        this.appInfoProperties = appInfoProperties;
        this.homePageService = homePageService;
    }

    @GetMapping({"/", "/index"})
    public String index(ModelMap modelMap) throws Exception {
        UserInfoDetails userDetails = BizContextHandler.getUserDetails();
        setAppInfo(modelMap, userDetails);

        String permsAuthUri = appInfoProperties.getContextPath() + "/pear/admin/menu";
        modelMap.put("permsAuthUri", permsAuthUri);

        return "backstage/pear/index";
    }


    @GetMapping({"/dashboard"})
    public String dashboard(ModelMap modelMap) {
        modelMap.put("title", "FLY-NEXT");
        return "dashboard";
    }


    /***
     * 统一返回给前端页面信息
     *
     * @author 王大宸
     * @date 2024/5/4 23:13
     * @param modelMap modelMap
     * @return void
     */
    private void setAppInfo(ModelMap modelMap, UserInfoDetails userDetails) throws Exception {
        /* 登录用户头像和姓名 */
        modelMap.put("userName", BizContextHandler.getRoleName());
        modelMap.put("avatar", BizContextHandler.getAvatar());

        /* 系统信息 */
        modelMap.put("title", appInfoProperties.getAppName());
        modelMap.put("copyrightYear", appInfoProperties.getYearly());
        modelMap.put("clientName", appInfoProperties.getAppName());
        modelMap.put("referredToAs", appInfoProperties.getToAs());
        modelMap.put("version", appInfoProperties.getVersion());
        modelMap.put("issuer", appInfoProperties.getIssuer());

        /* 默认跳转页面 */
        PermissionInfo homePage = homePageService.homePage(appInfoProperties.getAppId(), userDetails);
        modelMap.put("homeId", homePage.getId());
        modelMap.put("homeUri", homePage.getUri());
        modelMap.put("menuName", homePage.getName());

        /* 退出登录 */
        modelMap.put("logoutUri", appInfoProperties.getContextPath() + "/logout");
    }

}
