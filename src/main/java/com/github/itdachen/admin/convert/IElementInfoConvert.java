package com.github.itdachen.admin.convert;

import com.github.itdachen.admin.entity.ElementInfo;
import com.github.itdachen.admin.sdk.dto.ElementInfoDto;
import com.github.itdachen.admin.sdk.vo.ElementInfoVo;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;
import org.springframework.stereotype.Component;

/**
 * Description:
 * Created by 王大宸 on 2023-06-26 14:38
 * Created with IntelliJ IDEA.
 */
@Component
public interface IElementInfoConvert extends IBizConvertMapper<ElementInfo, ElementInfoDto, ElementInfoVo> {
}
