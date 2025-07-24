package com.github.itdachen.my.controller;

import com.github.itdachen.framework.context.annotation.FuncTitle;
import com.github.itdachen.framework.core.response.ServerResponse;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.msg.sdk.query.MsgPoolQuery;
import com.github.itdachen.msg.sdk.vo.MsgPoolFileVO;
import com.github.itdachen.msg.sdk.vo.MsgPoolVO;
import com.github.itdachen.msg.service.IMsgPoolService;
import com.github.itdachen.my.service.IMyMsgService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * 我的消息
 *
 * @author 王大宸
 * @date 2025/7/24 21:05
 */
@Controller
@RequestMapping("/my/msg")
@FuncTitle("我的消息")
public class MyMsgController {
    private static final String PATH_PREFIX = "my/msg";

    private final IMyMsgService myMsgService;
    private final IMsgPoolService msgPoolService;

    public MyMsgController(IMyMsgService myMsgService,
                           IMsgPoolService msgPoolService) {
        this.myMsgService = myMsgService;
        this.msgPoolService = msgPoolService;
    }

    @GetMapping("/index")
    @PreAuthorize("hasAuthority('fly:my:msg:index')")
    public String index() {
        return PATH_PREFIX + "/index";
    }

    @GetMapping("/view/{id}")
   // @PreAuthorize("hasAuthority('fly:my:msg:view')")
    public String view(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("msgId", id);
        return PATH_PREFIX + "/view";
    }

    @GetMapping("/page")
    @ResponseBody
    public ServerResponse<TableData<MsgPoolVO>> myMsgPage(MsgPoolQuery msgPoolQuery) throws Exception {
        return ServerResponse.ok(myMsgService.myMsgPage(msgPoolQuery));
    }


    @PostMapping("/read/{id}")
    @ResponseBody
    public ServerResponse<MsgPoolVO> readMsgFlag(@PathVariable("id") String id) throws Exception {
        return ServerResponse.ok(myMsgService.readMsgFlag(id));
    }


    @GetMapping("/info/{id}")
    @ResponseBody
    public ServerResponse<MsgPoolVO> findMsgPoolInfo(@PathVariable("id") String id) throws Exception {
        return ServerResponse.ok(msgPoolService.findMsgPoolInfo(id));
    }


    @PostMapping("/download/file/{id}")
    @ResponseBody
    public ServerResponse<MsgPoolFileVO> downloadFile(@PathVariable("id") String id) throws Exception {
        return ServerResponse.ok(myMsgService.downloadFile(id));
    }


}
