package com.github.itdachen.dashboard.service.impl;


import com.github.itdachen.admin_v1.sdk.constants.MenuValidConstant;
import com.github.itdachen.dashboard.entity.LYearAdminMenu;
import com.github.itdachen.dashboard.entity.LayuiAdminMenu;
import com.github.itdachen.dashboard.entity.OkAdminMenu;
import com.github.itdachen.dashboard.mapper.IAuthenticationAuthorityMapper;
import com.github.itdachen.dashboard.service.IPermsAuthWebService;
import com.github.itdachen.framework.context.BizContextHandler;
import com.github.itdachen.framework.context.constants.UserTypeConstant;
import com.github.itdachen.framework.context.permission.PermissionInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description: 获取菜单
 * Created by 王大宸 on 2021-11-28 11:47
 * Created with IntelliJ IDEA.
 */
@Service
public class AdminPermsAuthService implements IPermsAuthWebService {
    private final IAuthenticationAuthorityMapper permsAuthMapper;

    public AdminPermsAuthService(IAuthenticationAuthorityMapper permsAuthMapper) {
        this.permsAuthMapper = permsAuthMapper;
    }

    /***
     * 登录查询菜单
     *
     * @author 王大宸
     * @date 2021/11/29 23:13
     * @param client     客户端id
     * @param userType   用户类型
     * @param userId     用户id
     * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
     */
    @Override
    public List<LayuiAdminMenu> findPermsAuthMenu(String client, String userType, String userId) {
        if (UserTypeConstant.SUPER_ADMINISTRATOR.equals(userType)) {
            return findMenuAll(client);
        }
        return getChildrenMenu(client, userId);
    }

    /***
     * 递归查询菜单
     *
     * @author 王大宸
     * @date 2021/11/29 23:14
     * @param pid     上级菜单id
     * @param userId  用户id
     * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
     */
    private List<LayuiAdminMenu> getChildrenMenu(String pid,
                                                 String userId) {
        List<LayuiAdminMenu> menus = permsAuthMapper.getChildrenMenu(pid, userId);
        for (LayuiAdminMenu map : menus) {
            List<LayuiAdminMenu> children = getChildrenMenu(String.valueOf(map.getId()), userId);
            if (0 == children.size()) {
                continue;
            }
            map.setList(children);
        }
        return menus;
    }


    private List<LayuiAdminMenu> findMenuAll(String pid) {
        List<LayuiAdminMenu> menus = permsAuthMapper.findMenuAll(pid);
        for (LayuiAdminMenu map : menus) {
            List<LayuiAdminMenu> children = findMenuAll(String.valueOf(map.getId()));
            if (0 == children.size()) {
                continue;
            }
            map.setList(children);
        }
        return menus;
    }


    /***
     * ok-admin 后台获取用户菜单
     *
     * @author 王大宸
     * @date 2022/2/25 21:33
     * @param client     客户点id
     * @param userType   用户类型
     * @param userId     用户id
     * @return java.util.List<com.itdachen.security.core.model.OkAdminMenu>
     */
    @Override
    public List<OkAdminMenu> getUserOkAdminMenu(String client,
                                                String userType,
                                                String userId) {
        if (UserTypeConstant.SUPER_ADMINISTRATOR.equals(userType)) {
            return getOkAdminMenuAll(client);
        }
        return getOkAdminChildrenMenu(client, userId);
    }

    @Override
    public PermissionInfo getHomeUri(String client) {
        PermissionInfo info = null;
        String userType = BizContextHandler.getUserType();
        if (UserTypeConstant.SUPER_ADMINISTRATOR.equals(userType)) {
            PermissionInfo homePage = permsAuthMapper.findHomePage(client);
            if (null == homePage) {
                return error404();
            }
            if (!MenuValidConstant.MENU.equals(homePage.getType())) {
                homePage = permsAuthMapper.findHomePage(homePage.getId());
            }
            if (MenuValidConstant.MENU.equals(homePage.getType())) {
                return homePage;
            }
            return error404();
        }
        info = permsAuthMapper.findIndexPath(client, BizContextHandler.getUserId());
        if (null == info) {
            String parentId = permsAuthMapper.findMenuPath(client, BizContextHandler.getUserId());
            info = permsAuthMapper.findIndexPath(parentId, BizContextHandler.getUserId());
        }
        if (null == info) {
            info = error404();
        }
        return info;
    }

    @Override
    public List<LYearAdminMenu> findLYearAdminMenu(String client, String userType, String userId) throws Exception {
        if (UserTypeConstant.SUPER_ADMINISTRATOR.equals(userType)) {
            return null;
        }
        return null;
    }

    private List<OkAdminMenu> getOkAdminMenuAll(String pid) {
        List<OkAdminMenu> menus = permsAuthMapper.getOkAdminMenuAll(pid);
        for (OkAdminMenu menu : menus) {
            List<OkAdminMenu> children = getOkAdminMenuAll(menu.getId());
            if (0 == children.size()) {
                continue;
            }
            menu.setChildren(children);
        }
        return menus;
    }

    private List<OkAdminMenu> getOkAdminChildrenMenu(String pid,
                                                     String userId) {
        List<OkAdminMenu> menus = permsAuthMapper.getOkAdminChildrenMenu(pid, userId);
        for (OkAdminMenu menu : menus) {
            List<OkAdminMenu> children = getOkAdminChildrenMenu(menu.getId(), userId);
            if (0 == children.size()) {
                continue;
            }
            menu.setChildren(children);
        }
        return menus;
    }


    /***
     * error404
     *
     * @author 王大宸
     * @date 2022/10/26 0:40
     * @return com.itdachen.security.core.PermissionInfo
     */
    private PermissionInfo error404() {
        PermissionInfo info = new PermissionInfo();
        info.setUri("/error/404");
        info.setName("404");
        return info;
    }

}
