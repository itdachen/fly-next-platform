package com.github.itdachen.admin.convert;

import com.github.itdachen.admin.entity.DeptInfo;
import com.github.itdachen.admin.sdk.dto.DeptInfoDto;
import com.github.itdachen.admin.sdk.vo.DeptInfoVo;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;

/**
 * Description:
 * Created by 王大宸 on 2023-06-26 14:32
 * Created with IntelliJ IDEA.
 */
public interface IDeptInfoConvert extends IBizConvertMapper<DeptInfo, DeptInfoDto, DeptInfoVo> {

    DeptInfo toJavaObject(DeptInfoVo deptInfoVo);

    DeptInfoVo toJavaObjectVo(DeptInfoDto deptInfoDto);

}
