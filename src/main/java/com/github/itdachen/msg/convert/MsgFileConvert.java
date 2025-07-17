package com.github.itdachen.msg.convert;

import com.github.itdachen.msg.entity.MsgFile;
import com.github.itdachen.msg.sdk.dto.MsgFileDTO;
import com.github.itdachen.msg.sdk.vo.MsgFileVO;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;

/**
 * 消息附件 类型转换
 *
 * @author 王大宸
 * @date 2025-07-11 22:52:18
 */
public class MsgFileConvert implements IBizConvertMapper<MsgFile, MsgFileDTO, MsgFileVO> {

    @Override
    public MsgFile toJavaObject(MsgFileDTO msgFileDTO) {
        if (null == msgFileDTO) {
            return null;
        }
        MsgFile msgFile = new MsgFile();
        msgFile.setId(msgFileDTO.getId());
        msgFile.setTenantId(msgFileDTO.getTenantId());
        msgFile.setTenantTitle(msgFileDTO.getTenantTitle());
        msgFile.setPlatId(msgFileDTO.getPlatId());
        msgFile.setPlatTitle(msgFileDTO.getPlatTitle());
        msgFile.setAppId(msgFileDTO.getAppId());
        msgFile.setAppTitle(msgFileDTO.getAppTitle());
        msgFile.setUserId(msgFileDTO.getUserId());
        msgFile.setNickName(msgFileDTO.getNickName());
        msgFile.setMsgId(msgFileDTO.getMsgId());
        msgFile.setFileTitle(msgFileDTO.getFileTitle());
        msgFile.setFileFormat(msgFileDTO.getFileFormat());
        msgFile.setFileUrl(msgFileDTO.getFileUrl());
        msgFile.setFileSize(msgFileDTO.getFileSize());
        msgFile.setHexMd5(msgFileDTO.getHexMd5());
        msgFile.setMd5ValidFlag(msgFileDTO.getMd5ValidFlag());
        msgFile.setDownloadFlag(msgFileDTO.getDownloadFlag());
        msgFile.setDownloadTotal(msgFileDTO.getDownloadTotal());
        msgFile.setDownloadFirstTime(msgFileDTO.getDownloadFirstTime());
        msgFile.setDownloadLastTime(msgFileDTO.getDownloadLastTime());
        msgFile.setReadFlag(msgFileDTO.getReadFlag());
        msgFile.setReadTime(msgFileDTO.getReadTime());
        msgFile.setRemoveTime(msgFileDTO.getRemoveTime());
        msgFile.setRemoveUserId(msgFileDTO.getRemoveUserId());
        msgFile.setRemoveNickName(msgFileDTO.getRemoveNickName());
        msgFile.setYearly(msgFileDTO.getYearly());
        msgFile.setMonthly(msgFileDTO.getMonthly());
        return msgFile;
    }


    @Override
    public MsgFileVO toJavaObjectVO(MsgFile msgFile) {
        if (null == msgFile) {
            return null;
        }
        MsgFileVO msgFileVO = new MsgFileVO();
        msgFileVO.setId(msgFile.getId());
        msgFileVO.setTenantId(msgFile.getTenantId());
        msgFileVO.setTenantTitle(msgFile.getTenantTitle());
        msgFileVO.setPlatId(msgFile.getPlatId());
        msgFileVO.setPlatTitle(msgFile.getPlatTitle());
        msgFileVO.setAppId(msgFile.getAppId());
        msgFileVO.setAppTitle(msgFile.getAppTitle());
        msgFileVO.setUserId(msgFile.getUserId());
        msgFileVO.setNickName(msgFile.getNickName());
        msgFileVO.setMsgId(msgFile.getMsgId());
        msgFileVO.setFileTitle(msgFile.getFileTitle());
        msgFileVO.setFileFormat(msgFile.getFileFormat());
        msgFileVO.setFileUrl(msgFile.getFileUrl());
        msgFileVO.setFileSize(msgFile.getFileSize());
        msgFileVO.setHexMd5(msgFile.getHexMd5());
        msgFileVO.setMd5ValidFlag(msgFile.getMd5ValidFlag());
        msgFileVO.setDownloadFlag(msgFile.getDownloadFlag());
        msgFileVO.setDownloadTotal(msgFile.getDownloadTotal());
        msgFileVO.setDownloadFirstTime(msgFile.getDownloadFirstTime());
        msgFileVO.setDownloadLastTime(msgFile.getDownloadLastTime());
        msgFileVO.setReadFlag(msgFile.getReadFlag());
        msgFileVO.setReadTime(msgFile.getReadTime());
        msgFileVO.setRemoveTime(msgFile.getRemoveTime());
        msgFileVO.setRemoveUserId(msgFile.getRemoveUserId());
        msgFileVO.setRemoveNickName(msgFile.getRemoveNickName());
        msgFileVO.setYearly(msgFile.getYearly());
        msgFileVO.setMonthly(msgFile.getMonthly());
        msgFileVO.setCreateTime(msgFile.getCreateTime());
        return msgFileVO;
    }

    public MsgFile toJavaObject(MsgFileVO msgFileVO) {
        if (null == msgFileVO) {
            return null;
        }
        MsgFile msgFile = new MsgFile();
        msgFile.setId(msgFileVO.getId());
        msgFile.setTenantId(msgFileVO.getTenantId());
        msgFile.setTenantTitle(msgFileVO.getTenantTitle());
        msgFile.setPlatId(msgFileVO.getPlatId());
        msgFile.setPlatTitle(msgFileVO.getPlatTitle());
        msgFile.setAppId(msgFileVO.getAppId());
        msgFile.setAppTitle(msgFileVO.getAppTitle());
        msgFile.setUserId(msgFileVO.getUserId());
        msgFile.setNickName(msgFileVO.getNickName());
        msgFile.setMsgId(msgFileVO.getMsgId());
        msgFile.setFileTitle(msgFileVO.getFileTitle());
        msgFile.setFileFormat(msgFileVO.getFileFormat());
        msgFile.setFileUrl(msgFileVO.getFileUrl());
        msgFile.setFileSize(msgFileVO.getFileSize());
        msgFile.setHexMd5(msgFileVO.getHexMd5());
        msgFile.setMd5ValidFlag(msgFileVO.getMd5ValidFlag());
        msgFile.setDownloadFlag(msgFileVO.getDownloadFlag());
        msgFile.setDownloadTotal(msgFileVO.getDownloadTotal());
        msgFile.setDownloadFirstTime(msgFileVO.getDownloadFirstTime());
        msgFile.setDownloadLastTime(msgFileVO.getDownloadLastTime());
        msgFile.setReadFlag(msgFileVO.getReadFlag());
        msgFile.setReadTime(msgFileVO.getReadTime());
        msgFile.setRemoveTime(msgFileVO.getRemoveTime());
        msgFile.setRemoveUserId(msgFileVO.getRemoveUserId());
        msgFile.setRemoveNickName(msgFileVO.getRemoveNickName());
        msgFile.setYearly(msgFileVO.getYearly());
        msgFile.setMonthly(msgFileVO.getMonthly());
        msgFile.setCreateTime(msgFileVO.getCreateTime());
        return msgFile;
    }

    public MsgFileVO toJavaObjectVO(MsgFileDTO msgFileDTO) {
        if (null == msgFileDTO) {
            return null;
        }
        MsgFileVO msgFileVO = new MsgFileVO();
        msgFileVO.setId(msgFileDTO.getId());
        msgFileVO.setTenantId(msgFileDTO.getTenantId());
        msgFileVO.setTenantTitle(msgFileDTO.getTenantTitle());
        msgFileVO.setPlatId(msgFileDTO.getPlatId());
        msgFileVO.setPlatTitle(msgFileDTO.getPlatTitle());
        msgFileVO.setAppId(msgFileDTO.getAppId());
        msgFileVO.setAppTitle(msgFileDTO.getAppTitle());
        msgFileVO.setUserId(msgFileDTO.getUserId());
        msgFileVO.setNickName(msgFileDTO.getNickName());
        msgFileVO.setMsgId(msgFileDTO.getMsgId());
        msgFileVO.setFileTitle(msgFileDTO.getFileTitle());
        msgFileVO.setFileFormat(msgFileDTO.getFileFormat());
        msgFileVO.setFileUrl(msgFileDTO.getFileUrl());
        msgFileVO.setFileSize(msgFileDTO.getFileSize());
        msgFileVO.setHexMd5(msgFileDTO.getHexMd5());
        msgFileVO.setMd5ValidFlag(msgFileDTO.getMd5ValidFlag());
        msgFileVO.setDownloadFlag(msgFileDTO.getDownloadFlag());
        msgFileVO.setDownloadTotal(msgFileDTO.getDownloadTotal());
        msgFileVO.setDownloadFirstTime(msgFileDTO.getDownloadFirstTime());
        msgFileVO.setDownloadLastTime(msgFileDTO.getDownloadLastTime());
        msgFileVO.setReadFlag(msgFileDTO.getReadFlag());
        msgFileVO.setReadTime(msgFileDTO.getReadTime());
        msgFileVO.setRemoveTime(msgFileDTO.getRemoveTime());
        msgFileVO.setRemoveUserId(msgFileDTO.getRemoveUserId());
        msgFileVO.setRemoveNickName(msgFileDTO.getRemoveNickName());
        msgFileVO.setYearly(msgFileDTO.getYearly());
        msgFileVO.setMonthly(msgFileDTO.getMonthly());
        return msgFileVO;
    }


}