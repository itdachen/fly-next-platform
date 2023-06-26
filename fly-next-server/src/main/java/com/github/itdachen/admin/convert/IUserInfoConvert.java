package com.github.itdachen.admin.convert;

import com.github.itdachen.admin.entity.UserInfo;
import com.github.itdachen.admin.sdk.dto.UserInfoDto;
import com.github.itdachen.admin.sdk.vo.UserInfoVo;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;

/**
 * Description:
 * Created by 王大宸 on 2023-06-26 14:45
 * Created with IntelliJ IDEA.
 */
public interface IUserInfoConvert extends IBizConvertMapper<UserInfo, UserInfoDto, UserInfoVo> {
}
