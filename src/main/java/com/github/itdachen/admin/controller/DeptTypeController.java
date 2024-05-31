package com.github.itdachen.admin.controller;

import com.github.itdachen.admin.sdk.vo.PlatformInfoVO;
import com.github.itdachen.admin.service.IDeptTypeService;
import com.github.itdachen.admin.sdk.dto.DeptTypeDTO;
import com.github.itdachen.admin.sdk.query.DeptTypeQuery;
import com.github.itdachen.admin.sdk.vo.DeptTypeVO;
import com.github.itdachen.framework.context.annotation.FuncTitle;
import com.github.itdachen.framework.core.response.ServerResponse;
import com.github.itdachen.framework.webmvc.controller.BizController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * 部门类型管理
 *
 * @author 王大宸
 * @date 2024-04-24 21:47:25
 */
@Controller
@RequestMapping("/admin/dept/type")
@FuncTitle("部门类型管理")
public class DeptTypeController extends BizController<IDeptTypeService, DeptTypeDTO, DeptTypeVO, DeptTypeQuery, String> {
    private static final Logger logger = LoggerFactory.getLogger(DeptTypeController.class);
    private static final String PATH_PREFIX = "admin/dept/type";

    /***
     * 跳转到信息管理界面
     *
     * @author 王大宸
     * @date 2024-04-24 21:47:25
     * @return java.lang.String
     */
    @GetMapping(value = "/index")
    // @PreAuthorize("hasAuthority('admin:dept:type:index')")
    public String index() {
        return PATH_PREFIX + "/index";
    }

    /***
     * 跳转到添加页面
     *
     * @author 王大宸
     * @date 2024-04-24 21:47:25
     * @return java.lang.String
     */
    @GetMapping(value = "/add")
    //  @PreAuthorize("hasAuthority('admin:dept:type:save')")
    public String add() {
        return PATH_PREFIX + "/add";
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
    // @PreAuthorize("hasAuthority('admin:dept:type:update')")
    public String edit(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("deptType", bizService.selectByPrimaryKey(id));
        return PATH_PREFIX + "/edit";
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
    //  @PreAuthorize("hasAuthority('admin:dept:type:view')")
    public String view(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("deptType", bizService.selectByPrimaryKey(id));
        return PATH_PREFIX + "/view";
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
    // @PreAuthorize("hasAuthority('admin:dept:type:checked')")
    public ServerResponse<PlatformInfoVO> validFlagChecked(@PathVariable("id") String id,
                                                           @PathVariable("checked") Boolean checked) throws Exception {
        bizService.validFlagChecked(id, checked);
        return ServerResponse.ok();
    }


}