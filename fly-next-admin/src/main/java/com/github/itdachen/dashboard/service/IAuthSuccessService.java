package com.github.itdachen.dashboard.service;

import jakarta.servlet.http.HttpServletRequest;

/**
 * Description:
 * Created by 王大宸 on 2023-07-01 13:41
 * Created with IntelliJ IDEA.
 */
public interface IAuthSuccessService {


    void onAuthenticationSuccess(HttpServletRequest request, String sessionId);

}