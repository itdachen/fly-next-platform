package com.github.itdachen.oplog.controller;

import com.github.itdachen.oplog.service.IOplogPageViewService;
import com.github.itdachen.oplog.sdk.dto.OplogPageViewDTO;
import com.github.itdachen.oplog.sdk.query.OplogPageViewQuery;
import com.github.itdachen.oplog.sdk.vo.OplogPageViewVO;
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
 * 页面访问日志
 *
 * @author 王大宸
 * @date 2025-09-09 21:56:31
 */
@Controller
@RequestMapping("/oplog/page/view")
@FuncTitle("页面访问日志")
public class OplogPageViewController extends BizController<IOplogPageViewService, OplogPageViewDTO, OplogPageViewVO, OplogPageViewQuery, String> {
    private static final Logger logger = LoggerFactory.getLogger(OplogPageViewController.class);
    private static final String PATH_PREFIX = "oplog/page";

    /***
     * 跳转到信息管理界面
     *
     * @author 王大宸
     * @date 2025-09-09 21:56:31
     * @return java.lang.String
     */
    @GetMapping(value = "/index")
    @PreAuthorize("hasAuthority('fly:oplog:page:view:index')")
    @PageView(value = PageTypeEnum.INDEX)
    public String index() {
        return PATH_PREFIX + "/index";
    }

    /***
     * 跳转到查看页面
     *
     * @author 王大宸
     * @date 2025-09-09 21:56:31
     * @param id 需要查看数据的 id
     * @param modelMap    modelMap
     * @return java.lang.String
     */
    @GetMapping(value = "/view/{id}")
    @PreAuthorize("hasAuthority('fly:oplog:page:view:view')")
    @PageView(value = PageTypeEnum.VIEW)
    public String view(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("oplogPageView", bizService.selectByPrimaryKey(id));
        return PATH_PREFIX + "/view";
    }


}