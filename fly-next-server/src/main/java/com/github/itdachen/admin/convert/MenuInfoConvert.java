package com.github.itdachen.admin.convert;

import com.github.itdachen.admin.entity.MenuInfo;
import com.github.itdachen.admin.sdk.dto.MenuInfoDto;
import com.github.itdachen.admin.sdk.vo.MenuInfoVo;
import com.github.itdachen.framework.webmvc.convert.BizConvert;

/**
 * Description:
 * Created by 王大宸 on 2023/04/27 20:26
 * Created with IntelliJ IDEA.
 */
public class MenuInfoConvert extends BizConvert<MenuInfo, MenuInfoDto, MenuInfoVo> {

    @Override
    public MenuInfo toJavaObject(MenuInfoDto menuInfoDto) {
        if (null == menuInfoDto){
            return null;
        }
        MenuInfo menuInfo = new MenuInfo();
        menuInfo.setId(menuInfoDto.getId());
        menuInfo.setCode(menuInfoDto.getCode());
        menuInfo.setTitle(menuInfoDto.getTitle());
        menuInfo.setClientId(menuInfoDto.getClientId());
        menuInfo.setParentId(menuInfoDto.getParentId());
        menuInfo.setPath(menuInfoDto.getPath());
        menuInfo.setRedirect(menuInfoDto.getRedirect());
        menuInfo.setIcon(menuInfoDto.getIcon());
        menuInfo.setType(menuInfoDto.getType());
        menuInfo.setOrderNum(menuInfoDto.getOrderNum());
        menuInfo.setVisible(menuInfoDto.getVisible());
        menuInfo.setName(menuInfoDto.getName());
        menuInfo.setComponent(menuInfoDto.getComponent());
        menuInfo.setLink(menuInfoDto.getLink());
        menuInfo.setAffix(menuInfoDto.getAffix());
        menuInfo.setIframe(menuInfoDto.getIframe());
        menuInfo.setKeepAlive(menuInfoDto.getKeepAlive());
        menuInfo.setRemarks(menuInfoDto.getRemarks());
        return menuInfo;
    }


    @Override
    public MenuInfoVo toJavaObjectVo(MenuInfo menuInfo) {
        if (null == menuInfo){
            return null;
        }
        MenuInfoVo menuInfoVo = new MenuInfoVo();
        menuInfoVo.setId(menuInfo.getId());
        menuInfoVo.setCode(menuInfo.getCode());
        menuInfoVo.setTitle(menuInfo.getTitle());
        menuInfoVo.setClientId(menuInfo.getClientId());
        menuInfoVo.setParentId(menuInfo.getParentId());
        menuInfoVo.setPath(menuInfo.getPath());
        menuInfoVo.setRedirect(menuInfo.getRedirect());
        menuInfoVo.setIcon(menuInfo.getIcon());
        menuInfoVo.setType(menuInfo.getType());
        menuInfoVo.setOrderNum(menuInfo.getOrderNum());
        menuInfoVo.setVisible(menuInfo.getVisible());
        menuInfoVo.setName(menuInfo.getName());
        menuInfoVo.setComponent(menuInfo.getComponent());
        menuInfoVo.setLink(menuInfo.getLink());
        menuInfoVo.setAffix(menuInfo.getAffix());
        menuInfoVo.setIframe(menuInfo.getIframe());
        menuInfoVo.setKeepAlive(menuInfo.getKeepAlive());
        menuInfoVo.setRemarks(menuInfo.getRemarks());
        return menuInfoVo;
    }

    public static MenuInfo toJavaObject(MenuInfoVo menuInfoVo) {
        if (null == menuInfoVo){
            return null;
        }
        MenuInfo menuInfo = new MenuInfo();
        menuInfo.setId(menuInfoVo.getId());
        menuInfo.setCode(menuInfoVo.getCode());
        menuInfo.setTitle(menuInfoVo.getTitle());
        menuInfo.setClientId(menuInfoVo.getClientId());
        menuInfo.setParentId(menuInfoVo.getParentId());
        menuInfo.setPath(menuInfoVo.getPath());
        menuInfo.setRedirect(menuInfoVo.getRedirect());
        menuInfo.setIcon(menuInfoVo.getIcon());
        menuInfo.setType(menuInfoVo.getType());
        menuInfo.setOrderNum(menuInfoVo.getOrderNum());
        menuInfo.setVisible(menuInfoVo.getVisible());
        menuInfo.setName(menuInfoVo.getName());
        menuInfo.setComponent(menuInfoVo.getComponent());
        menuInfo.setLink(menuInfoVo.getLink());
        menuInfo.setAffix(menuInfoVo.getAffix());
        menuInfo.setIframe(menuInfoVo.getIframe());
        menuInfo.setKeepAlive(menuInfoVo.getKeepAlive());
        menuInfo.setRemarks(menuInfoVo.getRemarks());
        return menuInfo;
    }

    public static MenuInfoVo toJavaObjectVo(MenuInfoDto menuInfoDto) {
        if (null == menuInfoDto){
            return null;
        }
        MenuInfoVo menuInfoVo = new MenuInfoVo();
        menuInfoVo.setId(menuInfoDto.getId());
        menuInfoVo.setCode(menuInfoDto.getCode());
        menuInfoVo.setTitle(menuInfoDto.getTitle());
        menuInfoVo.setClientId(menuInfoDto.getClientId());
        menuInfoVo.setParentId(menuInfoDto.getParentId());
        menuInfoVo.setPath(menuInfoDto.getPath());
        menuInfoVo.setRedirect(menuInfoDto.getRedirect());
        menuInfoVo.setIcon(menuInfoDto.getIcon());
        menuInfoVo.setType(menuInfoDto.getType());
        menuInfoVo.setOrderNum(menuInfoDto.getOrderNum());
        menuInfoVo.setVisible(menuInfoDto.getVisible());
        menuInfoVo.setName(menuInfoDto.getName());
        menuInfoVo.setComponent(menuInfoDto.getComponent());
        menuInfoVo.setLink(menuInfoDto.getLink());
        menuInfoVo.setAffix(menuInfoDto.getAffix());
        menuInfoVo.setIframe(menuInfoDto.getIframe());
        menuInfoVo.setKeepAlive(menuInfoDto.getKeepAlive());
        menuInfoVo.setRemarks(menuInfoDto.getRemarks());
        return menuInfoVo;
    }

}
