package com.github.itdachen.auth.manager.impl;

import com.github.itdachen.auth.manager.IUserMenuManager;
import com.github.itdachen.auth.mapper.IUserDetailsRouteMapper;
import com.github.itdachen.framework.context.userdetails.UserInfoDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * UserMenuManagerImpl
 *
 * @author 王大宸
 * @date 2024-05-24 17:00
 */
@Component
public class UserMenuManagerImpl implements IUserMenuManager {

    private final IUserDetailsRouteMapper userDetailsRouteMapper;

    public UserMenuManagerImpl(IUserDetailsRouteMapper userDetailsRouteMapper) {
        this.userDetailsRouteMapper = userDetailsRouteMapper;
    }


    @Override
    public List<String> canUsableMenu(String appId, UserInfoDetails userInfoDetails) {
        // 查询不需要授权的菜单
        List<String> authMenuList = userDetailsRouteMapper.findNoopAuthMenu(appId);
        // 查询岗位菜单
        List<String> clazzAuthMenuAndElement = userDetailsRouteMapper.findClazzAuthMenuAndElement(userInfoDetails.getRoleId());
        /* 授权的与不需要授权的合并 */
        authMenuList.addAll(clazzAuthMenuAndElement);
        /* 去重 */
        Set<String> hashSet = new HashSet<>(authMenuList);
        return new ArrayList<>(hashSet);
    }

}
