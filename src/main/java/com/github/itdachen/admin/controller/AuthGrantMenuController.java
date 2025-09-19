package com.github.itdachen.admin.controller;

import com.github.itdachen.admin.service.IAuthGrantMenuService;
import com.github.itdachen.admin.sdk.dto.AuthGrantMenuDTO;
import com.github.itdachen.admin.sdk.query.AuthGrantMenuQuery;
import com.github.itdachen.admin.sdk.vo.AuthGrantMenuVO;
import com.github.itdachen.framework.context.annotation.FuncTitle;
import com.github.itdachen.framework.context.tree.ZTreeNode;
import com.github.itdachen.framework.core.response.ServerResponse;
import com.github.itdachen.framework.webmvc.controller.BizController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 权限下发
 *
 * @author 王大宸
 * @date 2024-05-15 21:32:13
 */
@Controller
@RequestMapping("/admin/auth/grant/menu")
@FuncTitle("权限下发")
public class AuthGrantMenuController {
    private static final Logger logger = LoggerFactory.getLogger(AuthGrantMenuController.class);
    private static final String PATH_PREFIX = "admin/grant";

    private final IAuthGrantMenuService authGrantMenuService;

    public AuthGrantMenuController(IAuthGrantMenuService authGrantMenuService) {
        this.authGrantMenuService = authGrantMenuService;
    }


    /***
     * 跳转到信息管理界面
     *
     * @author 王大宸
     * @date 2024-05-15 21:32:13
     * @return java.lang.String
     */
    @GetMapping(value = "/{roleId}/index")
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
    public String add(@PathVariable("roleId") String roleId,
                      @PathVariable("appId") String appId,
                      ModelMap modelMap) {
        modelMap.put("roleId", roleId);
        modelMap.put("appId", appId);
        return PATH_PREFIX + "/power";
    }


    /***
     * 新增入库
     *
     * @author 王大宸
     * @date 2024/5/17 16:10
     * @param dto dto
     * @return com.github.itdachen.framework.core.response.ServerResponse<com.github.itdachen.admin.sdk.vo.AuthGrantMenuVO>
     */
    @PostMapping("")
    @ResponseBody
    public ServerResponse<AuthGrantMenuVO> saveInfo(@RequestBody AuthGrantMenuDTO dto) throws Exception {
        return ServerResponse.ok(authGrantMenuService.saveInfo(dto));
    }

    /***
     * 权限下发时, 获取权限信息
     *
     * @author 王大宸
     * @date 2024/5/28 21:27
     * @param roleId roleId
     * @param appId appId
     * @return com.github.itdachen.framework.core.response.ServerResponse<java.util.List < com.github.itdachen.framework.context.tree.ZTreeNode>>
     */
    @GetMapping("/lower/{roleId}/app/{appId}")
    @ResponseBody
    public ServerResponse<List<ZTreeNode>> findLowerTreeData(@PathVariable("roleId") String roleId, @PathVariable("appId") String appId) throws Exception {
        return ServerResponse.ok(authGrantMenuService.findLowerTreeData(roleId, appId));
    }


    /***
     * 获取可下发的菜单树
     *
     * @author 王大宸
     * @date 2024/5/15 22:53
     * @param appId appId
     * @return com.github.itdachen.framework.core.response.ServerResponse<java.util.List < com.github.itdachen.framework.context.tree.ZTreeNode>>
     */
    @GetMapping("/clazz/{clazzCode}/app/{appId}/tree")
    @ResponseBody
    public ServerResponse<List<ZTreeNode>> findTreeData(@PathVariable("clazzCode") String clazzCode, @PathVariable("appId") String appId) throws Exception {
        return ServerResponse.ok(authGrantMenuService.findTreeData(clazzCode, appId));
    }


    /***
     * 获取可下放的权限
     *
     * @author 王大宸
     * @date 2024/5/17 16:21
     * @param roleId 用户身份ID
     * @param appId  应用ID
     * @return com.github.itdachen.framework.core.response.ServerResponse<java.util.List < com.github.itdachen.framework.context.tree.ZTreeNode>>
     */
    @GetMapping("/{roleId}/app/{appId}/tree")
    @ResponseBody
    public ServerResponse<List<ZTreeNode>> findGrantMenuTreeData(@PathVariable("roleId") String roleId, @PathVariable("appId") String appId) throws Exception {
        return ServerResponse.ok(authGrantMenuService.findGrantMenuTreeData(roleId, appId));
    }

    /***
     * 获取人员特殊授权可使用权限
     *
     * @author 王大宸
     * @date 2024/5/17 16:21
     * @param roleId 用户身份ID
     * @param appId  应用ID
     * @return com.github.itdachen.framework.core.response.ServerResponse<java.util.List < com.github.itdachen.framework.context.tree.ZTreeNode>>
     */
    @GetMapping("/role/{roleId}/app/{appId}/tree")
    @ResponseBody
    public ServerResponse<List<ZTreeNode>> findRoleMenuTreeData(@PathVariable("roleId") String roleId, @PathVariable("appId") String appId) throws Exception {
        return ServerResponse.ok(authGrantMenuService.findRoleMenuTreeData(roleId, appId));
    }


}