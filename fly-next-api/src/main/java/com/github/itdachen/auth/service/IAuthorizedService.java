package com.github.itdachen.auth.service;

import com.github.itdachen.auth.entity.AuthUserInfo;
import com.github.itdachen.framework.cloud.jwt.core.AccessTokenInfo;

/**
 * Description:
 * Created by 王大宸 on 2023/04/25 20:52
 * Created with IntelliJ IDEA.
 */
public interface IAuthorizedService {

    /***
     * 账号密码登录认证
     *
     * @author 王大宸
     * @date 2023/4/25 21:09
     * @param authUserInfo authUserInfo
     * @return com.github.itdachen.framework.jjwt.core.JwtTokenInfo
     */
    AccessTokenInfo authAccountToken(AuthUserInfo authUserInfo) throws Exception;

}
