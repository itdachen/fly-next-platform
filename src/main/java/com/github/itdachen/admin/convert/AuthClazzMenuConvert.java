package com.github.itdachen.admin.convert;

import com.github.itdachen.admin.entity.AuthClazzMenu;
import com.github.itdachen.admin.sdk.dto.AuthClazzMenuDTO;
import com.github.itdachen.admin.sdk.vo.AuthClazzMenuVO;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;

/**
 * 岗位菜单 类型转换
 *
 * @author 王大宸
 * @date 2024-05-15 21:32:13
 */
public class AuthClazzMenuConvert implements IBizConvertMapper< AuthClazzMenu, AuthClazzMenuDTO, AuthClazzMenuVO > {

    @Override
    public AuthClazzMenu toJavaObject(AuthClazzMenuDTO authClazzMenuDTO) {
        if (null == authClazzMenuDTO){
            return null;
        }
        AuthClazzMenu authClazzMenu = new AuthClazzMenu();
        authClazzMenu.setId(authClazzMenuDTO.getId());
        authClazzMenu.setTenantId(authClazzMenuDTO.getTenantId());
        authClazzMenu.setAppId(authClazzMenuDTO.getAppId());
        authClazzMenu.setClazzId(authClazzMenuDTO.getClazzId());
        authClazzMenu.setMeniId(authClazzMenuDTO.getMeniId());
        return authClazzMenu;
    }


    @Override
    public AuthClazzMenuVO toJavaObjectVO(AuthClazzMenu authClazzMenu) {
        if (null == authClazzMenu){
            return null;
        }
        AuthClazzMenuVO authClazzMenuVO = new AuthClazzMenuVO();
        authClazzMenuVO.setId(authClazzMenu.getId());
        authClazzMenuVO.setTenantId(authClazzMenu.getTenantId());
        authClazzMenuVO.setAppId(authClazzMenu.getAppId());
        authClazzMenuVO.setClazzId(authClazzMenu.getClazzId());
        authClazzMenuVO.setMeniId(authClazzMenu.getMeniId());
        return authClazzMenuVO;
    }

    public AuthClazzMenu toJavaObject(AuthClazzMenuVO authClazzMenuVO) {
        if (null == authClazzMenuVO){
            return null;
        }
        AuthClazzMenu authClazzMenu = new AuthClazzMenu();
        authClazzMenu.setId(authClazzMenuVO.getId());
        authClazzMenu.setTenantId(authClazzMenuVO.getTenantId());
        authClazzMenu.setAppId(authClazzMenuVO.getAppId());
        authClazzMenu.setClazzId(authClazzMenuVO.getClazzId());
        authClazzMenu.setMeniId(authClazzMenuVO.getMeniId());
        return authClazzMenu;
    }

    public AuthClazzMenuVO toJavaObjectVO(AuthClazzMenuDTO authClazzMenuDTO) {
        if (null == authClazzMenuDTO){
            return null;
        }
        AuthClazzMenuVO authClazzMenuVO = new AuthClazzMenuVO();
        authClazzMenuVO.setId(authClazzMenuDTO.getId());
        authClazzMenuVO.setTenantId(authClazzMenuDTO.getTenantId());
        authClazzMenuVO.setAppId(authClazzMenuDTO.getAppId());
        authClazzMenuVO.setClazzId(authClazzMenuDTO.getClazzId());
        authClazzMenuVO.setMeniId(authClazzMenuDTO.getMeniId());
        return authClazzMenuVO;
    }


}