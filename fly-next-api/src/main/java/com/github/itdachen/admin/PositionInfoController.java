package com.github.itdachen.admin;

import com.github.itdachen.admin.sdk.dto.PositionInfoDto;
import com.github.itdachen.admin.service.IPositionInfoService;
import com.github.itdachen.admin.sdk.query.PositionInfoQuery;
import com.github.itdachen.admin.sdk.vo.PositionInfoVo;
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
 * 岗位信息
 *
 * @author 王大宸
 * @date 2023-05-15 20:13:36
 */
@Controller
@RequestMapping("/admin/position/info")
@CheckApiClient(title = "岗位信息", clientId = ClientConstant.CLIENT_WEB)
public class PositionInfoController extends BizController<PositionInfoDto, PositionInfoVo, PositionInfoQuery, String > {
    private static final Logger logger = LoggerFactory.getLogger(PositionInfoController.class);
    private final IPositionInfoService bizService;

    public PositionInfoController(IPositionInfoService bizService) {
        super(bizService);
        this.bizService = bizService;
    }


}