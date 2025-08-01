package com.github.itdachen.msg.controller;

import com.github.itdachen.framework.core.response.ServerResponse;
import com.github.itdachen.msg.service.IMsgPoolService;
import com.github.itdachen.msg.sdk.dto.MsgPoolDTO;
import com.github.itdachen.msg.sdk.query.MsgPoolQuery;
import com.github.itdachen.msg.sdk.vo.MsgPoolVO;
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
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 消息池
 *
 * @author 王大宸
 * @date 2025-07-11 22:52:18
 */
@Controller
@RequestMapping("/msg/pool")
@FuncTitle("消息池")
public class MsgPoolController extends BizController<IMsgPoolService, MsgPoolDTO, MsgPoolVO, MsgPoolQuery, String> {
    private static final Logger logger = LoggerFactory.getLogger(MsgPoolController.class);
    private static final String PATH_PREFIX = "msg/pool";

    /***
     * 跳转到信息管理界面
     *
     * @author 王大宸
     * @date 2025-07-11 22:52:18
     * @return java.lang.String
     */
    @GetMapping(value = "/index")
    @PreAuthorize("hasAuthority('fly:msg:pool:index')")
    public String index() {
        return PATH_PREFIX + "/index";
    }

    /***
     * 跳转到查看页面
     *
     * @author 王大宸
     * @date 2025-07-11 22:52:18
     * @param id 需要查看数据的 id
     * @param modelMap    modelMap
     * @return java.lang.String
     */
    @GetMapping(value = "/view/{id}")
    @PreAuthorize("hasAuthority('fly:msg:pool:view')")
    public String view(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("msgId", id);
        return PATH_PREFIX + "/view";
    }

    @GetMapping("/info/{id}")
    @ResponseBody
    public ServerResponse<MsgPoolVO> findMsgPoolInfo(@PathVariable("id") String id) throws Exception {
        return ServerResponse.ok(bizService.findMsgPoolInfo(id));
    }


}