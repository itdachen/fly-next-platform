package com.github.itdachen.auth.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;

/**
 * 更新密码
 *
 * @author 王大宸
 * @date 2024/4/30 0:10
 */
public class AdminUserDetailsPasswordService  implements UserDetailsPasswordService {
//    private final IUserLoginMapper userLoginMapper;
//
//    public AdminUserDetailsPasswordService(IUserLoginMapper userLoginMapper) {
//        this.userLoginMapper = userLoginMapper;
//    }

    @Override
    public UserDetails updatePassword(UserDetails user, String newPassword) {
//        UserLogin userLogin = userLoginMapper.findUserLoginByUsername(user.getUsername());
//        userLogin.setPassword(user.getPassword());
//        userLoginMapper.updateUserLogin(userLogin);
//        return user;

        return null;
    }
}
