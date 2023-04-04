package com.github.itdachen.admin.controller;

import com.github.itdachen.admin.service.IAppClientService;
import com.github.itdachen.admin.entity.AppClient;
import com.github.itdachen.admin.sdk.query.AppClientQuery;
import com.github.itdachen.admin.sdk.vo.AppClientVo;
import com.github.itdachen.framework.context.annotation.CheckApiClient;
import com.github.itdachen.framework.core.constants.ClientConstant;
import com.github.itdachen.framework.webmvc.controller.BizController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 应用管理
 *
 * @author 王大宸
 * @date 2023-04-04 21:26:23
 */
@Controller
@RequestMapping("/admin/app/client")
@CheckApiClient(title = "应用管理", clientId = ClientConstant.CLIENT_WEB)
public class AppClientController extends BizController<IAppClientService, AppClient, AppClientVo, AppClientQuery, String> {
    private static final Logger logger = LoggerFactory.getLogger(AppClientController.class);
    private static final String PATH_PREFIX = "admin/app" ;

    /***
     * 跳转到信息管理界面
     *
     * @author 王大宸
     * @date 2023-04-04 21:26:23
     * @return java.lang.String
     */
    @GetMapping(value = "/index")
    @PreAuthorize("hasAuthority('admin:app:client:index')")
    public String index() {
        return PATH_PREFIX + "/index" ;
    }

    /***
     * 跳转到添加页面
     *
     * @author 王大宸
     * @date 2023-04-04 21:26:23
     * @return java.lang.String
     */
    @GetMapping(value = "/add")
    @PreAuthorize("hasAuthority('admin:app:client:save')")
    public String add() {
        return PATH_PREFIX + "/add" ;
    }

    /***
     * 跳转到修改页面
     *
     * @author 王大宸
     * @date 2023-04-04 21:26:23
     * @param id         需要修改数据的id
     * @param modelMap   modelMap
     * @return java.lang.String
     */
    @GetMapping(value = "/edit/{id}")
    @PreAuthorize("hasAuthority('admin:app:client:update')")
    public String edit(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("appClient", bizService.getById(id));
        return PATH_PREFIX + "/edit" ;
    }

    /***
     * 跳转到查看页面
     *
     * @author 王大宸
     * @date 2023-04-04 21:26:23
     * @param id          需要查看数据的id
     * @param modelMap    modelMap
     * @return java.lang.String
     */
    @GetMapping(value = "/view/{id}")
    @PreAuthorize("hasAuthority('admin:app:client:view')")
    public String see(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("appClient", bizService.getById(id));
        return PATH_PREFIX + "/see" ;
    }

}