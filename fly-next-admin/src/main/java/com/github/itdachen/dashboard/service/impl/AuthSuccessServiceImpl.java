package com.github.itdachen.dashboard.service.impl;

import com.github.itdachen.dashboard.entity.LoginRecord;
import com.github.itdachen.dashboard.mapper.ILoginRecordMapper;
import com.github.itdachen.dashboard.mapper.IUserDetailsMapper;
import com.github.itdachen.dashboard.service.IAuthSuccessService;
import com.github.itdachen.framework.context.constants.YesOrNotConstant;
import com.github.itdachen.framework.context.userdetails.CurrentUserDetails;
import com.github.itdachen.framework.core.utils.StringUtils;
import com.github.itdachen.framework.security.authentication.mobile.SmsCodeAuthenticationToken;
import com.github.itdachen.framework.security.constants.LoginModeConstant;
import com.github.itdachen.framework.tools.ip.AddressUtils;
import com.github.itdachen.framework.tools.request.BodyUtils;
import com.github.itdachen.framework.tools.request.BrowserUtils;
import com.github.itdachen.framework.tools.request.OSUtils;
import com.github.itdachen.framework.webmvc.entity.EntityUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Description:
 * Created by 王大宸 on 2023-07-01 13:41
 * Created with IntelliJ IDEA.
 */
@Component
public class AuthSuccessServiceImpl implements IAuthSuccessService {

    private final IUserDetailsMapper userDetailsMapper;
    private final ILoginRecordMapper loginRecordMapper;

    public AuthSuccessServiceImpl(IUserDetailsMapper userDetailsMapper,
                                  ILoginRecordMapper loginRecordMapper) {
        this.userDetailsMapper = userDetailsMapper;
        this.loginRecordMapper = loginRecordMapper;
    }

    @Override
    @Async
    public void onAuthenticationSuccess(HttpServletRequest request, Authentication authentication, String sessionId) {
        /* 获取登录用户信息 */
        CurrentUserDetails userDetails = getUserDetails(request, authentication);

        if (null == userDetails || StringUtils.isEmpty(userDetails.getAccount()) || StringUtils.isEmpty(userDetails.getNickName())) {
            return;
        }

        // final String remoteAddr = "223.73.144.233";
        final String remoteAddr = request.getRemoteAddr();
        final String realAddress = AddressUtils.getRealAddressByIP(remoteAddr);

        LoginRecord loginRecord = LoginRecord.builder()
                .id(EntityUtils.getId())
                .sessionId(sessionId)
                .clientId(userDetails.getClientId())
                .signMethod(userDetails.getSignMethod())
                .nickname(userDetails.getNickName())
                .username(userDetails.getAccount())
                .ip(remoteAddr)
                .os(OSUtils.osInfo(request))
                .browser(BrowserUtils.browserInfo(request))
                .status(YesOrNotConstant.YES)
                .msg("登录成功")
                .createTime(LocalDateTime.now())
                .accessAddress(realAddress)
                .build();
        loginRecordMapper.insertSelective(loginRecord);
    }

    /***
     * 获取登录用户信息
     *
     * @author 王大宸
     * @date 2023/7/2 14:27
     * @param request request
     * @param authentication authentication
     * @return com.github.itdachen.framework.context.userdetails.CurrentUserDetails
     */
    private CurrentUserDetails getUserDetails(HttpServletRequest request, Authentication authentication) {
        /* 账号密码登录 */
        if (authentication.getClass().equals(UsernamePasswordAuthenticationToken.class)) {
            UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) authentication;
            Object principal = authenticationToken.getPrincipal();
            return (CurrentUserDetails) principal;
        }
        /* 短信验证码登录 */
        if (authentication.getClass().equals(SmsCodeAuthenticationToken.class)) {
            SmsCodeAuthenticationToken authenticationToken = (SmsCodeAuthenticationToken) authentication;
            Object principal = authenticationToken.getPrincipal();
            return (CurrentUserDetails) principal;
        }
        /* 记住我 */
        if (authentication.getClass().equals(RememberMeAuthenticationToken.class)) {
            RememberMeAuthenticationToken authenticationToken = (RememberMeAuthenticationToken) authentication;
            Object principal = authenticationToken.getPrincipal();
            CurrentUserDetails userDetails =  (CurrentUserDetails) principal;
            userDetails.setSignMethod("RememberMe");
            return userDetails;
        }
        final Map<String, String> body = BodyUtils.requestBody(request);
        if (body.containsKey("imageCode")) {
            CurrentUserDetails userDetails = userDetailsMapper.loadUserByUsername(body.get("username"));
            userDetails.setSignMethod(LoginModeConstant.PASSWORD);
            return userDetails;
        }
        CurrentUserDetails userDetails = userDetailsMapper.loadUserByMobile(body.get("mobile"));
        userDetails.setSignMethod(LoginModeConstant.SMS);
        return userDetails;
    }

}
