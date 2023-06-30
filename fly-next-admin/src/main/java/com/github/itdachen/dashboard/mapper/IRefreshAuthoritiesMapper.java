package com.github.itdachen.dashboard.mapper;

import java.util.Set;

/**
 * Description:
 * Created by 王大宸 on 2023/05/07 0:23
 * Created with IntelliJ IDEA.
 */
public interface IRefreshAuthoritiesMapper {


    /***
     * 获取权限资源(按钮权限,前后端分离时使用)
     *
     * @author 王大宸
     * @date 2023/4/16 22:56
     * @return java.util.Set<java.lang.String>
     */
    Set<String> findPermissionAll();

    /***
     * 根据用户查询用户权限(按钮权限,前后端分离时使用)
     *
     * @author 王大宸
     * @date 2023/4/17 1:39
     * @param userId userId
     * @return java.util.Set<java.lang.String>
     */
    Set<String> findUserPermission(String userId);

}
