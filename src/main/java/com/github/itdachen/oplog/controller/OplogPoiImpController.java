package com.github.itdachen.oplog.controller;

import com.github.itdachen.oplog.service.IOplogPoiImpService;
import com.github.itdachen.oplog.sdk.dto.OplogPoiImpDTO;
import com.github.itdachen.oplog.sdk.query.OplogPoiImpQuery;
import com.github.itdachen.oplog.sdk.vo.OplogPoiImpVO;
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
 * 导入日志
 *
 * @author 王大宸
 * @date 2025-07-28 15:55:31
 */
@Controller
@RequestMapping("/oplog/poi/imp")
@FuncTitle("导入日志")
public class OplogPoiImpController extends BizController< IOplogPoiImpService, OplogPoiImpDTO, OplogPoiImpVO, OplogPoiImpQuery, String > {
    private static final Logger logger = LoggerFactory.getLogger(OplogPoiImpController.class);
    private static final String PATH_PREFIX = "oplog/poi_imp";

    /***
     * 跳转到信息管理界面
     *
     * @author 王大宸
     * @date 2025-07-28 15:55:31
     * @return java.lang.String
     */
    @GetMapping(value = "/index")
    @PreAuthorize("hasAuthority('fly:oplog:poi:imp:index')")
    public String index() {
        return PATH_PREFIX + "/index";
    }

    /***
     * 跳转到添加页面
     *
     * @author 王大宸
     * @date 2025-07-28 15:55:31
     * @return java.lang.String
     */
    @GetMapping(value = "/add")
    @PreAuthorize("hasAuthority('fly:oplog:poi:imp:save')")
    public String add() {
        return PATH_PREFIX + "/add";
    }

    /***
     * 跳转到修改页面
     *
     * @author 王大宸
     * @date 2025-07-28 15:55:31
     * @param id id
     * @param modelMap   modelMap
     * @return java.lang.String
     */
    @GetMapping(value = "/edit/{id}")
    @PreAuthorize("hasAuthority('fly:oplog:poi:imp:update')")
    public String edit(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("oplogPoiImp", bizService.selectByPrimaryKey(id));
        return PATH_PREFIX + "/edit";
    }

    /***
     * 跳转到查看页面
     *
     * @author 王大宸
     * @date  2025-07-28 15:55:31
     * @param id 需要查看数据的 id
     * @param modelMap    modelMap
     * @return java.lang.String
     */
    @GetMapping(value = "/view/{id}")
    @PreAuthorize("hasAuthority('fly:oplog:poi:imp:view')")
    public String view(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("oplogPoiImp", bizService.selectByPrimaryKey(id));
        return PATH_PREFIX + "/view";
    }


}