package com.github.itdachen.msg.controller;

import com.github.itdachen.msg.service.IMsgFileService;
import com.github.itdachen.msg.sdk.dto.MsgFileDTO;
import com.github.itdachen.msg.sdk.query.MsgFileQuery;
import com.github.itdachen.msg.sdk.vo.MsgFileVO;
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
 * 消息附件
 *
 * @author 王大宸
 * @date 2025-07-11 22:52:18
 */
@Controller
@RequestMapping("/msg/file")
@FuncTitle("消息附件")
public class MsgFileController extends BizController< IMsgFileService, MsgFileDTO, MsgFileVO, MsgFileQuery, String > {
    private static final Logger logger = LoggerFactory.getLogger(MsgFileController.class);
    private static final String PATH_PREFIX = "msg/file";

    /***
     * 跳转到信息管理界面
     *
     * @author 王大宸
     * @date 2025-07-11 22:52:18
     * @return java.lang.String
     */
    @GetMapping(value = "/index")
    @PreAuthorize("hasAuthority('fly:msg:file:index')")
    public String index() {
        return PATH_PREFIX + "/index";
    }

    /***
     * 跳转到添加页面
     *
     * @author 王大宸
     * @date 2025-07-11 22:52:18
     * @return java.lang.String
     */
    @GetMapping(value = "/add")
    @PreAuthorize("hasAuthority('fly:msg:file:save')")
    public String add() {
        return PATH_PREFIX + "/add";
    }

    /***
     * 跳转到修改页面
     *
     * @author 王大宸
     * @date 2025-07-11 22:52:18
     * @param id id
     * @param modelMap   modelMap
     * @return java.lang.String
     */
    @GetMapping(value = "/edit/{id}")
    @PreAuthorize("hasAuthority('fly:msg:file:update')")
    public String edit(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("msgFile", bizService.selectByPrimaryKey(id));
        return PATH_PREFIX + "/edit";
    }

    /***
     * 跳转到查看页面
     *
     * @author 王大宸
     * @date  2025-07-11 22:52:18
     * @param id 需要查看数据的 id
     * @param modelMap    modelMap
     * @return java.lang.String
     */
    @GetMapping(value = "/view/{id}")
    @PreAuthorize("hasAuthority('fly:msg:file:view')")
    public String view(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("msgFile", bizService.selectByPrimaryKey(id));
        return PATH_PREFIX + "/view";
    }


}