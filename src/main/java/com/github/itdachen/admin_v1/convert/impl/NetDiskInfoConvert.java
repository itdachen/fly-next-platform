package com.github.itdachen.admin_v1.convert.impl;

import com.github.itdachen.admin_v1.entity.NetDiskInfo;
import com.github.itdachen.admin_v1.sdk.dto.NetDiskInfoDto;
import com.github.itdachen.admin_v1.sdk.vo.NetDiskInfoVo;

/**
 * Description:
 * Created by 王大宸 on 2023/04/27 21:57
 * Created with IntelliJ IDEA.
 */
public class NetDiskInfoConvert {

    public static NetDiskInfoVo toJavaObjectVo(NetDiskInfoDto netDiskInfoDto) {
        NetDiskInfoVo netDiskInfoVo = new NetDiskInfoVo();
        if (null == netDiskInfoDto) {
            return netDiskInfoVo;
        }
        netDiskInfoVo.setId(netDiskInfoDto.getId());
        netDiskInfoVo.setBizMd5(netDiskInfoDto.getBizMd5());
        netDiskInfoVo.setRealPath(netDiskInfoDto.getRealPath());
        netDiskInfoVo.setUrl(netDiskInfoDto.getUrl());
        netDiskInfoVo.setFileName(netDiskInfoDto.getFileName());
        netDiskInfoVo.setFileSize(netDiskInfoDto.getFileSize());
        netDiskInfoVo.setFileFormat(netDiskInfoDto.getFileFormat());
        netDiskInfoVo.setBizType(netDiskInfoDto.getBizType());
        netDiskInfoVo.setDownloadCount(netDiskInfoDto.getDownloadCount());
        return netDiskInfoVo;
    }


    public static NetDiskInfoVo toJavaObjectVo(NetDiskInfo netDiskInfo) {
        NetDiskInfoVo netDiskInfoVo = new NetDiskInfoVo();
        if (null == netDiskInfo) {
            return netDiskInfoVo;
        }
        netDiskInfoVo.setId(netDiskInfo.getId());
        netDiskInfoVo.setBizMd5(netDiskInfo.getBizMd5());
        netDiskInfoVo.setRealPath(netDiskInfo.getRealPath());
        netDiskInfoVo.setUrl(netDiskInfo.getUrl());
        netDiskInfoVo.setFileName(netDiskInfo.getFileName());
        netDiskInfoVo.setFileSize(netDiskInfo.getFileSize());
        netDiskInfoVo.setFileFormat(netDiskInfo.getFileFormat());
        netDiskInfoVo.setBizType(netDiskInfo.getBizType());
        netDiskInfoVo.setDownloadCount(netDiskInfo.getDownloadCount());
        return netDiskInfoVo;
    }

    public static NetDiskInfo toJavaObject(NetDiskInfoDto netDiskInfoDto) {
        NetDiskInfo netDiskInfo = new NetDiskInfo();
        if (null == netDiskInfoDto) {
            return netDiskInfo;
        }
        netDiskInfo.setId(netDiskInfoDto.getId());
        netDiskInfo.setBizMd5(netDiskInfoDto.getBizMd5());
        netDiskInfo.setRealPath(netDiskInfoDto.getRealPath());
        netDiskInfo.setUrl(netDiskInfoDto.getUrl());
        netDiskInfo.setFileName(netDiskInfoDto.getFileName());
        netDiskInfo.setFileSize(netDiskInfoDto.getFileSize());
        netDiskInfo.setFileFormat(netDiskInfoDto.getFileFormat());
        netDiskInfo.setBizType(netDiskInfoDto.getBizType());
        netDiskInfo.setDownloadCount(netDiskInfoDto.getDownloadCount());
        return netDiskInfo;
    }

    public static NetDiskInfo toJavaObject(NetDiskInfoVo netDiskInfoVo) {
        NetDiskInfo netDiskInfo = new NetDiskInfo();
        if (null == netDiskInfoVo) {
            return netDiskInfo;
        }
        netDiskInfo.setId(netDiskInfoVo.getId());
        netDiskInfo.setBizMd5(netDiskInfoVo.getBizMd5());
        netDiskInfo.setRealPath(netDiskInfoVo.getRealPath());
        netDiskInfo.setUrl(netDiskInfoVo.getUrl());
        netDiskInfo.setFileName(netDiskInfoVo.getFileName());
        netDiskInfo.setFileSize(netDiskInfoVo.getFileSize());
        netDiskInfo.setFileFormat(netDiskInfoVo.getFileFormat());
        netDiskInfo.setBizType(netDiskInfoVo.getBizType());
        netDiskInfo.setDownloadCount(netDiskInfoVo.getDownloadCount());
        return netDiskInfo;
    }


}
