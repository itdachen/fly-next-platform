package com.github.itdachen.auth.controller;

import com.github.itdachen.auth.entity.AuthUserInfo;
import com.github.itdachen.auth.service.IAuthorizedService;
import com.github.itdachen.framework.core.response.ServerResponse;
import com.github.itdachen.framework.jwt.core.JwtTokenInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录
 *
 * @author 王大宸
 * @date 2023/4/25 20:53
 */
@RestController
@RequestMapping("/oauth")
public class AuthorizedAccessTokenController {

    private final IAuthorizedService authorizedService;

    public AuthorizedAccessTokenController(IAuthorizedService authorizedService) {
        this.authorizedService = authorizedService;
    }
    
    /***
     * 账号密码登录认证
     *
     * @author 王大宸
     * @date 2023/4/25 21:09
     * @param authUserInfo authUserInfo
     * @return com.github.itdachen.framework.core.response.ServerResponse<com.github.itdachen.framework.jjwt.core.JwtTokenInfo>
     */
    @PostMapping("/token")
    public ServerResponse<JwtTokenInfo> authAccountToken(@RequestBody AuthUserInfo authUserInfo) throws Exception {
        return ServerResponse.okData(authorizedService.authAccountToken(authUserInfo));
    }


}
