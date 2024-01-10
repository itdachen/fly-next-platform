package com.github.itdachen.dashboard.service.impl;

import com.github.itdachen.boot.autoconfigure.client.ClientProperties;
import com.github.itdachen.boot.security.constants.LoginModeConstant;
import com.github.itdachen.boot.security.log.IAuthFailureCredentialsLogHandler;
import com.github.itdachen.dashboard.entity.LoginErrorRecord;
import com.github.itdachen.dashboard.entity.LoginRecord;
import com.github.itdachen.dashboard.mapper.ILoginErrorRecordMapper;
import com.github.itdachen.dashboard.mapper.ILoginRecordMapper;
import com.github.itdachen.dashboard.mapper.IUserDetailsMapper;
import com.github.itdachen.framework.context.constants.YesOrNotConstant;
import com.github.itdachen.framework.context.userdetails.CurrentUserDetails;
import com.github.itdachen.framework.tools.ip.AddressUtils;
import com.github.itdachen.framework.tools.request.BodyUtils;
import com.github.itdachen.framework.tools.request.BrowserUtils;
import com.github.itdachen.framework.tools.request.OSUtils;
import com.github.itdachen.framework.webmvc.entity.EntityUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Description: 记录登录失败
 * Created by 王大宸 on 2023-06-30 22:08
 * Created with IntelliJ IDEA.
 */
@Component
public class AuthFailureBadCredentialsHandler implements IAuthFailureCredentialsLogHandler {

    private final ILoginErrorRecordMapper loginErrorRecordMapper;
    private final IUserDetailsMapper userDetailsMapper;
    private final ILoginRecordMapper loginRecordMapper;
    private final ClientProperties clientProperties;

    public AuthFailureBadCredentialsHandler(ILoginErrorRecordMapper loginErrorRecordMapper,
                                            IUserDetailsMapper userDetailsMapper,
                                            ILoginRecordMapper loginRecordMapper,
                                            ClientProperties clientProperties) {
        this.loginErrorRecordMapper = loginErrorRecordMapper;
        this.userDetailsMapper = userDetailsMapper;
        this.loginRecordMapper = loginRecordMapper;
        this.clientProperties = clientProperties;
    }

    @Override
    @Async
    public void handler(HttpServletRequest request,
                        HttpServletResponse response,
                        AuthenticationException exception,
                        String sessionId) {
        final String realAddress = AddressUtils.getRealAddressByIP(request.getRemoteAddr());
        final Map<String, String> body = BodyUtils.requestBody(request);

        LoginErrorRecord err = LoginErrorRecord.builder()
                .id(EntityUtils.getId())
                .createTime(LocalDateTime.now())
                .sessionId(sessionId)
                .clientId(clientProperties.getId())
                .ip(request.getRemoteAddr())
                .requestId(request.getRequestId())
                .message(exception.getMessage())
                .os(OSUtils.osInfo(request))
                .browser(BrowserUtils.browserInfo(request))
                .accessAddress(realAddress)
                .build();

        /* 登录验证码 */
        if (body.containsKey("imageCode")) {
            err.setVerificationCode(body.get("imageCode"));
            err.setErrorType(LoginModeConstant.PASSWORD);
            err.setUsername(body.get("username"));
            err.setPassword(body.get(LoginModeConstant.PASSWORD));
        }
        if (body.containsKey("smsCode")) {
            err.setVerificationCode(body.get("smsCode"));
            err.setUsername(body.get("mobile"));
            err.setPassword(body.get("smsCode"));
            err.setErrorType(LoginModeConstant.SMS);
        }
        loginErrorRecordMapper.insertSelective(err);


        /**
         * 登录数据入库
         */
        CurrentUserDetails userDetails;
        if (LoginModeConstant.SMS.equals(err.getErrorType())) {
            userDetails = userDetailsMapper.loadUserByMobile(err.getUsername());
        } else {
            userDetails = userDetailsMapper.loadUserByUsername(err.getUsername());
        }

        if (null == userDetails) {
            return;
        }

        LoginRecord loginRecord = LoginRecord.builder()
                .id(err.getId())
                .sessionId(err.getSessionId())
                .clientId(err.getClientId())
                .nickname(userDetails.getNickName())
                .username(userDetails.getAccount())
                .ip(err.getIp())
                .browser(err.getBrowser())
                .os(err.getOs())
                .status(YesOrNotConstant.NOT)
                .msg(err.getMessage())
                .createTime(err.getCreateTime())
                .accessAddress(realAddress)
                .build();
        loginRecordMapper.insertSelective(loginRecord);
    }

}
