package com.github.itdachen.dashboard.service.impl;

import com.github.itdachen.dashboard.mapper.IRefreshAuthoritiesMapper;
import com.github.itdachen.dashboard.service.IRefreshAuthoritiesService;
import com.github.itdachen.framework.context.BizContextHandler;
import com.github.itdachen.framework.context.constants.UserTypeConstant;
import com.github.itdachen.security.context.SecurityContextHandler;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Description: 刷新权限
 * Created by 王大宸 on 2023/05/07 0:22
 * Created with IntelliJ IDEA.
 */
@Service
public class RefreshAuthoritiesServiceImpl implements IRefreshAuthoritiesService {

    private final IRefreshAuthoritiesMapper refreshAuthoritiesMapper;

    public RefreshAuthoritiesServiceImpl(IRefreshAuthoritiesMapper refreshAuthoritiesMapper) {
        this.refreshAuthoritiesMapper = refreshAuthoritiesMapper;
    }

    @Override
    public void refreshAuthorities(String clientId) throws Exception {
        if (UserTypeConstant.SUPER_ADMINISTRATOR.equals(BizContextHandler.getUserType())) {
            refreshAuthoritiesAllPermission(clientId);
        }
        refreshAuthoritiesUserPermission(BizContextHandler.getUserId(), clientId);
    }

    /***
     * 查询所有的权限
     *
     * @author 王大宸
     * @date 2023/4/16 22:19
     * @param client client
     * @return void
     */
    private void refreshAuthoritiesAllPermission(String client) {
        Set<String> list = refreshAuthoritiesMapper.findPermissionAll();
        list.add("ROLE_USER");
        SecurityContextHandler.refreshAuthorities(list.stream().toList());
    }

    /***
     * 根据用户ID查询用户权限
     *
     * @author 王大宸
     * @date 2023/4/16 22:20
     * @param userId userId
     * @param client client
     * @return void
     */
    private void refreshAuthoritiesUserPermission(String userId, String client) {
        Set<String> list = refreshAuthoritiesMapper.findUserPermission(userId);
        list.add("ROLE_USER");
        SecurityContextHandler.refreshAuthorities(list.stream().toList());
    }

}
