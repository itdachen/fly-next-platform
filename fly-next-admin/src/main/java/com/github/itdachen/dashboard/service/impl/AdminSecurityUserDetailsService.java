package com.github.itdachen.dashboard.service.impl;

import com.github.itdachen.dashboard.mapper.IAuthenticationAuthorityMapper;
import com.github.itdachen.dashboard.mapper.ILoginErrorRecordMapper;
import com.github.itdachen.dashboard.mapper.IUserDetailsMapper;
import com.github.itdachen.admin.entity.UserInfo;
import com.github.itdachen.admin.mapper.IUserInfoMapper;
import com.github.itdachen.framework.context.constants.UserTypeConstant;
import com.github.itdachen.framework.context.userdetails.CurrentUserDetails;
import com.github.itdachen.security.details.AbstractSecurityUserDetailsService;
import com.github.itdachen.security.exception.BizSecurityException;
import com.github.itdachen.security.user.CurrentUserInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Description: 登录用户信息查询
 * Created by 王大宸 on 2022-08-27 11:00
 * Created with IntelliJ IDEA.
 */
@Service
public class AdminSecurityUserDetailsService extends AbstractSecurityUserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(AdminSecurityUserDetailsService.class);
    private final IAuthenticationAuthorityMapper permsAuthMapper;
    private final IUserDetailsMapper userDetailsMapper;
    private final IUserInfoMapper userInfoMapper;
    private final ILoginErrorRecordMapper loginErrorRecordMapper;

    public AdminSecurityUserDetailsService(IAuthenticationAuthorityMapper permsAuthMapper,
                                           IUserDetailsMapper userDetailsMapper,
                                           IUserInfoMapper userInfoMapper,
                                           ILoginErrorRecordMapper loginErrorRecordMapper) {
        this.permsAuthMapper = permsAuthMapper;
        this.userDetailsMapper = userDetailsMapper;
        this.userInfoMapper = userInfoMapper;
        this.loginErrorRecordMapper = loginErrorRecordMapper;
    }

    @Override
    public CurrentUserInfo loadUserByUsername(String username) throws UsernameNotFoundException {
        /* 根据登录账号, 查询 5 分钟内登录失败次数 */
        Integer errTotal = loginErrorRecordMapper.findErrTotal(username);
        if (10 <= errTotal) {
            throw new BizSecurityException("您已在 5 分钟内登录错误 10 次, 请 10 分钟之后再登录！");
        }

        CurrentUserDetails user = userDetailsMapper.loadUserByUsername(username);
        if (null == user) {
            logger.error("登录账号: " + username + " 不存在");
            throw new BizSecurityException("登录账号 " + username + " 不存在,请检查账号是否正确");
        }

        setUserInfo(user);
        return getUserPermission(user);
    }

    @Override
    public CurrentUserInfo loadUserByMobile(String mobile) throws UsernameNotFoundException {
      //  mobile = "admin";

        /* 根据登录账号, 查询 5 分钟内登录失败次数 */
        Integer errTotal = loginErrorRecordMapper.findErrTotal(mobile);
        if (10 <= errTotal) {
            throw new BizSecurityException("您已在 5 分钟内登录错误 10 次, 请 10 分钟之后再登录！");
        }

        CurrentUserDetails user = userDetailsMapper.loadUserByMobile(mobile);
        if (null == user) {
            logger.error("登录手机号: " + mobile + " 不存在");
            throw new BizSecurityException("登录手机号 " + mobile + " 不存在,请检查登录手机号是否正确");
        }
        setUserInfo(user);
        return getUserPermission(user);
    }

    /***
     * 查询用户权限
     *
     * @author 王大宸
     * @date 2021/11/27 11:58
     * @param user
     * @return com.itdachen.security.core.model.CurrentUser
     */
    private CurrentUserInfo getUserPermission(CurrentUserDetails user) {
        // todo 登录时不查询用户权限, 进入首页时动态更新用户权限
        if (UserTypeConstant.SUPER_ADMINISTRATOR.equals(user.getUserType())) {
            user.setIsSuperAdmin(true);
        }
        if (StringUtils.isEmpty(user.getAccountSecret())) {
            user.setAccountSecret("0");
            user.setIsSuperAdmin(false);
        }
        //  return setUserPermission(user);

        // 新版本动态添加权限不生效,这里登录的时候添加权限
        Set<String> permissions = findUserPermission(user);
        return setUserPermission(user, permissions);
    }

    /***
     * 系统用户基础信息填充
     *
     * @author 王大宸
     * @date 2023/4/16 17:27
     * @param user user
     * @return void
     */
    private void setUserInfo(CurrentUserDetails user) {
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(user.getId());
        user.setDeptId(userInfo.getDepartId());
        user.setTelephone(userInfo.getTelephone());
        user.setEmail(userInfo.getEmail());
        user.setSex(user.getSex());
        user.setGrade(user.getGrade());
    }


    /***
     * 查询用户权限
     *
     * @author 王大宸
     * @date 2023/5/3 22:46
     * @param user user
     * @return java.util.Set<java.lang.String>
     */
    private Set<String> findUserPermission(CurrentUserDetails user) {
        Set<String> userPermission = null;
        if (UserTypeConstant.SUPER_ADMINISTRATOR.equals(user.getUserType())) {
            userPermission = permsAuthMapper.findPermissionAll();
        } else {
            userPermission = permsAuthMapper.findUserPermission(user.getId());
        }
        return userPermission;
    }

}