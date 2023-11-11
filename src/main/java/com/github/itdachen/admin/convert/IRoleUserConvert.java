package com.github.itdachen.admin.convert;

import com.github.itdachen.admin.entity.RoleUser;
import com.github.itdachen.admin.sdk.dto.RoleUserDto;
import com.github.itdachen.admin.sdk.vo.RoleUserVo;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;

/**
 * Description:
 * Created by 王大宸 on 2023-06-26 14:45
 * Created with IntelliJ IDEA.
 */
public interface IRoleUserConvert extends IBizConvertMapper<RoleUser, RoleUserDto, RoleUserVo> {
}
