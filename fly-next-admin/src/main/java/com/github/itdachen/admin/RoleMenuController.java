package com.github.itdachen.admin;

import com.github.itdachen.admin.sdk.dto.RoleMenuDto;
import com.github.itdachen.admin.service.IRoleMenuService;
import com.github.itdachen.admin.sdk.vo.RoleMenuVo;
import com.github.itdachen.framework.assets.tree.ZTreeNode;
import com.github.itdachen.framework.context.BizContextHandler;
import com.github.itdachen.framework.context.annotation.CheckApiClient;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.core.constants.ClientConstant;
import com.github.itdachen.framework.core.response.ServerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 菜单角色
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
@Controller
@RequestMapping("/admin/role/menu")
@CheckApiClient(title = "菜单角色", clientId = ClientConstant.CLIENT_WEB)
public class RoleMenuController {
    private static final Logger logger = LoggerFactory.getLogger(RoleMenuController.class);


    private final IRoleMenuService roleMenuService;

    public RoleMenuController(IRoleMenuService roleMenuService) {
        this.roleMenuService = roleMenuService;
    }


    /***
     * 新增
     *
     * @author 王大宸
     * @date 2022/8/24 23:39
     * @param roleMenu roleMenu
     * @return com.itdachen.framework.core.response.ServerResponse<com.itdachen.admin.entity.RoleMenu>
     */
    @PostMapping("")
    @ResponseBody
    public ServerResponse<RoleMenuVo> save(@RequestBody RoleMenuDto roleMenu) throws Exception {
        return ServerResponse.okData(roleMenuService.save(roleMenu));
    }

    /***
     * 获取菜单树
     *
     * @author 王大宸
     * @date 2022/8/25 21:05
     * @param roleId roleId
     * @return com.itdachen.framework.core.response.ServerResponse<java.util.List < com.itdachen.common.node.ZTreeNode>>
     */
    @GetMapping(value = "/zTree/{roleId}")
    @ResponseBody
    public ServerResponse<List<ZTreeNode>> roleMenuTreeData(@PathVariable("roleId") String roleId) throws BizException {
        return ServerResponse.okData(roleMenuService.roleMenuTreeData(roleId,
                BizContextHandler.getUserType(),
                BizContextHandler.getUserId()));
    }


}