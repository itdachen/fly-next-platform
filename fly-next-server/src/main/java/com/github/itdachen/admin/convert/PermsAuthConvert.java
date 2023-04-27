package com.github.itdachen.admin.convert;

import com.github.itdachen.admin.entity.PermsAuth;
import com.github.itdachen.admin.sdk.dto.PermsAuthDto;
import com.github.itdachen.admin.sdk.vo.PermsAuthVo;
import com.github.itdachen.framework.webmvc.convert.BizConvert;

/**
 * Description:
 * Created by 王大宸 on 2023/04/27 20:31
 * Created with IntelliJ IDEA.
 */
public class PermsAuthConvert extends BizConvert<PermsAuth, PermsAuthDto, PermsAuthVo> {

    @Override
    public PermsAuth toJavaObject(PermsAuthDto permsAuthDto) {
        if (null == permsAuthDto){
            return null;
        }
        PermsAuth permsAuth = new PermsAuth();
        permsAuth.setId(permsAuthDto.getId());
        permsAuth.setUserId(permsAuthDto.getUserId());
        permsAuth.setMenuId(permsAuthDto.getMenuId());
        permsAuth.setClientId(permsAuthDto.getClientId());
        return permsAuth;
    }


    @Override
    public PermsAuthVo toJavaObjectVo(PermsAuth permsAuth) {
        if (null == permsAuth){
            return null;
        }
        PermsAuthVo permsAuthVo = new PermsAuthVo();
        permsAuthVo.setId(permsAuth.getId());
        permsAuthVo.setUserId(permsAuth.getUserId());
        permsAuthVo.setMenuId(permsAuth.getMenuId());
        permsAuthVo.setClientId(permsAuth.getClientId());
        return permsAuthVo;
    }

    public static PermsAuth toJavaObject(PermsAuthVo permsAuthVo) {
        if (null == permsAuthVo){
            return null;
        }
        PermsAuth permsAuth = new PermsAuth();
        permsAuth.setId(permsAuthVo.getId());
        permsAuth.setUserId(permsAuthVo.getUserId());
        permsAuth.setMenuId(permsAuthVo.getMenuId());
        permsAuth.setClientId(permsAuthVo.getClientId());
        return permsAuth;
    }

    public static PermsAuthVo toJavaObjectVo(PermsAuthDto permsAuthDto) {
        if (null == permsAuthDto){
            return null;
        }
        PermsAuthVo permsAuthVo = new PermsAuthVo();
        permsAuthVo.setId(permsAuthDto.getId());
        permsAuthVo.setUserId(permsAuthDto.getUserId());
        permsAuthVo.setMenuId(permsAuthDto.getMenuId());
        permsAuthVo.setClientId(permsAuthDto.getClientId());
        return permsAuthVo;
    }

}
