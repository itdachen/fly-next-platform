package com.github.itdachen.oplog.convert;

import com.github.itdachen.oplog.entity.OplogInfo;
import com.github.itdachen.oplog.sdk.dto.OplogInfoDTO;
import com.github.itdachen.oplog.sdk.vo.OplogInfoVO;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;

/**
 * 操作日志 类型转换
 *
 * @author 王大宸
 * @date 2025-09-09 17:52:15
 */
public class OplogInfoConvert implements IBizConvertMapper< OplogInfo, OplogInfoDTO, OplogInfoVO > {

    @Override
    public OplogInfo toJavaObject(OplogInfoDTO oplogInfoDTO) {
        if (null == oplogInfoDTO){
            return null;
        }
        OplogInfo oplogInfo = new OplogInfo();
                oplogInfo.setId(oplogInfoDTO.getId());
                oplogInfo.setPlatId(oplogInfoDTO.getPlatId());
                oplogInfo.setPlatTitle(oplogInfoDTO.getPlatTitle());
                oplogInfo.setAppId(oplogInfoDTO.getAppId());
                oplogInfo.setAppTitle(oplogInfoDTO.getAppTitle());
                oplogInfo.setAppVersion(oplogInfoDTO.getAppVersion());
                oplogInfo.setTenantId(oplogInfoDTO.getTenantId());
                oplogInfo.setTenantTitle(oplogInfoDTO.getTenantTitle());
                oplogInfo.setProvCode(oplogInfoDTO.getProvCode());
                oplogInfo.setProvName(oplogInfoDTO.getProvName());
                oplogInfo.setCityCode(oplogInfoDTO.getCityCode());
                oplogInfo.setCityName(oplogInfoDTO.getCityName());
                oplogInfo.setCountyCode(oplogInfoDTO.getCountyCode());
                oplogInfo.setCountyName(oplogInfoDTO.getCountyName());
                oplogInfo.setTownCode(oplogInfoDTO.getTownCode());
                oplogInfo.setTownName(oplogInfoDTO.getTownName());
                oplogInfo.setDeptId(oplogInfoDTO.getDeptId());
                oplogInfo.setDeptTitle(oplogInfoDTO.getDeptTitle());
                oplogInfo.setDeptLevel(oplogInfoDTO.getDeptLevel());
                oplogInfo.setDeptParentId(oplogInfoDTO.getDeptParentId());
                oplogInfo.setUserId(oplogInfoDTO.getUserId());
                oplogInfo.setNickName(oplogInfoDTO.getNickName());
                oplogInfo.setMenuTitle(oplogInfoDTO.getMenuTitle());
                oplogInfo.setOpCode(oplogInfoDTO.getOpCode());
                oplogInfo.setOpTitle(oplogInfoDTO.getOpTitle());
                oplogInfo.setOpVersion(oplogInfoDTO.getOpVersion());
                oplogInfo.setOpTime(oplogInfoDTO.getOpTime());
                oplogInfo.setHostIp(oplogInfoDTO.getHostIp());
                oplogInfo.setHostAddress(oplogInfoDTO.getHostAddress());
                oplogInfo.setHostOs(oplogInfoDTO.getHostOs());
                oplogInfo.setHostBrowser(oplogInfoDTO.getHostBrowser());
                oplogInfo.setUserAgent(oplogInfoDTO.getUserAgent());
                oplogInfo.setRequestId(oplogInfoDTO.getRequestId());
                oplogInfo.setRequestUri(oplogInfoDTO.getRequestUri());
                oplogInfo.setRequestMethod(oplogInfoDTO.getRequestMethod());
                oplogInfo.setRequestParams(oplogInfoDTO.getRequestParams());
                oplogInfo.setResponseJson(oplogInfoDTO.getResponseJson());
                oplogInfo.setResponseCode(oplogInfoDTO.getResponseCode());
                oplogInfo.setResponseStatus(oplogInfoDTO.getResponseStatus());
                oplogInfo.setResponseMsg(oplogInfoDTO.getResponseMsg());
                oplogInfo.setExInfo(oplogInfoDTO.getExInfo());
                oplogInfo.setRemarks(oplogInfoDTO.getRemarks());
                oplogInfo.setExecuteTime(oplogInfoDTO.getExecuteTime());
                oplogInfo.setYearly(oplogInfoDTO.getYearly());
                oplogInfo.setMonthly(oplogInfoDTO.getMonthly());
        return oplogInfo;
    }


    @Override
    public OplogInfoVO toJavaObjectVO(OplogInfo oplogInfo) {
        if (null == oplogInfo){
            return null;
        }
            OplogInfoVO oplogInfoVO = new OplogInfoVO();
                    oplogInfoVO.setId(oplogInfo.getId());
                    oplogInfoVO.setPlatId(oplogInfo.getPlatId());
                    oplogInfoVO.setPlatTitle(oplogInfo.getPlatTitle());
                    oplogInfoVO.setAppId(oplogInfo.getAppId());
                    oplogInfoVO.setAppTitle(oplogInfo.getAppTitle());
                    oplogInfoVO.setAppVersion(oplogInfo.getAppVersion());
                    oplogInfoVO.setTenantId(oplogInfo.getTenantId());
                    oplogInfoVO.setTenantTitle(oplogInfo.getTenantTitle());
                    oplogInfoVO.setProvCode(oplogInfo.getProvCode());
                    oplogInfoVO.setProvName(oplogInfo.getProvName());
                    oplogInfoVO.setCityCode(oplogInfo.getCityCode());
                    oplogInfoVO.setCityName(oplogInfo.getCityName());
                    oplogInfoVO.setCountyCode(oplogInfo.getCountyCode());
                    oplogInfoVO.setCountyName(oplogInfo.getCountyName());
                    oplogInfoVO.setTownCode(oplogInfo.getTownCode());
                    oplogInfoVO.setTownName(oplogInfo.getTownName());
                    oplogInfoVO.setDeptId(oplogInfo.getDeptId());
                    oplogInfoVO.setDeptTitle(oplogInfo.getDeptTitle());
                    oplogInfoVO.setDeptLevel(oplogInfo.getDeptLevel());
                    oplogInfoVO.setDeptParentId(oplogInfo.getDeptParentId());
                    oplogInfoVO.setUserId(oplogInfo.getUserId());
                    oplogInfoVO.setNickName(oplogInfo.getNickName());
                    oplogInfoVO.setMenuTitle(oplogInfo.getMenuTitle());
                    oplogInfoVO.setOpCode(oplogInfo.getOpCode());
                    oplogInfoVO.setOpTitle(oplogInfo.getOpTitle());
                    oplogInfoVO.setOpVersion(oplogInfo.getOpVersion());
                    oplogInfoVO.setOpTime(oplogInfo.getOpTime());
                    oplogInfoVO.setHostIp(oplogInfo.getHostIp());
                    oplogInfoVO.setHostAddress(oplogInfo.getHostAddress());
                    oplogInfoVO.setHostOs(oplogInfo.getHostOs());
                    oplogInfoVO.setHostBrowser(oplogInfo.getHostBrowser());
                    oplogInfoVO.setUserAgent(oplogInfo.getUserAgent());
                    oplogInfoVO.setRequestId(oplogInfo.getRequestId());
                    oplogInfoVO.setRequestUri(oplogInfo.getRequestUri());
                    oplogInfoVO.setRequestMethod(oplogInfo.getRequestMethod());
                    oplogInfoVO.setRequestParams(oplogInfo.getRequestParams());
                    oplogInfoVO.setResponseJson(oplogInfo.getResponseJson());
                    oplogInfoVO.setResponseCode(oplogInfo.getResponseCode());
                    oplogInfoVO.setResponseStatus(oplogInfo.getResponseStatus());
                    oplogInfoVO.setResponseMsg(oplogInfo.getResponseMsg());
                    oplogInfoVO.setExInfo(oplogInfo.getExInfo());
                    oplogInfoVO.setRemarks(oplogInfo.getRemarks());
                    oplogInfoVO.setExecuteTime(oplogInfo.getExecuteTime());
                    oplogInfoVO.setYearly(oplogInfo.getYearly());
                    oplogInfoVO.setMonthly(oplogInfo.getMonthly());
        return oplogInfoVO;
    }

    public OplogInfo toJavaObject(OplogInfoVO oplogInfoVO) {
        if (null == oplogInfoVO){
            return null;
        }
        OplogInfo oplogInfo = new OplogInfo();
                oplogInfo.setId(oplogInfoVO.getId());
                oplogInfo.setPlatId(oplogInfoVO.getPlatId());
                oplogInfo.setPlatTitle(oplogInfoVO.getPlatTitle());
                oplogInfo.setAppId(oplogInfoVO.getAppId());
                oplogInfo.setAppTitle(oplogInfoVO.getAppTitle());
                oplogInfo.setAppVersion(oplogInfoVO.getAppVersion());
                oplogInfo.setTenantId(oplogInfoVO.getTenantId());
                oplogInfo.setTenantTitle(oplogInfoVO.getTenantTitle());
                oplogInfo.setProvCode(oplogInfoVO.getProvCode());
                oplogInfo.setProvName(oplogInfoVO.getProvName());
                oplogInfo.setCityCode(oplogInfoVO.getCityCode());
                oplogInfo.setCityName(oplogInfoVO.getCityName());
                oplogInfo.setCountyCode(oplogInfoVO.getCountyCode());
                oplogInfo.setCountyName(oplogInfoVO.getCountyName());
                oplogInfo.setTownCode(oplogInfoVO.getTownCode());
                oplogInfo.setTownName(oplogInfoVO.getTownName());
                oplogInfo.setDeptId(oplogInfoVO.getDeptId());
                oplogInfo.setDeptTitle(oplogInfoVO.getDeptTitle());
                oplogInfo.setDeptLevel(oplogInfoVO.getDeptLevel());
                oplogInfo.setDeptParentId(oplogInfoVO.getDeptParentId());
                oplogInfo.setUserId(oplogInfoVO.getUserId());
                oplogInfo.setNickName(oplogInfoVO.getNickName());
                oplogInfo.setMenuTitle(oplogInfoVO.getMenuTitle());
                oplogInfo.setOpCode(oplogInfoVO.getOpCode());
                oplogInfo.setOpTitle(oplogInfoVO.getOpTitle());
                oplogInfo.setOpVersion(oplogInfoVO.getOpVersion());
                oplogInfo.setOpTime(oplogInfoVO.getOpTime());
                oplogInfo.setHostIp(oplogInfoVO.getHostIp());
                oplogInfo.setHostAddress(oplogInfoVO.getHostAddress());
                oplogInfo.setHostOs(oplogInfoVO.getHostOs());
                oplogInfo.setHostBrowser(oplogInfoVO.getHostBrowser());
                oplogInfo.setUserAgent(oplogInfoVO.getUserAgent());
                oplogInfo.setRequestId(oplogInfoVO.getRequestId());
                oplogInfo.setRequestUri(oplogInfoVO.getRequestUri());
                oplogInfo.setRequestMethod(oplogInfoVO.getRequestMethod());
                oplogInfo.setRequestParams(oplogInfoVO.getRequestParams());
                oplogInfo.setResponseJson(oplogInfoVO.getResponseJson());
                oplogInfo.setResponseCode(oplogInfoVO.getResponseCode());
                oplogInfo.setResponseStatus(oplogInfoVO.getResponseStatus());
                oplogInfo.setResponseMsg(oplogInfoVO.getResponseMsg());
                oplogInfo.setExInfo(oplogInfoVO.getExInfo());
                oplogInfo.setRemarks(oplogInfoVO.getRemarks());
                oplogInfo.setExecuteTime(oplogInfoVO.getExecuteTime());
                oplogInfo.setYearly(oplogInfoVO.getYearly());
                oplogInfo.setMonthly(oplogInfoVO.getMonthly());
        return oplogInfo;
    }

    public OplogInfoVO toJavaObjectVO(OplogInfoDTO oplogInfoDTO) {
        if (null == oplogInfoDTO){
            return null;
        }
            OplogInfoVO oplogInfoVO = new OplogInfoVO();
                    oplogInfoVO.setId(oplogInfoDTO.getId());
                    oplogInfoVO.setPlatId(oplogInfoDTO.getPlatId());
                    oplogInfoVO.setPlatTitle(oplogInfoDTO.getPlatTitle());
                    oplogInfoVO.setAppId(oplogInfoDTO.getAppId());
                    oplogInfoVO.setAppTitle(oplogInfoDTO.getAppTitle());
                    oplogInfoVO.setAppVersion(oplogInfoDTO.getAppVersion());
                    oplogInfoVO.setTenantId(oplogInfoDTO.getTenantId());
                    oplogInfoVO.setTenantTitle(oplogInfoDTO.getTenantTitle());
                    oplogInfoVO.setProvCode(oplogInfoDTO.getProvCode());
                    oplogInfoVO.setProvName(oplogInfoDTO.getProvName());
                    oplogInfoVO.setCityCode(oplogInfoDTO.getCityCode());
                    oplogInfoVO.setCityName(oplogInfoDTO.getCityName());
                    oplogInfoVO.setCountyCode(oplogInfoDTO.getCountyCode());
                    oplogInfoVO.setCountyName(oplogInfoDTO.getCountyName());
                    oplogInfoVO.setTownCode(oplogInfoDTO.getTownCode());
                    oplogInfoVO.setTownName(oplogInfoDTO.getTownName());
                    oplogInfoVO.setDeptId(oplogInfoDTO.getDeptId());
                    oplogInfoVO.setDeptTitle(oplogInfoDTO.getDeptTitle());
                    oplogInfoVO.setDeptLevel(oplogInfoDTO.getDeptLevel());
                    oplogInfoVO.setDeptParentId(oplogInfoDTO.getDeptParentId());
                    oplogInfoVO.setUserId(oplogInfoDTO.getUserId());
                    oplogInfoVO.setNickName(oplogInfoDTO.getNickName());
                    oplogInfoVO.setMenuTitle(oplogInfoDTO.getMenuTitle());
                    oplogInfoVO.setOpCode(oplogInfoDTO.getOpCode());
                    oplogInfoVO.setOpTitle(oplogInfoDTO.getOpTitle());
                    oplogInfoVO.setOpVersion(oplogInfoDTO.getOpVersion());
                    oplogInfoVO.setOpTime(oplogInfoDTO.getOpTime());
                    oplogInfoVO.setHostIp(oplogInfoDTO.getHostIp());
                    oplogInfoVO.setHostAddress(oplogInfoDTO.getHostAddress());
                    oplogInfoVO.setHostOs(oplogInfoDTO.getHostOs());
                    oplogInfoVO.setHostBrowser(oplogInfoDTO.getHostBrowser());
                    oplogInfoVO.setUserAgent(oplogInfoDTO.getUserAgent());
                    oplogInfoVO.setRequestId(oplogInfoDTO.getRequestId());
                    oplogInfoVO.setRequestUri(oplogInfoDTO.getRequestUri());
                    oplogInfoVO.setRequestMethod(oplogInfoDTO.getRequestMethod());
                    oplogInfoVO.setRequestParams(oplogInfoDTO.getRequestParams());
                    oplogInfoVO.setResponseJson(oplogInfoDTO.getResponseJson());
                    oplogInfoVO.setResponseCode(oplogInfoDTO.getResponseCode());
                    oplogInfoVO.setResponseStatus(oplogInfoDTO.getResponseStatus());
                    oplogInfoVO.setResponseMsg(oplogInfoDTO.getResponseMsg());
                    oplogInfoVO.setExInfo(oplogInfoDTO.getExInfo());
                    oplogInfoVO.setRemarks(oplogInfoDTO.getRemarks());
                    oplogInfoVO.setExecuteTime(oplogInfoDTO.getExecuteTime());
                    oplogInfoVO.setYearly(oplogInfoDTO.getYearly());
                    oplogInfoVO.setMonthly(oplogInfoDTO.getMonthly());
        return oplogInfoVO;
    }


}