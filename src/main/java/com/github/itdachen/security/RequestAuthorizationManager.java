package com.github.itdachen.security;

import com.github.itdachen.dashboard.mapper.IAuthenticationAuthorityMapper;
import com.github.itdachen.framework.context.BizContextHandler;
import com.github.itdachen.framework.context.permission.PermissionInfo;
import com.github.itdachen.framework.security.user.CurrentUserInfo;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Supplier;
import java.util.regex.Pattern;

/**
 * Description: 自定义权限校验
 * Created by 王大宸 on 2023-11-24 22:14
 * Created with IntelliJ IDEA.
 */
@Component
public class RequestAuthorizationManager implements AuthorizationManager<RequestAuthorizationContext> {
    private static final Logger logger = LoggerFactory.getLogger(RequestAuthorizationManager.class);

    /**
     * 需要认证的权限
     */
    private static List<PermissionInfo> permissionsSet = null;

    private final IAuthenticationAuthorityMapper authenticationAuthorityMapper;

    public RequestAuthorizationManager(IAuthenticationAuthorityMapper authenticationAuthorityMapper) {
        this.authenticationAuthorityMapper = authenticationAuthorityMapper;
    }


    @PostConstruct
    public void loadDataSource() {
        logger.info("正在初始化系统权限 ...");
        // 从数据库加载
        permissionsSet = authenticationAuthorityMapper.findPermissionInfoAll();
    }

    public void clearDataSource() {
        permissionsSet.clear();
        permissionsSet = null;
    }

    @Override
    public void verify(Supplier<Authentication> authentication, RequestAuthorizationContext object) {
        AuthorizationManager.super.verify(authentication, object);
    }

    @Override
    public AuthorizationDecision check(Supplier<Authentication> authentication, RequestAuthorizationContext requestAuthorizationContext) {
        boolean granted = isGranted(authentication.get(), requestAuthorizationContext.getRequest());
        // 返回授权决策对象，根据权限结果
        return new AuthorizationDecision(granted);
    }

    private boolean isGranted(Authentication authentication, HttpServletRequest request) {
        return authentication != null && isAuthorized(authentication, request);
    }

    private boolean isAuthorized(Authentication authentication, HttpServletRequest request) {
        // 自定义的权限控制，request 可以获取到当前的请求信息。
        // authentication 就是我们的认证对象，我们可以直接拿到认证用户的权限

        //TODO 查询缓存中用户的权限
        // anonymousUser 匿名用户 ROLE_ANONYMOUS 默认权限
        Object principal = authentication.getPrincipal();
        if (principal.equals("anonymousUser")) {
            return false;
        }

        final String method = request.getMethod();
        final String requestURI = request.getRequestURI();

        /* 检查是否需要鉴权 */
        List<PermissionInfo> matchPermission = permissionsSet.parallelStream().filter(info -> {
            if (info.getUri().indexOf("{") > 0) {
                info.setUri(info.getUri().replaceAll("\\{\\*\\}", "[a-zA-Z\\\\d]+"));
            }
            return Pattern.compile("^" + info.getUri() + "$").matcher(requestURI).find() && method.equals(info.getMethod());
        }).toList();


        // 说明当前访问资源不做权限控制
        if (0 == matchPermission.size()) {
            return true;
        }

        /* 用户鉴权 */
        CurrentUserInfo userInfo = (CurrentUserInfo) principal;
        List<PermissionInfo> userInfoPermissions = userInfo.getPermissions();
        if (null == userInfoPermissions || userInfoPermissions.isEmpty()) {
            return false;
        }
        boolean anyMatch = false;
        for (PermissionInfo info : userInfoPermissions) {
            anyMatch = matchPermission.parallelStream()
                    .anyMatch(permissionInfo -> permissionInfo.getPermission().equals(info.getPermission()));
            if (anyMatch) {
                break;
            }
        }

        return anyMatch;
    }

}
