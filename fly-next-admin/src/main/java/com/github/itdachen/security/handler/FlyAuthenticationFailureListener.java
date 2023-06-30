package com.github.itdachen.security.handler;

import com.github.itdachen.dashboard.service.IAuthFailureBadCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

/**
 * Description: 登录失败监听
 * Created by 王大宸 on 2022-11-16 17:11
 * Created with IntelliJ IDEA.
 */
// @Component
public class FlyAuthenticationFailureListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

    private final IAuthFailureBadCredentialsService authFailureBadCredentialsService;

    public FlyAuthenticationFailureListener(IAuthFailureBadCredentialsService authFailureBadCredentialsService) {
        this.authFailureBadCredentialsService = authFailureBadCredentialsService;
    }

    @Override
    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent e) {
        // 在这里记录登陆失败的次数
        //    authFailureBadCredentialsService.onApplicationEvent(e);
    }

}
