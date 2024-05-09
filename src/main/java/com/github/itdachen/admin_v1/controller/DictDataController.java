package com.github.itdachen.admin_v1.controller;

import com.github.itdachen.admin_v1.sdk.dto.DictDataDto;
import com.github.itdachen.admin_v1.sdk.query.DictDataQuery;
import com.github.itdachen.admin_v1.sdk.vo.DictDataVo;
import com.github.itdachen.admin_v1.service.IDictDataService;
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
 * 字典数据表
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:47
 */
@Controller
@RequestMapping("/admin/dict/data")
@CheckApiClient(title = "字典数据表", clientId = ClientConstant.CLIENT_WEB)
public class DictDataController extends BizController<IDictDataService, DictDataDto, DictDataVo, DictDataQuery, String> {
    private static final Logger logger = LoggerFactory.getLogger(DictDataController.class);
    private static final String PATH_PREFIX = "admin_v1/dict/data" ;

    /***
     * 跳转到信息管理界面
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:47
     * @return java.lang.String
     */
    @GetMapping(value = "/{dictType}/index")
    @PreAuthorize("hasAuthority('admin:dict:data:index')")
    public String index(@PathVariable("dictType") String dictType, ModelMap modelMap) {
        modelMap.put("dictType", dictType);
        return PATH_PREFIX + "/index" ;
    }

    /***
     * 跳转到添加页面
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:47
     * @return java.lang.String
     */
    @GetMapping(value = "/{dictType}/add")
    @PreAuthorize("hasAuthority('admin:dict:data:save')")
    public String add(@PathVariable("dictType") String dictType, ModelMap modelMap) {
        modelMap.put("dictType", dictType);
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
    @PreAuthorize("hasAuthority('admin:dict:data:update')")
    public String edit(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("dictData", bizService.selectByPrimaryKey(id));
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
    @PreAuthorize("hasAuthority('admin:dict:data:view')")
    public String see(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("dictData", bizService.selectByPrimaryKey(id));
        return PATH_PREFIX + "/see" ;
    }


    /***
     * 更新数据字典类型状态
     *
     * @author 王大宸
     * @date 2023/4/5 21:17
     * @param id        需要更新的数据字典id
     * @param status    需要更新的数据字典状态
     * @return com.github.itdachen.framework.core.response.ServerResponse<com.github.itdachen.admin.sdk.vo.DictDataVo>
     */
    @PutMapping(value = "/{id}/status/{status}")
    @ResponseBody
    @PreAuthorize("hasAuthority('admin:dict:data:update')")
    public ServerResponse<DictDataVo> updateStatus(@PathVariable("id") String id, @PathVariable("status") Boolean status) throws BizException {
        return ServerResponse.okData(bizService.updateStatus(id, status));
    }

}