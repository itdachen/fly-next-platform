package com.github.itdachen.security;

import com.github.itdachen.dashboard.mapper.IAuthenticationAuthorityMapper;
import com.github.itdachen.framework.context.permission.PermissionInfo;
import com.github.itdachen.framework.security.rbac.IRequestAuthorizationHandler;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/***
 * 初始化系统权限
 * SpringSecurity 6.x 默认的注解鉴权不生效了, 这里通过 Rbac 模式自定义鉴权
 * @author 王大宸
 * @date 2023/11/27 20:54
 */
@Service
public class FlyNextRequestAuthorizationHandler implements IRequestAuthorizationHandler {

    private final IAuthenticationAuthorityMapper authenticationAuthorityMapper;

    public FlyNextRequestAuthorizationHandler(IAuthenticationAuthorityMapper authenticationAuthorityMapper) {
        this.authenticationAuthorityMapper = authenticationAuthorityMapper;
    }

    @Override
    public List<PermissionInfo> init() {
        //  return new ArrayList<>();
      return authenticationAuthorityMapper.findPermissionInfoAll();
    }

}
