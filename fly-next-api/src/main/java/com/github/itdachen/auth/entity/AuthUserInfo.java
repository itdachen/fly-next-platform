package com.github.itdachen.auth.entity;

import java.io.Serializable;

/**
 * Description: 认证用户信息
 * Created by 王大宸 on 2023/04/25 21:03
 * Created with IntelliJ IDEA.
 */
public class AuthUserInfo implements Serializable {
    private static final long serialVersionUID = 4609010871941494233L;

    /**
     * 登录账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 验证码
     */
    private String code;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
