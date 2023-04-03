package com.github.itdachen.admin.mapper;

import com.github.itdachen.framework.context.permission.PermissionInfo;
import com.github.itdachen.framework.core.permission.LoginUserModel;

import java.util.Set;

/**
 * Description:
 * Created by 王大宸 on 2022-08-27 11:13
 * Created with IntelliJ IDEA.
 */
public interface IUserDetailsMapper {

    /***
     * 根据登录账号查询用户信息
     *
     * @author 王大宸
     * @date 2022/9/25 13:57
     * @param username username
     * @return com.itdachen.security.core.LoginUserModel
     */
    LoginUserModel loadUserByUsername(String username);

    /***
     * 根据电话号码查询用户信息
     *
     * @author 王大宸
     * @date 2022/9/25 13:15
     * @param mobile mobile
     * @return com.itdachen.security.core.LoginUserModel
     */
    LoginUserModel loadUserByMobile(String mobile);

    /***
     * 获取权限资源(按钮权限,前后端分离时使用)
     *
     * @author 王大宸
     * @date 2021/11/27 12:09
     * @param
     * @return java.util.Set<com.itdachen.security.core.model.SysPermission>
     */
    Set<PermissionInfo> findPermissionAll();

    /***
     * 根据用户查询用户权限(按钮权限,前后端分离时使用)
     *
     * @author 王大宸
     * @date 2021/11/27 12:12
     * @param userId 用户id
     * @return java.util.Set<com.itdachen.security.core.model.SysPermission>
     */
    Set<PermissionInfo> findUserPermission(String userId);

    /***
     * 查询菜单权限编码(路径跳转权限)
     *
     * @author 王大宸
     * @date 2021/11/27 12:09
     * @param
     * @return java.util.Set<com.itdachen.security.core.model.SysPermission>
     */
    Set<PermissionInfo> findPermissionMenuAll();

    /***
     * 根据用户查询用户权限(非前后端分离,基于注解跳转页面)
     *
     * @author 王大宸
     * @date 2021/11/27 12:12
     * @param userId 用户id
     * @return java.util.Set<com.itdachen.security.core.model.SysPermission>
     */
    Set<PermissionInfo> findUserPermissionMenu(String userId);

}
