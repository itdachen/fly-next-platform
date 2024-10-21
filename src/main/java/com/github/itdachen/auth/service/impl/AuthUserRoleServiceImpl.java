package com.github.itdachen.auth.service.impl;

import com.github.itdachen.auth.mapper.IAuthUserRoleMapper;
import com.github.itdachen.auth.service.IAuthUserRoleService;
import com.github.itdachen.framework.context.BizContextHandler;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.context.tree.ZTreeNode;
import com.github.itdachen.framework.context.userdetails.UserInfoDetails;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * AuthUserRoleServiceImpl
 *
 * @author 王大宸
 * @date 2024/5/7 21:04
 */
@Service
public class AuthUserRoleServiceImpl implements IAuthUserRoleService {

    private final IAuthUserRoleMapper authUserRoleMapper;

    public AuthUserRoleServiceImpl(IAuthUserRoleMapper authUserRoleMapper) {
        this.authUserRoleMapper = authUserRoleMapper;
    }

    @Override
    public List<ZTreeNode> findAuthUserRole(String userId) {
        return authUserRoleMapper.findAuthUserRole(userId, BizContextHandler.getTenantId());
    }

    @Override
    public UserInfoDetails findUserRoleDetails(String roleId) throws Exception {
        UserInfoDetails userRoleDetails = authUserRoleMapper.findUserRoleDetails(roleId);
        if (null == userRoleDetails) {
            throw new BizException("该身份信息不存在或被禁用");
        }
        return userRoleDetails;
    }

}
