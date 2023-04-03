package com.github.itdachen.admin.controller;

import com.github.itdachen.admin.service.IAppClientService;
import org.springframework.stereotype.Controller;

/**
 * 应用管理
 *
 * @author 王大宸
 * @date 2022-08-20 22:27:58
 */
@Controller
public class AppClientController {
    private final IAppClientService appClientService;


    public AppClientController(IAppClientService appClientService) {
        this.appClientService = appClientService;
    }


}
