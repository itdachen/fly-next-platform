package com.github.itdachen.auth.service.impl;

import com.github.itdachen.admin.entity.UserInfo;
import com.github.itdachen.admin.mapper.IUserInfoMapper;
import com.github.itdachen.auth.manager.IUserMenuManager;
import com.github.itdachen.auth.mapper.IAuthenticationAuthorityMapper;
import com.github.itdachen.auth.mapper.IUserDetailsMapper;
import com.github.itdachen.boot.autoconfigure.app.AppInfoProperties;
import com.github.itdachen.boot.autoconfigure.app.PlatformInfoProperties;
import com.github.itdachen.boot.security.constants.LoginModeConstant;
import com.github.itdachen.boot.security.details.AbstractSecurityUserDetailsService;
import com.github.itdachen.boot.security.exception.BizSecurityException;
import com.github.itdachen.boot.security.user.CurrentUserInfo;
import com.github.itdachen.framework.context.constants.UserTypeConstant;
import com.github.itdachen.framework.context.constants.YesOrNotConstant;
import com.github.itdachen.framework.context.permission.PermissionInfo;
import com.github.itdachen.framework.context.userdetails.UserInfoDetails;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 认证用户信息查询
 *
 * @author 王大宸
 * @date 2024/4/29 22:20
 */
@Service
public class AdminSecurityUserDetailsService extends AbstractSecurityUserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(AdminSecurityUserDetailsService.class);

    private final IAuthenticationAuthorityMapper authenticationAuthorityMapper;
    private final IUserDetailsMapper userDetailsMapper;

    @Autowired
    private IUserMenuManager userMenuManager;

    // private final ILoginErrorRecordMapper loginErrorRecordMapper;

    public AdminSecurityUserDetailsService(IAuthenticationAuthorityMapper authenticationAuthorityMapper,
                                           //  ILoginErrorRecordMapper loginErrorRecordMapper,
                                           IUserDetailsMapper userDetailsMapper,
                                           PlatformInfoProperties platformInfoProperties,
                                           AppInfoProperties appInfoProperties) {
        super(platformInfoProperties, appInfoProperties);
        this.userDetailsMapper = userDetailsMapper;
        this.authenticationAuthorityMapper = authenticationAuthorityMapper;

        // this.loginErrorRecordMapper = loginErrorRecordMapper;

    }

    /***
     * 根据登录账号查询用户信息
     *
     * @author 王大宸
     * @date 2024/4/29 23:22
     * @param username username
     * @return com.github.itdachen.boot.security.user.CurrentUserInfo
     */
    @Override
    public CurrentUserInfo loadUserByUsername(String username) throws UsernameNotFoundException {
        /* 根据登录账号, 查询 5 分钟内登录失败次数 */
        checkUpErrorTotal(username);

        UserInfoDetails user = userDetailsMapper.loadUserByUsername(username);
        if (null == user) {
            logger.error("登录账号: " + username + " 不存在");
            throw new BizSecurityException("登录账号 " + username + " 不存在,请检查账号是否正确");
        }
        user.setLoginMethod(LoginModeConstant.PASSWORD);

        return toVerifyUserDetails(user);
    }

    @Override
    public CurrentUserInfo loadUserByMobile(String mobile) throws UsernameNotFoundException {
        UserInfoDetails user = userDetailsMapper.loadUserByMobile(mobile);
        if (null == user) {
            logger.error("登录手机号: " + mobile + " 不存在");
            throw new BizSecurityException("登登录手机号录账号 " + mobile + " 不存在,请检查手机号是否正确！！！");
        }
        user.setLoginMethod(LoginModeConstant.SMS);

        return toVerifyUserDetails(user);
    }

    /***
     * 检查是否登录超次数
     *
     * @author 王大宸
     * @date 2023/7/2 15:11
     * @param username 登录账号
     * @return void
     */
    private void checkUpErrorTotal(String username) throws UsernameNotFoundException {
//        Integer errTotal = loginErrorRecordMapper.findErrTotal(username);
//        if (10 <= errTotal) {
//            throw new BizSecurityException("您已在 5 分钟内登录错误 10 次, 请 10 分钟之后再登录！");
//        }
    }


    /***
     * 获取权限信息
     *
     * @author 王大宸
     * @date 2024/4/30 0:01
     * @param userInfoDetails userInfoDetails
     * @return java.util.Set<java.lang.String>
     */
    @Override
    protected Set<String> getUserAuthority(UserInfoDetails userInfoDetails) {
        if (YesOrNotConstant.Y.equals(userInfoDetails.getUserType())) {
            List<String> appAuthority = authenticationAuthorityMapper.findAppAuthority(userInfoDetails.getAppId());
            return new HashSet<>(appAuthority);
        }
        List<String> list = userMenuManager.canUsableMenu(userInfoDetails.getAppId(), userInfoDetails);
        List<String> userAuthority = authenticationAuthorityMapper.findUserAuthority(userInfoDetails.getAppId(), list);
        return new HashSet<>(userAuthority);
    }

}
