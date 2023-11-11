package com.github.itdachen.dashboard.controller;

import com.github.itdachen.dashboard.sdk.query.LoginRecordQuery;
import com.github.itdachen.dashboard.sdk.vo.LoginRecordVO;
import com.github.itdachen.dashboard.service.ILoginRecordService;
import com.github.itdachen.framework.autoconfigure.client.FlyClientProperties;
import com.github.itdachen.framework.core.response.ServerResponse;
import com.github.itdachen.framework.core.response.TableData;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/***
 * 登录记录
 *
 * @author 王大宸
 * @date 2023/7/1 14:10
 */
@Controller
@RequestMapping("/record/login")
public class LoginRecordController {

    private final ILoginRecordService loginRecordService;
    private final FlyClientProperties clientProperties;

    public LoginRecordController(ILoginRecordService loginRecordService,
                                 FlyClientProperties clientProperties) {
        this.loginRecordService = loginRecordService;
        this.clientProperties = clientProperties;
    }

    @GetMapping("/index")
    @PreAuthorize("hasAuthority('record:login:index')")
    public String index() {
        return "admin/login/index";
    }


    @GetMapping("/page")
    @ResponseBody
    @PreAuthorize("hasAuthority('record:login:index')")
    public ServerResponse<TableData<LoginRecordVO>> page(LoginRecordQuery params) throws Exception {
        params.setClientId(clientProperties.getId());
        return ServerResponse.okData(loginRecordService.page(params));
    }

}
