package com.github.itdachen.admin.controller;

import com.github.itdachen.admin.sdk.dto.DictTypeDto;
import com.github.itdachen.admin.sdk.query.DictTypeQuery;
import com.github.itdachen.admin.sdk.vo.DictDataVo;
import com.github.itdachen.admin.sdk.vo.DictTypeVo;
import com.github.itdachen.admin.service.IDictTypeService;
import com.github.itdachen.framework.context.annotation.CheckApiClient;
import com.github.itdachen.framework.context.exception.BizException;
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
 * 字典类型表
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:47
 */
@Controller
@RequestMapping("/admin/dict/type")
@CheckApiClient(title = "字典类型表", clientId = ClientConstant.CLIENT_WEB)
public class DictTypeController extends BizController<IDictTypeService, DictTypeDto, DictTypeVo, DictTypeQuery, String> {
    private static final Logger logger = LoggerFactory.getLogger(DictTypeController.class);
    private static final String PATH_PREFIX = "admin/dict/type" ;

    /***
     * 跳转到信息管理界面
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:47
     * @return java.lang.String
     */
    @GetMapping(value = "/index")
    @PreAuthorize("hasAuthority('admin:dict:type:index')")
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
    @GetMapping(value = "/add")
    @PreAuthorize("hasAuthority('admin:dict:type:save')")
    public String add() {
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
    @PreAuthorize("hasAuthority('admin:dict:type:update')")
    public String edit(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("dictType", bizService.selectByPrimaryKey(id));
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
    @PreAuthorize("hasAuthority('admin:dict:type:view')")
    public String see(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("dictType", bizService.selectByPrimaryKey(id));
        return PATH_PREFIX + "/see" ;
    }

    /***
     * 更新状态
     *
     * @author 王大宸
     * @date 2023/4/5 21:16
     * @param id id
     * @param status status
     * @return com.github.itdachen.framework.core.response.ServerResponse<com.github.itdachen.admin.sdk.vo.DictDataVo>
     */
    @PutMapping(value = "/{id}/status/{status}")
    @PreAuthorize("hasAuthority('admin:dict:type:update')")
    @ResponseBody
    public ServerResponse<DictDataVo> updateStatus(@PathVariable("id") String id, @PathVariable("status") Boolean status) throws BizException {
        return ServerResponse.okData(bizService.updateStatus(id, status));
    }

}