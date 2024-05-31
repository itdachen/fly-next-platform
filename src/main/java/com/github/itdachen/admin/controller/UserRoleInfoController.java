package com.github.itdachen.admin.controller;

import com.github.itdachen.admin.service.IUserRoleInfoService;
import com.github.itdachen.admin.sdk.dto.UserRoleInfoDTO;
import com.github.itdachen.admin.sdk.query.UserRoleInfoQuery;
import com.github.itdachen.admin.sdk.vo.UserRoleInfoVO;
import com.github.itdachen.framework.context.BizContextHandler;
import com.github.itdachen.framework.context.annotation.FuncTitle;
import com.github.itdachen.framework.context.tree.ZTreeNode;
import com.github.itdachen.framework.core.response.ServerResponse;
import com.github.itdachen.framework.webmvc.controller.BizController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 身份信息
 *
 * @author 王大宸
 * @date 2024-04-27 20:42:58
 */
@Controller
@RequestMapping("/admin/user/role/info")
@FuncTitle("身份信息")
public class UserRoleInfoController extends BizController<IUserRoleInfoService, UserRoleInfoDTO, UserRoleInfoVO, UserRoleInfoQuery, String> {
    private static final Logger logger = LoggerFactory.getLogger(UserRoleInfoController.class);
    private static final String PATH_PREFIX = "admin/user/role";

    /***
     * 跳转到信息管理界面
     *
     * @author 王大宸
     * @date 2024-04-27 20:42:58
     * @return java.lang.String
     */
    @GetMapping(value = "/index")
    @PreAuthorize("hasAuthority('admin:user:role:info:index')")
    public String index(ModelMap modelMap) {
        modelMap.put("parentId", BizContextHandler.getTenantId());
        return PATH_PREFIX + "/index";
    }

    /***
     * 跳转到添加页面
     *
     * @author 王大宸
     * @date 2024-04-27 20:42:58
     * @return java.lang.String
     */
    @GetMapping(value = "/{deptId}/add")
    @PreAuthorize("hasAuthority('admin:user:role:info:save')")
    public String add(@PathVariable("deptId") String deptId, ModelMap modelMap) {
        modelMap.put("deptId", deptId);
        return PATH_PREFIX + "/add";
    }

    /***
     * 跳转到修改页面
     *
     * @author 王大宸
     * @date 2024-04-27 20:42:58
     * @param id id
     * @param modelMap   modelMap
     * @return java.lang.String
     */
    @GetMapping(value = "/edit/{id}")
    @PreAuthorize("hasAuthority('admin:user:role:info:update')")
    public String edit(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("userRoleInfo", bizService.selectByPrimaryKey(id));
        return PATH_PREFIX + "/edit";
    }

    /***
     * 跳转到查看页面
     *
     * @author 王大宸
     * @date 2024-04-27 20:42:58
     * @param id 需要查看数据的 id
     * @param modelMap    modelMap
     * @return java.lang.String
     */
    @GetMapping(value = "/view/{id}")
    @PreAuthorize("hasAuthority('admin:user:role:info:view')")
    public String view(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("userRoleInfo", bizService.selectByPrimaryKey(id));
        return PATH_PREFIX + "/view";
    }

    /***
     * 更改有效标志状态
     *
     * @author 王大宸
     * @date 2024/4/27 21:28
     * @param id id
     * @param checked checked
     * @return com.github.itdachen.framework.core.response.ServerResponse<com.github.itdachen.admin.sdk.vo.UserRoleInfoVO>
     */
    @PostMapping("/{id}/valid/{checked}")
    @ResponseBody
    // @PreAuthorize("hasAuthority('admin:user:role:info:checked')")
    public ServerResponse<UserRoleInfoVO> validFlagChecked(@PathVariable("id") String id,
                                                           @PathVariable("checked") Boolean checked) throws Exception {
        bizService.validFlagChecked(id, checked);
        return ServerResponse.ok();
    }

    /***
     * 跳转人员岗位页面
     *
     * @author 王大宸
     * @date 2024/5/15 20:39
     * @param id id
     * @param modelMap modelMap
     * @return java.lang.String
     */
    @GetMapping("/clazz/{id}")
    public String setClazz(@PathVariable("id") String id, ModelMap modelMap) {
        modelMap.put("roleId", id);
        return PATH_PREFIX + "/clazz";
    }

    /***
     * 获取部门岗位权限
     *
     * @author 王大宸
     * @date 2024/5/15 20:50
     * @param id 人员身份ID
     * @return com.github.itdachen.framework.core.response.ServerResponse<java.util.List < com.github.itdachen.framework.context.tree.ZTreeNode>>
     */
    @GetMapping("/clazz/{id}/tree")
    @ResponseBody
    public ServerResponse<List<ZTreeNode>> deptClazzTree(@PathVariable("id") String id) throws Exception {
        return ServerResponse.ok(bizService.deptClazzTree(id));
    }


}