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
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

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
        try {
            // 自定义的权限控制，request 可以获取到当前的请求信息。
            // authentication 就是我们的认证对象，我们可以直接拿到认证用户的权限
            Object principal = authentication.getPrincipal();
            if (null == principal || "anonymousUser".equals(principal)) {
                return false;
            }

            if (null == permissionsSet || permissionsSet.isEmpty()) {
                return true;
            }

            /* 检查是否需要鉴权 */
            AntPathMatcher antPathMatcher = new AntPathMatcher();
            String uri;
            PermissionInfo hasPermissionInfo = null;
            for (PermissionInfo info : permissionsSet) {
                uri = info.getUri().replaceAll("\\{\\*\\}", "*");
                if (info.getMethod().equals(request.getMethod())
                        && antPathMatcher.match(uri, request.getRequestURI())) {
                    hasPermissionInfo = info;
                    break;
                }
            }

            // 说明当前访问资源不做权限控制
            if (null == hasPermissionInfo) {
                return true;
            }

            /* 用户鉴权 */
            if (principal instanceof CurrentUserInfo userInfo) {
                List<PermissionInfo> userInfoPermissions = userInfo.getPermissions();
                if (null == userInfoPermissions || userInfoPermissions.isEmpty()) {
                    return false;
                }
                for (PermissionInfo info : userInfoPermissions) {
                    if (hasPermissionInfo.getPermission().equals(info.getPermission())) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception ex) {
            logger.error("权限校验失败: ", ex);
            return false;
        }
    }

}
