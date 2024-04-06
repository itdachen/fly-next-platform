package com.github.itdachen.admin_v1.convert.impl;

import com.github.itdachen.admin_v1.convert.IUserInfoConvert;
import com.github.itdachen.admin_v1.entity.UserInfo;
import com.github.itdachen.admin_v1.sdk.dto.UserInfoDto;
import com.github.itdachen.admin_v1.sdk.vo.UserInfoVo;
import org.springframework.stereotype.Component;

/**
 * Description:
 * Created by 王大宸 on 2023/04/27 20:41
 * Created with IntelliJ IDEA.
 */
@Component
public class UserInfoConvert implements IUserInfoConvert {

    @Override
    public UserInfo toJavaObject(UserInfoDto userInfoDto) {
        if (null == userInfoDto){
            return null;
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setId(userInfoDto.getId());
        userInfo.setUsername(userInfoDto.getUsername());
        userInfo.setPassword(userInfoDto.getPassword());
        userInfo.setName(userInfoDto.getName());
        userInfo.setAvatar(userInfoDto.getAvatar());
        userInfo.setBirthday(userInfoDto.getBirthday());
        userInfo.setAddress(userInfoDto.getAddress());
        userInfo.setTelephone(userInfoDto.getTelephone());
        userInfo.setEmail(userInfoDto.getEmail());
        userInfo.setDepartId(userInfoDto.getDepartId());
        userInfo.setSex(userInfoDto.getSex());
        userInfo.setType(userInfoDto.getType());
        userInfo.setStatus(userInfoDto.getStatus());
        userInfo.setRemarks(userInfoDto.getRemarks());
        userInfo.setTenantId(userInfoDto.getTenantId());
        userInfo.setClientId(userInfoDto.getClientId());
        userInfo.setIsDel(userInfoDto.getIsDel());
        userInfo.setAttr1(userInfoDto.getAttr1());
        userInfo.setAttr2(userInfoDto.getAttr2());
        userInfo.setAttr3(userInfoDto.getAttr3());
        userInfo.setAttr4(userInfoDto.getAttr4());
        userInfo.setAttr5(userInfoDto.getAttr5());
        userInfo.setAttr6(userInfoDto.getAttr6());
        userInfo.setAttr7(userInfoDto.getAttr7());
        userInfo.setAttr8(userInfoDto.getAttr8());
        userInfo.setAttr9(userInfoDto.getAttr9());
        userInfo.setAttr10(userInfoDto.getAttr10());
        return userInfo;
    }


    @Override
    public UserInfoVo toJavaObjectVo(UserInfo userInfo) {
        if (null == userInfo){
            return null;
        }
        UserInfoVo userInfoVo = new UserInfoVo();
        userInfoVo.setId(userInfo.getId());
        userInfoVo.setUsername(userInfo.getUsername());
        userInfoVo.setPassword(userInfo.getPassword());
        userInfoVo.setName(userInfo.getName());
        userInfoVo.setAvatar(userInfo.getAvatar());
        userInfoVo.setBirthday(userInfo.getBirthday());
        userInfoVo.setAddress(userInfo.getAddress());
        userInfoVo.setTelephone(userInfo.getTelephone());
        userInfoVo.setEmail(userInfo.getEmail());
        userInfoVo.setDepartId(userInfo.getDepartId());
        userInfoVo.setSex(userInfo.getSex());
        userInfoVo.setType(userInfo.getType());
        userInfoVo.setStatus(userInfo.getStatus());
        userInfoVo.setRemarks(userInfo.getRemarks());
        userInfoVo.setTenantId(userInfo.getTenantId());
        userInfoVo.setClientId(userInfo.getClientId());
        userInfoVo.setIsDel(userInfo.getIsDel());
        userInfoVo.setAttr1(userInfo.getAttr1());
        userInfoVo.setAttr2(userInfo.getAttr2());
        userInfoVo.setAttr3(userInfo.getAttr3());
        userInfoVo.setAttr4(userInfo.getAttr4());
        userInfoVo.setAttr5(userInfo.getAttr5());
        userInfoVo.setAttr6(userInfo.getAttr6());
        userInfoVo.setAttr7(userInfo.getAttr7());
        userInfoVo.setAttr8(userInfo.getAttr8());
        userInfoVo.setAttr9(userInfo.getAttr9());
        userInfoVo.setAttr10(userInfo.getAttr10());
        return userInfoVo;
    }

    public static UserInfo toJavaObject(UserInfoVo userInfoVo) {
        if (null == userInfoVo){
            return null;
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setId(userInfoVo.getId());
        userInfo.setUsername(userInfoVo.getUsername());
        userInfo.setPassword(userInfoVo.getPassword());
        userInfo.setName(userInfoVo.getName());
        userInfo.setAvatar(userInfoVo.getAvatar());
        userInfo.setBirthday(userInfoVo.getBirthday());
        userInfo.setAddress(userInfoVo.getAddress());
        userInfo.setTelephone(userInfoVo.getTelephone());
        userInfo.setEmail(userInfoVo.getEmail());
        userInfo.setDepartId(userInfoVo.getDepartId());
        userInfo.setSex(userInfoVo.getSex());
        userInfo.setType(userInfoVo.getType());
        userInfo.setStatus(userInfoVo.getStatus());
        userInfo.setRemarks(userInfoVo.getRemarks());
        userInfo.setTenantId(userInfoVo.getTenantId());
        userInfo.setClientId(userInfoVo.getClientId());
        userInfo.setIsDel(userInfoVo.getIsDel());
        userInfo.setAttr1(userInfoVo.getAttr1());
        userInfo.setAttr2(userInfoVo.getAttr2());
        userInfo.setAttr3(userInfoVo.getAttr3());
        userInfo.setAttr4(userInfoVo.getAttr4());
        userInfo.setAttr5(userInfoVo.getAttr5());
        userInfo.setAttr6(userInfoVo.getAttr6());
        userInfo.setAttr7(userInfoVo.getAttr7());
        userInfo.setAttr8(userInfoVo.getAttr8());
        userInfo.setAttr9(userInfoVo.getAttr9());
        userInfo.setAttr10(userInfoVo.getAttr10());
        return userInfo;
    }

    public static UserInfoVo toJavaObjectVo(UserInfoDto userInfoDto) {
        if (null == userInfoDto){
            return null;
        }
        UserInfoVo userInfoVo = new UserInfoVo();
        userInfoVo.setId(userInfoDto.getId());
        userInfoVo.setUsername(userInfoDto.getUsername());
        userInfoVo.setPassword(userInfoDto.getPassword());
        userInfoVo.setName(userInfoDto.getName());
        userInfoVo.setAvatar(userInfoDto.getAvatar());
        userInfoVo.setBirthday(userInfoDto.getBirthday());
        userInfoVo.setAddress(userInfoDto.getAddress());
        userInfoVo.setTelephone(userInfoDto.getTelephone());
        userInfoVo.setEmail(userInfoDto.getEmail());
        userInfoVo.setDepartId(userInfoDto.getDepartId());
        userInfoVo.setSex(userInfoDto.getSex());
        userInfoVo.setType(userInfoDto.getType());
        userInfoVo.setStatus(userInfoDto.getStatus());
        userInfoVo.setRemarks(userInfoDto.getRemarks());
        userInfoVo.setTenantId(userInfoDto.getTenantId());
        userInfoVo.setClientId(userInfoDto.getClientId());
        userInfoVo.setIsDel(userInfoDto.getIsDel());
        userInfoVo.setAttr1(userInfoDto.getAttr1());
        userInfoVo.setAttr2(userInfoDto.getAttr2());
        userInfoVo.setAttr3(userInfoDto.getAttr3());
        userInfoVo.setAttr4(userInfoDto.getAttr4());
        userInfoVo.setAttr5(userInfoDto.getAttr5());
        userInfoVo.setAttr6(userInfoDto.getAttr6());
        userInfoVo.setAttr7(userInfoDto.getAttr7());
        userInfoVo.setAttr8(userInfoDto.getAttr8());
        userInfoVo.setAttr9(userInfoDto.getAttr9());
        userInfoVo.setAttr10(userInfoDto.getAttr10());
        return userInfoVo;
    }


}
