package com.github.itdachen.admin.controller;

import com.github.itdachen.admin.service.IDictTypeService;
import com.github.itdachen.admin.sdk.dto.DictTypeDTO;
import com.github.itdachen.admin.sdk.query.DictTypeQuery;
import com.github.itdachen.admin.sdk.vo.DictTypeVO;
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
 * 数据字典类型
 *
 * @author 王大宸
 * @date 2024-04-21 20:21:24
 */
@Controller
@RequestMapping("/admin/dict/type")
@FuncTitle("数据字典类型")
public class DictTypeController extends BizController<IDictTypeService, DictTypeDTO, DictTypeVO, DictTypeQuery, String> {
    private static final Logger logger = LoggerFactory.getLogger(DictTypeController.class);
    private static final String PATH_PREFIX = "admin/dict/type" ;

    /***
     * 跳转到信息管理界面
     *
     * @author 王大宸
     * @date 2024-04-21 20:21:24
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
     * @date 2024-04-21 20:21:24
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
     * @date 2024-04-21 20:21:24
     * @param id id
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
     * @date 2024-04-21 20:21:24
     * @param id 需要查看数据的 id
     * @param modelMap    modelMap
     * @return java.lang.String
     */
    @GetMapping(value = "/view/{id}")
    @PreAuthorize("hasAuthority('admin:dict:type:view')")
    public String view(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("dictType", bizService.selectByPrimaryKey(id));
        return PATH_PREFIX + "/view" ;
    }


}