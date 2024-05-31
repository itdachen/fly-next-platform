package com.github.itdachen.admin.convert;

import com.github.itdachen.admin.entity.AuthGrantMenu;
import com.github.itdachen.admin.sdk.dto.AuthGrantMenuDTO;
import com.github.itdachen.admin.sdk.vo.AuthGrantMenuVO;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;

/**
 * 权限下发 类型转换
 *
 * @author 王大宸
 * @date 2024-05-15 21:32:13
 */
public class AuthGrantMenuConvert implements IBizConvertMapper< AuthGrantMenu, AuthGrantMenuDTO, AuthGrantMenuVO > {

    @Override
    public AuthGrantMenu toJavaObject(AuthGrantMenuDTO authGrantMenuDTO) {
        if (null == authGrantMenuDTO){
            return null;
        }
        AuthGrantMenu authGrantMenu = new AuthGrantMenu();
                authGrantMenu.setId(authGrantMenuDTO.getId());
                authGrantMenu.setPlatId(authGrantMenuDTO.getPlatId());
                authGrantMenu.setAppId(authGrantMenuDTO.getAppId());
                authGrantMenu.setTenantId(authGrantMenuDTO.getTenantId());
                authGrantMenu.setUserId(authGrantMenuDTO.getUserId());
                authGrantMenu.setMenuId(authGrantMenuDTO.getMenuId());
        return authGrantMenu;
    }


    @Override
    public AuthGrantMenuVO toJavaObjectVO(AuthGrantMenu authGrantMenu) {
        if (null == authGrantMenu){
            return null;
        }
            AuthGrantMenuVO authGrantMenuVO = new AuthGrantMenuVO();
                    authGrantMenuVO.setId(authGrantMenu.getId());
                    authGrantMenuVO.setPlatId(authGrantMenu.getPlatId());
                    authGrantMenuVO.setAppId(authGrantMenu.getAppId());
                    authGrantMenuVO.setTenantId(authGrantMenu.getTenantId());
                    authGrantMenuVO.setUserId(authGrantMenu.getUserId());
                    authGrantMenuVO.setMenuId(authGrantMenu.getMenuId());
        return authGrantMenuVO;
    }

    public AuthGrantMenu toJavaObject(AuthGrantMenuVO authGrantMenuVO) {
        if (null == authGrantMenuVO){
            return null;
        }
        AuthGrantMenu authGrantMenu = new AuthGrantMenu();
                authGrantMenu.setId(authGrantMenuVO.getId());
                authGrantMenu.setPlatId(authGrantMenuVO.getPlatId());
                authGrantMenu.setAppId(authGrantMenuVO.getAppId());
                authGrantMenu.setTenantId(authGrantMenuVO.getTenantId());
                authGrantMenu.setUserId(authGrantMenuVO.getUserId());
                authGrantMenu.setMenuId(authGrantMenuVO.getMenuId());
        return authGrantMenu;
    }

    public AuthGrantMenuVO toJavaObjectVO(AuthGrantMenuDTO authGrantMenuDTO) {
        if (null == authGrantMenuDTO){
            return null;
        }
            AuthGrantMenuVO authGrantMenuVO = new AuthGrantMenuVO();
                    authGrantMenuVO.setId(authGrantMenuDTO.getId());
                    authGrantMenuVO.setPlatId(authGrantMenuDTO.getPlatId());
                    authGrantMenuVO.setAppId(authGrantMenuDTO.getAppId());
                    authGrantMenuVO.setTenantId(authGrantMenuDTO.getTenantId());
                    authGrantMenuVO.setUserId(authGrantMenuDTO.getUserId());
                    authGrantMenuVO.setMenuId(authGrantMenuDTO.getMenuId());
        return authGrantMenuVO;
    }


}