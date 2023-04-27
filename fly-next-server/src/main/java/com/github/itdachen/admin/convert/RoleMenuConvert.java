package com.github.itdachen.admin.convert;

import com.github.itdachen.admin.entity.RoleMenu;
import com.github.itdachen.admin.sdk.dto.RoleMenuDto;
import com.github.itdachen.admin.sdk.vo.RoleMenuVo;
import com.github.itdachen.framework.webmvc.convert.BizConvert;

/**
 * Description:
 * Created by 王大宸 on 2023/04/27 20:35
 * Created with IntelliJ IDEA.
 */
public class RoleMenuConvert extends BizConvert<RoleMenu, RoleMenuDto, RoleMenuVo> {

    @Override
    public RoleMenu toJavaObject(RoleMenuDto roleMenuDto) {
        if (null == roleMenuDto){
            return null;
        }
        RoleMenu roleMenu = new RoleMenu();
        roleMenu.setId(roleMenuDto.getId());
        roleMenu.setRoleId(roleMenuDto.getRoleId());
        roleMenu.setMenuId(roleMenuDto.getMenuId());
        roleMenu.setClientId(roleMenuDto.getClientId());
        return roleMenu;
    }


    @Override
    public RoleMenuVo toJavaObjectVo(RoleMenu roleMenu) {
        if (null == roleMenu){
            return null;
        }
        RoleMenuVo roleMenuVo = new RoleMenuVo();
        roleMenuVo.setId(roleMenu.getId());
        roleMenuVo.setRoleId(roleMenu.getRoleId());
        roleMenuVo.setMenuId(roleMenu.getMenuId());
        roleMenuVo.setClientId(roleMenu.getClientId());
        return roleMenuVo;
    }

    public static RoleMenu toJavaObject(RoleMenuVo roleMenuVo) {
        if (null == roleMenuVo){
            return null;
        }
        RoleMenu roleMenu = new RoleMenu();
        roleMenu.setId(roleMenuVo.getId());
        roleMenu.setRoleId(roleMenuVo.getRoleId());
        roleMenu.setMenuId(roleMenuVo.getMenuId());
        roleMenu.setClientId(roleMenuVo.getClientId());
        return roleMenu;
    }

    public static RoleMenuVo toJavaObjectVo(RoleMenuDto roleMenuDto) {
        if (null == roleMenuDto){
            return null;
        }
        RoleMenuVo roleMenuVo = new RoleMenuVo();
        roleMenuVo.setId(roleMenuDto.getId());
        roleMenuVo.setRoleId(roleMenuDto.getRoleId());
        roleMenuVo.setMenuId(roleMenuDto.getMenuId());
        roleMenuVo.setClientId(roleMenuDto.getClientId());
        return roleMenuVo;
    }

}
