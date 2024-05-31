package com.github.itdachen.admin.convert;

import com.github.itdachen.admin.entity.UserInfo;
import com.github.itdachen.admin.sdk.dto.UserInfoDTO;
import com.github.itdachen.admin.sdk.vo.UserInfoVO;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;

/**
 * 用户信息 类型转换
 *
 * @author 王大宸
 * @date 2024-04-27 20:42:58
 */
public class UserInfoConvert implements IBizConvertMapper< UserInfo, UserInfoDTO, UserInfoVO > {

    @Override
    public UserInfo toJavaObject(UserInfoDTO userInfoDTO) {
        if (null == userInfoDTO){
            return null;
        }
        UserInfo userInfo = new UserInfo();
                userInfo.setId(userInfoDTO.getId());
                userInfo.setTenantId(userInfoDTO.getTenantId());
                userInfo.setTenantTitle(userInfoDTO.getTenantTitle());
                userInfo.setNickName(userInfoDTO.getNickName());
                userInfo.setIdCard(userInfoDTO.getIdCard());
                userInfo.setSex(userInfoDTO.getSex());
                userInfo.setTelephone(userInfoDTO.getTelephone());
                userInfo.setAvatar(userInfoDTO.getAvatar());
                userInfo.seteMailBox(userInfoDTO.geteMailBox());
                userInfo.setUserType(userInfoDTO.getUserType());
                userInfo.setValidFlag(userInfoDTO.getValidFlag());
                userInfo.setRemarks(userInfoDTO.getRemarks());
        return userInfo;
    }


    @Override
    public UserInfoVO toJavaObjectVO(UserInfo userInfo) {
        if (null == userInfo){
            return null;
        }
            UserInfoVO userInfoVO = new UserInfoVO();
                    userInfoVO.setId(userInfo.getId());
                    userInfoVO.setTenantId(userInfo.getTenantId());
                    userInfoVO.setTenantTitle(userInfo.getTenantTitle());
                    userInfoVO.setNickName(userInfo.getNickName());
                    userInfoVO.setIdCard(userInfo.getIdCard());
                    userInfoVO.setSex(userInfo.getSex());
                    userInfoVO.setTelephone(userInfo.getTelephone());
                    userInfoVO.setAvatar(userInfo.getAvatar());
                    userInfoVO.seteMailBox(userInfo.geteMailBox());
                    userInfoVO.setUserType(userInfo.getUserType());
                    userInfoVO.setValidFlag(userInfo.getValidFlag());
                    userInfoVO.setRemarks(userInfo.getRemarks());
        return userInfoVO;
    }

    public UserInfo toJavaObject(UserInfoVO userInfoVO) {
        if (null == userInfoVO){
            return null;
        }
        UserInfo userInfo = new UserInfo();
                userInfo.setId(userInfoVO.getId());
                userInfo.setTenantId(userInfoVO.getTenantId());
                userInfo.setTenantTitle(userInfoVO.getTenantTitle());
                userInfo.setNickName(userInfoVO.getNickName());
                userInfo.setIdCard(userInfoVO.getIdCard());
                userInfo.setSex(userInfoVO.getSex());
                userInfo.setTelephone(userInfoVO.getTelephone());
                userInfo.setAvatar(userInfoVO.getAvatar());
                userInfo.seteMailBox(userInfoVO.geteMailBox());
                userInfo.setUserType(userInfoVO.getUserType());
                userInfo.setValidFlag(userInfoVO.getValidFlag());
                userInfo.setRemarks(userInfoVO.getRemarks());
        return userInfo;
    }

    public UserInfoVO toJavaObjectVO(UserInfoDTO userInfoDTO) {
        if (null == userInfoDTO){
            return null;
        }
            UserInfoVO userInfoVO = new UserInfoVO();
                    userInfoVO.setId(userInfoDTO.getId());
                    userInfoVO.setTenantId(userInfoDTO.getTenantId());
                    userInfoVO.setTenantTitle(userInfoDTO.getTenantTitle());
                    userInfoVO.setNickName(userInfoDTO.getNickName());
                    userInfoVO.setIdCard(userInfoDTO.getIdCard());
                    userInfoVO.setSex(userInfoDTO.getSex());
                    userInfoVO.setTelephone(userInfoDTO.getTelephone());
                    userInfoVO.setAvatar(userInfoDTO.getAvatar());
                    userInfoVO.seteMailBox(userInfoDTO.geteMailBox());
                    userInfoVO.setUserType(userInfoDTO.getUserType());
                    userInfoVO.setValidFlag(userInfoDTO.getValidFlag());
                    userInfoVO.setRemarks(userInfoDTO.getRemarks());
        return userInfoVO;
    }


}