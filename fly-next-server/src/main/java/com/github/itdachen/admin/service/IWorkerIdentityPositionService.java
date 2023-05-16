package com.github.itdachen.admin.service;

import com.github.itdachen.admin.sdk.dto.WorkerIdentityPositionDto;
import com.github.itdachen.admin.sdk.query.WorkerIdentityPositionQuery;
import com.github.itdachen.admin.sdk.vo.WorkerIdentityPositionVo;
import com.github.itdachen.framework.webmvc.service.IBizService;

/**
 * 身份岗位 业务接口
 *
 * @author 王大宸
 * @date 2023-05-16 23:12:21
 */
public interface IWorkerIdentityPositionService extends IBizService<WorkerIdentityPositionDto, WorkerIdentityPositionVo, WorkerIdentityPositionQuery, String > {

}
