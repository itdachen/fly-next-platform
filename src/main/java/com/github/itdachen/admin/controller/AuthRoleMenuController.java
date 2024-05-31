package com.github.itdachen.admin.controller;

import com.github.itdachen.admin.service.IAuthRoleMenuService;
import com.github.itdachen.admin.sdk.dto.AuthRoleMenuDTO;
import com.github.itdachen.admin.sdk.query.AuthRoleMenuQuery;
import com.github.itdachen.admin.sdk.vo.AuthRoleMenuVO;
import com.github.itdachen.framework.context.annotation.FuncTitle;
import com.github.itdachen.framework.core.response.ServerResponse;
import com.github.itdachen.framework.webmvc.controller.BizController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * 人员身份菜单
 *
 * @author 王大宸
 * @date 2024-05-15 22:13:44
 */
@Controller
@RequestMapping("/admin/auth/role/menu")
@FuncTitle("人员身份菜单")
public class AuthRoleMenuController {
    private static final Logger logger = LoggerFactory.getLogger(AuthRoleMenuController.class);
    private static final String PATH_PREFIX = "admin/user/menu";

    private final IAuthRoleMenuService authRoleMenuService;

    public AuthRoleMenuController(IAuthRoleMenuService authRoleMenuService) {
        this.authRoleMenuService = authRoleMenuService;
    }

    /***
     * 跳转到信息管理界面
     *
     * @author 王大宸
     * @date 2024-05-15 21:32:13
     * @return java.lang.String
     */
    @GetMapping(value = "/{roleId}/index")
    // @PreAuthorize("hasAuthority('fly:admin:fly:auth:grant:menu:index')")
    public String index(@PathVariable("roleId") String roleId,
                        ModelMap modelMap) {
        modelMap.put("roleId", roleId);
        return PATH_PREFIX + "/app";
    }

    /***
     * 跳转到权限下发
     *
     * @author 王大宸
     * @date 2024-05-15 21:32:13
     * @return java.lang.String
     */
    @GetMapping(value = "/{roleId}/app/{appId}")
    // @PreAuthorize("hasAuthority('fly:admin:fly:auth:grant:menu:save')")
    public String add(@PathVariable("roleId") String roleId,
                      @PathVariable("appId") String appId,
                      ModelMap modelMap) {
        modelMap.put("roleId", roleId);
        modelMap.put("appId", appId);
        return PATH_PREFIX + "/power";
    }

    @PostMapping("")
    @ResponseBody
    public ServerResponse<AuthRoleMenuVO> saveInfo(@RequestBody AuthRoleMenuDTO dto) throws Exception {
        return ServerResponse.ok(authRoleMenuService.saveInfo(dto));
    }


}