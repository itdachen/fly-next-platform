package com.github.itdachen.admin.service.impl;

import com.github.itdachen.admin.entity.UserLogin;
import com.github.itdachen.admin.mapper.IUserLoginMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.stereotype.Service;

/**
 * Description: 多密码模式下, 将旧密码加密方式更新成新密码加密方式
 * Created by 王大宸 on 2023/04/29 18:27
 * Created with IntelliJ IDEA.
 */
@Service
public class AdminUserDetailsPasswordService implements UserDetailsPasswordService {
    private final IUserLoginMapper userLoginMapper;

    public AdminUserDetailsPasswordService(IUserLoginMapper userLoginMapper) {
        this.userLoginMapper = userLoginMapper;
    }

    @Override
    public UserDetails updatePassword(UserDetails user, String newPassword) {
        UserLogin userLogin = userLoginMapper.findUserLoginByUsername(user.getUsername());
        userLogin.setPassword(user.getPassword());
        userLoginMapper.updateUserLogin(userLogin);
        return user;
    }


}
