package com.github.itdachen.admin_v1.convert.impl;

import com.github.itdachen.admin_v1.convert.IRoleUserConvert;
import com.github.itdachen.admin_v1.entity.RoleUser;
import com.github.itdachen.admin_v1.sdk.dto.RoleUserDto;
import com.github.itdachen.admin_v1.sdk.vo.RoleUserVo;
import org.springframework.stereotype.Component;

/**
 * Description:
 * Created by 王大宸 on 2023/04/27 20:37
 * Created with IntelliJ IDEA.
 */
@Component
public class RoleUserConvert implements IRoleUserConvert {


    @Override
    public RoleUser toJavaObject(RoleUserDto roleUserDto) {
        if (null == roleUserDto) {
            return null;
        }
        RoleUser roleUser = new RoleUser();
        roleUser.setId(roleUserDto.getId());
        roleUser.setUserId(roleUserDto.getUserId());
        roleUser.setRoleId(roleUserDto.getRoleId());
        roleUser.setClientId(roleUserDto.getClientId());
        return roleUser;
    }


    @Override
    public RoleUserVo toJavaObjectVo(RoleUser roleUser) {
        if (null == roleUser) {
            return null;
        }
        RoleUserVo roleUserVo = new RoleUserVo();
        roleUserVo.setId(roleUser.getId());
        roleUserVo.setUserId(roleUser.getUserId());
        roleUserVo.setRoleId(roleUser.getRoleId());
        roleUserVo.setClientId(roleUser.getClientId());
        return roleUserVo;
    }

    public static RoleUser toJavaObject(RoleUserVo roleUserVo) {
        if (null == roleUserVo) {
            return null;
        }
        RoleUser roleUser = new RoleUser();
        roleUser.setId(roleUserVo.getId());
        roleUser.setUserId(roleUserVo.getUserId());
        roleUser.setRoleId(roleUserVo.getRoleId());
        roleUser.setClientId(roleUserVo.getClientId());
        return roleUser;
    }

    public static RoleUserVo toJavaObjectVo(RoleUserDto roleUserDto) {
        if (null == roleUserDto) {
            return null;
        }
        RoleUserVo roleUserVo = new RoleUserVo();
        roleUserVo.setId(roleUserDto.getId());
        roleUserVo.setUserId(roleUserDto.getUserId());
        roleUserVo.setRoleId(roleUserDto.getRoleId());
        roleUserVo.setClientId(roleUserDto.getClientId());
        return roleUserVo;
    }

}
