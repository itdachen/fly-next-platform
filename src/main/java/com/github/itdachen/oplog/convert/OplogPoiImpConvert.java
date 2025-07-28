package com.github.itdachen.oplog.convert;

import com.github.itdachen.oplog.entity.OplogPoiImp;
import com.github.itdachen.oplog.sdk.dto.OplogPoiImpDTO;
import com.github.itdachen.oplog.sdk.vo.OplogPoiImpVO;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;

/**
 * 导入日志 类型转换
 *
 * @author 王大宸
 * @date 2025-07-28 15:55:31
 */
public class OplogPoiImpConvert implements IBizConvertMapper<OplogPoiImp, OplogPoiImpDTO, OplogPoiImpVO> {

    @Override
    public OplogPoiImp toJavaObject(OplogPoiImpDTO oplogPoiImpDTO) {
        if (null == oplogPoiImpDTO) {
            return null;
        }
        OplogPoiImp oplogPoiImp = new OplogPoiImp();
        oplogPoiImp.setId(oplogPoiImpDTO.getId());
        oplogPoiImp.setTenantId(oplogPoiImpDTO.getTenantId());
        oplogPoiImp.setTenantTitle(oplogPoiImpDTO.getTenantTitle());
        oplogPoiImp.setPlatId(oplogPoiImpDTO.getPlatId());
        oplogPoiImp.setPlatTitle(oplogPoiImpDTO.getPlatTitle());
        oplogPoiImp.setAppId(oplogPoiImpDTO.getAppId());
        oplogPoiImp.setAppTitle(oplogPoiImpDTO.getAppTitle());
        oplogPoiImp.setAppVersion(oplogPoiImpDTO.getAppVersion());
        oplogPoiImp.setUserId(oplogPoiImpDTO.getUserId());
        oplogPoiImp.setNickName(oplogPoiImpDTO.getNickName());
        oplogPoiImp.setRoleId(oplogPoiImpDTO.getRoleId());
        oplogPoiImp.setRoleName(oplogPoiImpDTO.getRoleName());
        oplogPoiImp.setProvId(oplogPoiImpDTO.getProvId());
        oplogPoiImp.setProvTitle(oplogPoiImpDTO.getProvTitle());
        oplogPoiImp.setCityId(oplogPoiImpDTO.getCityId());
        oplogPoiImp.setCityTitle(oplogPoiImpDTO.getCityTitle());
        oplogPoiImp.setCountyId(oplogPoiImpDTO.getCountyId());
        oplogPoiImp.setCountyTitle(oplogPoiImpDTO.getCountyTitle());
        oplogPoiImp.setDeptId(oplogPoiImpDTO.getDeptId());
        oplogPoiImp.setDeptTitle(oplogPoiImpDTO.getDeptTitle());
        oplogPoiImp.setDeptLevel(oplogPoiImpDTO.getDeptLevel());
        oplogPoiImp.setDeptParentId(oplogPoiImpDTO.getDeptParentId());
        oplogPoiImp.setMsgId(oplogPoiImpDTO.getMsgId());
        oplogPoiImp.setFuncId(oplogPoiImpDTO.getFuncId());
        oplogPoiImp.setFuncTitle(oplogPoiImpDTO.getFuncTitle());
        oplogPoiImp.setHostIp(oplogPoiImpDTO.getHostIp());
        oplogPoiImp.setHostAddress(oplogPoiImpDTO.getHostAddress());
        oplogPoiImp.setHostOs(oplogPoiImpDTO.getHostOs());
        oplogPoiImp.setHostBrowser(oplogPoiImpDTO.getHostBrowser());
        oplogPoiImp.setHostUserAgent(oplogPoiImpDTO.getHostUserAgent());
        oplogPoiImp.setRequestId(oplogPoiImpDTO.getRequestId());
        oplogPoiImp.setRequestUri(oplogPoiImpDTO.getRequestUri());
        oplogPoiImp.setRequestMethod(oplogPoiImpDTO.getRequestMethod());
        oplogPoiImp.setRequestParams(oplogPoiImpDTO.getRequestParams());
        oplogPoiImp.setDataTotal(oplogPoiImpDTO.getDataTotal());
        oplogPoiImp.setFileName(oplogPoiImpDTO.getFileName());
        oplogPoiImp.setFileUrl(oplogPoiImpDTO.getFileUrl());
        oplogPoiImp.setFileSize(oplogPoiImpDTO.getFileSize());
        oplogPoiImp.setFileTotal(oplogPoiImpDTO.getFileTotal());
        oplogPoiImp.setExInfo(oplogPoiImpDTO.getExInfo());
        oplogPoiImp.setRemarks(oplogPoiImpDTO.getRemarks());
        oplogPoiImp.setExecuteTime(oplogPoiImpDTO.getExecuteTime());
        oplogPoiImp.setYearly(oplogPoiImpDTO.getYearly());
        oplogPoiImp.setMonthly(oplogPoiImpDTO.getMonthly());
        return oplogPoiImp;
    }


    @Override
    public OplogPoiImpVO toJavaObjectVO(OplogPoiImp oplogPoiImp) {
        if (null == oplogPoiImp) {
            return null;
        }
        OplogPoiImpVO oplogPoiImpVO = new OplogPoiImpVO();
        oplogPoiImpVO.setId(oplogPoiImp.getId());
        oplogPoiImpVO.setTenantId(oplogPoiImp.getTenantId());
        oplogPoiImpVO.setTenantTitle(oplogPoiImp.getTenantTitle());
        oplogPoiImpVO.setPlatId(oplogPoiImp.getPlatId());
        oplogPoiImpVO.setPlatTitle(oplogPoiImp.getPlatTitle());
        oplogPoiImpVO.setAppId(oplogPoiImp.getAppId());
        oplogPoiImpVO.setAppTitle(oplogPoiImp.getAppTitle());
        oplogPoiImpVO.setAppVersion(oplogPoiImp.getAppVersion());
        oplogPoiImpVO.setUserId(oplogPoiImp.getUserId());
        oplogPoiImpVO.setNickName(oplogPoiImp.getNickName());
        oplogPoiImpVO.setRoleId(oplogPoiImp.getRoleId());
        oplogPoiImpVO.setRoleName(oplogPoiImp.getRoleName());
        oplogPoiImpVO.setProvId(oplogPoiImp.getProvId());
        oplogPoiImpVO.setProvTitle(oplogPoiImp.getProvTitle());
        oplogPoiImpVO.setCityId(oplogPoiImp.getCityId());
        oplogPoiImpVO.setCityTitle(oplogPoiImp.getCityTitle());
        oplogPoiImpVO.setCountyId(oplogPoiImp.getCountyId());
        oplogPoiImpVO.setCountyTitle(oplogPoiImp.getCountyTitle());
        oplogPoiImpVO.setDeptId(oplogPoiImp.getDeptId());
        oplogPoiImpVO.setDeptTitle(oplogPoiImp.getDeptTitle());
        oplogPoiImpVO.setDeptLevel(oplogPoiImp.getDeptLevel());
        oplogPoiImpVO.setDeptParentId(oplogPoiImp.getDeptParentId());
        oplogPoiImpVO.setMsgId(oplogPoiImp.getMsgId());
        oplogPoiImpVO.setFuncId(oplogPoiImp.getFuncId());
        oplogPoiImpVO.setFuncTitle(oplogPoiImp.getFuncTitle());
        oplogPoiImpVO.setHostIp(oplogPoiImp.getHostIp());
        oplogPoiImpVO.setHostAddress(oplogPoiImp.getHostAddress());
        oplogPoiImpVO.setHostOs(oplogPoiImp.getHostOs());
        oplogPoiImpVO.setHostBrowser(oplogPoiImp.getHostBrowser());
        oplogPoiImpVO.setHostUserAgent(oplogPoiImp.getHostUserAgent());
        oplogPoiImpVO.setRequestId(oplogPoiImp.getRequestId());
        oplogPoiImpVO.setRequestUri(oplogPoiImp.getRequestUri());
        oplogPoiImpVO.setRequestMethod(oplogPoiImp.getRequestMethod());
        oplogPoiImpVO.setRequestParams(oplogPoiImp.getRequestParams());
        oplogPoiImpVO.setDataTotal(oplogPoiImp.getDataTotal());
        oplogPoiImpVO.setFileName(oplogPoiImp.getFileName());
        oplogPoiImpVO.setFileUrl(oplogPoiImp.getFileUrl());
        oplogPoiImpVO.setFileSize(oplogPoiImp.getFileSize());
        oplogPoiImpVO.setFileTotal(oplogPoiImp.getFileTotal());
        oplogPoiImpVO.setExInfo(oplogPoiImp.getExInfo());
        oplogPoiImpVO.setRemarks(oplogPoiImp.getRemarks());
        oplogPoiImpVO.setExecuteTime(oplogPoiImp.getExecuteTime());
        oplogPoiImpVO.setRemoveFlag(oplogPoiImp.getRemoveFlag());
        oplogPoiImpVO.setRemoveTime(oplogPoiImp.getRemoveTime());
        oplogPoiImpVO.setRemoveUserId(oplogPoiImp.getRemoveUserId());
        oplogPoiImpVO.setRemoveUser(oplogPoiImp.getRemoveUser());
        oplogPoiImpVO.setYearly(oplogPoiImp.getYearly());
        oplogPoiImpVO.setMonthly(oplogPoiImp.getMonthly());
        oplogPoiImpVO.setCreateTime(oplogPoiImp.getCreateTime());
        return oplogPoiImpVO;
    }

    public OplogPoiImp toJavaObject(OplogPoiImpVO oplogPoiImpVO) {
        if (null == oplogPoiImpVO) {
            return null;
        }
        OplogPoiImp oplogPoiImp = new OplogPoiImp();
        oplogPoiImp.setId(oplogPoiImpVO.getId());
        oplogPoiImp.setTenantId(oplogPoiImpVO.getTenantId());
        oplogPoiImp.setTenantTitle(oplogPoiImpVO.getTenantTitle());
        oplogPoiImp.setPlatId(oplogPoiImpVO.getPlatId());
        oplogPoiImp.setPlatTitle(oplogPoiImpVO.getPlatTitle());
        oplogPoiImp.setAppId(oplogPoiImpVO.getAppId());
        oplogPoiImp.setAppTitle(oplogPoiImpVO.getAppTitle());
        oplogPoiImp.setAppVersion(oplogPoiImpVO.getAppVersion());
        oplogPoiImp.setUserId(oplogPoiImpVO.getUserId());
        oplogPoiImp.setNickName(oplogPoiImpVO.getNickName());
        oplogPoiImp.setRoleId(oplogPoiImpVO.getRoleId());
        oplogPoiImp.setRoleName(oplogPoiImpVO.getRoleName());
        oplogPoiImp.setProvId(oplogPoiImpVO.getProvId());
        oplogPoiImp.setProvTitle(oplogPoiImpVO.getProvTitle());
        oplogPoiImp.setCityId(oplogPoiImpVO.getCityId());
        oplogPoiImp.setCityTitle(oplogPoiImpVO.getCityTitle());
        oplogPoiImp.setCountyId(oplogPoiImpVO.getCountyId());
        oplogPoiImp.setCountyTitle(oplogPoiImpVO.getCountyTitle());
        oplogPoiImp.setDeptId(oplogPoiImpVO.getDeptId());
        oplogPoiImp.setDeptTitle(oplogPoiImpVO.getDeptTitle());
        oplogPoiImp.setDeptLevel(oplogPoiImpVO.getDeptLevel());
        oplogPoiImp.setDeptParentId(oplogPoiImpVO.getDeptParentId());
        oplogPoiImp.setMsgId(oplogPoiImpVO.getMsgId());
        oplogPoiImp.setFuncId(oplogPoiImpVO.getFuncId());
        oplogPoiImp.setFuncTitle(oplogPoiImpVO.getFuncTitle());
        oplogPoiImp.setHostIp(oplogPoiImpVO.getHostIp());
        oplogPoiImp.setHostAddress(oplogPoiImpVO.getHostAddress());
        oplogPoiImp.setHostOs(oplogPoiImpVO.getHostOs());
        oplogPoiImp.setHostBrowser(oplogPoiImpVO.getHostBrowser());
        oplogPoiImp.setHostUserAgent(oplogPoiImpVO.getHostUserAgent());
        oplogPoiImp.setRequestId(oplogPoiImpVO.getRequestId());
        oplogPoiImp.setRequestUri(oplogPoiImpVO.getRequestUri());
        oplogPoiImp.setRequestMethod(oplogPoiImpVO.getRequestMethod());
        oplogPoiImp.setRequestParams(oplogPoiImpVO.getRequestParams());
        oplogPoiImp.setDataTotal(oplogPoiImpVO.getDataTotal());
        oplogPoiImp.setFileName(oplogPoiImpVO.getFileName());
        oplogPoiImp.setFileUrl(oplogPoiImpVO.getFileUrl());
        oplogPoiImp.setFileSize(oplogPoiImpVO.getFileSize());
        oplogPoiImp.setFileTotal(oplogPoiImpVO.getFileTotal());
        oplogPoiImp.setExInfo(oplogPoiImpVO.getExInfo());
        oplogPoiImp.setRemarks(oplogPoiImpVO.getRemarks());
        oplogPoiImp.setExecuteTime(oplogPoiImpVO.getExecuteTime());
        oplogPoiImp.setRemoveFlag(oplogPoiImpVO.getRemoveFlag());
        oplogPoiImp.setRemoveTime(oplogPoiImpVO.getRemoveTime());
        oplogPoiImp.setRemoveUserId(oplogPoiImpVO.getRemoveUserId());
        oplogPoiImp.setRemoveUser(oplogPoiImpVO.getRemoveUser());
        oplogPoiImp.setYearly(oplogPoiImpVO.getYearly());
        oplogPoiImp.setMonthly(oplogPoiImpVO.getMonthly());
        oplogPoiImp.setCreateTime(oplogPoiImpVO.getCreateTime());
        return oplogPoiImp;
    }

    public OplogPoiImpVO toJavaObjectVO(OplogPoiImpDTO oplogPoiImpDTO) {
        if (null == oplogPoiImpDTO) {
            return null;
        }
        OplogPoiImpVO oplogPoiImpVO = new OplogPoiImpVO();
        oplogPoiImpVO.setId(oplogPoiImpDTO.getId());
        oplogPoiImpVO.setTenantId(oplogPoiImpDTO.getTenantId());
        oplogPoiImpVO.setTenantTitle(oplogPoiImpDTO.getTenantTitle());
        oplogPoiImpVO.setPlatId(oplogPoiImpDTO.getPlatId());
        oplogPoiImpVO.setPlatTitle(oplogPoiImpDTO.getPlatTitle());
        oplogPoiImpVO.setAppId(oplogPoiImpDTO.getAppId());
        oplogPoiImpVO.setAppTitle(oplogPoiImpDTO.getAppTitle());
        oplogPoiImpVO.setAppVersion(oplogPoiImpDTO.getAppVersion());
        oplogPoiImpVO.setUserId(oplogPoiImpDTO.getUserId());
        oplogPoiImpVO.setNickName(oplogPoiImpDTO.getNickName());
        oplogPoiImpVO.setRoleId(oplogPoiImpDTO.getRoleId());
        oplogPoiImpVO.setRoleName(oplogPoiImpDTO.getRoleName());
        oplogPoiImpVO.setProvId(oplogPoiImpDTO.getProvId());
        oplogPoiImpVO.setProvTitle(oplogPoiImpDTO.getProvTitle());
        oplogPoiImpVO.setCityId(oplogPoiImpDTO.getCityId());
        oplogPoiImpVO.setCityTitle(oplogPoiImpDTO.getCityTitle());
        oplogPoiImpVO.setCountyId(oplogPoiImpDTO.getCountyId());
        oplogPoiImpVO.setCountyTitle(oplogPoiImpDTO.getCountyTitle());
        oplogPoiImpVO.setDeptId(oplogPoiImpDTO.getDeptId());
        oplogPoiImpVO.setDeptTitle(oplogPoiImpDTO.getDeptTitle());
        oplogPoiImpVO.setDeptLevel(oplogPoiImpDTO.getDeptLevel());
        oplogPoiImpVO.setDeptParentId(oplogPoiImpDTO.getDeptParentId());
        oplogPoiImpVO.setMsgId(oplogPoiImpDTO.getMsgId());
        oplogPoiImpVO.setFuncId(oplogPoiImpDTO.getFuncId());
        oplogPoiImpVO.setFuncTitle(oplogPoiImpDTO.getFuncTitle());
        oplogPoiImpVO.setHostIp(oplogPoiImpDTO.getHostIp());
        oplogPoiImpVO.setHostAddress(oplogPoiImpDTO.getHostAddress());
        oplogPoiImpVO.setHostOs(oplogPoiImpDTO.getHostOs());
        oplogPoiImpVO.setHostBrowser(oplogPoiImpDTO.getHostBrowser());
        oplogPoiImpVO.setHostUserAgent(oplogPoiImpDTO.getHostUserAgent());
        oplogPoiImpVO.setRequestId(oplogPoiImpDTO.getRequestId());
        oplogPoiImpVO.setRequestUri(oplogPoiImpDTO.getRequestUri());
        oplogPoiImpVO.setRequestMethod(oplogPoiImpDTO.getRequestMethod());
        oplogPoiImpVO.setRequestParams(oplogPoiImpDTO.getRequestParams());
        oplogPoiImpVO.setDataTotal(oplogPoiImpDTO.getDataTotal());
        oplogPoiImpVO.setFileName(oplogPoiImpDTO.getFileName());
        oplogPoiImpVO.setFileUrl(oplogPoiImpDTO.getFileUrl());
        oplogPoiImpVO.setFileSize(oplogPoiImpDTO.getFileSize());
        oplogPoiImpVO.setFileTotal(oplogPoiImpDTO.getFileTotal());
        oplogPoiImpVO.setExInfo(oplogPoiImpDTO.getExInfo());
        oplogPoiImpVO.setRemarks(oplogPoiImpDTO.getRemarks());
        oplogPoiImpVO.setExecuteTime(oplogPoiImpDTO.getExecuteTime());
        oplogPoiImpVO.setYearly(oplogPoiImpDTO.getYearly());
        oplogPoiImpVO.setMonthly(oplogPoiImpDTO.getMonthly());
        return oplogPoiImpVO;
    }


}