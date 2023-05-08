package com.github.itdachen.admin;

import com.github.itdachen.admin.sdk.dto.MenuInfoDto;
import com.github.itdachen.admin.service.IMenuInfoService;
import com.github.itdachen.admin.sdk.query.MenuInfoQuery;
import com.github.itdachen.admin.sdk.vo.MenuInfoVo;
import com.github.itdachen.framework.context.annotation.CheckApiClient;
import com.github.itdachen.framework.core.constants.ClientConstant;
import com.github.itdachen.framework.webmvc.controller.BizController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 菜单管理
 *
 * @author 王大宸
 * @date 2023-05-08 22:40:36
 */
@Controller
@RequestMapping("/admin/menu/info")
@CheckApiClient(title = "菜单管理", clientId = ClientConstant.CLIENT_WEB)
public class MenuInfoController extends BizController<MenuInfoDto, MenuInfoVo, MenuInfoQuery, String> {
    private static final Logger logger = LoggerFactory.getLogger(MenuInfoController.class);
    private final IMenuInfoService bizService;

    public MenuInfoController(IMenuInfoService bizService) {
        super(bizService);
        this.bizService = bizService;
    }


}