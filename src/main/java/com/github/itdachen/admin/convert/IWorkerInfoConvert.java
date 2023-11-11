package com.github.itdachen.admin.convert;

import com.github.itdachen.admin.entity.WorkerInfo;
import com.github.itdachen.admin.sdk.dto.WorkerInfoDto;
import com.github.itdachen.admin.sdk.vo.WorkerInfoVo;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;

/**
 * Description:
 * Created by 王大宸 on 2023-06-26 14:47
 * Created with IntelliJ IDEA.
 */
public interface IWorkerInfoConvert extends IBizConvertMapper<WorkerInfo, WorkerInfoDto, WorkerInfoVo> {
}
