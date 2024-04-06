package com.github.itdachen.admin_v1.service;

import com.github.itdachen.admin_v1.sdk.dto.WorkerIdentityDto;
import com.github.itdachen.admin_v1.sdk.query.WorkerIdentityQuery;
import com.github.itdachen.admin_v1.sdk.vo.WorkerIdentityVo;
import com.github.itdachen.framework.webmvc.service.IBizService;

/**
 * 职工身份 业务接口
 *
 * @author 王大宸
 * @date 2023-05-16 21:19:44
 */
public interface IWorkerIdentityService extends IBizService< WorkerIdentityDto, WorkerIdentityVo, WorkerIdentityQuery, String > {

}
