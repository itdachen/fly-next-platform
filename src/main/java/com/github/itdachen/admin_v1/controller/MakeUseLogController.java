package com.github.itdachen.admin_v1.controller;

import com.github.itdachen.admin_v1.sdk.dto.MakeUseLogDto;
import com.github.itdachen.admin_v1.sdk.query.MakeUseLogQuery;
import com.github.itdachen.admin_v1.sdk.vo.MakeUseLogVo;
import com.github.itdachen.admin_v1.service.IMakeUseLogService;
import com.github.itdachen.framework.context.annotation.CheckApiClient;
import com.github.itdachen.framework.core.constants.ClientConstant;
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
 * 日志表
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:45
 */
@Controller
@RequestMapping("/admin/make/use/log")
@CheckApiClient(title = "操作日志", clientId = ClientConstant.CLIENT_WEB)
public class MakeUseLogController extends BizController<IMakeUseLogService, MakeUseLogDto, MakeUseLogVo, MakeUseLogQuery, String> {
    private static final Logger logger = LoggerFactory.getLogger(MakeUseLogController.class);
    private static final String PATH_PREFIX = "admin/log";

    /***
     * 跳转到信息管理界面
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:45
     * @return java.lang.String
     */
    @GetMapping(value = "/index")
    @PreAuthorize("hasAuthority('admin:make:use:log:index')")
    public String index() {
        return PATH_PREFIX + "/index";
    }

    /***
     * 跳转到查看页面
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:45
     * @param id          需要查看数据的id
     * @param modelMap    modelMap
     * @return java.lang.String
     */
    @GetMapping(value = "/view/{id}")
    @PreAuthorize("hasAuthority('admin:make:use:log:view')")
    public String view(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("makeUseLog", bizService.selectByPrimaryKey(id));
        return PATH_PREFIX + "/view";
    }

}