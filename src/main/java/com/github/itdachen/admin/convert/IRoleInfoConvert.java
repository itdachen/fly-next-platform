package com.github.itdachen.admin.convert;

import com.github.itdachen.admin.entity.RoleInfo;
import com.github.itdachen.admin.sdk.dto.RoleInfoDto;
import com.github.itdachen.admin.sdk.vo.RoleInfoVo;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;

/**
 * Description:
 * Created by 王大宸 on 2023-06-26 14:43
 * Created with IntelliJ IDEA.
 */
public interface IRoleInfoConvert extends IBizConvertMapper<RoleInfo, RoleInfoDto, RoleInfoVo> {
}
