package com.github.itdachen.admin.service.impl.manager;

import com.github.itdachen.auth.entity.LoginInfo;
import com.github.itdachen.auth.mapper.ILoginInfoMapper;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

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

    public LoginInfoEventListener(ILoginInfoMapper loginInfoMapper,
                                  PasswordEncoder passwordEncoder) {
        this.loginInfoMapper = loginInfoMapper;
        this.passwordEncoder = passwordEncoder;
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
    }

}
