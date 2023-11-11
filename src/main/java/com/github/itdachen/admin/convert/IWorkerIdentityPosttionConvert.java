package com.github.itdachen.admin.convert;

import com.github.itdachen.admin.entity.WorkerIdentityPosition;
import com.github.itdachen.admin.sdk.dto.WorkerIdentityPositionDto;
import com.github.itdachen.admin.sdk.vo.WorkerIdentityPositionVo;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;

/**
 * Description:
 * Created by 王大宸 on 2023-06-26 14:47
 * Created with IntelliJ IDEA.
 */
public interface IWorkerIdentityPosttionConvert extends IBizConvertMapper<WorkerIdentityPosition, WorkerIdentityPositionDto, WorkerIdentityPositionVo> {


    WorkerIdentityPositionVo toJavaObjectVo(WorkerIdentityPositionDto workerIdentityPositionDto);

}
