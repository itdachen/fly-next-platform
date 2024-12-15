package com.github.itdachen.auth.mapper;

import com.github.itdachen.framework.context.userdetails.UserInfoDetails;

/**
 * IUserDetailsMapper
 *
 * @author 王大宸
 * @date 2024/4/19 21:40
 */
public interface IUserDetailsMapper {

    /***
     * 根据登录账号查询用户信息
     *
     * @author 王大宸
     * @date 2024/4/29 22:29
     * @param username username
     * @return com.github.itdachen.boot.security.user.CurrentUserInfo
     */
    UserInfoDetails loadUserByUsername(String username);


    /***
     * 根据电话号码查询
     *
     * @author 王大宸
     * @date 2024/11/28 16:57
     * @param mobile mobile
     * @return
     */
    UserInfoDetails loadUserByMobile(String mobile);


    /***
     * 获取用户主身份标识
     *
     * @author 王大宸
     * @date 2024/4/29 23:36
     * @param userId userId
     * @return com.github.itdachen.framework.context.userdetails.UserInfoDetails
     */
    UserInfoDetails findRoleFlag(String userId);

}
