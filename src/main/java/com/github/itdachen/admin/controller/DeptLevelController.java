package com.github.itdachen.admin.controller;

import com.github.itdachen.admin.service.IDeptLevelService;
import com.github.itdachen.admin.sdk.dto.DeptLevelDTO;
import com.github.itdachen.admin.sdk.query.DeptLevelQuery;
import com.github.itdachen.admin.sdk.vo.DeptLevelVO;
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
 * 部门等级
 *
 * @author 王大宸
 * @date 2025-09-18 22:02:49
 */
@Controller
@RequestMapping("/admin/dept/level")
@FuncTitle("部门等级")
public class DeptLevelController extends BizController< IDeptLevelService, DeptLevelDTO, DeptLevelVO, DeptLevelQuery, String > {
    private static final Logger logger = LoggerFactory.getLogger(DeptLevelController.class);
    private static final String PATH_PREFIX = "admin/dept/level";

    /***
     * 跳转到信息管理界面
     *
     * @author 王大宸
     * @date 2025-09-18 22:02:49
     * @return java.lang.String
     */
    @GetMapping(value = "/index")
    @PreAuthorize("hasAuthority('fly:admin:dept:level:index')")
    @PageView(value = PageTypeEnum.INDEX)
    public String index() {
        return PATH_PREFIX + "/index";
    }

    /***
     * 跳转到添加页面
     *
     * @author 王大宸
     * @date 2025-09-18 22:02:49
     * @return java.lang.String
     */
    @GetMapping(value = "/add")
    @PreAuthorize("hasAuthority('fly:admin:dept:level:save')")
    @PageView(value = PageTypeEnum.SAVE)
    public String add() {
        return PATH_PREFIX + "/add";
    }

    /***
     * 跳转到修改页面
     *
     * @author 王大宸
     * @date 2025-09-18 22:02:49
     * @param id id
     * @param modelMap   modelMap
     * @return java.lang.String
     */
    @GetMapping(value = "/edit/{id}")
    @PreAuthorize("hasAuthority('fly:admin:dept:level:update')")
    @PageView(value = PageTypeEnum.UPDATE)
    public String edit(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("deptLevel", bizService.selectByPrimaryKey(id));
        return PATH_PREFIX + "/edit";
    }

    /***
     * 跳转到查看页面
     *
     * @author 王大宸
     * @date  2025-09-18 22:02:49
     * @param id 需要查看数据的 id
     * @param modelMap    modelMap
     * @return java.lang.String
     */
    @GetMapping(value = "/view/{id}")
    @PreAuthorize("hasAuthority('fly:admin:dept:level:view')")
    @PageView(value = PageTypeEnum.VIEW)
    public String view(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("deptLevel", bizService.selectByPrimaryKey(id));
        return PATH_PREFIX + "/view";
    }


}