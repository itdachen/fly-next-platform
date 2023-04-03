package com.github.itdachen.security.utils;

/**
 * Description: 请求路径处理
 * Created by 王大宸 on 2023/03/02 14:57
 * Created with IntelliJ IDEA.
 */
public class AuthorizeHttpRequestsHandler {


    public static String anyRequestUriHandler(final String contextPath, String requestUri) {
        if (!requestUri.startsWith("http://") && !requestUri.startsWith("https://") && !requestUri.startsWith(contextPath)) {
            requestUri = contextPath + requestUri;
        }
        return requestUri;
    }

}
