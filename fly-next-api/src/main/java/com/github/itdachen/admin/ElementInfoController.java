package com.github.itdachen.admin;

import com.github.itdachen.admin.sdk.dto.ElementInfoDto;
import com.github.itdachen.admin.service.IElementInfoService;
import com.github.itdachen.admin.sdk.query.ElementInfoQuery;
import com.github.itdachen.admin.sdk.vo.ElementInfoVo;
import com.github.itdachen.framework.context.annotation.CheckApiClient;
import com.github.itdachen.framework.core.constants.ClientConstant;
import com.github.itdachen.framework.webmvc.controller.BizController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 按钮资源
 *
 * @author 王大宸
 * @date 2023-05-09 20:26:39
 */
@Controller
@RequestMapping("/admin/element/info")
@CheckApiClient(title = "按钮资源", clientId = ClientConstant.CLIENT_WEB)
public class ElementInfoController extends BizController<IElementInfoService, ElementInfoDto, ElementInfoVo, ElementInfoQuery, String > {
    private static final Logger logger = LoggerFactory.getLogger(ElementInfoController.class);


}