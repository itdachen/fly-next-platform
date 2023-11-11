package com.github.itdachen.admin.controller;

import com.github.itdachen.admin.sdk.dto.ElementInfoDto;
import com.github.itdachen.admin.sdk.query.ElementInfoQuery;
import com.github.itdachen.admin.sdk.vo.ElementInfoVo;
import com.github.itdachen.admin.service.IElementInfoService;
import com.github.itdachen.framework.context.annotation.CheckApiClient;
import com.github.itdachen.framework.core.constants.ClientConstant;
import com.github.itdachen.framework.core.response.ServerResponse;
import com.github.itdachen.framework.webmvc.controller.BizController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * 按钮资源
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:47
 */
@Controller
@RequestMapping("/admin/element/info")
@CheckApiClient(title = "按钮资源", clientId = ClientConstant.CLIENT_WEB)
public class ElementInfoController extends BizController<IElementInfoService, ElementInfoDto, ElementInfoVo, ElementInfoQuery, String> {
    private static final Logger logger = LoggerFactory.getLogger(ElementInfoController.class);
    private static final String PATH_PREFIX = "admin/menu/element" ;

    /***
     * 跳转到信息管理界面
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:47
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
     * @date 2023-04-04 21:44:47
     * @return java.lang.String
     */
    @GetMapping(value = "/{menuId}/add")
    @PreAuthorize("hasAuthority('admin:element:info:save')")
    public String add(@PathVariable("menuId") String menuId, ModelMap modelMap) throws Exception {
        modelMap.put("menuId", menuId);
        return PATH_PREFIX + "/add" ;
    }

    /***
     * 跳转到修改页面
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:47
     * @param id         需要修改数据的id
     * @param modelMap   modelMap
     * @return java.lang.String
     */
    @GetMapping(value = "/edit/{id}")
    @PreAuthorize("hasAuthority('admin:element:info:update')")
    public String edit(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("elementInfo", bizService.getById(id));
        return PATH_PREFIX + "/edit" ;
    }

    /***
     * 跳转到查看页面
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:47
     * @param id          需要查看数据的id
     * @param modelMap    modelMap
     * @return java.lang.String
     */
    @GetMapping(value = "/view/{id}")
    @PreAuthorize("hasAuthority('admin:element:info:view')")
    public String see(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("elementInfo", bizService.getById(id));
        return PATH_PREFIX + "/see" ;
    }


    /***
     * 修改状态
     *
     * @author 王大宸
     * @date 2023/4/5 22:38
     * @param id id
     * @param status status
     * @return com.github.itdachen.framework.core.response.ServerResponse<com.github.itdachen.admin.sdk.vo.ElementInfoVo>
     */
    @PutMapping("/{id}/status/{status}")
    @ResponseBody
    @PreAuthorize("hasAuthority('admin:element:info:update')")
    public ServerResponse<ElementInfoVo> updateStatus(@PathVariable("id") String id,
                                                      @PathVariable("status") Boolean status) throws Exception {
        bizService.updateStatus(id, status);
        return ServerResponse.ok();
    }


}