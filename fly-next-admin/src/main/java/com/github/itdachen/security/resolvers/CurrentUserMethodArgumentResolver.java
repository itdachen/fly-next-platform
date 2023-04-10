package com.github.itdachen.security.resolvers;

import com.github.itdachen.framework.context.annotation.CurrentUser;
import com.github.itdachen.security.context.SecurityContextHandler;
import com.github.itdachen.security.user.CurrentUserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

/**
 * Description:
 * Created by 王大宸 on 2023/04/10 16:04
 * Created with IntelliJ IDEA.
 */
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {
    private static final Logger logger = LoggerFactory.getLogger(CurrentUserMethodArgumentResolver.class);

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(CurrentUserInfo.class)
                && parameter.hasParameterAnnotation(CurrentUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {
        return (CurrentUserInfo) SecurityContextHandler.getUserInfo();
    }

}
