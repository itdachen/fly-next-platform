package com.github.itdachen.admin.convert.impl;

import com.github.itdachen.admin.entity.NetDiskMd5;
import com.github.itdachen.admin.sdk.dto.NetDiskMd5Dto;
import com.github.itdachen.admin.sdk.vo.NetDiskMd5Vo;

/**
 * Description:
 * Created by 王大宸 on 2023/04/27 21:57
 * Created with IntelliJ IDEA.
 */
public class NetDiskMd5Convert {

    public static NetDiskMd5Vo toJavaObjectVo(NetDiskMd5Dto netDiskMd5Dto) {
        if (null == netDiskMd5Dto) {
            return null;
        }
        NetDiskMd5Vo netDiskMd5Vo = new NetDiskMd5Vo();
        netDiskMd5Vo.setId(netDiskMd5Dto.getId());
        netDiskMd5Vo.setMd5(netDiskMd5Dto.getMd5());
        netDiskMd5Vo.setRealPath(netDiskMd5Dto.getRealPath());
        netDiskMd5Vo.setUrl(netDiskMd5Dto.getUrl());
        netDiskMd5Vo.setFileName(netDiskMd5Dto.getFileName());
        netDiskMd5Vo.setFileSize(netDiskMd5Dto.getFileSize());
        netDiskMd5Vo.setFileFormat(netDiskMd5Dto.getFileFormat());
        return netDiskMd5Vo;
    }


    public static NetDiskMd5Vo toJavaObjectVo(NetDiskMd5 netDiskMd5) {
        if (null == netDiskMd5) {
            return null;
        }
        NetDiskMd5Vo netDiskMd5Vo = new NetDiskMd5Vo();
        netDiskMd5Vo.setId(netDiskMd5.getId());
        netDiskMd5Vo.setMd5(netDiskMd5.getMd5());
        netDiskMd5Vo.setRealPath(netDiskMd5.getRealPath());
        netDiskMd5Vo.setUrl(netDiskMd5.getUrl());
        netDiskMd5Vo.setFileName(netDiskMd5.getFileName());
        netDiskMd5Vo.setFileSize(netDiskMd5.getFileSize());
        netDiskMd5Vo.setFileFormat(netDiskMd5.getFileFormat());
        return netDiskMd5Vo;
    }

    public static NetDiskMd5 toJavaObject(NetDiskMd5Dto netDiskMd5Dto) {
        if (null == netDiskMd5Dto) {
            return null;
        }
        NetDiskMd5 netDiskMd5 = new NetDiskMd5();
        netDiskMd5.setId(netDiskMd5Dto.getId());
        netDiskMd5.setMd5(netDiskMd5Dto.getMd5());
        netDiskMd5.setRealPath(netDiskMd5Dto.getRealPath());
        netDiskMd5.setUrl(netDiskMd5Dto.getUrl());
        netDiskMd5.setFileName(netDiskMd5Dto.getFileName());
        netDiskMd5.setFileSize(netDiskMd5Dto.getFileSize());
        netDiskMd5.setFileFormat(netDiskMd5Dto.getFileFormat());
        return netDiskMd5;
    }

    public static NetDiskMd5 toJavaObject(NetDiskMd5Vo netDiskMd5Vo) {
        if (null == netDiskMd5Vo) {
            return null;
        }
        NetDiskMd5 netDiskMd5 = new NetDiskMd5();
        netDiskMd5.setId(netDiskMd5Vo.getId());
        netDiskMd5.setMd5(netDiskMd5Vo.getMd5());
        netDiskMd5.setRealPath(netDiskMd5Vo.getRealPath());
        netDiskMd5.setUrl(netDiskMd5Vo.getUrl());
        netDiskMd5.setFileName(netDiskMd5Vo.getFileName());
        netDiskMd5.setFileSize(netDiskMd5Vo.getFileSize());
        netDiskMd5.setFileFormat(netDiskMd5Vo.getFileFormat());
        return netDiskMd5;
    }


}
