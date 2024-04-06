package com.github.itdachen.admin_v1.service;

import com.github.itdachen.admin_v1.sdk.dto.WorkerInfoDto;
import com.github.itdachen.admin_v1.sdk.query.WorkerInfoQuery;
import com.github.itdachen.admin_v1.sdk.vo.WorkerInfoVo;
import com.github.itdachen.framework.webmvc.service.IBizService;

/**
 * 员工信息 业务接口
 *
 * @author 王大宸
 * @date 2023-05-16 19:37:24
 */
public interface IWorkerInfoService extends IBizService< WorkerInfoDto, WorkerInfoVo, WorkerInfoQuery, String > {

}
