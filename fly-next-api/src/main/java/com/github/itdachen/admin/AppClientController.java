package com.github.itdachen.admin;

import com.github.itdachen.admin.sdk.dto.AppClientDto;
import com.github.itdachen.admin.sdk.query.AppClientQuery;
import com.github.itdachen.admin.sdk.vo.AppClientVo;
import com.github.itdachen.admin.service.IAppClientService;
import com.github.itdachen.framework.context.annotation.CheckApiClient;
import com.github.itdachen.framework.core.constants.ClientConstant;
import com.github.itdachen.framework.webmvc.controller.BizController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * 应用管理
 *
 * @author 王大宸
 * @date 2023-04-04 21:26:23
 */
@RestController
@RequestMapping("/admin/app/client")
@CheckApiClient(title = "应用管理", clientId = ClientConstant.CLIENT_WEB)
public class AppClientController extends BizController<AppClientDto, AppClientVo, AppClientQuery, String> {
    private static final Logger logger = LoggerFactory.getLogger(AppClientController.class);
    private final IAppClientService bizService;
    public AppClientController(IAppClientService bizService) {
        super(bizService);
        this.bizService = bizService;
    }

}