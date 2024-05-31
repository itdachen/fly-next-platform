package com.github.itdachen.admin.convert;

import com.github.itdachen.admin.entity.AuthRoleMenu;
import com.github.itdachen.admin.sdk.dto.AuthRoleMenuDTO;
import com.github.itdachen.admin.sdk.vo.AuthRoleMenuVO;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;

/**
 * 人员身份菜单 类型转换
 *
 * @author 王大宸
 * @date 2024-05-15 22:13:44
 */
public class AuthRoleMenuConvert implements IBizConvertMapper< AuthRoleMenu, AuthRoleMenuDTO, AuthRoleMenuVO > {

    @Override
    public AuthRoleMenu toJavaObject(AuthRoleMenuDTO authRoleMenuDTO) {
        if (null == authRoleMenuDTO){
            return null;
        }
        AuthRoleMenu authRoleMenu = new AuthRoleMenu();
                authRoleMenu.setId(authRoleMenuDTO.getId());
                authRoleMenu.setTenantId(authRoleMenuDTO.getTenantId());
                authRoleMenu.setAppId(authRoleMenuDTO.getAppId());
                authRoleMenu.setRoleId(authRoleMenuDTO.getRoleId());
                authRoleMenu.setMeniId(authRoleMenuDTO.getMeniId());
        return authRoleMenu;
    }


    @Override
    public AuthRoleMenuVO toJavaObjectVO(AuthRoleMenu authRoleMenu) {
        if (null == authRoleMenu){
            return null;
        }
            AuthRoleMenuVO authRoleMenuVO = new AuthRoleMenuVO();
                    authRoleMenuVO.setId(authRoleMenu.getId());
                    authRoleMenuVO.setTenantId(authRoleMenu.getTenantId());
                    authRoleMenuVO.setAppId(authRoleMenu.getAppId());
                    authRoleMenuVO.setRoleId(authRoleMenu.getRoleId());
                    authRoleMenuVO.setMeniId(authRoleMenu.getMeniId());
        return authRoleMenuVO;
    }

    public AuthRoleMenu toJavaObject(AuthRoleMenuVO authRoleMenuVO) {
        if (null == authRoleMenuVO){
            return null;
        }
        AuthRoleMenu authRoleMenu = new AuthRoleMenu();
                authRoleMenu.setId(authRoleMenuVO.getId());
                authRoleMenu.setTenantId(authRoleMenuVO.getTenantId());
                authRoleMenu.setAppId(authRoleMenuVO.getAppId());
                authRoleMenu.setRoleId(authRoleMenuVO.getRoleId());
                authRoleMenu.setMeniId(authRoleMenuVO.getMeniId());
        return authRoleMenu;
    }

    public AuthRoleMenuVO toJavaObjectVO(AuthRoleMenuDTO authRoleMenuDTO) {
        if (null == authRoleMenuDTO){
            return null;
        }
            AuthRoleMenuVO authRoleMenuVO = new AuthRoleMenuVO();
                    authRoleMenuVO.setId(authRoleMenuDTO.getId());
                    authRoleMenuVO.setTenantId(authRoleMenuDTO.getTenantId());
                    authRoleMenuVO.setAppId(authRoleMenuDTO.getAppId());
                    authRoleMenuVO.setRoleId(authRoleMenuDTO.getRoleId());
                    authRoleMenuVO.setMeniId(authRoleMenuDTO.getMeniId());
        return authRoleMenuVO;
    }


}