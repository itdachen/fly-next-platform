package com.github.itdachen.dashboard.service.impl;

import com.github.itdachen.dashboard.entity.LoginErrorRecord;
import com.github.itdachen.dashboard.mapper.ILoginErrorRecordMapper;
import com.github.itdachen.dashboard.service.IAuthFailureBadCredentialsService;
import com.github.itdachen.framework.webmvc.entity.EntityUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Description: 记录登录记录
 * Created by 王大宸 on 2023-06-30 22:08
 * Created with IntelliJ IDEA.
 */
@Component
public class AuthFailureBadCredentialsServiceImpl implements IAuthFailureBadCredentialsService {

    private final ILoginErrorRecordMapper loginErrorRecordMapper;

    public AuthFailureBadCredentialsServiceImpl(ILoginErrorRecordMapper loginErrorRecordMapper) {
        this.loginErrorRecordMapper = loginErrorRecordMapper;
    }


    @Override
    @Async
    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent e) {
        AuthenticationException exception = e.getException();
        Authentication authentication = e.getAuthentication();
        WebAuthenticationDetails details = (WebAuthenticationDetails)authentication.getDetails();

        LoginErrorRecord build = LoginErrorRecord.builder()
                .id(EntityUtils.getId())
                .createTime(LocalDateTime.now())
                .sessionId(details.getSessionId())
                .errorType("password")
                .clientId("web_app")
                .ip(details.getRemoteAddress())
                .username(authentication.getPrincipal().toString())
                .password(authentication.getCredentials().toString())
                .message(exception.getMessage())
                .build();

        loginErrorRecordMapper.insertSelective(build);
    }

    @Override
    @Async
    public void onApplicationEvent(LoginErrorRecord loginErrorRecord) {
        loginErrorRecordMapper.insertSelective(loginErrorRecord);
    }


}
