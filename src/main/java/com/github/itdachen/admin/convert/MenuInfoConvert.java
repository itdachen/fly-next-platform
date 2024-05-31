package com.github.itdachen.admin.convert;

import com.github.itdachen.admin.entity.MenuInfo;
import com.github.itdachen.admin.sdk.dto.MenuInfoDTO;
import com.github.itdachen.admin.sdk.vo.MenuInfoVO;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;

/**
 * 菜单信息 类型转换
 *
 * @author 王大宸
 * @date 2024-04-20 22:16:39
 */
public class MenuInfoConvert implements IBizConvertMapper< MenuInfo, MenuInfoDTO, MenuInfoVO > {

    @Override
    public MenuInfo toJavaObject(MenuInfoDTO menuInfoDTO) {
        if (null == menuInfoDTO){
            return null;
        }
        MenuInfo menuInfo = new MenuInfo();
                menuInfo.setId(menuInfoDTO.getId());
                menuInfo.setAppId(menuInfoDTO.getAppId());
                menuInfo.setParentId(menuInfoDTO.getParentId());
                menuInfo.setParentTitle(menuInfoDTO.getParentTitle());
                menuInfo.setAuthCode(menuInfoDTO.getAuthCode());
                menuInfo.setType(menuInfoDTO.getType());
                menuInfo.setTitle(menuInfoDTO.getTitle());
                menuInfo.setPath(menuInfoDTO.getPath());
                menuInfo.setLayIcon(menuInfoDTO.getLayIcon());
                menuInfo.setOrderNum(menuInfoDTO.getOrderNum());
                menuInfo.setValidFlag(menuInfoDTO.getValidFlag());
                menuInfo.setOpenType(menuInfoDTO.getOpenType());
                menuInfo.setHasAuth(menuInfoDTO.getHasAuth());
                menuInfo.setHasIp(menuInfoDTO.getHasIp());
                menuInfo.setThirdParty(menuInfoDTO.getThirdParty());
                menuInfo.setThirdTitle(menuInfoDTO.getThirdTitle());
                menuInfo.setThirdUri(menuInfoDTO.getThirdUri());
                menuInfo.setAskUri(menuInfoDTO.getAskUri());
                menuInfo.setComponentName(menuInfoDTO.getComponentName());
                menuInfo.setRemarks(menuInfoDTO.getRemarks());
        return menuInfo;
    }


    @Override
    public MenuInfoVO toJavaObjectVO(MenuInfo menuInfo) {
        if (null == menuInfo){
            return null;
        }
            MenuInfoVO menuInfoVO = new MenuInfoVO();
                    menuInfoVO.setId(menuInfo.getId());
                    menuInfoVO.setAppId(menuInfo.getAppId());
                    menuInfoVO.setParentId(menuInfo.getParentId());
                    menuInfoVO.setParentTitle(menuInfo.getParentTitle());
                    menuInfoVO.setAuthCode(menuInfo.getAuthCode());
                    menuInfoVO.setType(menuInfo.getType());
                    menuInfoVO.setTitle(menuInfo.getTitle());
                    menuInfoVO.setPath(menuInfo.getPath());
                    menuInfoVO.setLayIcon(menuInfo.getLayIcon());
                    menuInfoVO.setOrderNum(menuInfo.getOrderNum());
                    menuInfoVO.setValidFlag(menuInfo.getValidFlag());
                    menuInfoVO.setOpenType(menuInfo.getOpenType());
                    menuInfoVO.setHasAuth(menuInfo.getHasAuth());
                    menuInfoVO.setHasIp(menuInfo.getHasIp());
                    menuInfoVO.setThirdParty(menuInfo.getThirdParty());
                    menuInfoVO.setThirdTitle(menuInfo.getThirdTitle());
                    menuInfoVO.setThirdUri(menuInfo.getThirdUri());
                    menuInfoVO.setAskUri(menuInfo.getAskUri());
                    menuInfoVO.setComponentName(menuInfo.getComponentName());
                    menuInfoVO.setRemarks(menuInfo.getRemarks());
        return menuInfoVO;
    }

    public MenuInfo toJavaObject(MenuInfoVO menuInfoVO) {
        if (null == menuInfoVO){
            return null;
        }
        MenuInfo menuInfo = new MenuInfo();
                menuInfo.setId(menuInfoVO.getId());
                menuInfo.setAppId(menuInfoVO.getAppId());
                menuInfo.setParentId(menuInfoVO.getParentId());
                menuInfo.setParentTitle(menuInfoVO.getParentTitle());
                menuInfo.setAuthCode(menuInfoVO.getAuthCode());
                menuInfo.setType(menuInfoVO.getType());
                menuInfo.setTitle(menuInfoVO.getTitle());
                menuInfo.setPath(menuInfoVO.getPath());
                menuInfo.setLayIcon(menuInfoVO.getLayIcon());
                menuInfo.setOrderNum(menuInfoVO.getOrderNum());
                menuInfo.setValidFlag(menuInfoVO.getValidFlag());
                menuInfo.setOpenType(menuInfoVO.getOpenType());
                menuInfo.setHasAuth(menuInfoVO.getHasAuth());
                menuInfo.setHasIp(menuInfoVO.getHasIp());
                menuInfo.setThirdParty(menuInfoVO.getThirdParty());
                menuInfo.setThirdTitle(menuInfoVO.getThirdTitle());
                menuInfo.setThirdUri(menuInfoVO.getThirdUri());
                menuInfo.setAskUri(menuInfoVO.getAskUri());
                menuInfo.setComponentName(menuInfoVO.getComponentName());
                menuInfo.setRemarks(menuInfoVO.getRemarks());
        return menuInfo;
    }

    public MenuInfoVO toJavaObjectVO(MenuInfoDTO menuInfoDTO) {
        if (null == menuInfoDTO){
            return null;
        }
            MenuInfoVO menuInfoVO = new MenuInfoVO();
                    menuInfoVO.setId(menuInfoDTO.getId());
                    menuInfoVO.setAppId(menuInfoDTO.getAppId());
                    menuInfoVO.setParentId(menuInfoDTO.getParentId());
                    menuInfoVO.setParentTitle(menuInfoDTO.getParentTitle());
                    menuInfoVO.setAuthCode(menuInfoDTO.getAuthCode());
                    menuInfoVO.setType(menuInfoDTO.getType());
                    menuInfoVO.setTitle(menuInfoDTO.getTitle());
                    menuInfoVO.setPath(menuInfoDTO.getPath());
                    menuInfoVO.setLayIcon(menuInfoDTO.getLayIcon());
                    menuInfoVO.setOrderNum(menuInfoDTO.getOrderNum());
                    menuInfoVO.setValidFlag(menuInfoDTO.getValidFlag());
                    menuInfoVO.setOpenType(menuInfoDTO.getOpenType());
                    menuInfoVO.setHasAuth(menuInfoDTO.getHasAuth());
                    menuInfoVO.setHasIp(menuInfoDTO.getHasIp());
                    menuInfoVO.setThirdParty(menuInfoDTO.getThirdParty());
                    menuInfoVO.setThirdTitle(menuInfoDTO.getThirdTitle());
                    menuInfoVO.setThirdUri(menuInfoDTO.getThirdUri());
                    menuInfoVO.setAskUri(menuInfoDTO.getAskUri());
                    menuInfoVO.setComponentName(menuInfoDTO.getComponentName());
                    menuInfoVO.setRemarks(menuInfoDTO.getRemarks());
        return menuInfoVO;
    }


}