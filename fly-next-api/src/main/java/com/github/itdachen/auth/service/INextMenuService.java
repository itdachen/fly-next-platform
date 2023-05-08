package com.github.itdachen.auth.service;

import com.github.itdachen.auth.entity.NextMenuRoute;

import java.util.List;

/**
 * Description:
 * Created by 王大宸 on 2023/05/08 21:04
 * Created with IntelliJ IDEA.
 */
public interface INextMenuService {

    /***
     * 获取菜单权限
     *
     * @author 王大宸
     * @date 2023/5/8 21:07
     * @return java.util.List<com.github.itdachen.auth.entity.NextMenuRoute>
     */
    List<NextMenuRoute> findNextMenuRoutes() throws Exception;

    /***
     * 获取按钮权限
     *
     * @author 王大宸
     * @date 2023/5/8 21:07
     * @return java.util.List<java.lang.String>
     */
    List<String> findNextPermission() throws Exception;

}
