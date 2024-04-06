package com.github.itdachen.admin_v1.convert;

import com.github.itdachen.admin_v1.entity.WorkerIdentityPosition;
import com.github.itdachen.admin_v1.sdk.dto.WorkerIdentityPositionDto;
import com.github.itdachen.admin_v1.sdk.vo.WorkerIdentityPositionVo;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;

/**
 * Description:
 * Created by 王大宸 on 2023-06-26 14:47
 * Created with IntelliJ IDEA.
 */
public interface IWorkerIdentityPosttionConvert extends IBizConvertMapper<WorkerIdentityPosition, WorkerIdentityPositionDto, WorkerIdentityPositionVo> {


    WorkerIdentityPositionVo toJavaObjectVo(WorkerIdentityPositionDto workerIdentityPositionDto);

}
