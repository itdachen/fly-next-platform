package com.github.itdachen.security.web.service.impl;

import com.github.itdachen.framework.context.permission.PermissionInfo;
import com.github.itdachen.security.user.LYearAdminMenu;
import com.github.itdachen.security.user.LayuiAdminMenu;
import com.github.itdachen.security.user.OkAdminMenu;
import com.github.itdachen.security.web.service.IPermsAuthWebService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Created by 王大宸 on 2022-09-25 15:16
 * Created with IntelliJ IDEA.
 */
public class DefaultPermsAuthWebService implements IPermsAuthWebService {
    private static final Logger logger = LoggerFactory.getLogger(DefaultPermsAuthWebService.class);


    @Override
    public List<LayuiAdminMenu> findPermsAuthMenu(String client, String userType, String userId) {
        logger.info("获取菜单的客户端: " + client);
        logger.info("获取菜单的用户类型: " + userType);
        logger.info("获取菜单的用户id: " + userId);
        logger.info("各子系统各自实现");
        return new ArrayList<>();
    }

    @Override
    public List<OkAdminMenu> getUserOkAdminMenu(String client, String userType, String userId) {
        logger.info("获取菜单的客户端: " + client);
        logger.info("获取菜单的用户类型: " + userType);
        logger.info("获取菜单的用户id: " + userId);
        logger.info("各子系统各自实现");
        return new ArrayList<>();
    }

    @Override
    public PermissionInfo getHomeUri(String client) {
        logger.info("查询用户首页访问路径, 客户端: " + client);
        PermissionInfo info = new PermissionInfo();
        info.setUri("/dashboard/console");
        info.setName("控制台");
        return info;
    }

    /***
     * 获取光年后台管理模板菜单
     *
     * @author 王大宸
     * @date 2023/2/3 9:17
     * @param client client
     * @param userType userType
     * @param userId userId
     * @return java.util.List<LYearAdminMenu>
     */
    @Override
    public List<LYearAdminMenu> findLYearAdminMenu(String client, String userType, String userId) throws Exception {
        logger.info("获取光年后台管理模板菜单的客户端: " + client);
        logger.info("获取光年后台管理模板菜单的用户类型: " + userType);
        logger.info("获取光年后台管理模板菜单的用户id: " + userId);
        logger.info("各子系统各自实现");
        return new ArrayList<>();
    }

}
