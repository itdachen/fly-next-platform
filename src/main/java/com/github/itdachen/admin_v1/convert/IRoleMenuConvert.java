package com.github.itdachen.admin_v1.convert;

import com.github.itdachen.admin_v1.entity.RoleMenu;
import com.github.itdachen.admin_v1.sdk.dto.RoleMenuDto;
import com.github.itdachen.admin_v1.sdk.vo.RoleMenuVo;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;

/**
 * Description:
 * Created by 王大宸 on 2023-06-26 14:44
 * Created with IntelliJ IDEA.
 */
public interface IRoleMenuConvert extends IBizConvertMapper<RoleMenu, RoleMenuDto, RoleMenuVo> {
}
