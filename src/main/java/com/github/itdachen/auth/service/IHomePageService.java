package com.github.itdachen.auth.service;

import com.github.itdachen.framework.context.permission.PermissionInfo;
import com.github.itdachen.framework.context.userdetails.UserInfoDetails;

/**
 * 查询首页菜单
 *
 * @author 王大宸
 * @date 2024/5/4 23:33
 */
public interface IHomePageService {

    PermissionInfo homePage(String appId, UserInfoDetails userDetails) throws Exception;


}
