package com.github.itdachen.dashboard.service.impl;

import com.github.itdachen.config.WebAppClientConfig;
import com.github.itdachen.dashboard.entity.LoginRecord;
import com.github.itdachen.dashboard.mapper.ILoginErrorRecordMapper;
import com.github.itdachen.dashboard.mapper.ILoginRecordMapper;
import com.github.itdachen.dashboard.mapper.IUserDetailsMapper;
import com.github.itdachen.dashboard.service.IAuthSuccessService;
import com.github.itdachen.framework.context.constants.YesOrNotConstant;
import com.github.itdachen.framework.context.userdetails.CurrentUserDetails;
import com.github.itdachen.framework.tools.ip.AddressUtils;
import com.github.itdachen.framework.tools.request.BodyUtils;
import com.github.itdachen.framework.tools.request.BrowserUtils;
import com.github.itdachen.framework.tools.request.OSUtils;
import com.github.itdachen.framework.webmvc.entity.EntityUtils;
import com.github.itdachen.security.constants.LoginModeConstant;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.swing.text.html.parser.Entity;
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
    private final WebAppClientConfig webAppClientConfig;

    public AuthSuccessServiceImpl(IUserDetailsMapper userDetailsMapper,
                                  ILoginRecordMapper loginRecordMapper,
                                  WebAppClientConfig webAppClientConfig) {
        this.userDetailsMapper = userDetailsMapper;
        this.loginRecordMapper = loginRecordMapper;
        this.webAppClientConfig = webAppClientConfig;
    }

    @Override
    @Async
    public void onAuthenticationSuccess(HttpServletRequest request, String sessionId) {

        final Map<String, String> body = BodyUtils.requestBody(request);
        CurrentUserDetails userDetails;
        if (body.containsKey("imageCode")) {
            userDetails = userDetailsMapper.loadUserByUsername(body.get("username"));
        } else {
            userDetails = userDetailsMapper.loadUserByMobile(body.get("mobile"));
        }

        if (null == userDetails) {
            userDetails = new CurrentUserDetails();
        }

        final String remoteAddr = request.getRemoteAddr();
        final String realAddress = AddressUtils.getRealAddressByIP(remoteAddr);

        //  final String realAddress = AddressUtils.getRealAddressByIP("223.73.144.233");

        LoginRecord loginRecord = LoginRecord.builder()
                .id(EntityUtils.getId())
                // .sessionId(sessionId)
                .clientId(webAppClientConfig.getId())
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

}
