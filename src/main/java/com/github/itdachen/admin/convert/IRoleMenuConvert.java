package com.github.itdachen.admin.convert;

import com.github.itdachen.admin.entity.RoleMenu;
import com.github.itdachen.admin.sdk.dto.RoleMenuDto;
import com.github.itdachen.admin.sdk.vo.RoleMenuVo;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;

/**
 * Description:
 * Created by 王大宸 on 2023-06-26 14:44
 * Created with IntelliJ IDEA.
 */
public interface IRoleMenuConvert extends IBizConvertMapper<RoleMenu, RoleMenuDto, RoleMenuVo> {
}
