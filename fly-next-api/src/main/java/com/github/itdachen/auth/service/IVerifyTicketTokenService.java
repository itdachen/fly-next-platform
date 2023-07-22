package com.github.itdachen.auth.service;

import com.github.itdachen.framework.cloud.jwt.core.IJwtInfo;

/**
 * Description:
 * Created by 王大宸 on 2023/04/25 23:55
 * Created with IntelliJ IDEA.
 */
public interface IVerifyTicketTokenService {

    IJwtInfo verifyTicketToken(String token) throws Exception;


}
