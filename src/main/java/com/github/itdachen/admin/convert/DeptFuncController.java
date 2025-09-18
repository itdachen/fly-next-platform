package com.github.itdachen.admin.convert;

import com.github.itdachen.admin.service.IDeptFuncService;
import com.github.itdachen.admin.sdk.dto.DeptFuncDTO;
import com.github.itdachen.admin.sdk.query.DeptFuncQuery;
import com.github.itdachen.admin.sdk.vo.DeptFuncVO;
import com.github.itdachen.framework.context.annotation.FuncTitle;
import com.github.itdachen.framework.webmvc.controller.BizController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.github.itdachen.framework.context.annotation.PageView;
import com.github.itdachen.framework.context.enums.PageTypeEnum;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 部门职能管理
 *
 * @author 王大宸
 * @date 2025-09-18 23:03:17
 */
@Controller
@RequestMapping("/admin/dept/func")
@FuncTitle("部门职能管理")
public class DeptFuncController extends BizController< IDeptFuncService, DeptFuncDTO, DeptFuncVO, DeptFuncQuery, String > {
    private static final Logger logger = LoggerFactory.getLogger(DeptFuncController.class);
    private static final String PATH_PREFIX = "admin/dept/func";

    /***
     * 跳转到信息管理界面
     *
     * @author 王大宸
     * @date 2025-09-18 23:03:17
     * @return java.lang.String
     */
    @GetMapping(value = "/index")
    @PreAuthorize("hasAuthority('fly:admin:dept:func:index')")
    @PageView(value = PageTypeEnum.INDEX)
    public String index() {
        return PATH_PREFIX + "/index";
    }

    /***
     * 跳转到添加页面
     *
     * @author 王大宸
     * @date 2025-09-18 23:03:17
     * @return java.lang.String
     */
    @GetMapping(value = "/add")
    @PreAuthorize("hasAuthority('fly:admin:dept:func:save')")
    @PageView(value = PageTypeEnum.SAVE)
    public String add() {
        return PATH_PREFIX + "/add";
    }

    /***
     * 跳转到修改页面
     *
     * @author 王大宸
     * @date 2025-09-18 23:03:17
     * @param id id
     * @param modelMap   modelMap
     * @return java.lang.String
     */
    @GetMapping(value = "/edit/{id}")
    @PreAuthorize("hasAuthority('fly:admin:dept:func:update')")
    @PageView(value = PageTypeEnum.UPDATE)
    public String edit(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("deptFunc", bizService.selectByPrimaryKey(id));
        return PATH_PREFIX + "/edit";
    }

    /***
     * 跳转到查看页面
     *
     * @author 王大宸
     * @date  2025-09-18 23:03:17
     * @param id 需要查看数据的 id
     * @param modelMap    modelMap
     * @return java.lang.String
     */
    @GetMapping(value = "/view/{id}")
    @PreAuthorize("hasAuthority('fly:admin:dept:func:view')")
    @PageView(value = PageTypeEnum.VIEW)
    public String view(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("deptFunc", bizService.selectByPrimaryKey(id));
        return PATH_PREFIX + "/view";
    }


}