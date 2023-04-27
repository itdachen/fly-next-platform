package com.github.itdachen.admin.convert;

import com.github.itdachen.admin.entity.MakeUseLog;
import com.github.itdachen.admin.sdk.dto.MakeUseLogDto;
import com.github.itdachen.admin.sdk.vo.MakeUseLogVo;
import com.github.itdachen.framework.webmvc.convert.BizConvert;

/**
 * Description:
 * Created by 王大宸 on 2023/04/27 20:24
 * Created with IntelliJ IDEA.
 */
public class MakeUseLogConvert extends BizConvert<MakeUseLog, MakeUseLogDto, MakeUseLogVo> {

    @Override
    public MakeUseLog toJavaObject(MakeUseLogDto makeUseLogDto) {
        if (null == makeUseLogDto){
            return null;
        }
        MakeUseLog makeUseLog = new MakeUseLog();
        makeUseLog.setId(makeUseLogDto.getId());
        makeUseLog.setTenantId(makeUseLogDto.getTenantId());
        makeUseLog.setServiceId(makeUseLogDto.getServiceId());
        makeUseLog.setClientId(makeUseLogDto.getClientId());
        makeUseLog.setRequestId(makeUseLogDto.getRequestId());
        makeUseLog.setMenuTitle(makeUseLogDto.getMenuTitle());
        makeUseLog.setMakeUseType(makeUseLogDto.getMakeUseType());
        makeUseLog.setLogType(makeUseLogDto.getLogType());
        makeUseLog.setMakeUseIp(makeUseLogDto.getMakeUseIp());
        makeUseLog.setMakeUseAddress(makeUseLogDto.getMakeUseAddress());
        makeUseLog.setMakeUseStatus(makeUseLogDto.getMakeUseStatus());
        makeUseLog.setUserAgent(makeUseLogDto.getUserAgent());
        makeUseLog.setRequestUri(makeUseLogDto.getRequestUri());
        makeUseLog.setRequestMethod(makeUseLogDto.getRequestMethod());
        makeUseLog.setParams(makeUseLogDto.getParams());
        makeUseLog.setJsonResult(makeUseLogDto.getJsonResult());
        makeUseLog.setDelFlag(makeUseLogDto.getDelFlag());
        makeUseLog.setException(makeUseLogDto.getException());
        makeUseLog.setRemarks(makeUseLogDto.getRemarks());
        makeUseLog.setExecuteTime(makeUseLogDto.getExecuteTime());
        makeUseLog.setMsg(makeUseLogDto.getMsg());
        return makeUseLog;
    }


    @Override
    public MakeUseLogVo toJavaObjectVo(MakeUseLog makeUseLog) {
        if (null == makeUseLog){
            return null;
        }
        MakeUseLogVo makeUseLogVo = new MakeUseLogVo();
        makeUseLogVo.setId(makeUseLog.getId());
        makeUseLogVo.setTenantId(makeUseLog.getTenantId());
        makeUseLogVo.setServiceId(makeUseLog.getServiceId());
        makeUseLogVo.setClientId(makeUseLog.getClientId());
        makeUseLogVo.setRequestId(makeUseLog.getRequestId());
        makeUseLogVo.setMenuTitle(makeUseLog.getMenuTitle());
        makeUseLogVo.setMakeUseType(makeUseLog.getMakeUseType());
        makeUseLogVo.setLogType(makeUseLog.getLogType());
        makeUseLogVo.setMakeUseIp(makeUseLog.getMakeUseIp());
        makeUseLogVo.setMakeUseAddress(makeUseLog.getMakeUseAddress());
        makeUseLogVo.setMakeUseStatus(makeUseLog.getMakeUseStatus());
        makeUseLogVo.setUserAgent(makeUseLog.getUserAgent());
        makeUseLogVo.setRequestUri(makeUseLog.getRequestUri());
        makeUseLogVo.setRequestMethod(makeUseLog.getRequestMethod());
        makeUseLogVo.setParams(makeUseLog.getParams());
        makeUseLogVo.setJsonResult(makeUseLog.getJsonResult());
        makeUseLogVo.setDelFlag(makeUseLog.getDelFlag());
        makeUseLogVo.setException(makeUseLog.getException());
        makeUseLogVo.setRemarks(makeUseLog.getRemarks());
        makeUseLogVo.setExecuteTime(makeUseLog.getExecuteTime());
        makeUseLogVo.setMsg(makeUseLog.getMsg());
        return makeUseLogVo;
    }

    public static MakeUseLog toJavaObject(MakeUseLogVo makeUseLogVo) {
        if (null == makeUseLogVo){
            return null;
        }
        MakeUseLog makeUseLog = new MakeUseLog();
        makeUseLog.setId(makeUseLogVo.getId());
        makeUseLog.setTenantId(makeUseLogVo.getTenantId());
        makeUseLog.setServiceId(makeUseLogVo.getServiceId());
        makeUseLog.setClientId(makeUseLogVo.getClientId());
        makeUseLog.setRequestId(makeUseLogVo.getRequestId());
        makeUseLog.setMenuTitle(makeUseLogVo.getMenuTitle());
        makeUseLog.setMakeUseType(makeUseLogVo.getMakeUseType());
        makeUseLog.setLogType(makeUseLogVo.getLogType());
        makeUseLog.setMakeUseIp(makeUseLogVo.getMakeUseIp());
        makeUseLog.setMakeUseAddress(makeUseLogVo.getMakeUseAddress());
        makeUseLog.setMakeUseStatus(makeUseLogVo.getMakeUseStatus());
        makeUseLog.setUserAgent(makeUseLogVo.getUserAgent());
        makeUseLog.setRequestUri(makeUseLogVo.getRequestUri());
        makeUseLog.setRequestMethod(makeUseLogVo.getRequestMethod());
        makeUseLog.setParams(makeUseLogVo.getParams());
        makeUseLog.setJsonResult(makeUseLogVo.getJsonResult());
        makeUseLog.setDelFlag(makeUseLogVo.getDelFlag());
        makeUseLog.setException(makeUseLogVo.getException());
        makeUseLog.setRemarks(makeUseLogVo.getRemarks());
        makeUseLog.setExecuteTime(makeUseLogVo.getExecuteTime());
        makeUseLog.setMsg(makeUseLogVo.getMsg());
        return makeUseLog;
    }

    public static MakeUseLogVo toJavaObjectVo(MakeUseLogDto makeUseLogDto) {
        if (null == makeUseLogDto){
            return null;
        }
        MakeUseLogVo makeUseLogVo = new MakeUseLogVo();
        makeUseLogVo.setId(makeUseLogDto.getId());
        makeUseLogVo.setTenantId(makeUseLogDto.getTenantId());
        makeUseLogVo.setServiceId(makeUseLogDto.getServiceId());
        makeUseLogVo.setClientId(makeUseLogDto.getClientId());
        makeUseLogVo.setRequestId(makeUseLogDto.getRequestId());
        makeUseLogVo.setMenuTitle(makeUseLogDto.getMenuTitle());
        makeUseLogVo.setMakeUseType(makeUseLogDto.getMakeUseType());
        makeUseLogVo.setLogType(makeUseLogDto.getLogType());
        makeUseLogVo.setMakeUseIp(makeUseLogDto.getMakeUseIp());
        makeUseLogVo.setMakeUseAddress(makeUseLogDto.getMakeUseAddress());
        makeUseLogVo.setMakeUseStatus(makeUseLogDto.getMakeUseStatus());
        makeUseLogVo.setUserAgent(makeUseLogDto.getUserAgent());
        makeUseLogVo.setRequestUri(makeUseLogDto.getRequestUri());
        makeUseLogVo.setRequestMethod(makeUseLogDto.getRequestMethod());
        makeUseLogVo.setParams(makeUseLogDto.getParams());
        makeUseLogVo.setJsonResult(makeUseLogDto.getJsonResult());
        makeUseLogVo.setDelFlag(makeUseLogDto.getDelFlag());
        makeUseLogVo.setException(makeUseLogDto.getException());
        makeUseLogVo.setRemarks(makeUseLogDto.getRemarks());
        makeUseLogVo.setExecuteTime(makeUseLogDto.getExecuteTime());
        makeUseLogVo.setMsg(makeUseLogDto.getMsg());
        return makeUseLogVo;
    }

}
