package com.github.itdachen.admin.controller;

import com.github.itdachen.admin.service.IClazzDeptService;
import com.github.itdachen.admin.sdk.dto.ClazzDeptDTO;
import com.github.itdachen.admin.sdk.query.ClazzDeptQuery;
import com.github.itdachen.admin.sdk.vo.ClazzDeptVO;
import com.github.itdachen.framework.context.BizContextHandler;
import com.github.itdachen.framework.context.annotation.FuncTitle;
import com.github.itdachen.framework.context.tree.ZTreeNode;
import com.github.itdachen.framework.core.response.ServerResponse;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.controller.BizController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * 部门岗位关联表
 *
 * @author 王大宸
 * @date 2024-05-10 21:17:50
 */
@Controller
@RequestMapping("/admin/clazz/dept")
@FuncTitle("部门岗位关联表")
public class ClazzDeptController extends BizController<IClazzDeptService, ClazzDeptDTO, ClazzDeptVO, ClazzDeptQuery, String> {
    private static final Logger logger = LoggerFactory.getLogger(ClazzDeptController.class);
    private static final String PATH_PREFIX = "admin/dept/clazz";

    /***
     * 跳转到信息管理界面
     *
     * @author 王大宸
     * @date 2024-05-10 21:17:50
     * @return java.lang.String
     */
    @GetMapping(value = "/index")
    @PreAuthorize("hasAuthority('fly:admin:clazz:dept:admin:index')")
    public String index(ModelMap modelMap) {
        modelMap.put("parentId", BizContextHandler.getTenantId());
        return PATH_PREFIX + "/index";
    }

    /***
     * 跳转到添加页面
     *
     * @author 王大宸
     * @date 2024-05-10 21:17:50
     * @return java.lang.String
     */
    @GetMapping(value = "/{deptId}/add")
    @PreAuthorize("hasAuthority('fly:admin:clazz:dept:admin:save')")
    public String add(@PathVariable("deptId") String deptId, ModelMap modelMap) throws Exception {
        modelMap.put("deptId", deptId);
        return PATH_PREFIX + "/add";
    }

    /***
     * 跳转到修改页面
     *
     * @author 王大宸
     * @date 2024-05-10 21:17:50
     * @param id id
     * @param modelMap   modelMap
     * @return java.lang.String
     */
    @GetMapping(value = "/edit/{id}")
    @PreAuthorize("hasAuthority('fly:admin:clazz:dept:admin:update')")
    public String edit(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("clazzDept", bizService.selectByPrimaryKey(id));
        return PATH_PREFIX + "/edit";
    }

    /***
     * 跳转到查看页面
     *
     * @author 王大宸
     * @date 2024-05-10 21:17:50
     * @param id 需要查看数据的 id
     * @param modelMap    modelMap
     * @return java.lang.String
     */
    @GetMapping(value = "/view/{id}")
    @PreAuthorize("hasAuthority('fly:admin:clazz:dept:admin:view')")
    public String view(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("clazzDept", bizService.selectByPrimaryKey(id));
        return PATH_PREFIX + "/view";
    }

    @GetMapping("/clazz/page")
    @ResponseBody
    public ServerResponse<TableData<ZTreeNode>> clazzPage(ClazzDeptQuery query) throws Exception {
        return ServerResponse.ok(bizService.clazzPage(query));
    }

    /***
     * 更改有效标志状态
     *
     * @author 王大宸
     * @date 2024/4/25 23:03
     * @param id id
     * @param checked checked
     * @return com.github.itdachen.framework.core.response.ServerResponse<com.github.itdachen.admin.sdk.vo.ClazzInfoVO>
     */
    @PostMapping("/{id}/valid/{checked}")
    @ResponseBody
    // @PreAuthorize("hasAuthority('admin:clazz:info:checked')")
    public ServerResponse<ClazzDeptVO> validFlagChecked(@PathVariable("id") String id,
                                                        @PathVariable("checked") Boolean checked) throws Exception {
        bizService.validFlagChecked(id, checked);
        return ServerResponse.ok();
    }


}