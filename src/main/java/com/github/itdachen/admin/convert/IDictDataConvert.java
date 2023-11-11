package com.github.itdachen.admin.convert;

import com.github.itdachen.admin.entity.DictData;
import com.github.itdachen.admin.sdk.dto.DictDataDto;
import com.github.itdachen.admin.sdk.vo.DictDataVo;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;

/**
 * Description:
 * Created by 王大宸 on 2023-06-26 14:34
 * Created with IntelliJ IDEA.
 */
public interface IDictDataConvert extends IBizConvertMapper<DictData, DictDataDto, DictDataVo> {
}
