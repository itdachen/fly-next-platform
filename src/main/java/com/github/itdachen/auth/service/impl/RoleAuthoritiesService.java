package com.github.itdachen.auth.service.impl;

import com.github.itdachen.auth.manager.IUserMenuManager;
import com.github.itdachen.auth.mapper.IAuthenticationAuthorityMapper;
import com.github.itdachen.auth.mapper.IUserDetailsMapper;
import com.github.itdachen.auth.service.IRoleAuthoritiesService;
import com.github.itdachen.boot.autoconfigure.app.AppInfoProperties;
import com.github.itdachen.boot.autoconfigure.app.PlatformInfoProperties;
import com.github.itdachen.framework.context.constants.YesOrNotConstant;
import com.github.itdachen.framework.context.userdetails.UserInfoDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * RoleAuthoritiesService
 *
 * @author 王大宸
 * @date 2024-10-21 17:45
 */
@Service
public class RoleAuthoritiesService implements IRoleAuthoritiesService {


    private final IAuthenticationAuthorityMapper authenticationAuthorityMapper;
    private final IUserMenuManager userMenuManager;

    public RoleAuthoritiesService(IAuthenticationAuthorityMapper authenticationAuthorityMapper,
                                  IUserMenuManager userMenuManager) {
        this.authenticationAuthorityMapper = authenticationAuthorityMapper;
        this.userMenuManager = userMenuManager;
    }


    @Override
    public Set<String> roleAuthorities(UserInfoDetails userInfoDetails) {
        if (YesOrNotConstant.Y.equals(userInfoDetails.getUserType())) {
            List<String> appAuthority = authenticationAuthorityMapper.findAppAuthority(userInfoDetails.getAppId());
            return new HashSet<>(appAuthority);
        }
        List<String> list = userMenuManager.canUsableMenu(userInfoDetails.getAppId(), userInfoDetails);
        List<String> userAuthority = authenticationAuthorityMapper.findUserAuthority(userInfoDetails.getAppId(), list);
        return new HashSet<>(userAuthority);
    }
}
