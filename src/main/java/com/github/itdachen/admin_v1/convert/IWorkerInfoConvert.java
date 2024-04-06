package com.github.itdachen.admin_v1.convert;

import com.github.itdachen.admin_v1.entity.WorkerInfo;
import com.github.itdachen.admin_v1.sdk.dto.WorkerInfoDto;
import com.github.itdachen.admin_v1.sdk.vo.WorkerInfoVo;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;

/**
 * Description:
 * Created by 王大宸 on 2023-06-26 14:47
 * Created with IntelliJ IDEA.
 */
public interface IWorkerInfoConvert extends IBizConvertMapper<WorkerInfo, WorkerInfoDto, WorkerInfoVo> {
}
