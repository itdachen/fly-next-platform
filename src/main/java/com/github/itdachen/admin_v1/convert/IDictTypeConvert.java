package com.github.itdachen.admin_v1.convert;

import com.github.itdachen.admin_v1.entity.DictType;
import com.github.itdachen.admin_v1.sdk.dto.DictTypeDto;
import com.github.itdachen.admin_v1.sdk.vo.DictTypeVo;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;

/**
 * Description:
 * Created by 王大宸 on 2023-06-26 14:37
 * Created with IntelliJ IDEA.
 */
public interface IDictTypeConvert extends IBizConvertMapper<DictType, DictTypeDto, DictTypeVo> {
}
