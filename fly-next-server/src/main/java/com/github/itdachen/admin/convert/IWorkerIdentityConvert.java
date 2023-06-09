package com.github.itdachen.admin.convert;

import com.github.itdachen.admin.entity.WorkerIdentity;
import com.github.itdachen.admin.sdk.dto.WorkerIdentityDto;
import com.github.itdachen.admin.sdk.vo.WorkerIdentityVo;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;

/**
 * Description:
 * Created by 王大宸 on 2023-06-26 14:46
 * Created with IntelliJ IDEA.
 */
public interface IWorkerIdentityConvert extends IBizConvertMapper<WorkerIdentity, WorkerIdentityDto, WorkerIdentityVo> {
}
