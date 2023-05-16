package com.github.itdachen.admin;

import com.github.itdachen.admin.sdk.dto.WorkerInfoDto;
import com.github.itdachen.admin.service.IWorkerInfoService;
import com.github.itdachen.admin.sdk.query.WorkerInfoQuery;
import com.github.itdachen.admin.sdk.vo.WorkerInfoVo;
import com.github.itdachen.framework.context.annotation.CheckApiClient;
import com.github.itdachen.framework.core.constants.ClientConstant;
import com.github.itdachen.framework.webmvc.controller.BizController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 员工信息
 *
 * @author 王大宸
 * @date 2023-05-16 19:37:24
 */
@Controller
@RequestMapping("/admin/worker/info")
@CheckApiClient(title = "员工信息", clientId = ClientConstant.CLIENT_WEB)
public class WorkerInfoController extends BizController<WorkerInfoDto, WorkerInfoVo, WorkerInfoQuery, String> {
    private static final Logger logger = LoggerFactory.getLogger(WorkerInfoController.class);
    private final IWorkerInfoService bizService;

    public WorkerInfoController(IWorkerInfoService bizService) {
        super(bizService);
        this.bizService = bizService;
    }


}