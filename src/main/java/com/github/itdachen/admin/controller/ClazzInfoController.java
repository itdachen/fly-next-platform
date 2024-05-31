package com.github.itdachen.admin.controller;

import com.github.itdachen.admin.service.IClazzInfoService;
import com.github.itdachen.admin.sdk.dto.ClazzInfoDTO;
import com.github.itdachen.admin.sdk.query.ClazzInfoQuery;
import com.github.itdachen.admin.sdk.vo.ClazzInfoVO;
import com.github.itdachen.framework.context.annotation.FuncTitle;
import com.github.itdachen.framework.core.response.ServerResponse;
import com.github.itdachen.framework.webmvc.controller.BizController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * 岗位信息
 *
 * @author 王大宸
 * @date 2024-04-25 22:40:02
 */
@Controller
@RequestMapping("/admin/clazz/info")
@FuncTitle("岗位信息")
public class ClazzInfoController extends BizController<IClazzInfoService, ClazzInfoDTO, ClazzInfoVO, ClazzInfoQuery, String> {
    private static final Logger logger = LoggerFactory.getLogger(ClazzInfoController.class);
    private static final String PATH_PREFIX = "admin/clazz" ;

    /***
     * 跳转到信息管理界面
     *
     * @author 王大宸
     * @date 2024-04-25 22:40:02
     * @return java.lang.String
     */
    @GetMapping(value = "/index")
    @PreAuthorize("hasAuthority('admin:clazz:info:index')")
    public String index() {
        return PATH_PREFIX + "/index" ;
    }

    /***
     * 跳转到添加页面
     *
     * @author 王大宸
     * @date 2024-04-25 22:40:02
     * @return java.lang.String
     */
    @GetMapping(value = "/add")
    @PreAuthorize("hasAuthority('admin:clazz:info:save')")
    public String add() {
        return PATH_PREFIX + "/add" ;
    }

    /***
     * 跳转到修改页面
     *
     * @author 王大宸
     * @date 2024-04-25 22:40:02
     * @param id id
     * @param modelMap   modelMap
     * @return java.lang.String
     */
    @GetMapping(value = "/edit/{id}")
    @PreAuthorize("hasAuthority('admin:clazz:info:update')")
    public String edit(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("clazzInfo", bizService.selectByPrimaryKey(id));
        return PATH_PREFIX + "/edit" ;
    }

    /***
     * 跳转到查看页面
     *
     * @author 王大宸
     * @date 2024-04-25 22:40:02
     * @param id 需要查看数据的 id
     * @param modelMap    modelMap
     * @return java.lang.String
     */
    @GetMapping(value = "/view/{id}")
    @PreAuthorize("hasAuthority('admin:clazz:info:view')")
    public String view(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("clazzInfo", bizService.selectByPrimaryKey(id));
        return PATH_PREFIX + "/view" ;
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
    public ServerResponse<ClazzInfoVO> validFlagChecked(@PathVariable("id") String id,
                                                        @PathVariable("checked") Boolean checked) throws Exception {
        bizService.validFlagChecked(id, checked);
        return ServerResponse.ok();
    }


}