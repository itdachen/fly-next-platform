package com.github.itdachen.admin_v1.convert;

import com.github.itdachen.admin_v1.entity.UserInfo;
import com.github.itdachen.admin_v1.sdk.dto.UserInfoDto;
import com.github.itdachen.admin_v1.sdk.vo.UserInfoVo;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;

/**
 * Description:
 * Created by 王大宸 on 2023-06-26 14:45
 * Created with IntelliJ IDEA.
 */
public interface IUserInfoConvert extends IBizConvertMapper<UserInfo, UserInfoDto, UserInfoVo> {
}
