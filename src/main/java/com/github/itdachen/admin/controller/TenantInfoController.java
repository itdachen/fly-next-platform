package com.github.itdachen.admin.controller;

import com.github.itdachen.admin.sdk.vo.PlatformInfoVO;
import com.github.itdachen.admin.service.ITenantInfoService;
import com.github.itdachen.admin.sdk.dto.TenantInfoDTO;
import com.github.itdachen.admin.sdk.query.TenantInfoQuery;
import com.github.itdachen.admin.sdk.vo.TenantInfoVO;
import com.github.itdachen.framework.context.annotation.FuncTitle;
import com.github.itdachen.framework.context.annotation.PageView;
import com.github.itdachen.framework.context.enums.PageTypeEnum;
import com.github.itdachen.framework.context.tree.ZTreeNode;
import com.github.itdachen.framework.core.response.ServerResponse;
import com.github.itdachen.framework.webmvc.controller.BizController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * 租户/公司信息
 *
 * @author 王大宸
 * @date 2024-04-24 22:42:35
 */
@Controller
@RequestMapping("/admin/tenant/info")
@FuncTitle("租户/公司信息")
public class TenantInfoController extends BizController<ITenantInfoService, TenantInfoDTO, TenantInfoVO, TenantInfoQuery, String> {
    private static final Logger logger = LoggerFactory.getLogger(TenantInfoController.class);
    private static final String PATH_PREFIX = "admin/tenant";

    /***
     * 跳转到信息管理界面
     *
     * @author 王大宸
     * @date 2024-04-24 22:42:35
     * @return java.lang.String
     */
    @GetMapping(value = "/index")
    @PreAuthorize("hasAuthority('admin:tenant:info:index')")
    @PageView(value = PageTypeEnum.INDEX)
    public String index() {
        return PATH_PREFIX + "/index";
    }

    /***
     * 跳转到添加页面
     *
     * @author 王大宸
     * @date 2024-04-24 22:42:35
     * @return java.lang.String
     */
    @GetMapping(value = "/add")
    @PreAuthorize("hasAuthority('admin:tenant:info:save')")
    @PageView(value = PageTypeEnum.SAVE)
    public String add() {
        return PATH_PREFIX + "/add";
    }

    /***
     * 跳转到修改页面
     *
     * @author 王大宸
     * @date 2024-04-24 22:42:35
     * @param id id
     * @param modelMap   modelMap
     * @return java.lang.String
     */
    @GetMapping(value = "/edit/{id}")
    @PreAuthorize("hasAuthority('admin:tenant:info:update')")
    @PageView(value = PageTypeEnum.UPDATE)
    public String edit(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("tenantInfo", bizService.selectByPrimaryKey(id));
        return PATH_PREFIX + "/edit";
    }

    /***
     * 跳转到查看页面
     *
     * @author 王大宸
     * @date 2024-04-24 22:42:35
     * @param id 需要查看数据的 id
     * @param modelMap    modelMap
     * @return java.lang.String
     */
    @GetMapping(value = "/view/{id}")
    @PreAuthorize("hasAuthority('admin:tenant:info:view')")
    @PageView(value = PageTypeEnum.VIEW)
    public String view(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("tenantInfo", bizService.selectByPrimaryKey(id));
        return PATH_PREFIX + "/view";
    }

    /***
     * 获取树结构
     *
     * @author 王大宸
     * @date 2024/4/24 23:30
     * @return com.github.itdachen.framework.core.response.ServerResponse<java.util.List < com.github.itdachen.framework.context.tree.ZTreeNode>>
     */
    @GetMapping("/tree")
    @ResponseBody
    public ServerResponse<List<ZTreeNode>> tenantTree() throws Exception {
        return ServerResponse.ok(bizService.findTenantTree());
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
    // @PreAuthorize("hasAuthority('admin:tenant:info:checked')")
    public ServerResponse<PlatformInfoVO> validFlagChecked(@PathVariable("id") String id,
                                                           @PathVariable("checked") Boolean checked) throws Exception {
        bizService.validFlagChecked(id, checked);
        return ServerResponse.ok();
    }

}