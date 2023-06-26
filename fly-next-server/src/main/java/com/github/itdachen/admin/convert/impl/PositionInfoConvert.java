package com.github.itdachen.admin.convert.impl;

import com.github.itdachen.admin.convert.IPositionInfoConvert;
import com.github.itdachen.admin.entity.PositionInfo;
import com.github.itdachen.admin.sdk.dto.PositionInfoDto;
import com.github.itdachen.admin.sdk.vo.PositionInfoVo;
import org.springframework.stereotype.Component;

/**
 * 岗位信息 类型转换
 *
 * @author 王大宸
 * @date 2023-05-15 20:13:36
 */
@Component
public class PositionInfoConvert implements IPositionInfoConvert {

    @Override
    public PositionInfo toJavaObject(PositionInfoDto positionInfoDto) {
        if (null == positionInfoDto) {
            return null;
        }
        PositionInfo positionInfo = new PositionInfo();
        positionInfo.setId(positionInfoDto.getId());
        positionInfo.setTenantId(positionInfoDto.getTenantId());
        positionInfo.setTitle(positionInfoDto.getTitle());
        positionInfo.setPositionCode(positionInfoDto.getPositionCode());
        positionInfo.setDeptId(positionInfoDto.getDeptId());
        positionInfo.setStatus(positionInfoDto.getStatus());
        positionInfo.setRemarks(positionInfoDto.getRemarks());
        return positionInfo;
    }


    @Override
    public PositionInfoVo toJavaObjectVo(PositionInfo positionInfo) {
        if (null == positionInfo) {
            return null;
        }
        PositionInfoVo positionInfoVo = new PositionInfoVo();
        positionInfoVo.setId(positionInfo.getId());
        positionInfoVo.setTenantId(positionInfo.getTenantId());
        positionInfoVo.setTitle(positionInfo.getTitle());
        positionInfoVo.setPositionCode(positionInfo.getPositionCode());
        positionInfoVo.setDeptId(positionInfo.getDeptId());
        positionInfoVo.setStatus(positionInfo.getStatus());
        positionInfoVo.setRemarks(positionInfo.getRemarks());
        return positionInfoVo;
    }

    public PositionInfo toJavaObject(PositionInfoVo positionInfoVo) {
        if (null == positionInfoVo) {
            return null;
        }
        PositionInfo positionInfo = new PositionInfo();
        positionInfo.setId(positionInfoVo.getId());
        positionInfo.setTenantId(positionInfoVo.getTenantId());
        positionInfo.setTitle(positionInfoVo.getTitle());
        positionInfo.setPositionCode(positionInfoVo.getPositionCode());
        positionInfo.setDeptId(positionInfoVo.getDeptId());
        positionInfo.setStatus(positionInfoVo.getStatus());
        positionInfo.setRemarks(positionInfoVo.getRemarks());
        return positionInfo;
    }

    public PositionInfoVo toJavaObjectVo(PositionInfoDto positionInfoDto) {
        if (null == positionInfoDto) {
            return null;
        }
        PositionInfoVo positionInfoVo = new PositionInfoVo();
        positionInfoVo.setId(positionInfoDto.getId());
        positionInfoVo.setTenantId(positionInfoDto.getTenantId());
        positionInfoVo.setTitle(positionInfoDto.getTitle());
        positionInfoVo.setPositionCode(positionInfoDto.getPositionCode());
        positionInfoVo.setDeptId(positionInfoDto.getDeptId());
        positionInfoVo.setStatus(positionInfoDto.getStatus());
        positionInfoVo.setRemarks(positionInfoDto.getRemarks());
        return positionInfoVo;
    }


}