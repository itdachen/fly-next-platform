package com.github.itdachen.admin.convert;

import com.github.itdachen.admin.entity.MenuInfo;
import com.github.itdachen.admin.sdk.dto.MenuInfoDto;
import com.github.itdachen.admin.sdk.vo.MenuInfoVo;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;

/**
 * Description:
 * Created by 王大宸 on 2023-06-26 14:40
 * Created with IntelliJ IDEA.
 */
public interface IMenuInfoConvert extends IBizConvertMapper<MenuInfo, MenuInfoDto, MenuInfoVo> {
}
