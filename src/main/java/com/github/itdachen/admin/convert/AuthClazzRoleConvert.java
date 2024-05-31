package com.github.itdachen.admin.convert;

import com.github.itdachen.admin.entity.AuthClazzRole;
import com.github.itdachen.admin.sdk.dto.AuthClazzRoleDTO;
import com.github.itdachen.admin.sdk.vo.AuthClazzRoleVO;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;

/**
 * 身份岗位管理表 类型转换
 *
 * @author 王大宸
 * @date 2024-05-15 21:32:14
 */
public class AuthClazzRoleConvert implements IBizConvertMapper<AuthClazzRole, AuthClazzRoleDTO, AuthClazzRoleVO> {

    @Override
    public AuthClazzRole toJavaObject(AuthClazzRoleDTO authClazzRoleDTO) {
        if (null == authClazzRoleDTO) {
            return null;
        }
        AuthClazzRole authClazzRole = new AuthClazzRole();
        authClazzRole.setId(authClazzRoleDTO.getId());
        authClazzRole.setTenantId(authClazzRoleDTO.getTenantId());
        authClazzRole.setAppId(authClazzRoleDTO.getAppId());
        authClazzRole.setClazzId(authClazzRoleDTO.getClazzId());
        authClazzRole.setRoleId(authClazzRoleDTO.getRoleId());
        return authClazzRole;
    }


    @Override
    public AuthClazzRoleVO toJavaObjectVO(AuthClazzRole authClazzRole) {
        if (null == authClazzRole) {
            return null;
        }
        AuthClazzRoleVO authClazzRoleVO = new AuthClazzRoleVO();
        authClazzRoleVO.setId(authClazzRole.getId());
        authClazzRoleVO.setTenantId(authClazzRole.getTenantId());
        authClazzRoleVO.setAppId(authClazzRole.getAppId());
        authClazzRoleVO.setClazzId(authClazzRole.getClazzId());
        authClazzRoleVO.setRoleId(authClazzRole.getRoleId());
        return authClazzRoleVO;
    }

    public AuthClazzRole toJavaObject(AuthClazzRoleVO authClazzRoleVO) {
        if (null == authClazzRoleVO) {
            return null;
        }
        AuthClazzRole authClazzRole = new AuthClazzRole();
        authClazzRole.setId(authClazzRoleVO.getId());
        authClazzRole.setTenantId(authClazzRoleVO.getTenantId());
        authClazzRole.setAppId(authClazzRoleVO.getAppId());
        authClazzRole.setClazzId(authClazzRoleVO.getClazzId());
        authClazzRole.setRoleId(authClazzRoleVO.getRoleId());
        return authClazzRole;
    }

    public AuthClazzRoleVO toJavaObjectVO(AuthClazzRoleDTO authClazzRoleDTO) {
        if (null == authClazzRoleDTO) {
            return null;
        }
        AuthClazzRoleVO authClazzRoleVO = new AuthClazzRoleVO();
        authClazzRoleVO.setId(authClazzRoleDTO.getId());
        authClazzRoleVO.setTenantId(authClazzRoleDTO.getTenantId());
        authClazzRoleVO.setAppId(authClazzRoleDTO.getAppId());
        authClazzRoleVO.setClazzId(authClazzRoleDTO.getClazzId());
        authClazzRoleVO.setRoleId(authClazzRoleDTO.getRoleId());
        return authClazzRoleVO;
    }

}