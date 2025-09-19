package com.github.itdachen.admin.controller;

import com.github.itdachen.admin.sdk.vo.PlatformInfoVO;
import com.github.itdachen.admin.service.IMenuInfoService;
import com.github.itdachen.admin.sdk.dto.MenuInfoDTO;
import com.github.itdachen.admin.sdk.query.MenuInfoQuery;
import com.github.itdachen.admin.sdk.vo.MenuInfoVO;
import com.github.itdachen.auth.constants.AppConstants;
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
 * 菜单信息
 *
 * @author 王大宸
 * @date 2024-04-20 22:16:39
 */
@Controller
@RequestMapping("/admin/menu/info")
@FuncTitle("菜单信息")
public class MenuInfoController extends BizController<IMenuInfoService, MenuInfoDTO, MenuInfoVO, MenuInfoQuery, String> {
    private static final Logger logger = LoggerFactory.getLogger(MenuInfoController.class);
    private static final String PATH_PREFIX = "admin/menu";

    @GetMapping(value = "/app")
    @PreAuthorize("hasAuthority('admin:menu:info:index')")
    public String app(ModelMap modelMap) throws Exception {
        // return PATH_PREFIX + "/app" ;

        modelMap.put("appId", AppConstants.APP_ID);
        return PATH_PREFIX + "/app_index";
    }


    /***
     * 跳转到信息管理界面
     *
     * @author 王大宸
     * @date 2024-04-20 22:16:39
     * @return java.lang.String
     */
    @GetMapping(value = "/app/{appId}/index")
    @PreAuthorize("hasAuthority('admin:menu:info:index')")
    public String index(@PathVariable("appId") String appId, ModelMap modelMap) {
        modelMap.put("appId", appId);
        return PATH_PREFIX + "/index";
    }

    /***
     * 跳转到添加页面
     *
     * @author 王大宸
     * @date 2024-04-20 22:16:39
     * @return java.lang.String
     */
    @GetMapping(value = "/{appId}/add/{parentId}")
    @PreAuthorize("hasAuthority('admin:menu:info:save')")
    public String add(@PathVariable("appId") String appId, @PathVariable("parentId") String parentId, ModelMap modelMap) {
        modelMap.put("appId", appId);
        modelMap.put("parentId", parentId);
        return PATH_PREFIX + "/add";
    }

    /***
     * 跳转到修改页面
     *
     * @author 王大宸
     * @date 2024-04-20 22:16:39
     * @param id id
     * @param modelMap   modelMap
     * @return java.lang.String
     */
    @GetMapping(value = "/edit/{id}")
    @PreAuthorize("hasAuthority('admin:menu:info:update')")
    public String edit(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("menuInfo", bizService.selectByPrimaryKey(id));
        return PATH_PREFIX + "/edit";
    }

    /***
     * 修改上级菜单
     *
     * @author 王大宸
     * @date 2024/4/24 21:07
     * @param appId appId
     * @param modelMap modelMap
     * @return java.lang.String
     */
    @GetMapping("/{appId}/edit/parent/title")
    @PreAuthorize("hasAuthority('admin:menu:info:update')")
    public String editParentTitle(@PathVariable("appId") String appId, ModelMap modelMap) throws Exception {
        modelMap.put("appId", appId);
        return PATH_PREFIX + "/edit_parent";
    }

    /***
     * 跳转到查看页面
     *
     * @author 王大宸
     * @date 2024-04-20 22:16:39
     * @param id 需要查看数据的 id
     * @param modelMap    modelMap
     * @return java.lang.String
     */
    @GetMapping(value = "/view/{id}")
    @PreAuthorize("hasAuthority('admin:menu:info:view')")
    public String view(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("menuInfo", bizService.selectByPrimaryKey(id));
        return PATH_PREFIX + "/view";
    }

    /***
     * 获取应用菜单
     *
     * @author 王大宸
     * @date 2024/4/21 21:44
     * @param appId appId
     * @return com.github.itdachen.framework.core.response.ServerResponse<java.util.List < com.github.itdachen.framework.context.tree.ZTreeNode>>
     */
    @GetMapping("/{appId}/tree")
    @ResponseBody
    public ServerResponse<List<ZTreeNode>> findAppMenuTree(@PathVariable("appId") String appId) throws Exception {
        return ServerResponse.ok(bizService.findAppMenuTree(appId));
    }

    /***
     * 获取目录树
     *
     * @author 王大宸
     * @date 2024/4/24 20:57
     * @param appId appId
     * @return com.github.itdachen.framework.core.response.ServerResponse<java.util.List < com.github.itdachen.framework.context.tree.ZTreeNode>>
     */
    @GetMapping("/catalog/{appId}/zTree")
    @ResponseBody
    public ServerResponse<List<ZTreeNode>> findAppCatalogTree(@PathVariable("appId") String appId) throws Exception {
        return ServerResponse.ok(bizService.findAppCatalogTree(appId));
    }

    /***
     * 更改有效标志状态
     *
     * @author 王大宸
     * @date 2024/4/20 21:21
     * @param id id
     * @param checked checked
     * @return com.github.itdachen.framework.core.response.ServerResponse<com.github.itdachen.admin.sdk.vo.PlatformInfoVO>
     */
    @PostMapping("/{id}/valid/{checked}")
    @ResponseBody
    // @PreAuthorize("hasAuthority('admin:menu:info:checked')")
    public ServerResponse<PlatformInfoVO> validFlagChecked(@PathVariable("id") String id,
                                                           @PathVariable("checked") Boolean checked) throws Exception {
        bizService.validFlagChecked(id, checked);
        return ServerResponse.ok();
    }


}