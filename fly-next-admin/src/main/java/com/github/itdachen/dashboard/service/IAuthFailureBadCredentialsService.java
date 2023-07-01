package com.github.itdachen.dashboard.service;

import jakarta.servlet.http.HttpServletRequest;

/**
 * Description: 认证失败监听
 * Created by 王大宸 on 2023-06-30 22:07
 * Created with IntelliJ IDEA.
 */
public interface IAuthFailureBadCredentialsService {

    void onApplicationEvent(HttpServletRequest request, String message, String sessionId);

}
