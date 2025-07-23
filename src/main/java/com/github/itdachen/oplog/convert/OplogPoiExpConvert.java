package com.github.itdachen.oplog.convert;

import com.github.itdachen.oplog.entity.OplogPoiExp;
import com.github.itdachen.oplog.sdk.dto.OplogPoiExpDTO;
import com.github.itdachen.oplog.sdk.vo.OplogPoiExpVO;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;

/**
 * 导出日志 类型转换
 *
 * @author 王大宸
 * @date 2025-07-23 23:06:08
 */
public class OplogPoiExpConvert implements IBizConvertMapper< OplogPoiExp, OplogPoiExpDTO, OplogPoiExpVO > {

    @Override
    public OplogPoiExp toJavaObject(OplogPoiExpDTO oplogPoiExpDTO) {
        if (null == oplogPoiExpDTO){
            return null;
        }
        OplogPoiExp oplogPoiExp = new OplogPoiExp();
                oplogPoiExp.setId(oplogPoiExpDTO.getId());
                oplogPoiExp.setTenantId(oplogPoiExpDTO.getTenantId());
                oplogPoiExp.setTenantTitle(oplogPoiExpDTO.getTenantTitle());
                oplogPoiExp.setPlatId(oplogPoiExpDTO.getPlatId());
                oplogPoiExp.setPlatTitle(oplogPoiExpDTO.getPlatTitle());
                oplogPoiExp.setAppId(oplogPoiExpDTO.getAppId());
                oplogPoiExp.setAppTitle(oplogPoiExpDTO.getAppTitle());
                oplogPoiExp.setAppVersion(oplogPoiExpDTO.getAppVersion());
                oplogPoiExp.setUserId(oplogPoiExpDTO.getUserId());
                oplogPoiExp.setNickName(oplogPoiExpDTO.getNickName());
                oplogPoiExp.setRoleId(oplogPoiExpDTO.getRoleId());
                oplogPoiExp.setRoleName(oplogPoiExpDTO.getRoleName());
                oplogPoiExp.setProvId(oplogPoiExpDTO.getProvId());
                oplogPoiExp.setProvTitle(oplogPoiExpDTO.getProvTitle());
                oplogPoiExp.setCityId(oplogPoiExpDTO.getCityId());
                oplogPoiExp.setCityTitle(oplogPoiExpDTO.getCityTitle());
                oplogPoiExp.setCountyId(oplogPoiExpDTO.getCountyId());
                oplogPoiExp.setCountyTitle(oplogPoiExpDTO.getCountyTitle());
                oplogPoiExp.setDeptId(oplogPoiExpDTO.getDeptId());
                oplogPoiExp.setDeptTitle(oplogPoiExpDTO.getDeptTitle());
                oplogPoiExp.setDeptLevel(oplogPoiExpDTO.getDeptLevel());
                oplogPoiExp.setDeptParentId(oplogPoiExpDTO.getDeptParentId());
                oplogPoiExp.setMsgId(oplogPoiExpDTO.getMsgId());
                oplogPoiExp.setFuncId(oplogPoiExpDTO.getFuncId());
                oplogPoiExp.setFuncTitle(oplogPoiExpDTO.getFuncTitle());
                oplogPoiExp.setHostIp(oplogPoiExpDTO.getHostIp());
                oplogPoiExp.setHostAddress(oplogPoiExpDTO.getHostAddress());
                oplogPoiExp.setHostOs(oplogPoiExpDTO.getHostOs());
                oplogPoiExp.setHostBrowser(oplogPoiExpDTO.getHostBrowser());
                oplogPoiExp.setHostUserAgent(oplogPoiExpDTO.getHostUserAgent());
                oplogPoiExp.setRequestId(oplogPoiExpDTO.getRequestId());
                oplogPoiExp.setRequestUri(oplogPoiExpDTO.getRequestUri());
                oplogPoiExp.setRequestMethod(oplogPoiExpDTO.getRequestMethod());
                oplogPoiExp.setRequestParams(oplogPoiExpDTO.getRequestParams());
                oplogPoiExp.setDataTotal(oplogPoiExpDTO.getDataTotal());
                oplogPoiExp.setFileName(oplogPoiExpDTO.getFileName());
                oplogPoiExp.setFileUrl(oplogPoiExpDTO.getFileUrl());
                oplogPoiExp.setFileSize(oplogPoiExpDTO.getFileSize());
                oplogPoiExp.setFileTotal(oplogPoiExpDTO.getFileTotal());
                oplogPoiExp.setExInfo(oplogPoiExpDTO.getExInfo());
                oplogPoiExp.setRemarks(oplogPoiExpDTO.getRemarks());
                oplogPoiExp.setExecuteTime(oplogPoiExpDTO.getExecuteTime());
                oplogPoiExp.setRemoveTime(oplogPoiExpDTO.getRemoveTime());
                oplogPoiExp.setRemoveUserId(oplogPoiExpDTO.getRemoveUserId());
                oplogPoiExp.setRemoveUser(oplogPoiExpDTO.getRemoveUser());
                oplogPoiExp.setYearly(oplogPoiExpDTO.getYearly());
                oplogPoiExp.setMonthly(oplogPoiExpDTO.getMonthly());
        return oplogPoiExp;
    }


    @Override
    public OplogPoiExpVO toJavaObjectVO(OplogPoiExp oplogPoiExp) {
        if (null == oplogPoiExp){
            return null;
        }
            OplogPoiExpVO oplogPoiExpVO = new OplogPoiExpVO();
                    oplogPoiExpVO.setId(oplogPoiExp.getId());
                    oplogPoiExpVO.setTenantId(oplogPoiExp.getTenantId());
                    oplogPoiExpVO.setTenantTitle(oplogPoiExp.getTenantTitle());
                    oplogPoiExpVO.setPlatId(oplogPoiExp.getPlatId());
                    oplogPoiExpVO.setPlatTitle(oplogPoiExp.getPlatTitle());
                    oplogPoiExpVO.setAppId(oplogPoiExp.getAppId());
                    oplogPoiExpVO.setAppTitle(oplogPoiExp.getAppTitle());
                    oplogPoiExpVO.setAppVersion(oplogPoiExp.getAppVersion());
                    oplogPoiExpVO.setUserId(oplogPoiExp.getUserId());
                    oplogPoiExpVO.setNickName(oplogPoiExp.getNickName());
                    oplogPoiExpVO.setRoleId(oplogPoiExp.getRoleId());
                    oplogPoiExpVO.setRoleName(oplogPoiExp.getRoleName());
                    oplogPoiExpVO.setProvId(oplogPoiExp.getProvId());
                    oplogPoiExpVO.setProvTitle(oplogPoiExp.getProvTitle());
                    oplogPoiExpVO.setCityId(oplogPoiExp.getCityId());
                    oplogPoiExpVO.setCityTitle(oplogPoiExp.getCityTitle());
                    oplogPoiExpVO.setCountyId(oplogPoiExp.getCountyId());
                    oplogPoiExpVO.setCountyTitle(oplogPoiExp.getCountyTitle());
                    oplogPoiExpVO.setDeptId(oplogPoiExp.getDeptId());
                    oplogPoiExpVO.setDeptTitle(oplogPoiExp.getDeptTitle());
                    oplogPoiExpVO.setDeptLevel(oplogPoiExp.getDeptLevel());
                    oplogPoiExpVO.setDeptParentId(oplogPoiExp.getDeptParentId());
                    oplogPoiExpVO.setMsgId(oplogPoiExp.getMsgId());
                    oplogPoiExpVO.setFuncId(oplogPoiExp.getFuncId());
                    oplogPoiExpVO.setFuncTitle(oplogPoiExp.getFuncTitle());
                    oplogPoiExpVO.setHostIp(oplogPoiExp.getHostIp());
                    oplogPoiExpVO.setHostAddress(oplogPoiExp.getHostAddress());
                    oplogPoiExpVO.setHostOs(oplogPoiExp.getHostOs());
                    oplogPoiExpVO.setHostBrowser(oplogPoiExp.getHostBrowser());
                    oplogPoiExpVO.setHostUserAgent(oplogPoiExp.getHostUserAgent());
                    oplogPoiExpVO.setRequestId(oplogPoiExp.getRequestId());
                    oplogPoiExpVO.setRequestUri(oplogPoiExp.getRequestUri());
                    oplogPoiExpVO.setRequestMethod(oplogPoiExp.getRequestMethod());
                    oplogPoiExpVO.setRequestParams(oplogPoiExp.getRequestParams());
                    oplogPoiExpVO.setDataTotal(oplogPoiExp.getDataTotal());
                    oplogPoiExpVO.setFileName(oplogPoiExp.getFileName());
                    oplogPoiExpVO.setFileUrl(oplogPoiExp.getFileUrl());
                    oplogPoiExpVO.setFileSize(oplogPoiExp.getFileSize());
                    oplogPoiExpVO.setFileTotal(oplogPoiExp.getFileTotal());
                    oplogPoiExpVO.setExInfo(oplogPoiExp.getExInfo());
                    oplogPoiExpVO.setRemarks(oplogPoiExp.getRemarks());
                    oplogPoiExpVO.setExecuteTime(oplogPoiExp.getExecuteTime());
                    oplogPoiExpVO.setRemoveTime(oplogPoiExp.getRemoveTime());
                    oplogPoiExpVO.setRemoveUserId(oplogPoiExp.getRemoveUserId());
                    oplogPoiExpVO.setRemoveUser(oplogPoiExp.getRemoveUser());
                    oplogPoiExpVO.setYearly(oplogPoiExp.getYearly());
                    oplogPoiExpVO.setMonthly(oplogPoiExp.getMonthly());
        return oplogPoiExpVO;
    }

    public OplogPoiExp toJavaObject(OplogPoiExpVO oplogPoiExpVO) {
        if (null == oplogPoiExpVO){
            return null;
        }
        OplogPoiExp oplogPoiExp = new OplogPoiExp();
                oplogPoiExp.setId(oplogPoiExpVO.getId());
                oplogPoiExp.setTenantId(oplogPoiExpVO.getTenantId());
                oplogPoiExp.setTenantTitle(oplogPoiExpVO.getTenantTitle());
                oplogPoiExp.setPlatId(oplogPoiExpVO.getPlatId());
                oplogPoiExp.setPlatTitle(oplogPoiExpVO.getPlatTitle());
                oplogPoiExp.setAppId(oplogPoiExpVO.getAppId());
                oplogPoiExp.setAppTitle(oplogPoiExpVO.getAppTitle());
                oplogPoiExp.setAppVersion(oplogPoiExpVO.getAppVersion());
                oplogPoiExp.setUserId(oplogPoiExpVO.getUserId());
                oplogPoiExp.setNickName(oplogPoiExpVO.getNickName());
                oplogPoiExp.setRoleId(oplogPoiExpVO.getRoleId());
                oplogPoiExp.setRoleName(oplogPoiExpVO.getRoleName());
                oplogPoiExp.setProvId(oplogPoiExpVO.getProvId());
                oplogPoiExp.setProvTitle(oplogPoiExpVO.getProvTitle());
                oplogPoiExp.setCityId(oplogPoiExpVO.getCityId());
                oplogPoiExp.setCityTitle(oplogPoiExpVO.getCityTitle());
                oplogPoiExp.setCountyId(oplogPoiExpVO.getCountyId());
                oplogPoiExp.setCountyTitle(oplogPoiExpVO.getCountyTitle());
                oplogPoiExp.setDeptId(oplogPoiExpVO.getDeptId());
                oplogPoiExp.setDeptTitle(oplogPoiExpVO.getDeptTitle());
                oplogPoiExp.setDeptLevel(oplogPoiExpVO.getDeptLevel());
                oplogPoiExp.setDeptParentId(oplogPoiExpVO.getDeptParentId());
                oplogPoiExp.setMsgId(oplogPoiExpVO.getMsgId());
                oplogPoiExp.setFuncId(oplogPoiExpVO.getFuncId());
                oplogPoiExp.setFuncTitle(oplogPoiExpVO.getFuncTitle());
                oplogPoiExp.setHostIp(oplogPoiExpVO.getHostIp());
                oplogPoiExp.setHostAddress(oplogPoiExpVO.getHostAddress());
                oplogPoiExp.setHostOs(oplogPoiExpVO.getHostOs());
                oplogPoiExp.setHostBrowser(oplogPoiExpVO.getHostBrowser());
                oplogPoiExp.setHostUserAgent(oplogPoiExpVO.getHostUserAgent());
                oplogPoiExp.setRequestId(oplogPoiExpVO.getRequestId());
                oplogPoiExp.setRequestUri(oplogPoiExpVO.getRequestUri());
                oplogPoiExp.setRequestMethod(oplogPoiExpVO.getRequestMethod());
                oplogPoiExp.setRequestParams(oplogPoiExpVO.getRequestParams());
                oplogPoiExp.setDataTotal(oplogPoiExpVO.getDataTotal());
                oplogPoiExp.setFileName(oplogPoiExpVO.getFileName());
                oplogPoiExp.setFileUrl(oplogPoiExpVO.getFileUrl());
                oplogPoiExp.setFileSize(oplogPoiExpVO.getFileSize());
                oplogPoiExp.setFileTotal(oplogPoiExpVO.getFileTotal());
                oplogPoiExp.setExInfo(oplogPoiExpVO.getExInfo());
                oplogPoiExp.setRemarks(oplogPoiExpVO.getRemarks());
                oplogPoiExp.setExecuteTime(oplogPoiExpVO.getExecuteTime());
                oplogPoiExp.setRemoveTime(oplogPoiExpVO.getRemoveTime());
                oplogPoiExp.setRemoveUserId(oplogPoiExpVO.getRemoveUserId());
                oplogPoiExp.setRemoveUser(oplogPoiExpVO.getRemoveUser());
                oplogPoiExp.setYearly(oplogPoiExpVO.getYearly());
                oplogPoiExp.setMonthly(oplogPoiExpVO.getMonthly());
        return oplogPoiExp;
    }

    public OplogPoiExpVO toJavaObjectVO(OplogPoiExpDTO oplogPoiExpDTO) {
        if (null == oplogPoiExpDTO){
            return null;
        }
            OplogPoiExpVO oplogPoiExpVO = new OplogPoiExpVO();
                    oplogPoiExpVO.setId(oplogPoiExpDTO.getId());
                    oplogPoiExpVO.setTenantId(oplogPoiExpDTO.getTenantId());
                    oplogPoiExpVO.setTenantTitle(oplogPoiExpDTO.getTenantTitle());
                    oplogPoiExpVO.setPlatId(oplogPoiExpDTO.getPlatId());
                    oplogPoiExpVO.setPlatTitle(oplogPoiExpDTO.getPlatTitle());
                    oplogPoiExpVO.setAppId(oplogPoiExpDTO.getAppId());
                    oplogPoiExpVO.setAppTitle(oplogPoiExpDTO.getAppTitle());
                    oplogPoiExpVO.setAppVersion(oplogPoiExpDTO.getAppVersion());
                    oplogPoiExpVO.setUserId(oplogPoiExpDTO.getUserId());
                    oplogPoiExpVO.setNickName(oplogPoiExpDTO.getNickName());
                    oplogPoiExpVO.setRoleId(oplogPoiExpDTO.getRoleId());
                    oplogPoiExpVO.setRoleName(oplogPoiExpDTO.getRoleName());
                    oplogPoiExpVO.setProvId(oplogPoiExpDTO.getProvId());
                    oplogPoiExpVO.setProvTitle(oplogPoiExpDTO.getProvTitle());
                    oplogPoiExpVO.setCityId(oplogPoiExpDTO.getCityId());
                    oplogPoiExpVO.setCityTitle(oplogPoiExpDTO.getCityTitle());
                    oplogPoiExpVO.setCountyId(oplogPoiExpDTO.getCountyId());
                    oplogPoiExpVO.setCountyTitle(oplogPoiExpDTO.getCountyTitle());
                    oplogPoiExpVO.setDeptId(oplogPoiExpDTO.getDeptId());
                    oplogPoiExpVO.setDeptTitle(oplogPoiExpDTO.getDeptTitle());
                    oplogPoiExpVO.setDeptLevel(oplogPoiExpDTO.getDeptLevel());
                    oplogPoiExpVO.setDeptParentId(oplogPoiExpDTO.getDeptParentId());
                    oplogPoiExpVO.setMsgId(oplogPoiExpDTO.getMsgId());
                    oplogPoiExpVO.setFuncId(oplogPoiExpDTO.getFuncId());
                    oplogPoiExpVO.setFuncTitle(oplogPoiExpDTO.getFuncTitle());
                    oplogPoiExpVO.setHostIp(oplogPoiExpDTO.getHostIp());
                    oplogPoiExpVO.setHostAddress(oplogPoiExpDTO.getHostAddress());
                    oplogPoiExpVO.setHostOs(oplogPoiExpDTO.getHostOs());
                    oplogPoiExpVO.setHostBrowser(oplogPoiExpDTO.getHostBrowser());
                    oplogPoiExpVO.setHostUserAgent(oplogPoiExpDTO.getHostUserAgent());
                    oplogPoiExpVO.setRequestId(oplogPoiExpDTO.getRequestId());
                    oplogPoiExpVO.setRequestUri(oplogPoiExpDTO.getRequestUri());
                    oplogPoiExpVO.setRequestMethod(oplogPoiExpDTO.getRequestMethod());
                    oplogPoiExpVO.setRequestParams(oplogPoiExpDTO.getRequestParams());
                    oplogPoiExpVO.setDataTotal(oplogPoiExpDTO.getDataTotal());
                    oplogPoiExpVO.setFileName(oplogPoiExpDTO.getFileName());
                    oplogPoiExpVO.setFileUrl(oplogPoiExpDTO.getFileUrl());
                    oplogPoiExpVO.setFileSize(oplogPoiExpDTO.getFileSize());
                    oplogPoiExpVO.setFileTotal(oplogPoiExpDTO.getFileTotal());
                    oplogPoiExpVO.setExInfo(oplogPoiExpDTO.getExInfo());
                    oplogPoiExpVO.setRemarks(oplogPoiExpDTO.getRemarks());
                    oplogPoiExpVO.setExecuteTime(oplogPoiExpDTO.getExecuteTime());
                    oplogPoiExpVO.setRemoveTime(oplogPoiExpDTO.getRemoveTime());
                    oplogPoiExpVO.setRemoveUserId(oplogPoiExpDTO.getRemoveUserId());
                    oplogPoiExpVO.setRemoveUser(oplogPoiExpDTO.getRemoveUser());
                    oplogPoiExpVO.setYearly(oplogPoiExpDTO.getYearly());
                    oplogPoiExpVO.setMonthly(oplogPoiExpDTO.getMonthly());
        return oplogPoiExpVO;
    }


}