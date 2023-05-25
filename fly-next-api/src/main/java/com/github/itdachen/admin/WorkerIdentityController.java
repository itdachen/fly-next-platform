package com.github.itdachen.admin;

import com.github.itdachen.admin.sdk.dto.WorkerIdentityDto;
import com.github.itdachen.admin.sdk.dto.WorkerIdentityPositionDto;
import com.github.itdachen.admin.sdk.vo.WorkerIdentityPositionVo;
import com.github.itdachen.admin.service.IWorkerIdentityPositionService;
import com.github.itdachen.admin.service.IWorkerIdentityService;
import com.github.itdachen.admin.sdk.query.WorkerIdentityQuery;
import com.github.itdachen.admin.sdk.vo.WorkerIdentityVo;
import com.github.itdachen.framework.context.annotation.CheckApiClient;
import com.github.itdachen.framework.core.constants.ClientConstant;
import com.github.itdachen.framework.core.response.ServerResponse;
import com.github.itdachen.framework.webmvc.controller.BizController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 职工身份
 *
 * @author 王大宸
 * @date 2023-05-16 21:19:44
 */
@Controller
@RequestMapping("/admin/worker/identity")
@CheckApiClient(title = "职工身份", clientId = ClientConstant.CLIENT_WEB)
public class WorkerIdentityController extends BizController<IWorkerIdentityService, WorkerIdentityDto, WorkerIdentityVo, WorkerIdentityQuery, String> {
    private static final Logger logger = LoggerFactory.getLogger(WorkerIdentityController.class);
    private final IWorkerIdentityPositionService identityPositionService;

    public WorkerIdentityController(IWorkerIdentityPositionService identityPositionService) {
        this.identityPositionService = identityPositionService;
    }

    @PostMapping("/position")
    @ResponseBody
    public ServerResponse<WorkerIdentityPositionVo> saveIdentityPosition(@RequestBody WorkerIdentityPositionDto dto) throws Exception {
        return ServerResponse.okData(identityPositionService.save(dto));
    }

}