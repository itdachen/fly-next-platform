package com.github.itdachen.oplog.convert;

import com.github.itdachen.oplog.entity.OplogPageView;
import com.github.itdachen.oplog.sdk.dto.OplogPageViewDTO;
import com.github.itdachen.oplog.sdk.vo.OplogPageViewVO;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;

/**
 * 页面访问日志 类型转换
 *
 * @author 王大宸
 * @date 2025-09-09 21:56:31
 */
public class OplogPageViewConvert implements IBizConvertMapper< OplogPageView, OplogPageViewDTO, OplogPageViewVO > {

    @Override
    public OplogPageView toJavaObject(OplogPageViewDTO oplogPageViewDTO) {
        if (null == oplogPageViewDTO){
            return null;
        }
        OplogPageView oplogPageView = new OplogPageView();
                oplogPageView.setId(oplogPageViewDTO.getId());
                oplogPageView.setPlatId(oplogPageViewDTO.getPlatId());
                oplogPageView.setPlatTitle(oplogPageViewDTO.getPlatTitle());
                oplogPageView.setAppId(oplogPageViewDTO.getAppId());
                oplogPageView.setAppTitle(oplogPageViewDTO.getAppTitle());
                oplogPageView.setAppVersion(oplogPageViewDTO.getAppVersion());
                oplogPageView.setTenantId(oplogPageViewDTO.getTenantId());
                oplogPageView.setTenantTitle(oplogPageViewDTO.getTenantTitle());
                oplogPageView.setProvCode(oplogPageViewDTO.getProvCode());
                oplogPageView.setProvName(oplogPageViewDTO.getProvName());
                oplogPageView.setCityCode(oplogPageViewDTO.getCityCode());
                oplogPageView.setCityName(oplogPageViewDTO.getCityName());
                oplogPageView.setCountyCode(oplogPageViewDTO.getCountyCode());
                oplogPageView.setCountyName(oplogPageViewDTO.getCountyName());
                oplogPageView.setTownCode(oplogPageViewDTO.getTownCode());
                oplogPageView.setTownName(oplogPageViewDTO.getTownName());
                oplogPageView.setDeptId(oplogPageViewDTO.getDeptId());
                oplogPageView.setDeptTitle(oplogPageViewDTO.getDeptTitle());
                oplogPageView.setDeptLevel(oplogPageViewDTO.getDeptLevel());
                oplogPageView.setDeptParentId(oplogPageViewDTO.getDeptParentId());
                oplogPageView.setUserId(oplogPageViewDTO.getUserId());
                oplogPageView.setNickName(oplogPageViewDTO.getNickName());
                oplogPageView.setMenuTitle(oplogPageViewDTO.getMenuTitle());
                oplogPageView.setMenuId(oplogPageViewDTO.getMenuId());
                oplogPageView.setOpCode(oplogPageViewDTO.getOpCode());
                oplogPageView.setOpTitle(oplogPageViewDTO.getOpTitle());
                oplogPageView.setOpVersion(oplogPageViewDTO.getOpVersion());
                oplogPageView.setOpTime(oplogPageViewDTO.getOpTime());
                oplogPageView.setHostIp(oplogPageViewDTO.getHostIp());
                oplogPageView.setHostAddress(oplogPageViewDTO.getHostAddress());
                oplogPageView.setHostOs(oplogPageViewDTO.getHostOs());
                oplogPageView.setHostBrowser(oplogPageViewDTO.getHostBrowser());
                oplogPageView.setUserAgent(oplogPageViewDTO.getUserAgent());
                oplogPageView.setRequestId(oplogPageViewDTO.getRequestId());
                oplogPageView.setRequestUri(oplogPageViewDTO.getRequestUri());
                oplogPageView.setRequestMethod(oplogPageViewDTO.getRequestMethod());
                oplogPageView.setExInfo(oplogPageViewDTO.getExInfo());
                oplogPageView.setRemarks(oplogPageViewDTO.getRemarks());
                oplogPageView.setExecuteTime(oplogPageViewDTO.getExecuteTime());
                oplogPageView.setYearly(oplogPageViewDTO.getYearly());
                oplogPageView.setMonthly(oplogPageViewDTO.getMonthly());
        return oplogPageView;
    }


    @Override
    public OplogPageViewVO toJavaObjectVO(OplogPageView oplogPageView) {
        if (null == oplogPageView){
            return null;
        }
            OplogPageViewVO oplogPageViewVO = new OplogPageViewVO();
                    oplogPageViewVO.setId(oplogPageView.getId());
                    oplogPageViewVO.setPlatId(oplogPageView.getPlatId());
                    oplogPageViewVO.setPlatTitle(oplogPageView.getPlatTitle());
                    oplogPageViewVO.setAppId(oplogPageView.getAppId());
                    oplogPageViewVO.setAppTitle(oplogPageView.getAppTitle());
                    oplogPageViewVO.setAppVersion(oplogPageView.getAppVersion());
                    oplogPageViewVO.setTenantId(oplogPageView.getTenantId());
                    oplogPageViewVO.setTenantTitle(oplogPageView.getTenantTitle());
                    oplogPageViewVO.setProvCode(oplogPageView.getProvCode());
                    oplogPageViewVO.setProvName(oplogPageView.getProvName());
                    oplogPageViewVO.setCityCode(oplogPageView.getCityCode());
                    oplogPageViewVO.setCityName(oplogPageView.getCityName());
                    oplogPageViewVO.setCountyCode(oplogPageView.getCountyCode());
                    oplogPageViewVO.setCountyName(oplogPageView.getCountyName());
                    oplogPageViewVO.setTownCode(oplogPageView.getTownCode());
                    oplogPageViewVO.setTownName(oplogPageView.getTownName());
                    oplogPageViewVO.setDeptId(oplogPageView.getDeptId());
                    oplogPageViewVO.setDeptTitle(oplogPageView.getDeptTitle());
                    oplogPageViewVO.setDeptLevel(oplogPageView.getDeptLevel());
                    oplogPageViewVO.setDeptParentId(oplogPageView.getDeptParentId());
                    oplogPageViewVO.setUserId(oplogPageView.getUserId());
                    oplogPageViewVO.setNickName(oplogPageView.getNickName());
                    oplogPageViewVO.setMenuTitle(oplogPageView.getMenuTitle());
                    oplogPageViewVO.setMenuId(oplogPageView.getMenuId());
                    oplogPageViewVO.setOpCode(oplogPageView.getOpCode());
                    oplogPageViewVO.setOpTitle(oplogPageView.getOpTitle());
                    oplogPageViewVO.setOpVersion(oplogPageView.getOpVersion());
                    oplogPageViewVO.setOpTime(oplogPageView.getOpTime());
                    oplogPageViewVO.setHostIp(oplogPageView.getHostIp());
                    oplogPageViewVO.setHostAddress(oplogPageView.getHostAddress());
                    oplogPageViewVO.setHostOs(oplogPageView.getHostOs());
                    oplogPageViewVO.setHostBrowser(oplogPageView.getHostBrowser());
                    oplogPageViewVO.setUserAgent(oplogPageView.getUserAgent());
                    oplogPageViewVO.setRequestId(oplogPageView.getRequestId());
                    oplogPageViewVO.setRequestUri(oplogPageView.getRequestUri());
                    oplogPageViewVO.setRequestMethod(oplogPageView.getRequestMethod());
                    oplogPageViewVO.setExInfo(oplogPageView.getExInfo());
                    oplogPageViewVO.setRemarks(oplogPageView.getRemarks());
                    oplogPageViewVO.setExecuteTime(oplogPageView.getExecuteTime());
                    oplogPageViewVO.setYearly(oplogPageView.getYearly());
                    oplogPageViewVO.setMonthly(oplogPageView.getMonthly());
        return oplogPageViewVO;
    }

    public OplogPageView toJavaObject(OplogPageViewVO oplogPageViewVO) {
        if (null == oplogPageViewVO){
            return null;
        }
        OplogPageView oplogPageView = new OplogPageView();
                oplogPageView.setId(oplogPageViewVO.getId());
                oplogPageView.setPlatId(oplogPageViewVO.getPlatId());
                oplogPageView.setPlatTitle(oplogPageViewVO.getPlatTitle());
                oplogPageView.setAppId(oplogPageViewVO.getAppId());
                oplogPageView.setAppTitle(oplogPageViewVO.getAppTitle());
                oplogPageView.setAppVersion(oplogPageViewVO.getAppVersion());
                oplogPageView.setTenantId(oplogPageViewVO.getTenantId());
                oplogPageView.setTenantTitle(oplogPageViewVO.getTenantTitle());
                oplogPageView.setProvCode(oplogPageViewVO.getProvCode());
                oplogPageView.setProvName(oplogPageViewVO.getProvName());
                oplogPageView.setCityCode(oplogPageViewVO.getCityCode());
                oplogPageView.setCityName(oplogPageViewVO.getCityName());
                oplogPageView.setCountyCode(oplogPageViewVO.getCountyCode());
                oplogPageView.setCountyName(oplogPageViewVO.getCountyName());
                oplogPageView.setTownCode(oplogPageViewVO.getTownCode());
                oplogPageView.setTownName(oplogPageViewVO.getTownName());
                oplogPageView.setDeptId(oplogPageViewVO.getDeptId());
                oplogPageView.setDeptTitle(oplogPageViewVO.getDeptTitle());
                oplogPageView.setDeptLevel(oplogPageViewVO.getDeptLevel());
                oplogPageView.setDeptParentId(oplogPageViewVO.getDeptParentId());
                oplogPageView.setUserId(oplogPageViewVO.getUserId());
                oplogPageView.setNickName(oplogPageViewVO.getNickName());
                oplogPageView.setMenuTitle(oplogPageViewVO.getMenuTitle());
                oplogPageView.setMenuId(oplogPageViewVO.getMenuId());
                oplogPageView.setOpCode(oplogPageViewVO.getOpCode());
                oplogPageView.setOpTitle(oplogPageViewVO.getOpTitle());
                oplogPageView.setOpVersion(oplogPageViewVO.getOpVersion());
                oplogPageView.setOpTime(oplogPageViewVO.getOpTime());
                oplogPageView.setHostIp(oplogPageViewVO.getHostIp());
                oplogPageView.setHostAddress(oplogPageViewVO.getHostAddress());
                oplogPageView.setHostOs(oplogPageViewVO.getHostOs());
                oplogPageView.setHostBrowser(oplogPageViewVO.getHostBrowser());
                oplogPageView.setUserAgent(oplogPageViewVO.getUserAgent());
                oplogPageView.setRequestId(oplogPageViewVO.getRequestId());
                oplogPageView.setRequestUri(oplogPageViewVO.getRequestUri());
                oplogPageView.setRequestMethod(oplogPageViewVO.getRequestMethod());
                oplogPageView.setExInfo(oplogPageViewVO.getExInfo());
                oplogPageView.setRemarks(oplogPageViewVO.getRemarks());
                oplogPageView.setExecuteTime(oplogPageViewVO.getExecuteTime());
                oplogPageView.setYearly(oplogPageViewVO.getYearly());
                oplogPageView.setMonthly(oplogPageViewVO.getMonthly());
        return oplogPageView;
    }

    public OplogPageViewVO toJavaObjectVO(OplogPageViewDTO oplogPageViewDTO) {
        if (null == oplogPageViewDTO){
            return null;
        }
            OplogPageViewVO oplogPageViewVO = new OplogPageViewVO();
                    oplogPageViewVO.setId(oplogPageViewDTO.getId());
                    oplogPageViewVO.setPlatId(oplogPageViewDTO.getPlatId());
                    oplogPageViewVO.setPlatTitle(oplogPageViewDTO.getPlatTitle());
                    oplogPageViewVO.setAppId(oplogPageViewDTO.getAppId());
                    oplogPageViewVO.setAppTitle(oplogPageViewDTO.getAppTitle());
                    oplogPageViewVO.setAppVersion(oplogPageViewDTO.getAppVersion());
                    oplogPageViewVO.setTenantId(oplogPageViewDTO.getTenantId());
                    oplogPageViewVO.setTenantTitle(oplogPageViewDTO.getTenantTitle());
                    oplogPageViewVO.setProvCode(oplogPageViewDTO.getProvCode());
                    oplogPageViewVO.setProvName(oplogPageViewDTO.getProvName());
                    oplogPageViewVO.setCityCode(oplogPageViewDTO.getCityCode());
                    oplogPageViewVO.setCityName(oplogPageViewDTO.getCityName());
                    oplogPageViewVO.setCountyCode(oplogPageViewDTO.getCountyCode());
                    oplogPageViewVO.setCountyName(oplogPageViewDTO.getCountyName());
                    oplogPageViewVO.setTownCode(oplogPageViewDTO.getTownCode());
                    oplogPageViewVO.setTownName(oplogPageViewDTO.getTownName());
                    oplogPageViewVO.setDeptId(oplogPageViewDTO.getDeptId());
                    oplogPageViewVO.setDeptTitle(oplogPageViewDTO.getDeptTitle());
                    oplogPageViewVO.setDeptLevel(oplogPageViewDTO.getDeptLevel());
                    oplogPageViewVO.setDeptParentId(oplogPageViewDTO.getDeptParentId());
                    oplogPageViewVO.setUserId(oplogPageViewDTO.getUserId());
                    oplogPageViewVO.setNickName(oplogPageViewDTO.getNickName());
                    oplogPageViewVO.setMenuTitle(oplogPageViewDTO.getMenuTitle());
                    oplogPageViewVO.setMenuId(oplogPageViewDTO.getMenuId());
                    oplogPageViewVO.setOpCode(oplogPageViewDTO.getOpCode());
                    oplogPageViewVO.setOpTitle(oplogPageViewDTO.getOpTitle());
                    oplogPageViewVO.setOpVersion(oplogPageViewDTO.getOpVersion());
                    oplogPageViewVO.setOpTime(oplogPageViewDTO.getOpTime());
                    oplogPageViewVO.setHostIp(oplogPageViewDTO.getHostIp());
                    oplogPageViewVO.setHostAddress(oplogPageViewDTO.getHostAddress());
                    oplogPageViewVO.setHostOs(oplogPageViewDTO.getHostOs());
                    oplogPageViewVO.setHostBrowser(oplogPageViewDTO.getHostBrowser());
                    oplogPageViewVO.setUserAgent(oplogPageViewDTO.getUserAgent());
                    oplogPageViewVO.setRequestId(oplogPageViewDTO.getRequestId());
                    oplogPageViewVO.setRequestUri(oplogPageViewDTO.getRequestUri());
                    oplogPageViewVO.setRequestMethod(oplogPageViewDTO.getRequestMethod());
                    oplogPageViewVO.setExInfo(oplogPageViewDTO.getExInfo());
                    oplogPageViewVO.setRemarks(oplogPageViewDTO.getRemarks());
                    oplogPageViewVO.setExecuteTime(oplogPageViewDTO.getExecuteTime());
                    oplogPageViewVO.setYearly(oplogPageViewDTO.getYearly());
                    oplogPageViewVO.setMonthly(oplogPageViewDTO.getMonthly());
        return oplogPageViewVO;
    }


}