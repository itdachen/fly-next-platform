package com.github.itdachen.admin.convert.impl;

import com.github.itdachen.admin.convert.IRoleInfoConvert;
import com.github.itdachen.admin.entity.RoleInfo;
import com.github.itdachen.admin.sdk.dto.RoleInfoDto;
import com.github.itdachen.admin.sdk.vo.RoleInfoVo;
import org.springframework.stereotype.Component;

/**
 * Description:
 * Created by 王大宸 on 2023/04/27 20:33
 * Created with IntelliJ IDEA.
 */
@Component
public class RoleInfoConvert implements IRoleInfoConvert {


    @Override
    public RoleInfo toJavaObject(RoleInfoDto roleInfoDto) {
        if (null == roleInfoDto) {
            return null;
        }
        RoleInfo roleInfo = new RoleInfo();
        roleInfo.setId(roleInfoDto.getId());
        roleInfo.setDeptId(roleInfoDto.getDeptId());
        roleInfo.setRoleCode(roleInfoDto.getRoleCode());
        roleInfo.setTitle(roleInfoDto.getTitle());
        roleInfo.setClientId(roleInfoDto.getClientId());
        roleInfo.setRemarks(roleInfoDto.getRemarks());
        return roleInfo;
    }


    @Override
    public RoleInfoVo toJavaObjectVo(RoleInfo roleInfo) {
        if (null == roleInfo) {
            return null;
        }
        RoleInfoVo roleInfoVo = new RoleInfoVo();
        roleInfoVo.setId(roleInfo.getId());
        roleInfoVo.setDeptId(roleInfo.getDeptId());
        roleInfoVo.setRoleCode(roleInfo.getRoleCode());
        roleInfoVo.setTitle(roleInfo.getTitle());
        roleInfoVo.setClientId(roleInfo.getClientId());
        roleInfoVo.setRemarks(roleInfo.getRemarks());
        return roleInfoVo;
    }

    public static RoleInfo toJavaObject(RoleInfoVo roleInfoVo) {
        if (null == roleInfoVo) {
            return null;
        }
        RoleInfo roleInfo = new RoleInfo();
        roleInfo.setId(roleInfoVo.getId());
        roleInfo.setDeptId(roleInfoVo.getDeptId());
        roleInfo.setRoleCode(roleInfoVo.getRoleCode());
        roleInfo.setTitle(roleInfoVo.getTitle());
        roleInfo.setClientId(roleInfoVo.getClientId());
        roleInfo.setRemarks(roleInfoVo.getRemarks());
        return roleInfo;
    }

    public static RoleInfoVo toJavaObjectVo(RoleInfoDto roleInfoDto) {
        if (null == roleInfoDto) {
            return null;
        }
        RoleInfoVo roleInfoVo = new RoleInfoVo();
        roleInfoVo.setId(roleInfoDto.getId());
        roleInfoVo.setDeptId(roleInfoDto.getDeptId());
        roleInfoVo.setRoleCode(roleInfoDto.getRoleCode());
        roleInfoVo.setTitle(roleInfoDto.getTitle());
        roleInfoVo.setClientId(roleInfoDto.getClientId());
        roleInfoVo.setRemarks(roleInfoDto.getRemarks());
        return roleInfoVo;
    }

}
