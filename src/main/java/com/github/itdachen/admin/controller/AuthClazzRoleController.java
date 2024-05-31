package com.github.itdachen.admin.controller;

import com.github.itdachen.admin.service.IAuthClazzRoleService;
import com.github.itdachen.admin.sdk.dto.AuthClazzRoleDTO;
import com.github.itdachen.admin.sdk.vo.AuthClazzRoleVO;
import com.github.itdachen.framework.context.annotation.FuncTitle;
import com.github.itdachen.framework.core.response.ServerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 身份岗位管理表
 *
 * @author 王大宸
 * @date 2024-05-15 21:32:14
 */
@RestController
@RequestMapping("/admin/auth/clazz/role")
@FuncTitle("身份岗位管理表")
public class AuthClazzRoleController {
    private static final Logger logger = LoggerFactory.getLogger(AuthClazzRoleController.class);

    private final IAuthClazzRoleService authClazzRoleService;

    public AuthClazzRoleController(IAuthClazzRoleService authClazzRoleService) {
        this.authClazzRoleService = authClazzRoleService;
    }

    @RequestMapping("")
    public ServerResponse<AuthClazzRoleVO> saveInfo(@RequestBody AuthClazzRoleDTO dto) throws Exception {
        return ServerResponse.ok(authClazzRoleService.saveInfo(dto));
    }


}