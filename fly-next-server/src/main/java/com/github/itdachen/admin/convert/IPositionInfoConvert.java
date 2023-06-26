package com.github.itdachen.admin.convert;

import com.github.itdachen.admin.entity.PositionInfo;
import com.github.itdachen.admin.sdk.dto.PositionInfoDto;
import com.github.itdachen.admin.sdk.vo.PositionInfoVo;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;

/**
 * Description:
 * Created by 王大宸 on 2023-06-26 14:42
 * Created with IntelliJ IDEA.
 */
public interface IPositionInfoConvert extends IBizConvertMapper<PositionInfo, PositionInfoDto, PositionInfoVo>  {
}
