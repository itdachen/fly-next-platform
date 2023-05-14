package com.github.itdachen.auth.service.impl;

import com.github.itdachen.auth.service.IVerifyTicketTokenService;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.jjwt.JWTHelper;
import com.github.itdachen.framework.jjwt.config.SecretKeyConfiguration;
import com.github.itdachen.framework.jjwt.core.IJWTInfo;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 * Created by 王大宸 on 2023/04/25 23:56
 * Created with IntelliJ IDEA.
 */
@Service
public class VerifyTicketTokenServiceImpl implements IVerifyTicketTokenService {
    @Autowired
    private JWTHelper jwtHelper;

    @Autowired
    private SecretKeyConfiguration secretKeyConfiguration;

    @Override
    public IJWTInfo verifyTicketToken(String token) throws Exception {
        try {
            return jwtHelper.parseToken(token, secretKeyConfiguration.getUserPubKey());
        } catch (ExpiredJwtException e) {
            throw new BizException("认证令牌已过期！", 401);
        } catch (IllegalArgumentException e) {
            throw new BizException("秘钥错误！", 401);
        }
    }


}
