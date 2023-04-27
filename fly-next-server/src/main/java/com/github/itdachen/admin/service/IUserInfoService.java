package com.github.itdachen.admin.service;

import com.github.itdachen.admin.entity.SetUserPassword;
import com.github.itdachen.admin.entity.UserInfo;
import com.github.itdachen.admin.sdk.dto.UserInfoDto;
import com.github.itdachen.admin.sdk.query.UserInfoQuery;
import com.github.itdachen.admin.sdk.vo.UserInfoVo;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.webmvc.service.IBizService;

/**
 * 用户信息 业务接口
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
public interface IUserInfoService extends IBizService<UserInfoDto, UserInfoVo, UserInfoQuery, String> {


    /***
     * 修改用户状态
     *
     * @author 王大宸
     * @date 2023/4/5 0:51
     * @param id id
     * @param status status
     * @return com.github.itdachen.admin.entity.UserInfo
     */
    UserInfo updateUserStatus(String id, Boolean status) throws BizException;

    /***
     * 修改密码
     *
     * @author 王大宸
     * @date 2023/4/5 0:51
     * @param userPassword userPassword
     * @return com.github.itdachen.admin.sdk.vo.UserInfoVo
     */
    void password(SetUserPassword userPassword) throws BizException;

}
