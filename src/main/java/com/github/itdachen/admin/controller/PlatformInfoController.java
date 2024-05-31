package com.github.itdachen.admin.controller;

import com.github.itdachen.admin.service.IPlatformInfoService;
import com.github.itdachen.admin.sdk.dto.PlatformInfoDTO;
import com.github.itdachen.admin.sdk.query.PlatformInfoQuery;
import com.github.itdachen.admin.sdk.vo.PlatformInfoVO;
import com.github.itdachen.framework.context.annotation.FuncTitle;
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
 * 平台信息
 *
 * @author 王大宸
 * @date 2024-04-20 16:04:52
 */
@Controller
@RequestMapping("/admin/platform/info")
@FuncTitle("平台信息")
public class PlatformInfoController extends BizController<IPlatformInfoService, PlatformInfoDTO, PlatformInfoVO, PlatformInfoQuery, String> {
    private static final Logger logger = LoggerFactory.getLogger(PlatformInfoController.class);
    private static final String PATH_PREFIX = "admin/platform" ;

    /***
     * 跳转到信息管理界面
     *
     * @author 王大宸
     * @date 2024-04-20 16:04:52
     * @return java.lang.String
     */
    @GetMapping(value = "/index")
    @PreAuthorize("hasAuthority('admin:platform:info:index')")
    public String index() {
        return PATH_PREFIX + "/index" ;
    }

    /***
     * 跳转到添加页面
     *
     * @author 王大宸
     * @date 2024-04-20 16:04:52
     * @return java.lang.String
     */
    @GetMapping(value = "/add")
    @PreAuthorize("hasAuthority('admin:platform:info:save')")
    public String add() {
        return PATH_PREFIX + "/add" ;
    }

    /***
     * 跳转到修改页面
     *
     * @author 王大宸
     * @date 2024-04-20 16:04:52
     * @param id id
     * @param modelMap   modelMap
     * @return java.lang.String
     */
    @GetMapping(value = "/edit/{id}")
    @PreAuthorize("hasAuthority('admin:platform:info:update')")
    public String edit(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("platformInfo", bizService.selectByPrimaryKey(id));
        return PATH_PREFIX + "/edit" ;
    }

    /***
     * 跳转到查看页面
     *
     * @author 王大宸
     * @date 2024-04-20 16:04:52
     * @param id 需要查看数据的 id
     * @param modelMap    modelMap
     * @return java.lang.String
     */
    @GetMapping(value = "/view/{id}")
    @PreAuthorize("hasAuthority('admin:platform:info:view')")
    public String view(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("platformInfo", bizService.selectByPrimaryKey(id));
        return PATH_PREFIX + "/view" ;
    }

    /***
     * 查询所有可用的平台信息
     *
     * @author 王大宸
     * @date 2024/4/20 16:43
     * @return com.github.itdachen.framework.core.response.ServerResponse<java.util.List < com.github.itdachen.admin.sdk.vo.PlatformInfoVO>>
     */
    @GetMapping("/list")
    @ResponseBody
    public ServerResponse<List<PlatformInfoVO>> findPlatformInfoList() throws Exception {
        return ServerResponse.ok(bizService.findPlatformInfoList());
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
    // @PreAuthorize("hasAuthority('admin:platform:info:checked')")
    public ServerResponse<PlatformInfoVO> validFlagChecked(@PathVariable("id") String id,
                                                           @PathVariable("checked") Boolean checked) throws Exception {
        bizService.validFlagChecked(id, checked);
        return ServerResponse.ok();
    }


}