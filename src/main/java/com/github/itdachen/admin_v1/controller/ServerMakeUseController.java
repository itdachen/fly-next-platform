package com.github.itdachen.admin_v1.controller;

import com.github.itdachen.framework.server.ServerInfoUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description: 系统监控
 * Created by 王大宸 on 2023/04/05 16:32
 * Created with IntelliJ IDEA.
 */
@Controller
@RequestMapping("/admin/server/use")
public class ServerMakeUseController {
    private static final String PATH_PREFIX = "admin/server" ;

    @GetMapping("/index")
    public String index(ModelMap modelMap) {
        modelMap.put("server", ServerInfoUtils.getServerInfo());
        return PATH_PREFIX + "/index" ;
    }


}
