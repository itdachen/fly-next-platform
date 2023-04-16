package com.github.itdachen.config;

import com.github.itdachen.framework.context.BizContextHandler;
import com.github.itdachen.framework.context.constants.UserInfoConstant;
import com.github.itdachen.framework.context.exception.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description: 拦截器
 * Created by 王大宸 on 2023/04/15 17:03
 * Created with IntelliJ IDEA.
 */
public class UserAuthRestInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(UserAuthRestInterceptor.class);

//    private final IJWTAuthHelper jwtTokenHelper;
//
//    public UserAuthRestInterceptor(IJWTAuthHelper jwtTokenHelper) {
//        this.jwtTokenHelper = jwtTokenHelper;
//    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        String method = request.getMethod();
        if (HttpMethod.OPTIONS.matches(method)) {
            return true;
        }

//        HandlerMethod handlerMethod = (HandlerMethod) handler;
//
//        // 配置该注解，说明不进行用户拦截
//        IgnoreUserToken ignoreUserToken = handlerMethod.getBeanType().getAnnotation(IgnoreUserToken.class);
//        if (ignoreUserToken == null) {
//            ignoreUserToken = handlerMethod.getMethodAnnotation(IgnoreUserToken.class);
//        }
//        if (ignoreUserToken != null) {
//            return true;
//        }

//        String token = request.getHeader(RequestHeaderConstants.HEADER_AUTHORIZATION);
//        if (StringUtils.isEmpty(token)) {
//            if (request.getCookies() != null) {
//                for (Cookie cookie : request.getCookies()) {
//                    if (cookie.getName().equals(RequestHeaderConstants.HEADER_AUTHORIZATION)) {
//                        token = cookie.getValue();
//                    }
//                }
//            }
//        }
//        if (StringUtils.isEmpty(token)) {
//            throw new BizException("用户认证失败");
//        }
//        token = token.replaceAll("%20", " ");
//        if (token.startsWith(RequestHeaderConstants.JWT_TOKEN_TYPE)) {
//            token = token.substring(RequestHeaderConstants.JWT_TOKEN_TYPE.length(), token.length());
//        }
//        try {
//            IJWTInfo infoFromToken = jwtTokenHelper.getInfoFromToken(token);
//            BizContextHandler.setAccount(infoFromToken.getUniqueName());
//            BizContextHandler.setUserName(infoFromToken.getName());
//            BizContextHandler.setUserId(infoFromToken.getId());
//            BizContextHandler.setDepartId(infoFromToken.getOtherInfo().get(UserInfoConstant.DEPART_ID));
//            BizContextHandler.setAvatar(infoFromToken.getOtherInfo().get(UserInfoConstant.AVATAR));
//            BizContextHandler.setUserType(infoFromToken.getOtherInfo().get(UserInfoConstant.USER_TYPE));
//            BizContextHandler.setTenantId(infoFromToken.getOtherInfo().get(UserInfoConstant.TENANT_ID));
//
//            return true;
//        } catch (Exception ex) {
//            logger.error("用户认证错误：", ex);
//            response.setStatus(HttpStatus.UNAUTHORIZED.value());
//            response.setContentType("application/json;charset=utf-8");
//            response.getWriter().write(getMessage(HttpStatus.UNAUTHORIZED.value(), ex.getMessage()));
//            return false;
//        }

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        BizContextHandler.remove();
    }

    private String getMessage(int status, String msg) {
        return "{\"success\":\"false\",\"status\":\"" + status + "\", \"msg\":\"" + msg + "\",\"data\": null}";
    }

}
