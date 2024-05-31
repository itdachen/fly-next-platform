package com.github.itdachen.admin.convert;

import com.github.itdachen.admin.entity.AppInfo;
import com.github.itdachen.admin.sdk.dto.AppInfoDTO;
import com.github.itdachen.admin.sdk.vo.AppInfoVO;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;

/**
 * 应用信息 类型转换
 *
 * @author 王大宸
 * @date 2024-04-19 21:22:54
 */
public class AppInfoConvert implements IBizConvertMapper<AppInfo, AppInfoDTO, AppInfoVO> {

    @Override
    public AppInfo toJavaObject(AppInfoDTO appInfoDTO) {
        if (null == appInfoDTO){
            return null;
        }
        AppInfo appInfo = new AppInfo();
                appInfo.setId(appInfoDTO.getId());
                appInfo.setPlatId(appInfoDTO.getPlatId());
                appInfo.setPlatTitle(appInfoDTO.getPlatTitle());
                appInfo.setAppSecret(appInfoDTO.getAppSecret());
                appInfo.setAppCode(appInfoDTO.getAppCode());
                appInfo.setAppTitle(appInfoDTO.getAppTitle());
                appInfo.setTypeCode(appInfoDTO.getTypeCode());
                appInfo.setTypeTitle(appInfoDTO.getTypeTitle());
                appInfo.setAskUri(appInfoDTO.getAskUri());
                appInfo.setIconIco(appInfoDTO.getIconIco());
                appInfo.setFuncCode(appInfoDTO.getFuncCode());
                appInfo.setFuncTitle(appInfoDTO.getFuncTitle());
                appInfo.setValidDel(appInfoDTO.getValidDel());
                appInfo.setValidFlag(appInfoDTO.getValidFlag());
                appInfo.setRemarks(appInfoDTO.getRemarks());
        return appInfo;
    }


    @Override
    public AppInfoVO toJavaObjectVO(AppInfo appInfo) {
        if (null == appInfo){
            return null;
        }
            AppInfoVO appInfoVO = new AppInfoVO();
                    appInfoVO.setId(appInfo.getId());
                    appInfoVO.setPlatId(appInfo.getPlatId());
                    appInfoVO.setPlatTitle(appInfo.getPlatTitle());
                    appInfoVO.setAppSecret(appInfo.getAppSecret());
                    appInfoVO.setAppCode(appInfo.getAppCode());
                    appInfoVO.setAppTitle(appInfo.getAppTitle());
                    appInfoVO.setTypeCode(appInfo.getTypeCode());
                    appInfoVO.setTypeTitle(appInfo.getTypeTitle());
                    appInfoVO.setAskUri(appInfo.getAskUri());
                    appInfoVO.setIconIco(appInfo.getIconIco());
                    appInfoVO.setFuncCode(appInfo.getFuncCode());
                    appInfoVO.setFuncTitle(appInfo.getFuncTitle());
                    appInfoVO.setValidDel(appInfo.getValidDel());
                    appInfoVO.setValidFlag(appInfo.getValidFlag());
                    appInfoVO.setRemarks(appInfo.getRemarks());
        return appInfoVO;
    }

    public AppInfo toJavaObject(AppInfoVO appInfoVO) {
        if (null == appInfoVO){
            return null;
        }
        AppInfo appInfo = new AppInfo();
                appInfo.setId(appInfoVO.getId());
                appInfo.setPlatId(appInfoVO.getPlatId());
                appInfo.setPlatTitle(appInfoVO.getPlatTitle());
                appInfo.setAppSecret(appInfoVO.getAppSecret());
                appInfo.setAppCode(appInfoVO.getAppCode());
                appInfo.setAppTitle(appInfoVO.getAppTitle());
                appInfo.setTypeCode(appInfoVO.getTypeCode());
                appInfo.setTypeTitle(appInfoVO.getTypeTitle());
                appInfo.setAskUri(appInfoVO.getAskUri());
                appInfo.setIconIco(appInfoVO.getIconIco());
                appInfo.setFuncCode(appInfoVO.getFuncCode());
                appInfo.setFuncTitle(appInfoVO.getFuncTitle());
                appInfo.setValidDel(appInfoVO.getValidDel());
                appInfo.setValidFlag(appInfoVO.getValidFlag());
                appInfo.setRemarks(appInfoVO.getRemarks());
        return appInfo;
    }

    public AppInfoVO toJavaObjectVo(AppInfoDTO appInfoDTO) {
        if (null == appInfoDTO){
            return null;
        }
            AppInfoVO appInfoVO = new AppInfoVO();
                    appInfoVO.setId(appInfoDTO.getId());
                    appInfoVO.setPlatId(appInfoDTO.getPlatId());
                    appInfoVO.setPlatTitle(appInfoDTO.getPlatTitle());
                    appInfoVO.setAppSecret(appInfoDTO.getAppSecret());
                    appInfoVO.setAppCode(appInfoDTO.getAppCode());
                    appInfoVO.setAppTitle(appInfoDTO.getAppTitle());
                    appInfoVO.setTypeCode(appInfoDTO.getTypeCode());
                    appInfoVO.setTypeTitle(appInfoDTO.getTypeTitle());
                    appInfoVO.setAskUri(appInfoDTO.getAskUri());
                    appInfoVO.setIconIco(appInfoDTO.getIconIco());
                    appInfoVO.setFuncCode(appInfoDTO.getFuncCode());
                    appInfoVO.setFuncTitle(appInfoDTO.getFuncTitle());
                    appInfoVO.setValidDel(appInfoDTO.getValidDel());
                    appInfoVO.setValidFlag(appInfoDTO.getValidFlag());
                    appInfoVO.setRemarks(appInfoDTO.getRemarks());
        return appInfoVO;
    }


}