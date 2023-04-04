package com.github.itdachen.admin.service;

import com.github.itdachen.admin.entity.UserInfo;
import com.github.itdachen.admin.sdk.query.UserInfoQuery;
import com.github.itdachen.admin.sdk.vo.UserInfoVo;
import com.github.itdachen.framework.webmvc.service.IBizService;

/**
 * 用户信息 业务接口
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
public interface IUserInfoService extends IBizService< UserInfo, UserInfoVo, UserInfoQuery, String > {

}
