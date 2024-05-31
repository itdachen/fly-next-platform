package com.github.itdachen.admin.controller;

import com.github.itdachen.admin.sdk.vo.PlatformInfoVO;
import com.github.itdachen.admin.service.IElementInfoService;
import com.github.itdachen.admin.sdk.dto.ElementInfoDTO;
import com.github.itdachen.admin.sdk.query.ElementInfoQuery;
import com.github.itdachen.admin.sdk.vo.ElementInfoVO;
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
 * 认证资源信息(按钮信息)
 *
 * @author 王大宸
 * @date 2024-04-20 22:16:39
 */
@Controller
@RequestMapping("/admin/element/info")
@FuncTitle("认证资源信息(按钮信息)")
public class ElementInfoController extends BizController<IElementInfoService, ElementInfoDTO, ElementInfoVO, ElementInfoQuery, String> {
    private static final Logger logger = LoggerFactory.getLogger(ElementInfoController.class);
    private static final String PATH_PREFIX = "admin/menu/element" ;

    /***
     * 跳转到信息管理界面
     *
     * @author 王大宸
     * @date 2024-04-20 22:16:39
     * @return java.lang.String
     */
    @GetMapping(value = "/index")
    @PreAuthorize("hasAuthority('admin:element:info:index')")
    public String index() {
        return PATH_PREFIX + "/index" ;
    }

    /***
     * 跳转到添加页面
     *
     * @author 王大宸
     * @date 2024-04-20 22:16:39
     * @return java.lang.String
     */
    @GetMapping(value = "/{appId}/menu/{menuId}/add")
    @PreAuthorize("hasAuthority('admin:element:info:save')")
    public String add(@PathVariable("appId") String appId,
                      @PathVariable("menuId") String menuId,
                      ModelMap modelMap) {
        modelMap.put("appId", appId);
        modelMap.put("menuId", menuId);
        return PATH_PREFIX + "/add" ;
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
    @PreAuthorize("hasAuthority('admin:element:info:update')")
    public String edit(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("elementInfo", bizService.selectByPrimaryKey(id));
        return PATH_PREFIX + "/edit" ;
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
    @PreAuthorize("hasAuthority('admin:element:info:view')")
    public String view(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("elementInfo", bizService.selectByPrimaryKey(id));
        return PATH_PREFIX + "/view" ;
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
    // @PreAuthorize("hasAuthority('admin:element:info:checked')")
    public ServerResponse<PlatformInfoVO> validFlagChecked(@PathVariable("id") String id,
                                                           @PathVariable("checked") Boolean checked) throws Exception {
        bizService.validFlagChecked(id, checked);
        return ServerResponse.ok();
    }


}