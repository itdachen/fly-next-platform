package com.github.itdachen.admin.convert.impl;

import com.github.itdachen.admin.convert.IAppClientConvert;
import com.github.itdachen.admin.entity.AppClient;
import com.github.itdachen.admin.sdk.dto.AppClientDto;
import com.github.itdachen.admin.sdk.vo.AppClientVo;
import org.springframework.stereotype.Component;

/**
 * Description:
 * Created by 王大宸 on 2023/04/27 20:04
 * Created with IntelliJ IDEA.
 */
@Component
public class AppClientConvert implements IAppClientConvert {

    @Override
    public AppClient toJavaObject(AppClientDto appClientDto) {
        if (null == appClientDto){
            return null;
        }
        AppClient appClient = new AppClient();
        appClient.setId(appClientDto.getId());
        appClient.setAppCode(appClientDto.getAppCode());
        appClient.setAppType(appClientDto.getAppType());
        appClient.setAppTitle(appClientDto.getAppTitle());
        appClient.setAskUri(appClientDto.getAskUri());
        appClient.setLanUri(appClientDto.getLanUri());
        appClient.setIcon(appClientDto.getIcon());
        appClient.setStatus(appClientDto.getStatus());
        appClient.setRemarks(appClientDto.getRemarks());
        appClient.setCanDel(appClientDto.getCanDel());
        return appClient;
    }


    @Override
    public AppClientVo toJavaObjectVo(AppClient appClient) {
        if (null == appClient){
            return null;
        }
        AppClientVo appClientVo = new AppClientVo();
        appClientVo.setId(appClient.getId());
        appClientVo.setAppCode(appClient.getAppCode());
        appClientVo.setAppType(appClient.getAppType());
        appClientVo.setAppTitle(appClient.getAppTitle());
        appClientVo.setAskUri(appClient.getAskUri());
        appClientVo.setLanUri(appClient.getLanUri());
        appClientVo.setIcon(appClient.getIcon());
        appClientVo.setStatus(appClient.getStatus());
        appClientVo.setRemarks(appClient.getRemarks());
        appClientVo.setCanDel(appClient.getCanDel());
        return appClientVo;
    }

    @Override
    public AppClient toJavaObject(AppClientVo appClientVo) {
        if (null == appClientVo){
            return null;
        }
        AppClient appClient = new AppClient();
        appClient.setId(appClientVo.getId());
        appClient.setAppCode(appClientVo.getAppCode());
        appClient.setAppType(appClientVo.getAppType());
        appClient.setAppTitle(appClientVo.getAppTitle());
        appClient.setAskUri(appClientVo.getAskUri());
        appClient.setLanUri(appClientVo.getLanUri());
        appClient.setIcon(appClientVo.getIcon());
        appClient.setStatus(appClientVo.getStatus());
        appClient.setRemarks(appClientVo.getRemarks());
        appClient.setCanDel(appClientVo.getCanDel());
        return appClient;
    }

    @Override
    public AppClientVo toJavaObjectVo(AppClientDto appClientDto) {
        if (null == appClientDto){
            return null;
        }
        AppClientVo appClientVo = new AppClientVo();
        appClientVo.setId(appClientDto.getId());
        appClientVo.setAppCode(appClientDto.getAppCode());
        appClientVo.setAppType(appClientDto.getAppType());
        appClientVo.setAppTitle(appClientDto.getAppTitle());
        appClientVo.setAskUri(appClientDto.getAskUri());
        appClientVo.setLanUri(appClientDto.getLanUri());
        appClientVo.setIcon(appClientDto.getIcon());
        appClientVo.setStatus(appClientDto.getStatus());
        appClientVo.setRemarks(appClientDto.getRemarks());
        appClientVo.setCanDel(appClientDto.getCanDel());
        return appClientVo;
    }


}
