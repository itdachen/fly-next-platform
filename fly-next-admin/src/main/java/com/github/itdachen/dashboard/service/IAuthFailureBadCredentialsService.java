package com.github.itdachen.dashboard.service;

import com.github.itdachen.dashboard.entity.LoginErrorRecord;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;

/**
 * Description: 认证失败监听
 * Created by 王大宸 on 2023-06-30 22:07
 * Created with IntelliJ IDEA.
 */
public interface IAuthFailureBadCredentialsService {

    void onApplicationEvent(AuthenticationFailureBadCredentialsEvent e);

    void onApplicationEvent(LoginErrorRecord e);

}
