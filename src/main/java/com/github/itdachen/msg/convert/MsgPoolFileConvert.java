package com.github.itdachen.msg.convert;

import com.github.itdachen.msg.entity.MsgPoolFile;
import com.github.itdachen.msg.sdk.dto.MsgPoolFileDTO;
import com.github.itdachen.msg.sdk.vo.MsgPoolFileVO;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;

/**
 * 消息附件 类型转换
 *
 * @author 王大宸
 * @date 2025-07-11 22:52:18
 */
public class MsgPoolFileConvert implements IBizConvertMapper<MsgPoolFile, MsgPoolFileDTO, MsgPoolFileVO> {


    @Override
    public MsgPoolFile toJavaObject(MsgPoolFileDTO msgPoolFileDTO) {
        if (null == msgPoolFileDTO){
            return null;
        }
        MsgPoolFile msgPoolFile = new MsgPoolFile();
        msgPoolFile.setId(msgPoolFileDTO.getId());
        msgPoolFile.setTenantId(msgPoolFileDTO.getTenantId());
        msgPoolFile.setTenantTitle(msgPoolFileDTO.getTenantTitle());
        msgPoolFile.setPlatId(msgPoolFileDTO.getPlatId());
        msgPoolFile.setPlatTitle(msgPoolFileDTO.getPlatTitle());
        msgPoolFile.setAppId(msgPoolFileDTO.getAppId());
        msgPoolFile.setAppTitle(msgPoolFileDTO.getAppTitle());
        msgPoolFile.setAppVersion(msgPoolFileDTO.getAppVersion());
        msgPoolFile.setUserId(msgPoolFileDTO.getUserId());
        msgPoolFile.setNickName(msgPoolFileDTO.getNickName());
        msgPoolFile.setRoleId(msgPoolFileDTO.getRoleId());
        msgPoolFile.setRoleName(msgPoolFileDTO.getRoleName());
        msgPoolFile.setProvId(msgPoolFileDTO.getProvId());
        msgPoolFile.setProvTitle(msgPoolFileDTO.getProvTitle());
        msgPoolFile.setCityId(msgPoolFileDTO.getCityId());
        msgPoolFile.setCityTitle(msgPoolFileDTO.getCityTitle());
        msgPoolFile.setCountyId(msgPoolFileDTO.getCountyId());
        msgPoolFile.setCountyTitle(msgPoolFileDTO.getCountyTitle());
        msgPoolFile.setDeptId(msgPoolFileDTO.getDeptId());
        msgPoolFile.setDeptTitle(msgPoolFileDTO.getDeptTitle());
        msgPoolFile.setDeptLevel(msgPoolFileDTO.getDeptLevel());
        msgPoolFile.setDeptParentId(msgPoolFileDTO.getDeptParentId());
        msgPoolFile.setHostIp(msgPoolFileDTO.getHostIp());
        msgPoolFile.setHostAddress(msgPoolFileDTO.getHostAddress());
        msgPoolFile.setHostOs(msgPoolFileDTO.getHostOs());
        msgPoolFile.setHostBrowser(msgPoolFileDTO.getHostBrowser());
        msgPoolFile.setHostUserAgent(msgPoolFileDTO.getHostUserAgent());
        msgPoolFile.setMsgType(msgPoolFileDTO.getMsgType());
        msgPoolFile.setMsgTypeTitle(msgPoolFileDTO.getMsgTypeTitle());
        msgPoolFile.setClazzType(msgPoolFileDTO.getClazzType());
        msgPoolFile.setClazzTitle(msgPoolFileDTO.getClazzTitle());
        msgPoolFile.setMsgId(msgPoolFileDTO.getMsgId());
        msgPoolFile.setMsgTitle(msgPoolFileDTO.getMsgTitle());
        msgPoolFile.setFileTitle(msgPoolFileDTO.getFileTitle());
        msgPoolFile.setFileFormat(msgPoolFileDTO.getFileFormat());
        msgPoolFile.setFileUrl(msgPoolFileDTO.getFileUrl());
        msgPoolFile.setFileSize(msgPoolFileDTO.getFileSize());
        msgPoolFile.setHexMd5(msgPoolFileDTO.getHexMd5());
        msgPoolFile.setMd5ValidFlag(msgPoolFileDTO.getMd5ValidFlag());
        msgPoolFile.setDownloadFlag(msgPoolFileDTO.getDownloadFlag());
        msgPoolFile.setDownloadTotal(msgPoolFileDTO.getDownloadTotal());
        msgPoolFile.setDownloadFirstTime(msgPoolFileDTO.getDownloadFirstTime());
        msgPoolFile.setDownloadLastTime(msgPoolFileDTO.getDownloadLastTime());
        msgPoolFile.setReadFlag(msgPoolFileDTO.getReadFlag());
        msgPoolFile.setReadTime(msgPoolFileDTO.getReadTime());
        msgPoolFile.setRemoveTime(msgPoolFileDTO.getRemoveTime());
        msgPoolFile.setRemoveUserId(msgPoolFileDTO.getRemoveUserId());
        msgPoolFile.setRemoveNickName(msgPoolFileDTO.getRemoveNickName());
        msgPoolFile.setYearly(msgPoolFileDTO.getYearly());
        msgPoolFile.setMonthly(msgPoolFileDTO.getMonthly());
        return msgPoolFile;
    }


    @Override
    public MsgPoolFileVO toJavaObjectVO(MsgPoolFile msgPoolFile) {
        if (null == msgPoolFile){
            return null;
        }
        MsgPoolFileVO msgPoolFileVO = new MsgPoolFileVO();
        msgPoolFileVO.setId(msgPoolFile.getId());
        msgPoolFileVO.setTenantId(msgPoolFile.getTenantId());
        msgPoolFileVO.setTenantTitle(msgPoolFile.getTenantTitle());
        msgPoolFileVO.setPlatId(msgPoolFile.getPlatId());
        msgPoolFileVO.setPlatTitle(msgPoolFile.getPlatTitle());
        msgPoolFileVO.setAppId(msgPoolFile.getAppId());
        msgPoolFileVO.setAppTitle(msgPoolFile.getAppTitle());
        msgPoolFileVO.setAppVersion(msgPoolFile.getAppVersion());
        msgPoolFileVO.setUserId(msgPoolFile.getUserId());
        msgPoolFileVO.setNickName(msgPoolFile.getNickName());
        msgPoolFileVO.setRoleId(msgPoolFile.getRoleId());
        msgPoolFileVO.setRoleName(msgPoolFile.getRoleName());
        msgPoolFileVO.setProvId(msgPoolFile.getProvId());
        msgPoolFileVO.setProvTitle(msgPoolFile.getProvTitle());
        msgPoolFileVO.setCityId(msgPoolFile.getCityId());
        msgPoolFileVO.setCityTitle(msgPoolFile.getCityTitle());
        msgPoolFileVO.setCountyId(msgPoolFile.getCountyId());
        msgPoolFileVO.setCountyTitle(msgPoolFile.getCountyTitle());
        msgPoolFileVO.setDeptId(msgPoolFile.getDeptId());
        msgPoolFileVO.setDeptTitle(msgPoolFile.getDeptTitle());
        msgPoolFileVO.setDeptLevel(msgPoolFile.getDeptLevel());
        msgPoolFileVO.setDeptParentId(msgPoolFile.getDeptParentId());
        msgPoolFileVO.setHostIp(msgPoolFile.getHostIp());
        msgPoolFileVO.setHostAddress(msgPoolFile.getHostAddress());
        msgPoolFileVO.setHostOs(msgPoolFile.getHostOs());
        msgPoolFileVO.setHostBrowser(msgPoolFile.getHostBrowser());
        msgPoolFileVO.setHostUserAgent(msgPoolFile.getHostUserAgent());
        msgPoolFileVO.setMsgType(msgPoolFile.getMsgType());
        msgPoolFileVO.setMsgTypeTitle(msgPoolFile.getMsgTypeTitle());
        msgPoolFileVO.setClazzType(msgPoolFile.getClazzType());
        msgPoolFileVO.setClazzTitle(msgPoolFile.getClazzTitle());
        msgPoolFileVO.setMsgId(msgPoolFile.getMsgId());
        msgPoolFileVO.setMsgTitle(msgPoolFile.getMsgTitle());
        msgPoolFileVO.setFileTitle(msgPoolFile.getFileTitle());
        msgPoolFileVO.setFileFormat(msgPoolFile.getFileFormat());
        msgPoolFileVO.setFileUrl(msgPoolFile.getFileUrl());
        msgPoolFileVO.setFileSize(msgPoolFile.getFileSize());
        msgPoolFileVO.setHexMd5(msgPoolFile.getHexMd5());
        msgPoolFileVO.setMd5ValidFlag(msgPoolFile.getMd5ValidFlag());
        msgPoolFileVO.setDownloadFlag(msgPoolFile.getDownloadFlag());
        msgPoolFileVO.setDownloadTotal(msgPoolFile.getDownloadTotal());
        msgPoolFileVO.setDownloadFirstTime(msgPoolFile.getDownloadFirstTime());
        msgPoolFileVO.setDownloadLastTime(msgPoolFile.getDownloadLastTime());
        msgPoolFileVO.setReadFlag(msgPoolFile.getReadFlag());
        msgPoolFileVO.setReadTime(msgPoolFile.getReadTime());
        msgPoolFileVO.setRemoveTime(msgPoolFile.getRemoveTime());
        msgPoolFileVO.setRemoveUserId(msgPoolFile.getRemoveUserId());
        msgPoolFileVO.setRemoveNickName(msgPoolFile.getRemoveNickName());
        msgPoolFileVO.setYearly(msgPoolFile.getYearly());
        msgPoolFileVO.setMonthly(msgPoolFile.getMonthly());
        return msgPoolFileVO;
    }

    public MsgPoolFile toJavaObject(MsgPoolFileVO msgPoolFileVO) {
        if (null == msgPoolFileVO){
            return null;
        }
        MsgPoolFile msgPoolFile = new MsgPoolFile();
        msgPoolFile.setId(msgPoolFileVO.getId());
        msgPoolFile.setTenantId(msgPoolFileVO.getTenantId());
        msgPoolFile.setTenantTitle(msgPoolFileVO.getTenantTitle());
        msgPoolFile.setPlatId(msgPoolFileVO.getPlatId());
        msgPoolFile.setPlatTitle(msgPoolFileVO.getPlatTitle());
        msgPoolFile.setAppId(msgPoolFileVO.getAppId());
        msgPoolFile.setAppTitle(msgPoolFileVO.getAppTitle());
        msgPoolFile.setAppVersion(msgPoolFileVO.getAppVersion());
        msgPoolFile.setUserId(msgPoolFileVO.getUserId());
        msgPoolFile.setNickName(msgPoolFileVO.getNickName());
        msgPoolFile.setRoleId(msgPoolFileVO.getRoleId());
        msgPoolFile.setRoleName(msgPoolFileVO.getRoleName());
        msgPoolFile.setProvId(msgPoolFileVO.getProvId());
        msgPoolFile.setProvTitle(msgPoolFileVO.getProvTitle());
        msgPoolFile.setCityId(msgPoolFileVO.getCityId());
        msgPoolFile.setCityTitle(msgPoolFileVO.getCityTitle());
        msgPoolFile.setCountyId(msgPoolFileVO.getCountyId());
        msgPoolFile.setCountyTitle(msgPoolFileVO.getCountyTitle());
        msgPoolFile.setDeptId(msgPoolFileVO.getDeptId());
        msgPoolFile.setDeptTitle(msgPoolFileVO.getDeptTitle());
        msgPoolFile.setDeptLevel(msgPoolFileVO.getDeptLevel());
        msgPoolFile.setDeptParentId(msgPoolFileVO.getDeptParentId());
        msgPoolFile.setHostIp(msgPoolFileVO.getHostIp());
        msgPoolFile.setHostAddress(msgPoolFileVO.getHostAddress());
        msgPoolFile.setHostOs(msgPoolFileVO.getHostOs());
        msgPoolFile.setHostBrowser(msgPoolFileVO.getHostBrowser());
        msgPoolFile.setHostUserAgent(msgPoolFileVO.getHostUserAgent());
        msgPoolFile.setMsgType(msgPoolFileVO.getMsgType());
        msgPoolFile.setMsgTypeTitle(msgPoolFileVO.getMsgTypeTitle());
        msgPoolFile.setClazzType(msgPoolFileVO.getClazzType());
        msgPoolFile.setClazzTitle(msgPoolFileVO.getClazzTitle());
        msgPoolFile.setMsgId(msgPoolFileVO.getMsgId());
        msgPoolFile.setMsgTitle(msgPoolFileVO.getMsgTitle());
        msgPoolFile.setFileTitle(msgPoolFileVO.getFileTitle());
        msgPoolFile.setFileFormat(msgPoolFileVO.getFileFormat());
        msgPoolFile.setFileUrl(msgPoolFileVO.getFileUrl());
        msgPoolFile.setFileSize(msgPoolFileVO.getFileSize());
        msgPoolFile.setHexMd5(msgPoolFileVO.getHexMd5());
        msgPoolFile.setMd5ValidFlag(msgPoolFileVO.getMd5ValidFlag());
        msgPoolFile.setDownloadFlag(msgPoolFileVO.getDownloadFlag());
        msgPoolFile.setDownloadTotal(msgPoolFileVO.getDownloadTotal());
        msgPoolFile.setDownloadFirstTime(msgPoolFileVO.getDownloadFirstTime());
        msgPoolFile.setDownloadLastTime(msgPoolFileVO.getDownloadLastTime());
        msgPoolFile.setReadFlag(msgPoolFileVO.getReadFlag());
        msgPoolFile.setReadTime(msgPoolFileVO.getReadTime());
        msgPoolFile.setRemoveTime(msgPoolFileVO.getRemoveTime());
        msgPoolFile.setRemoveUserId(msgPoolFileVO.getRemoveUserId());
        msgPoolFile.setRemoveNickName(msgPoolFileVO.getRemoveNickName());
        msgPoolFile.setYearly(msgPoolFileVO.getYearly());
        msgPoolFile.setMonthly(msgPoolFileVO.getMonthly());
        return msgPoolFile;
    }

    public MsgPoolFileVO toJavaObjectVO(MsgPoolFileDTO msgPoolFileDTO) {
        if (null == msgPoolFileDTO){
            return null;
        }
        MsgPoolFileVO msgPoolFileVO = new MsgPoolFileVO();
        msgPoolFileVO.setId(msgPoolFileDTO.getId());
        msgPoolFileVO.setTenantId(msgPoolFileDTO.getTenantId());
        msgPoolFileVO.setTenantTitle(msgPoolFileDTO.getTenantTitle());
        msgPoolFileVO.setPlatId(msgPoolFileDTO.getPlatId());
        msgPoolFileVO.setPlatTitle(msgPoolFileDTO.getPlatTitle());
        msgPoolFileVO.setAppId(msgPoolFileDTO.getAppId());
        msgPoolFileVO.setAppTitle(msgPoolFileDTO.getAppTitle());
        msgPoolFileVO.setAppVersion(msgPoolFileDTO.getAppVersion());
        msgPoolFileVO.setUserId(msgPoolFileDTO.getUserId());
        msgPoolFileVO.setNickName(msgPoolFileDTO.getNickName());
        msgPoolFileVO.setRoleId(msgPoolFileDTO.getRoleId());
        msgPoolFileVO.setRoleName(msgPoolFileDTO.getRoleName());
        msgPoolFileVO.setProvId(msgPoolFileDTO.getProvId());
        msgPoolFileVO.setProvTitle(msgPoolFileDTO.getProvTitle());
        msgPoolFileVO.setCityId(msgPoolFileDTO.getCityId());
        msgPoolFileVO.setCityTitle(msgPoolFileDTO.getCityTitle());
        msgPoolFileVO.setCountyId(msgPoolFileDTO.getCountyId());
        msgPoolFileVO.setCountyTitle(msgPoolFileDTO.getCountyTitle());
        msgPoolFileVO.setDeptId(msgPoolFileDTO.getDeptId());
        msgPoolFileVO.setDeptTitle(msgPoolFileDTO.getDeptTitle());
        msgPoolFileVO.setDeptLevel(msgPoolFileDTO.getDeptLevel());
        msgPoolFileVO.setDeptParentId(msgPoolFileDTO.getDeptParentId());
        msgPoolFileVO.setHostIp(msgPoolFileDTO.getHostIp());
        msgPoolFileVO.setHostAddress(msgPoolFileDTO.getHostAddress());
        msgPoolFileVO.setHostOs(msgPoolFileDTO.getHostOs());
        msgPoolFileVO.setHostBrowser(msgPoolFileDTO.getHostBrowser());
        msgPoolFileVO.setHostUserAgent(msgPoolFileDTO.getHostUserAgent());
        msgPoolFileVO.setMsgType(msgPoolFileDTO.getMsgType());
        msgPoolFileVO.setMsgTypeTitle(msgPoolFileDTO.getMsgTypeTitle());
        msgPoolFileVO.setClazzType(msgPoolFileDTO.getClazzType());
        msgPoolFileVO.setClazzTitle(msgPoolFileDTO.getClazzTitle());
        msgPoolFileVO.setMsgId(msgPoolFileDTO.getMsgId());
        msgPoolFileVO.setMsgTitle(msgPoolFileDTO.getMsgTitle());
        msgPoolFileVO.setFileTitle(msgPoolFileDTO.getFileTitle());
        msgPoolFileVO.setFileFormat(msgPoolFileDTO.getFileFormat());
        msgPoolFileVO.setFileUrl(msgPoolFileDTO.getFileUrl());
        msgPoolFileVO.setFileSize(msgPoolFileDTO.getFileSize());
        msgPoolFileVO.setHexMd5(msgPoolFileDTO.getHexMd5());
        msgPoolFileVO.setMd5ValidFlag(msgPoolFileDTO.getMd5ValidFlag());
        msgPoolFileVO.setDownloadFlag(msgPoolFileDTO.getDownloadFlag());
        msgPoolFileVO.setDownloadTotal(msgPoolFileDTO.getDownloadTotal());
        msgPoolFileVO.setDownloadFirstTime(msgPoolFileDTO.getDownloadFirstTime());
        msgPoolFileVO.setDownloadLastTime(msgPoolFileDTO.getDownloadLastTime());
        msgPoolFileVO.setReadFlag(msgPoolFileDTO.getReadFlag());
        msgPoolFileVO.setReadTime(msgPoolFileDTO.getReadTime());
        msgPoolFileVO.setRemoveTime(msgPoolFileDTO.getRemoveTime());
        msgPoolFileVO.setRemoveUserId(msgPoolFileDTO.getRemoveUserId());
        msgPoolFileVO.setRemoveNickName(msgPoolFileDTO.getRemoveNickName());
        msgPoolFileVO.setYearly(msgPoolFileDTO.getYearly());
        msgPoolFileVO.setMonthly(msgPoolFileDTO.getMonthly());
        return msgPoolFileVO;
    }

}