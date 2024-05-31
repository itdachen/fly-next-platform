package com.github.itdachen.auth.mapper;

import com.github.itdachen.framework.context.permission.PermissionInfo;

import java.util.List;

/**
 * IHomePageMapper
 *
 * @author 王大宸
 * @date 2024/5/4 23:35
 */
public interface IHomePageMapper {

    /***
     * 系统首页
     *
     * @author 王大宸
     * @date 2024/5/4 23:50
     * @param parentId parentId
     * @return com.github.itdachen.framework.context.permission.PermissionInfo
     */
    PermissionInfo homePage(String parentId);

    /***
     * 获取系统首页
     *
     * @author 王大宸
     * @date 2024/5/24 16:09
     * @param parentId parentId
     * @param list list
     * @return com.github.itdachen.framework.context.permission.PermissionInfo
     */
    PermissionInfo userHomePage(String parentId, List<String> list);

}
