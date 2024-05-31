package com.github.itdachen.auth.controller;

import com.github.itdachen.auth.service.IAuthUserRoleService;
import com.github.itdachen.framework.context.BizContextHandler;
import com.github.itdachen.framework.context.tree.ZTreeNode;
import com.github.itdachen.framework.core.response.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * UserRoleController
 *
 * @author 王大宸
 * @date 2024/5/7 20:58
 */
@RestController
@RequestMapping("/auth/user/role")
public class AuthUserRoleController {

    @Autowired
    private IAuthUserRoleService authUserRoleService;


    @GetMapping("/list")
    public ServerResponse<List<ZTreeNode>> findAuthUserRole() {
        return ServerResponse.ok(authUserRoleService.findAuthUserRole(BizContextHandler.getId()));
    }

}
