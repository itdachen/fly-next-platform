package com.github.itdachen.admin.controller;

import com.github.itdachen.admin.sdk.dto.MenuInfoDto;
import com.github.itdachen.admin.service.IMakeUseLogService;
import com.github.itdachen.admin.service.IMenuInfoService;
import com.github.itdachen.admin.entity.MenuInfo;
import com.github.itdachen.admin.sdk.query.MenuInfoQuery;
import com.github.itdachen.admin.sdk.vo.MenuInfoVo;
import com.github.itdachen.framework.assets.tree.ZTreeNode;
import com.github.itdachen.framework.context.annotation.CheckApiClient;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.core.constants.ClientConstant;
import com.github.itdachen.framework.core.response.ServerResponse;
import com.github.itdachen.framework.webmvc.controller.BizController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

/**
 * 菜单管理
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
@Controller
@RequestMapping("/admin/menu/info")
@CheckApiClient(title = "菜单管理", clientId = ClientConstant.CLIENT_WEB)
public class MenuInfoController extends BizController<MenuInfoDto, MenuInfoVo, MenuInfoQuery, String> {
    private static final Logger logger = LoggerFactory.getLogger(MenuInfoController.class);
    private static final String PATH_PREFIX = "admin/menu" ;
    private final IMenuInfoService bizService;

    public MenuInfoController(IMenuInfoService bizService) {
        super(bizService);
        this.bizService = bizService;
    }

    /***
     * 跳转到信息管理界面
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:46
     * @return java.lang.String
     */
    @GetMapping(value = "/index")
    @PreAuthorize("hasAuthority('admin:menu:info:index')")
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
    @GetMapping(value = "/{parentId}/add")
    @PreAuthorize("hasAuthority('admin:menu:info:save')")
    public String add(@PathVariable("parentId") String parentId, ModelMap modelMap) throws Exception {
        modelMap.put("parentId", parentId);
        return PATH_PREFIX + "/add" ;
    }

    /***
     * 跳转到修改页面
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:46
     * @param id         需要修改数据的id
     * @param modelMap   modelMap
     * @return java.lang.String
     */
    @GetMapping(value = "/edit/{id}")
    @PreAuthorize("hasAuthority('admin:menu:info:update')")
    public String edit(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        MenuInfoVo menu = bizService.findMenuInfoVo(id);
        modelMap.put("menuInfo", menu);
        String menuParentTitle = bizService.findMenuParentTitle(menu.getParentId());
        modelMap.put("parentTitle", menuParentTitle);
        return PATH_PREFIX + "/edit" ;
    }

    /***
     * 跳转到查看页面
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:46
     * @param id          需要查看数据的id
     * @param modelMap    modelMap
     * @return java.lang.String
     */
    @GetMapping(value = "/view/{id}")
    @PreAuthorize("hasAuthority('admin:menu:info:view')")
    public String see(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("menuInfo", bizService.findMenuInfoVo(id));
        return PATH_PREFIX + "/see" ;
    }

    /***
     * 选择上级菜单
     *
     * @author 王大宸
     * @date 2023/4/11 16:48
     * @return java.lang.String
     */
    @GetMapping("/edit/parent")
    public String editParent() {
        return PATH_PREFIX + "/edit_parent";
    }


    /***
     * 获取菜单树
     *
     * @author 王大宸
     * @date 2023/4/5 14:26
     * @return com.github.itdachen.framework.core.response.ServerResponse<java.util.List<com.github.itdachen.framework.assets.tree.ZTreeNode>>
     */
    @GetMapping(value = "/zTree")
    @ResponseBody
    public ServerResponse<List<ZTreeNode>> zTree() {
        return ServerResponse.okData(bizService.zTree());
    }

    /***
     * 修改状态
     *
     * @author 王大宸
     * @date 2023/4/5 14:25
     * @param id id
     * @param status status
     * @return com.github.itdachen.framework.core.response.ServerResponse<MenuVo>
     */
    @PutMapping("/{id}/status/{status}")
    @ResponseBody
    @PreAuthorize("hasAuthority('admin:menu:info:update')")
    public ServerResponse<MenuInfoVo> updateStatus(@PathVariable("id") String id,
                                                   @PathVariable("status") Boolean status) throws BizException {
        bizService.updateStatus(id, status);
        return ServerResponse.ok();
    }

    /***
     * 获取目录菜单
     *
     * @author 王大宸
     * @date 2023/4/11 21:03
     * @return com.github.itdachen.framework.core.response.ServerResponse<java.util.List<com.github.itdachen.framework.assets.tree.ZTreeNode>>
     */
    @GetMapping("/catalog/zTree")
    @ResponseBody
    public ServerResponse<List<ZTreeNode>> findCatalogZTree() throws BizException {
        return ServerResponse.okData(bizService.findCatalogZTree());
    }

}