package com.github.itdachen.auth.service.impl;

import com.github.itdachen.auth.entity.AuthUserInfo;
import com.github.itdachen.auth.mapper.IAuthorizedMapper;
import com.github.itdachen.auth.service.IAuthorizedService;
import com.github.itdachen.framework.autoconfigure.jwt.FlyJwtAutoconfigureProperties;
import com.github.itdachen.framework.context.constants.UserInfoConstant;
import com.github.itdachen.framework.context.constants.UserTypeConstant;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.context.userdetails.CurrentUserDetails;
import com.github.itdachen.framework.core.utils.StringUtils;
import com.github.itdachen.framework.jwt.JWTHelper;
import com.github.itdachen.framework.jwt.config.SecretKeyConfiguration;
import com.github.itdachen.framework.jwt.core.JWTInfo;
import com.github.itdachen.framework.jwt.core.JwtTokenInfo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * Created by 王大宸 on 2023/04/25 20:52
 * Created with IntelliJ IDEA.
 */
@Service
public class AuthorizedServiceImpl implements IAuthorizedService {

    private final IAuthorizedMapper authorizedMapper;
    private final JWTHelper jwtHelper;
    private final SecretKeyConfiguration secretKeyConfiguration;
    private final FlyJwtAutoconfigureProperties autoconfigureProperties;
    private final PasswordEncoder passwordEncoder;

    public AuthorizedServiceImpl(IAuthorizedMapper authorizedMapper,
                                 JWTHelper jwtHelper,
                                 SecretKeyConfiguration secretKeyConfiguration,
                                 FlyJwtAutoconfigureProperties autoconfigureProperties,
                                 PasswordEncoder passwordEncoder) {
        this.authorizedMapper = authorizedMapper;
        this.jwtHelper = jwtHelper;
        this.secretKeyConfiguration = secretKeyConfiguration;
        this.autoconfigureProperties = autoconfigureProperties;
        this.passwordEncoder = passwordEncoder;
    }

    /***
     * 账号密码登录认证
     *
     * @author 王大宸
     * @date 2023/4/25 21:07
     * @param authUserInfo authUserInfo
     * @return com.github.itdachen.framework.jjwt.core.JwtTokenInfo
     */
    @Override
    public JwtTokenInfo authAccountToken(AuthUserInfo authUserInfo) throws Exception {
        if (null == authUserInfo
                || StringUtils.isEmpty(authUserInfo.getUsername())
                || StringUtils.isEmpty(authUserInfo.getPassword())) {
            throw new BizException("登录认证信息不全!!!");
        }
        CurrentUserDetails currentUserDetails = authorizedMapper.loadUserByUsername(authUserInfo.getUsername());

        if (null == currentUserDetails) {
            throw new BizException("用户信息不存在");
        }

        if (!passwordEncoder.matches(authUserInfo.getPassword(), currentUserDetails.getAccountSecret())) {
            throw new BizException("密码错误");
        }

        /* 存放在 token 中的信息 */
        Map<String, String> otherInfo = new HashMap<>(16);
        otherInfo.put(UserInfoConstant.AVATAR, currentUserDetails.getAvatar());
        otherInfo.put(UserInfoConstant.TELEPHONE, currentUserDetails.getTelephone());
        otherInfo.put(UserInfoConstant.USER_TYPE, UserTypeConstant.MEMBER);
        otherInfo.put(UserInfoConstant.TENANT_ID, currentUserDetails.getTenantId());
        otherInfo.put(UserInfoConstant.GRADE, currentUserDetails.getGrade());

        String access_token = jwtHelper.createToken(new JWTInfo.Builder()
                        .username(currentUserDetails.getAccount())
                        .name(currentUserDetails.getNickName())
                        .userId(currentUserDetails.getId())
                        .otherInfo(otherInfo)
                        .build(),
                secretKeyConfiguration.getUserPriKey(),
                autoconfigureProperties.getExpires());


        Map<String, Object> infoMap = new HashMap<>(8);
        infoMap.put(UserInfoConstant.USER_TYPE, UserTypeConstant.MEMBER);
        infoMap.put(UserInfoConstant.TENANT_ID, currentUserDetails.getTenantId());
        infoMap.put(UserInfoConstant.AVATAR, currentUserDetails.getAvatar());
        infoMap.put(UserInfoConstant.NICK_NAME, currentUserDetails.getNickName());
        infoMap.put(UserInfoConstant.TELEPHONE, currentUserDetails.getTelephone());
        infoMap.put(UserInfoConstant.GRADE, currentUserDetails.getGrade());

        return new JwtTokenInfo.Builder()
                .access_token(access_token)
                .expires_in(Integer.parseInt(String.valueOf(autoconfigureProperties.getExpires())))
                .info(infoMap)
                .build();
    }


}
