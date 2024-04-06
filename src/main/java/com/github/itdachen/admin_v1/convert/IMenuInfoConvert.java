package com.github.itdachen.admin_v1.convert;

import com.github.itdachen.admin_v1.entity.MenuInfo;
import com.github.itdachen.admin_v1.sdk.dto.MenuInfoDto;
import com.github.itdachen.admin_v1.sdk.vo.MenuInfoVo;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;

/**
 * Description:
 * Created by 王大宸 on 2023-06-26 14:40
 * Created with IntelliJ IDEA.
 */
public interface IMenuInfoConvert extends IBizConvertMapper<MenuInfo, MenuInfoDto, MenuInfoVo> {
}
