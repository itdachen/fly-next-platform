package com.github.itdachen.admin.service.impl;

import com.github.itdachen.admin.entity.UserInfo;
import com.github.itdachen.admin.mapper.IUserDetailsMapper;
import com.github.itdachen.admin.mapper.IUserInfoMapper;
import com.github.itdachen.framework.context.userdetails.CurrentUserDetails;
import com.github.itdachen.framework.core.permission.LoginUserModel;
import com.github.itdachen.security.details.AbstractSecurityUserDetailsService;
import com.github.itdachen.security.user.CurrentUserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;

/**
 * Description:
 * Created by 王大宸 on 2022-08-27 11:00
 * Created with IntelliJ IDEA.
 */
@Service
public class AdminSecurityUserDetailsService extends AbstractSecurityUserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(AdminSecurityUserDetailsService.class);

    private final IUserDetailsMapper userDetailsMapper;
    private final IUserInfoMapper userInfoMapper;

    public AdminSecurityUserDetailsService(IUserDetailsMapper userDetailsMapper,
                                           IUserInfoMapper userInfoMapper) {
        this.userDetailsMapper = userDetailsMapper;
        this.userInfoMapper = userInfoMapper;
    }

    @Override
    public CurrentUserInfo loadUserByUsername(String username) throws UsernameNotFoundException {
        CurrentUserDetails user = userDetailsMapper.loadUserByUsername(username);
        if (null == user) {
            logger.error("登录账号: " + username + " 不存在");
            throw new UsernameNotFoundException("登录账号 " + username + " 不存在,请检查账号是否正确");
        }
        setUserInfo(user);
        return getUserPermission(user);
    }

    @Override
    public CurrentUserInfo loadUserByMobile(String mobile) throws UsernameNotFoundException {
        CurrentUserDetails user = userDetailsMapper.loadUserByMobile(mobile);
        if (null == user) {
            logger.error("登录手机号: " + mobile + " 不存在");
            throw new UsernameNotFoundException("登录手机号 " + mobile + " 不存在,请检查登录手机号是否正确");
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

//        Set<PermissionInfo> userPermission = null;
//        if (UserTypeConstant.SUPER_ADMINISTRATOR.equals(user.getType())) {
//            userPermission = userDetailsMapper.findPermissionAll();
//            userPermission.addAll(userDetailsMapper.findPermissionMenuAll());
//        } else {
//            userPermission = userDetailsMapper.findUserPermission(user.getId());
//            userPermission.addAll(userDetailsMapper.findUserPermissionMenu(user.getId()));
//        }
//        return setUserPermission(user, userPermission);

        return setUserPermission(user, new HashSet<>());
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


}
