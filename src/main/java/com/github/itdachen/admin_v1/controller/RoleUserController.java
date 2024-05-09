package com.github.itdachen.admin_v1.controller;

import com.github.itdachen.admin_v1.sdk.dto.RoleUserDto;
import com.github.itdachen.admin_v1.sdk.vo.RoleUserVo;
import com.github.itdachen.admin_v1.service.IRoleUserService;
import com.github.itdachen.framework.context.tree.ZTreeNode;
import com.github.itdachen.framework.context.annotation.CheckApiClient;
import com.github.itdachen.framework.core.constants.ClientConstant;
import com.github.itdachen.framework.core.response.ServerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户角色
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
@Controller
@RequestMapping("/admin/role/user")
@CheckApiClient(title = "用户角色", clientId = ClientConstant.CLIENT_WEB)
public class RoleUserController {
    private static final Logger logger = LoggerFactory.getLogger(RoleUserController.class);
    private static final String PATH_PREFIX = "admin_v1/role/user" ;

    private final IRoleUserService roleUserService;

    public RoleUserController(IRoleUserService roleUserService) {
        this.roleUserService = roleUserService;
    }


    /***
     * 跳转到信息管理界面
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:46
     * @return java.lang.String
     */
    @GetMapping(value = "/index")
    @PreAuthorize("hasAuthority('admin:role:user:index')")
    public String index() {
        return PATH_PREFIX + "/index" ;
    }

    /***
     * 跳转到添加页面
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:46
     * @return java.lang.String
     */
    @GetMapping(value = "/{userId}/index")
    @PreAuthorize("hasAuthority('admin:user:role:index')")
    public String index(@PathVariable("userId") String userId,
                        ModelMap modelMap) {
        modelMap.put("userId", userId);
        return PATH_PREFIX + "/index";
    }


    @PostMapping(value = "")
    @ResponseBody
    @PreAuthorize("hasAuthority('admin:user:role:index')")
    public ServerResponse<RoleUserVo> save(@RequestBody RoleUserDto entity) throws Exception {
        return ServerResponse.okData(roleUserService.saveInfo(entity));
    }

    @GetMapping("/zTree/{userId}")
    @ResponseBody
    public ServerResponse<List<ZTreeNode>> findRoleWithUser(@PathVariable("userId") String userId) throws Exception {
        return ServerResponse.okData(roleUserService.findRoleWithUser(userId));
    }

}