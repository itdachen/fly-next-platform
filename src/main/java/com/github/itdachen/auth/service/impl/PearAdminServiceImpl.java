package com.github.itdachen.auth.service.impl;

import com.github.itdachen.auth.entity.PearAdminRoute;
import com.github.itdachen.auth.manager.IUserMenuManager;
import com.github.itdachen.auth.mapper.IPearAdminMapper;
import com.github.itdachen.auth.mapper.IUserDetailsRouteMapper;
import com.github.itdachen.auth.service.IPearAdminService;
import com.github.itdachen.framework.context.constants.UserTypeConstant;
import com.github.itdachen.framework.context.userdetails.UserInfoDetails;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Pear Admin Layui 后台获取菜单
 *
 * @author 王大宸
 * @date 2024/4/23 23:15
 */
@Service
public class PearAdminServiceImpl implements IPearAdminService {

    @Autowired
    private IPearAdminMapper pearAdminMapper;
    @Autowired
    private IUserMenuManager userMenuManager;

    @Override
    public List<PearAdminRoute> pearAdminMenu(HttpServletRequest request, String appId, UserInfoDetails userInfoDetails) {
        /* 超级管理员, 查询所有 */
        if (UserTypeConstant.SUPER_ADMINISTRATOR.equals(userInfoDetails.getUserType())) {
            return findPearAdminMenuAll(appId);
        }

        List<String> userUsableMenuID = userMenuManager.canUsableMenu(appId, userInfoDetails);
       if (userUsableMenuID.isEmpty()){
           return new ArrayList<>();
       }
        return getPearAdminMenu(appId, userUsableMenuID);
    }


    /***
     * 查询可用菜单
     *
     * @author 王大宸
     * @date 2024/5/23 22:09
     * @param parentId 上级菜单ID
     * @param list     可查询的菜单ID
     * @return java.util.List<com.github.itdachen.auth.entity.PearAdminRoute>
     */
    private List<PearAdminRoute> getPearAdminMenu(String parentId, List<String> list) {
        List<PearAdminRoute> menus = pearAdminMapper.findPearAdminMenu(parentId, list);
        List<PearAdminRoute> children = new ArrayList<>();
        for (PearAdminRoute map : menus) {
            children = getPearAdminMenu(String.valueOf(map.getId()), list);
            if (0 == children.size()) {
                continue;
            }
            map.setChildren(children);
        }
        return menus;
    }

    /***
     * 查询所有菜单
     *
     * @author 王大宸
     * @date 2024/5/23 22:18
     * @param parentId parentId
     * @return java.util.List<com.github.itdachen.auth.entity.PearAdminRoute>
     */
    private List<PearAdminRoute> findPearAdminMenuAll(String parentId) {
        List<PearAdminRoute> menus = pearAdminMapper.findPearAdminMenuAll(parentId);
        List<PearAdminRoute> children = new ArrayList<>();
        for (PearAdminRoute map : menus) {
            children = findPearAdminMenuAll(String.valueOf(map.getId()));
            if (0 == children.size()) {
                continue;
            }
            map.setChildren(children);
        }
        return menus;
    }

}
