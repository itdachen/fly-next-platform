package com.github.itdachen.auth.mapper;

import java.util.List;

/**
 * 获取登录用户可用的菜单ID
 *
 * @author 王大宸
 * @date 2024/5/23 22:35
 */
public interface IUserDetailsRouteMapper {


    /***
     * 获取不需要授权的菜单ID
     *
     * @author 王大宸
     * @date 2024/5/23 22:37
     * @param appId appId
     * @return java.util.List<java.lang.String>
     */
    List<String> findNoopAuthMenu(String appId);

    /***
     * 获取不需要授权的按钮资源ID
     *
     * @author 王大宸
     * @date 2024/5/23 22:39
     * @param appId appId
     * @return java.util.List<java.lang.String>
     */
    List<String> findNoopAuthElement(String appId);

    /***
     * 根据用户角色ID,查询用户岗位权限菜单ID
     *
     * @author 王大宸
     * @date 2024/5/23 22:44
     * @param roleId roleId
     * @return java.util.List<java.lang.String>
     */
    List<String> findClazzAuthMenuAndElement(String roleId);


}
