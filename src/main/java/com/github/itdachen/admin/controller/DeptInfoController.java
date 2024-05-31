package com.github.itdachen.admin.controller;

import com.github.itdachen.admin.service.IDeptInfoService;
import com.github.itdachen.admin.sdk.dto.DeptInfoDTO;
import com.github.itdachen.admin.sdk.query.DeptInfoQuery;
import com.github.itdachen.admin.sdk.vo.DeptInfoVO;
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
 * 部门信息
 *
 * @author 王大宸
 * @date 2024-04-24 21:47:25
 */
@Controller
@RequestMapping("/admin/dept/info")
@FuncTitle("部门信息")
public class DeptInfoController extends BizController<IDeptInfoService, DeptInfoDTO, DeptInfoVO, DeptInfoQuery, String> {
    private static final Logger logger = LoggerFactory.getLogger(DeptInfoController.class);
    private static final String PATH_PREFIX = "admin/dept" ;

    /***
     * 跳转到信息管理界面
     *
     * @author 王大宸
     * @date 2024-04-24 21:47:25
     * @return java.lang.String
     */
    @GetMapping(value = "/index")
    @PreAuthorize("hasAuthority('admin:dept:info:index')")
    public String index(ModelMap modelMap) {
        modelMap.put("parentId", BizContextHandler.getTenantId());
        return PATH_PREFIX + "/index" ;
    }

    /***
     * 跳转到添加页面
     *
     * @author 王大宸
     * @date 2024-04-24 21:47:25
     * @return java.lang.String
     */
    @GetMapping(value = "/{parentId}/add")
    @PreAuthorize("hasAuthority('admin:dept:info:save')")
    public String add(@PathVariable("parentId") String parentId, ModelMap modelMap) {
        modelMap.put("parentId", parentId);
        return PATH_PREFIX + "/add" ;
    }

    /***
     * 跳转到修改页面
     *
     * @author 王大宸
     * @date 2024-04-24 21:47:25
     * @param id id
     * @param modelMap   modelMap
     * @return java.lang.String
     */
    @GetMapping(value = "/edit/{id}")
    @PreAuthorize("hasAuthority('admin:dept:info:update')")
    public String edit(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("deptInfo", bizService.selectByPrimaryKey(id));
        return PATH_PREFIX + "/edit" ;
    }

    /***
     * 跳转到查看页面
     *
     * @author 王大宸
     * @date 2024-04-24 21:47:25
     * @param id 需要查看数据的 id
     * @param modelMap    modelMap
     * @return java.lang.String
     */
    @GetMapping(value = "/view/{id}")
    @PreAuthorize("hasAuthority('admin:dept:info:view')")
    public String view(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("deptInfo", bizService.selectByPrimaryKey(id));
        return PATH_PREFIX + "/view" ;
    }

    @GetMapping("/tree")
    @ResponseBody
    public ServerResponse<List<ZTreeNode>> findDeptTree() throws Exception {
        return ServerResponse.ok(bizService.findDeptTree());
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
    // @PreAuthorize("hasAuthority('admin:dept:info:checked')")
    public ServerResponse<DeptInfoVO> validFlagChecked(@PathVariable("id") String id,
                                                       @PathVariable("checked") Boolean checked) throws Exception {
        bizService.validFlagChecked(id, checked);
        return ServerResponse.ok();
    }

    @GetMapping("/three/tree")
    @ResponseBody
    public ServerResponse<List<ZTreeNode>> findThreeDeptTree() throws Exception {
        return ServerResponse.ok(bizService.findThreeDeptTree());
    }


}