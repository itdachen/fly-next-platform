package com.github.itdachen.oplog.controller;

import com.github.itdachen.oplog.service.IOplogInfoService;
import com.github.itdachen.oplog.sdk.dto.OplogInfoDTO;
import com.github.itdachen.oplog.sdk.query.OplogInfoQuery;
import com.github.itdachen.oplog.sdk.vo.OplogInfoVO;
import com.github.itdachen.framework.context.annotation.FuncTitle;
import com.github.itdachen.framework.webmvc.controller.BizController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.github.itdachen.framework.context.annotation.PageView;
import com.github.itdachen.framework.context.enums.PageTypeEnum;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 操作日志
 *
 * @author 王大宸
 * @date 2025-09-09 17:52:15
 */
@Controller
@RequestMapping("/oplog/info")
@FuncTitle("操作日志")
public class OplogInfoController extends BizController< IOplogInfoService, OplogInfoDTO, OplogInfoVO, OplogInfoQuery, String > {
    private static final Logger logger = LoggerFactory.getLogger(OplogInfoController.class);
    private static final String PATH_PREFIX = "oplog/info";

    /***
     * 跳转到信息管理界面
     *
     * @author 王大宸
     * @date 2025-09-09 17:52:15
     * @return java.lang.String
     */
    @GetMapping(value = "/index")
    @PreAuthorize("hasAuthority('fly:oplog:info:index')")
    @PageView(value = PageTypeEnum.INDEX)
    public String index() {
        return PATH_PREFIX + "/index";
    }

    /***
     * 跳转到添加页面
     *
     * @author 王大宸
     * @date 2025-09-09 17:52:15
     * @return java.lang.String
     */
    @GetMapping(value = "/add")
    @PreAuthorize("hasAuthority('fly:oplog:info:save')")
    @PageView(value = PageTypeEnum.SAVE)
    public String add() {
        return PATH_PREFIX + "/add";
    }

    /***
     * 跳转到修改页面
     *
     * @author 王大宸
     * @date 2025-09-09 17:52:15
     * @param id id
     * @param modelMap   modelMap
     * @return java.lang.String
     */
    @GetMapping(value = "/edit/{id}")
    @PreAuthorize("hasAuthority('fly:oplog:info:update')")
    @PageView(value = PageTypeEnum.UPDATE)
    public String edit(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("oplogInfo", bizService.selectByPrimaryKey(id));
        return PATH_PREFIX + "/edit";
    }

    /***
     * 跳转到查看页面
     *
     * @author 王大宸
     * @date  2025-09-09 17:52:15
     * @param id 需要查看数据的 id
     * @param modelMap    modelMap
     * @return java.lang.String
     */
    @GetMapping(value = "/view/{id}")
    @PreAuthorize("hasAuthority('fly:oplog:info:view')")
    @PageView(value = PageTypeEnum.VIEW)
    public String view(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("oplogInfo", bizService.selectByPrimaryKey(id));
        return PATH_PREFIX + "/view";
    }


}