package com.github.itdachen.admin_v1.controller;

import com.github.itdachen.admin_v1.sdk.dto.PermsAuthDto;
import com.github.itdachen.admin_v1.sdk.vo.PermsAuthVo;
import com.github.itdachen.admin_v1.service.IPermsAuthService;
import com.github.itdachen.framework.context.tree.ZTreeNode;
import com.github.itdachen.framework.context.BizContextHandler;
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
 * 权限下发
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
@Controller
@RequestMapping("/admin/perms/auth")
@CheckApiClient(title = "权限下发", clientId = ClientConstant.CLIENT_WEB)
public class PermsAuthController {
    private static final Logger logger = LoggerFactory.getLogger(PermsAuthController.class);

    private static final String PATH_PREFIX = "admin_v1/user/perms";

    private final IPermsAuthService permsAuthService;

    public PermsAuthController(IPermsAuthService permsAuthService) {
        this.permsAuthService = permsAuthService;
    }



    /***
     * 跳转到信息管理界面
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:46
     * @return java.lang.String
     */
    @GetMapping(value = "/{userId}/index")
    @PreAuthorize("hasAuthority('admin:perms:auth:index')")
    public String index(@PathVariable("userId") String userId,
                        ModelMap modelMap) {
        modelMap.put("userId", userId);
        return PATH_PREFIX + "/index";
    }

    /***
     * 新增
     *
     * @author 王大宸
     * @date 2023/4/5 22:29
     * @param entity entity
     * @return com.github.itdachen.framework.core.response.ServerResponse<com.github.itdachen.admin.entity.PermsAuth>
     */
    @PostMapping(value = "")
    @ResponseBody
    @PreAuthorize("hasAuthority('admin:perms:auth:index')")
    public ServerResponse<PermsAuthVo> save(@RequestBody PermsAuthDto entity) throws Exception {
        return ServerResponse.okData(permsAuthService.saveInfo(entity));
    }

    @GetMapping(value = "/zTree/{userId}")
    @ResponseBody
    public ServerResponse<List<ZTreeNode>> findRoleWithUser(@PathVariable("userId") String userId) throws Exception {
        return ServerResponse.okData(permsAuthService.findMenuWithUser(userId,
                BizContextHandler.getUserType(),
                BizContextHandler.getUserId()));
    }

}