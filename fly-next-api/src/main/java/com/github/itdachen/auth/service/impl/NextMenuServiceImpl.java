package com.github.itdachen.auth.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.itdachen.auth.constants.RedisKeyConstant;
import com.github.itdachen.auth.entity.MenuRoutePo;
import com.github.itdachen.auth.entity.NextMenuRoute;
import com.github.itdachen.auth.entity.NextMetaMenu;
import com.github.itdachen.auth.mapper.INextMenuMapper;
import com.github.itdachen.auth.service.INextMenuService;
import com.github.itdachen.framework.context.BizContextHandler;
import com.github.itdachen.framework.context.constants.UserTypeConstant;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 * Created by 王大宸 on 2023/05/08 21:04
 * Created with IntelliJ IDEA.
 */
@Service
public class NextMenuServiceImpl implements INextMenuService {
    private static final Logger logger = LoggerFactory.getLogger(NextMenuServiceImpl.class);
    /* 是否使用  redis 存储存放权限 */
    private static final Boolean hasMenuRedis = false;
    private static final String CLIENT_ID = "NEXT_APP";
    private final INextMenuMapper nextMenuMapper;
    private final StringRedisTemplate stringRedisTemplate;

    public NextMenuServiceImpl(INextMenuMapper nextMenuMapper,
                               StringRedisTemplate stringRedisTemplate) {
        this.nextMenuMapper = nextMenuMapper;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    /***
     * 获取菜单权限
     *
     * @author 王大宸
     * @date 2023/5/8 21:07
     * @return java.util.List<com.github.itdachen.auth.entity.NextMenuRoute>
     */
    @Override
    public List<NextMenuRoute> findNextMenuRoutes() throws Exception {
        if (!hasMenuRedis) {
            if (UserTypeConstant.SUPER_ADMINISTRATOR.equals(BizContextHandler.getUserType()) ||
                    UserTypeConstant.SUPER_ADMINISTRATOR_USERNAME.equals(BizContextHandler.getAccount())) {
                return oAuthMenuAll(CLIENT_ID);
            }
            return userOAuthMenu(BizContextHandler.getUserId(), CLIENT_ID);
        }
        /* 线上环境, redis 缓存 */
        String key = RedisKeyConstant.USER_PERMISSIONS_MENU + BizContextHandler.getUserId();
        String s = stringRedisTemplate.opsForValue().get(key);
        if (null == s || StringUtils.isBlank(s)) {
            // String parentId = oauthMenuRouteMapper.findIdByParentId(CLIENT_ID);
            List<NextMenuRoute> list = new ArrayList<>();
            if (UserTypeConstant.SUPER_ADMINISTRATOR.equals(BizContextHandler.getUserType()) ||
                    UserTypeConstant.SUPER_ADMINISTRATOR_USERNAME.equals(BizContextHandler.getAccount())) {
                list = oAuthMenuAll(CLIENT_ID);
            } else {
                list = userOAuthMenu(BizContextHandler.getUserId(), CLIENT_ID);
            }

            // 保存20分钟, 20分钟后自动删除
            stringRedisTemplate.opsForValue().set(key,
                    JSON.toJSONString(list),
                    RedisKeyConstant.USER_PERMISSIONS_TIME_OUT,
                    TimeUnit.MINUTES);
            return list;
        }
        return JSON.parseArray(s, NextMenuRoute.class);
    }

    /***
     * 获取按钮权限
     *
     * @author 王大宸
     * @date 2023/5/8 21:07
     * @return java.util.List<java.lang.String>
     */
    @Override
    public List<String> findNextPermission() throws Exception {
        if (!hasMenuRedis) {
            if (UserTypeConstant.SUPER_ADMINISTRATOR.equals(BizContextHandler.getUserType()) ||
                    UserTypeConstant.SUPER_ADMINISTRATOR_USERNAME.equals(BizContextHandler.getAccount())) {
                return nextMenuMapper.permissionAll(CLIENT_ID);
            }
            return nextMenuMapper.userPermission(CLIENT_ID, BizContextHandler.getUserId());
        }

        /* 存入redis */
        String key = RedisKeyConstant.USER_PERMISSIONS_ELEMENT + BizContextHandler.getUserId();
        String s = stringRedisTemplate.opsForValue().get(key);
        if (null == s || StringUtils.isBlank(s)) {
            List<String> list;
            if (UserTypeConstant.SUPER_ADMINISTRATOR.equals(BizContextHandler.getUserType()) ||
                    UserTypeConstant.SUPER_ADMINISTRATOR_USERNAME.equals(BizContextHandler.getAccount())) {
                list = nextMenuMapper.permissionAll(CLIENT_ID);
            } else {
                list = nextMenuMapper.userPermission(CLIENT_ID, BizContextHandler.getUserId());
            }
            // 保存20分钟, 20分钟后自动删除
            stringRedisTemplate.opsForValue().set(key,
                    JSON.toJSONString(list),
                    RedisKeyConstant.USER_PERMISSIONS_TIME_OUT,
                    TimeUnit.MINUTES);
            return list;
        }
        return JSON.parseArray(s, String.class);
    }


    /***
     * 获取所有的菜单
     *
     * @author 王大宸
     * @date 2022/6/30 14:25
     * @param parentId parentId
     * @return java.util.List<com.itdachen.auth.oauth.entity.MenuRoute>
     */
    private List<NextMenuRoute> oAuthMenuAll(String parentId) {
        List<MenuRoutePo> list = nextMenuMapper.userOAuthMenuAll(CLIENT_ID, parentId);
        List<NextMenuRoute> routes = new ArrayList<>();
        List<NextMenuRoute> children;
        NextMenuRoute route;
        NextMetaMenu meta;
        for (MenuRoutePo menuRoutePo : list) {
            route = new NextMenuRoute();
            route.setPath(menuRoutePo.getPath());
            route.setName(menuRoutePo.getName());
            route.setComponent(menuRoutePo.getComponent());
            route.setRedirect(menuRoutePo.getRedirect());

            meta = new NextMetaMenu();
            meta.setParentId(menuRoutePo.getParentId());
            meta.setTitle(menuRoutePo.getTitle());
            meta.setIcon(menuRoutePo.getIcon());

            meta.setIsHide(false);
            meta.setIsLink(menuRoutePo.getIsLink());
            meta.setIsAffix(menuRoutePo.getIsAffix());
            meta.setIsKeepAlive(menuRoutePo.getIsKeepAlive());
            meta.setIsIframe(menuRoutePo.getIsIframe());

            route.setMeta(meta);

            children = oAuthMenuAll(menuRoutePo.getId());
            if (0 == children.size()) {
                routes.add(route);
                continue;
            }
            route.setChildren(children);
            //  route.setPath(null);
            routes.add(route);
        }

        return routes;
    }

    /***
     * 查询用户菜单
     *
     * @author 王大宸
     * @date 2023/5/8 21:14
     * @param userId userId
     * @param parentId parentId
     * @return java.util.List<MenuRoute>
     */
    private List<NextMenuRoute> userOAuthMenu(String userId, String parentId) {
        List<MenuRoutePo> list = nextMenuMapper.userOAuthMenu(CLIENT_ID, parentId, userId);
        List<NextMenuRoute> routes = new ArrayList<>();
        List<NextMenuRoute> children;
        NextMenuRoute route;
        NextMetaMenu meta;
        for (MenuRoutePo menuRoutePo : list) {
            route = new NextMenuRoute();
            route.setPath(menuRoutePo.getPath());
            route.setName(menuRoutePo.getName());
            route.setComponent(menuRoutePo.getComponent());
            route.setRedirect(menuRoutePo.getRedirect());

            meta = new NextMetaMenu();
            meta.setParentId(menuRoutePo.getParentId());
            meta.setTitle(menuRoutePo.getTitle());
            meta.setIcon(menuRoutePo.getIcon());

            meta.setIsHide(false);
            meta.setIsLink(menuRoutePo.getIsLink());
            meta.setIsAffix(menuRoutePo.getIsAffix());
            meta.setIsKeepAlive(menuRoutePo.getIsKeepAlive());
            meta.setIsIframe(menuRoutePo.getIsIframe());

            route.setMeta(meta);

            children = userOAuthMenu(menuRoutePo.getId(), userId);
            if (0 == children.size()) {
                routes.add(route);
                continue;
            }
            route.setChildren(children);
            route.setPath("");
            routes.add(route);
        }

        return routes;
    }


}
