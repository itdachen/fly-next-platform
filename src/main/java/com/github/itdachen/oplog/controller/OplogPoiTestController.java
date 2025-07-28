package com.github.itdachen.oplog.controller;

import com.github.itdachen.oplog.service.IOplogPoiTestService;
import com.github.itdachen.oplog.sdk.dto.OplogPoiTestDTO;
import com.github.itdachen.oplog.sdk.query.OplogPoiTestQuery;
import com.github.itdachen.oplog.sdk.vo.OplogPoiTestVO;
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
 * 导入导出测试
 *
 * @author 王大宸
 * @date 2025-07-28 16:55:09
 */
@Controller
@RequestMapping("/oplog/poi/test")
@FuncTitle("导入导出测试")
public class OplogPoiTestController extends BizController<IOplogPoiTestService, OplogPoiTestDTO, OplogPoiTestVO, OplogPoiTestQuery, String> {
    private static final Logger logger = LoggerFactory.getLogger(OplogPoiTestController.class);
    private static final String PATH_PREFIX = "oplog/poi_test";

    /***
     * 跳转到信息管理界面
     *
     * @author 王大宸
     * @date 2025-07-28 16:55:09
     * @return java.lang.String
     */
    @GetMapping(value = "/index")
    @PreAuthorize("hasAuthority('fly:oplog:poi:test:index')")
    public String index() {
        return PATH_PREFIX + "/index";
    }

    /***
     * 跳转到添加页面
     *
     * @author 王大宸
     * @date 2025-07-28 16:55:09
     * @return java.lang.String
     */
    @GetMapping(value = "/add")
    @PreAuthorize("hasAuthority('fly:oplog:poi:test:save')")
    public String add() {
        return PATH_PREFIX + "/add";
    }

    /***
     * 跳转到修改页面
     *
     * @author 王大宸
     * @date 2025-07-28 16:55:09
     * @param id id
     * @param modelMap   modelMap
     * @return java.lang.String
     */
    @GetMapping(value = "/edit/{id}")
    @PreAuthorize("hasAuthority('fly:oplog:poi:test:update')")
    public String edit(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("oplogPoiTest", bizService.selectByPrimaryKey(id));
        return PATH_PREFIX + "/edit";
    }

    /***
     * 跳转到查看页面
     *
     * @author 王大宸
     * @date 2025-07-28 16:55:09
     * @param id 需要查看数据的 id
     * @param modelMap    modelMap
     * @return java.lang.String
     */
    @GetMapping(value = "/view/{id}")
    @PreAuthorize("hasAuthority('fly:oplog:poi:test:view')")
    public String view(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("oplogPoiTest", bizService.selectByPrimaryKey(id));
        return PATH_PREFIX + "/view";
    }


}