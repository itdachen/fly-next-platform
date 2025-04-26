package com.github.itdachen.admin.service.impl.manager;

import com.github.itdachen.auth.constants.ProviderIdConstants;
import com.github.itdachen.auth.entity.LoginConnection;
import com.github.itdachen.auth.entity.LoginInfo;
import com.github.itdachen.auth.mapper.ILoginConnectionMapper;
import com.github.itdachen.auth.mapper.ILoginInfoMapper;
import com.github.itdachen.framework.webmvc.entity.EntityUtils;
import jakarta.persistence.Column;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 3、订阅事件
 *
 * @author 王大宸
 * @date 2025/1/22 21:37
 */
@Component
public class LoginInfoEventListener implements ApplicationListener<LoginInfoEvent> {

    private final ILoginInfoMapper loginInfoMapper;
    private final PasswordEncoder passwordEncoder;
    private final ILoginConnectionMapper loginConnectionMapper;

    public LoginInfoEventListener(ILoginInfoMapper loginInfoMapper,
                                  PasswordEncoder passwordEncoder,
                                  ILoginConnectionMapper loginConnectionMapper) {
        this.loginInfoMapper = loginInfoMapper;
        this.passwordEncoder = passwordEncoder;
        this.loginConnectionMapper = loginConnectionMapper;
    }


    /***
     * 3.1、订阅者可以通过实现 org.springframework.context.ApplicationListener 接口来订阅特定的事件
     *
     * @author 王大宸
     * @date 2025/1/22 22:11
     * @param event event
     * @return void
     */
    @Override
    public void onApplicationEvent(LoginInfoEvent event) {
        LoginInfo loginInfo = event.getLoginInfo();
        String password = loginInfo.getPassword();
        if (null == password || "".equals(password)) {
            password = "123456";
        }
        password = passwordEncoder.encode(password);
        loginInfo.setPassword(password);
        // 登录用户信息入库
        loginInfoMapper.insertSelective(loginInfo);

        /* 添加手机短信登录信息入库 */
        if (null != loginInfo.getTelephone()) {
            LoginConnection loginConnection = new LoginConnection();
            loginConnection.setId(EntityUtils.getId());
            loginConnection.setUserId(loginInfo.getId());
            loginConnection.setProviderId(ProviderIdConstants.TELEPHONE);
            loginConnection.setProviderUserId(loginInfo.getTelephone());
            loginConnection.setNickname(loginInfo.getNickName());
            loginConnection.setProfileUrl("-");
            loginConnection.setImageUrl("-");
            loginConnection.setSecretKey("-");
            loginConnection.setAccessToken("-");
            loginConnection.setRefreshToken("-");
            loginConnection.setExpireTime(LocalDateTime.now().plusYears(12));
            loginConnectionMapper.insertSelective(loginConnection);
        }


    }

}
