package com.github.itdachen.admin.controller;

import com.github.itdachen.admin.service.IDictDataService;
import com.github.itdachen.admin.sdk.dto.DictDataDTO;
import com.github.itdachen.admin.sdk.query.DictDataQuery;
import com.github.itdachen.admin.sdk.vo.DictDataVO;
import com.github.itdachen.framework.context.annotation.FuncTitle;
import com.github.itdachen.framework.webmvc.controller.BizController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 数据字典信息表
 *
 * @author 王大宸
 * @date 2024-04-21 20:21:24
 */
@Controller
@RequestMapping("/admin/dict/data")
@FuncTitle("数据字典信息表")
public class DictDataController extends BizController<IDictDataService, DictDataDTO, DictDataVO, DictDataQuery, String> {
    private static final Logger logger = LoggerFactory.getLogger(DictDataController.class);
    private static final String PATH_PREFIX = "admin/dict/data" ;

    /***
     * 跳转到信息管理界面
     *
     * @author 王大宸
     * @date 2024-04-21 20:21:24
     * @return java.lang.String
     */
    @GetMapping(value = "/{typeId}/index")
   // @PreAuthorize("hasAuthority('admin:dict:data:index')")
    public String index(@PathVariable("typeId") String typeId, ModelMap modelMap) {
        modelMap.put("typeId", typeId);
        return PATH_PREFIX + "/index" ;
    }

    /***
     * 跳转到添加页面
     *
     * @author 王大宸
     * @date 2024-04-21 20:21:24
     * @return java.lang.String
     */
    @GetMapping(value = "/{typeId}/add")
    @PreAuthorize("hasAuthority('admin:dict:data:save')")
    public String add(@PathVariable("typeId") String typeId, ModelMap modelMap) {
        modelMap.put("typeId", typeId);
        return PATH_PREFIX + "/add" ;
    }

    /***
     * 跳转到修改页面
     *
     * @author 王大宸
     * @date 2024-04-21 20:21:24
     * @param id id
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
     * @date 2024-04-21 20:21:24
     * @param id 需要查看数据的 id
     * @param modelMap    modelMap
     * @return java.lang.String
     */
    @GetMapping(value = "/view/{id}")
    @PreAuthorize("hasAuthority('admin:dict:data:view')")
    public String view(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("dictData", bizService.selectByPrimaryKey(id));
        return PATH_PREFIX + "/view" ;
    }


}