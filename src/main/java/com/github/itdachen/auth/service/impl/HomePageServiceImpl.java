package com.github.itdachen.auth.service.impl;

import com.github.itdachen.auth.manager.IUserMenuManager;
import com.github.itdachen.auth.mapper.IHomePageMapper;
import com.github.itdachen.auth.mapper.IUserDetailsRouteMapper;
import com.github.itdachen.auth.service.IHomePageService;
import com.github.itdachen.boot.run.handler.ContextPathHandler;
import com.github.itdachen.framework.context.constants.MenuElementConstant;
import com.github.itdachen.framework.context.constants.UserTypeConstant;
import com.github.itdachen.framework.context.permission.PermissionInfo;
import com.github.itdachen.framework.context.userdetails.UserInfoDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * HomePageServiceImpl
 *
 * @author 王大宸
 * @date 2024/5/4 23:34
 */
@Service
public class HomePageServiceImpl implements IHomePageService {
    private final IUserDetailsRouteMapper userDetailsRouteMapper;
    private final IUserMenuManager userMenuManager;
    private final IHomePageMapper homePageMapper;

    public HomePageServiceImpl(IHomePageMapper homePageMapper,
                               IUserDetailsRouteMapper userDetailsRouteMapper,
                               IUserMenuManager userMenuManager) {
        this.homePageMapper = homePageMapper;
        this.userDetailsRouteMapper = userDetailsRouteMapper;
        this.userMenuManager = userMenuManager;
    }

    @Override
    public PermissionInfo homePage(String appId, UserInfoDetails userDetails) throws Exception {
        if (UserTypeConstant.SUPER_ADMINISTRATOR.equals(userDetails.getUserType())) {
            PermissionInfo info = findHomePage(appId);
            if (null == info) {
                return error404();
            }
            return info;
        }

        /* 获取可用的菜单ID */
        List<String> userUsableMenuID = userMenuManager.canUsableMenu(appId, userDetails);

        PermissionInfo userHomePage = findUserHomePage(appId, userUsableMenuID);
        if (null == userHomePage) {
            return error404();
        }
        return userHomePage;
    }


    /***
     * 超级管理员查询首页展示菜单
     *
     * @author 王大宸
     * @date 2024/5/4 23:46
     * @param parentId parentId
     * @return com.github.itdachen.framework.context.permission.PermissionInfo
     */
    private PermissionInfo findHomePage(String parentId) {
        PermissionInfo permissionInfo = homePageMapper.homePage(parentId);
        if (null == permissionInfo) {
            return error404();
        }
        if (MenuElementConstant.RESOURCE_TYPE_MENU.equals(permissionInfo.getType())) {
            return permissionInfo;
        }
        return findHomePage(permissionInfo.getId());
    }

    /***
     * 用户获取主页
     *
     * @author 王大宸
     * @date 2024/5/24 16:03
     * @param parentId parentId
     * @param list list
     * @return com.github.itdachen.framework.context.permission.PermissionInfo
     */
    private PermissionInfo findUserHomePage(String parentId, List<String> list) {
        PermissionInfo permissionInfo = homePageMapper.userHomePage(parentId, list);
        if (null == permissionInfo) {
            return error404();
        }
        if (MenuElementConstant.RESOURCE_TYPE_MENU.equals(permissionInfo.getType())) {
            return permissionInfo;
        }
        return findUserHomePage(permissionInfo.getId(), list);
    }

    /***
     * error404
     *
     * @author 王大宸
     * @date 2024/5/4 23:38
     * @return com.github.itdachen.framework.context.permission.PermissionInfo
     */
    private PermissionInfo error404() {
        PermissionInfo info = new PermissionInfo();
        info.setId("1567182766066503680");
        info.setUri(ContextPathHandler.contextPath() + "/error/404");
        info.setName("404");
        return info;
    }


    /***
     * 获取可用的菜单ID
     *
     * @author 王大宸
     * @date 2024/5/23 23:04
     * @param appId appId
     * @param userInfoDetails userInfoDetails
     * @return java.util.List<java.lang.String>
     */
    private List<String> getUserUsableMenuID(String appId, UserInfoDetails userInfoDetails) {
        // 查询不需要授权的菜单
        List<String> noopAuthMenu = userDetailsRouteMapper.findNoopAuthMenu(appId);

        // 查询岗位菜单
        List<String> clazzAuthMenuAndElement = userDetailsRouteMapper.findClazzAuthMenuAndElement(userInfoDetails.getRoleId());

        /* 授权的与不需要授权的合并 */
        noopAuthMenu.addAll(clazzAuthMenuAndElement);

        /* 去重 */
        Set<String> hashSet = new HashSet<>(noopAuthMenu);
        return new ArrayList<>(hashSet);
    }

}
