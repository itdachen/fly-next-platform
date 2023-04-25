package com.github.itdachen.auth.mapper;

import com.github.itdachen.framework.context.userdetails.CurrentUserDetails;

/**
 * Description: 查询登录用户信息
 * Created by 王大宸 on 2023/04/25 20:52
 * Created with IntelliJ IDEA.
 */
public interface IAuthorizedMapper {

    /***
     * 根据登录账号查询用户信息
     *
     * @author 王大宸
     * @date 2023/4/25 21:14
     * @param username username
     * @return com.github.itdachen.framework.context.userdetails.CurrentUserDetails
     */
    CurrentUserDetails loadUserByUsername(String username);

}
