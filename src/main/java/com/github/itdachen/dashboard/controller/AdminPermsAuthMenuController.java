package com.github.itdachen.dashboard.controller;

import com.github.itdachen.boot.autoconfigure.client.ClientProperties;
import com.github.itdachen.dashboard.entity.LYearAdminMenu;
import com.github.itdachen.dashboard.entity.LayuiAdminMenu;
import com.github.itdachen.dashboard.entity.OkAdminMenu;
import com.github.itdachen.dashboard.entity.PearAdminMenu;
import com.github.itdachen.dashboard.service.IPearAdminMenuWebService;
import com.github.itdachen.dashboard.service.IPermsAuthWebService;
import com.github.itdachen.dashboard.service.IRefreshAuthoritiesService;
import com.github.itdachen.framework.context.BizContextHandler;
import com.github.itdachen.framework.context.annotation.IgnoreResponseAdvice;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.core.response.ServerResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description: 获取菜单
 * Created by 王大宸 on 2022-09-25 15:27
 * Created with IntelliJ IDEA.
 */
@RestController
public class AdminPermsAuthMenuController {

    private final IPermsAuthWebService permsAuthService;
    private final ClientProperties clientProperties;
    private final IPearAdminMenuWebService pearAdminMenuWebService;
    private final IRefreshAuthoritiesService refreshAuthoritiesService;

    public AdminPermsAuthMenuController(IPermsAuthWebService permsAuthService,
                                        ClientProperties clientProperties,
                                        IPearAdminMenuWebService pearAdminMenuWebService,
                                        IRefreshAuthoritiesService refreshAuthoritiesService) {
        this.permsAuthService = permsAuthService;
        this.clientProperties = clientProperties;
        this.pearAdminMenuWebService = pearAdminMenuWebService;
        this.refreshAuthoritiesService = refreshAuthoritiesService;
    }

    /***
     * layui 界面菜单
     *
     * @author 王大宸
     * @date 2022/10/7 16:26
     * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
     */
    @RequestMapping(value = "/perms/auth/menu")
    public ServerResponse<List<LayuiAdminMenu>> findPermsAuthMenu() throws BizException {
        //  refreshAuthoritiesService.refreshAuthorities(webAppClientConfig.getId());
        return ServerResponse.okData(permsAuthService.findPermsAuthMenu(clientProperties.getId(), BizContextHandler.getUserType(), BizContextHandler.getUserId()));
    }

    /***
     * ok-admin 界面菜单
     *
     * @author 王大宸
     * @date 2022/10/7 16:25
     * @return java.util.List<com.itdachen.auth.core.user.OkAdminMenu>
     */
    @GetMapping("/perms/okadmin/menu")
    @IgnoreResponseAdvice
    public List<OkAdminMenu> findOkAdminPermsAuthMenu() throws BizException {
        //  refreshAuthoritiesService.refreshAuthorities(webAppClientConfig.getId());
        return permsAuthService.getUserOkAdminMenu(clientProperties.getId(), BizContextHandler.getUserType(), BizContextHandler.getUserId());
    }

    /***
     * 获取光年后台管理模板菜单
     *
     * @author 王大宸
     * @date 2023/2/3 9:16
     * @return ServerResponse<java.util.List < LYearAdminMenu>>
     */
    @GetMapping("/lyear/admin/menu")
    public ServerResponse<List<LYearAdminMenu>> findLYearAdminMenu() throws Exception {
        //  refreshAuthoritiesService.refreshAuthorities(webAppClientConfig.getId());
        return ServerResponse.okData(permsAuthService.findLYearAdminMenu(clientProperties.getId(),
                BizContextHandler.getUserType(),
                BizContextHandler.getUserId())
        );
    }

    /***
     * PearAdmin 后台管理系统
     *
     * @author 王大宸
     * @date 2023/5/6 23:54
     * @return com.github.itdachen.framework.core.response.ServerResponse<java.util.List < com.github.itdachen.admin.entity.PearAdminMenu>>
     */
    @GetMapping("/pear/admin/menu")
    //   @IgnoreResponseAdvice
    public List<PearAdminMenu> findPearAdminMenu(HttpServletRequest request) throws Exception {
        //  refreshAuthoritiesService.refreshAuthorities(webAppClientConfig.getId());
        return pearAdminMenuWebService.findPearAdminMenu(request, clientProperties.getId());
    }

}
