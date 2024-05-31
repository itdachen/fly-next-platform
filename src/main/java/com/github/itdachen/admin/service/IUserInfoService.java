package com.github.itdachen.admin.service;

import com.github.itdachen.admin.sdk.dto.UserInfoDTO;
import com.github.itdachen.admin.sdk.query.UserInfoQuery;
import com.github.itdachen.admin.sdk.vo.UserInfoVO;
import com.github.itdachen.framework.webmvc.service.IBizService;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 用户信息 业务接口
 *
 * @author 王大宸
 * @date 2024-04-27 20:42:58
 */
public interface IUserInfoService extends IBizService<UserInfoDTO, UserInfoVO, UserInfoQuery, String> {

    /***
     * 有效标志
     *
     * @author 王大宸
     * @date 2024/4/20 21:20
     * @param id id
     * @param checked checked
     */
    void validFlagChecked(String id, Boolean checked) throws Exception;


    /***
     * 根据电话号码查询用户信息
     *
     * @author 王大宸
     * @date 2024/5/9 23:16
     * @param telephone telephone
     * @return com.github.itdachen.admin.sdk.vo.UserInfoVO
     */
    UserInfoVO findUserInfoByTelephone(String telephone) throws Exception;

}
