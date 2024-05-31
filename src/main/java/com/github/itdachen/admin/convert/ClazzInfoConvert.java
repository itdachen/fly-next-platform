package com.github.itdachen.admin.convert;

import com.github.itdachen.admin.entity.ClazzInfo;
import com.github.itdachen.admin.sdk.dto.ClazzInfoDTO;
import com.github.itdachen.admin.sdk.vo.ClazzInfoVO;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;

/**
 * 岗位信息 类型转换
 *
 * @author 王大宸
 * @date 2024-04-25 22:40:02
 */
public class ClazzInfoConvert implements IBizConvertMapper<ClazzInfo, ClazzInfoDTO, ClazzInfoVO> {

    @Override
    public ClazzInfo toJavaObject(ClazzInfoDTO clazzInfoDTO) {
        if (null == clazzInfoDTO){
            return null;
        }
        ClazzInfo clazzInfo = new ClazzInfo();
        clazzInfo.setId(clazzInfoDTO.getId());
        clazzInfo.setPlatId(clazzInfoDTO.getPlatId());
        clazzInfo.setAppId(clazzInfoDTO.getAppId());
        clazzInfo.setTenantId(clazzInfoDTO.getTenantId());
        clazzInfo.setDeptId(clazzInfoDTO.getDeptId());
        clazzInfo.setDeptTitle(clazzInfoDTO.getDeptTitle());
        clazzInfo.setThatLevel(clazzInfoDTO.getThatLevel());
        clazzInfo.setThatLevelTitle(clazzInfoDTO.getThatLevelTitle());
        clazzInfo.setTypeId(clazzInfoDTO.getTypeId());
        clazzInfo.setTypeTitle(clazzInfoDTO.getTypeTitle());
        clazzInfo.setTitle(clazzInfoDTO.getTitle());
        clazzInfo.setValidFlag(clazzInfoDTO.getValidFlag());
        clazzInfo.setRemarks(clazzInfoDTO.getRemarks());
        return clazzInfo;
    }


    @Override
    public ClazzInfoVO toJavaObjectVO(ClazzInfo clazzInfo) {
        if (null == clazzInfo){
            return null;
        }
        ClazzInfoVO clazzInfoVO = new ClazzInfoVO();
        clazzInfoVO.setId(clazzInfo.getId());
        clazzInfoVO.setPlatId(clazzInfo.getPlatId());
        clazzInfoVO.setAppId(clazzInfo.getAppId());
        clazzInfoVO.setTenantId(clazzInfo.getTenantId());
        clazzInfoVO.setDeptId(clazzInfo.getDeptId());
        clazzInfoVO.setDeptTitle(clazzInfo.getDeptTitle());
        clazzInfoVO.setThatLevel(clazzInfo.getThatLevel());
        clazzInfoVO.setThatLevelTitle(clazzInfo.getThatLevelTitle());
        clazzInfoVO.setTypeId(clazzInfo.getTypeId());
        clazzInfoVO.setTypeTitle(clazzInfo.getTypeTitle());
        clazzInfoVO.setTitle(clazzInfo.getTitle());
        clazzInfoVO.setValidFlag(clazzInfo.getValidFlag());
        clazzInfoVO.setRemarks(clazzInfo.getRemarks());
        return clazzInfoVO;
    }

    public ClazzInfo toJavaObject(ClazzInfoVO clazzInfoVO) {
        if (null == clazzInfoVO){
            return null;
        }
        ClazzInfo clazzInfo = new ClazzInfo();
        clazzInfo.setId(clazzInfoVO.getId());
        clazzInfo.setPlatId(clazzInfoVO.getPlatId());
        clazzInfo.setAppId(clazzInfoVO.getAppId());
        clazzInfo.setTenantId(clazzInfoVO.getTenantId());
        clazzInfo.setDeptId(clazzInfoVO.getDeptId());
        clazzInfo.setDeptTitle(clazzInfoVO.getDeptTitle());
        clazzInfo.setThatLevel(clazzInfoVO.getThatLevel());
        clazzInfo.setThatLevelTitle(clazzInfoVO.getThatLevelTitle());
        clazzInfo.setTypeId(clazzInfoVO.getTypeId());
        clazzInfo.setTypeTitle(clazzInfoVO.getTypeTitle());
        clazzInfo.setTitle(clazzInfoVO.getTitle());
        clazzInfo.setValidFlag(clazzInfoVO.getValidFlag());
        clazzInfo.setRemarks(clazzInfoVO.getRemarks());
        return clazzInfo;
    }

    public ClazzInfoVO toJavaObjectVO(ClazzInfoDTO clazzInfoDTO) {
        if (null == clazzInfoDTO){
            return null;
        }
        ClazzInfoVO clazzInfoVO = new ClazzInfoVO();
        clazzInfoVO.setId(clazzInfoDTO.getId());
        clazzInfoVO.setPlatId(clazzInfoDTO.getPlatId());
        clazzInfoVO.setAppId(clazzInfoDTO.getAppId());
        clazzInfoVO.setTenantId(clazzInfoDTO.getTenantId());
        clazzInfoVO.setDeptId(clazzInfoDTO.getDeptId());
        clazzInfoVO.setDeptTitle(clazzInfoDTO.getDeptTitle());
        clazzInfoVO.setThatLevel(clazzInfoDTO.getThatLevel());
        clazzInfoVO.setThatLevelTitle(clazzInfoDTO.getThatLevelTitle());
        clazzInfoVO.setTypeId(clazzInfoDTO.getTypeId());
        clazzInfoVO.setTypeTitle(clazzInfoDTO.getTypeTitle());
        clazzInfoVO.setTitle(clazzInfoDTO.getTitle());
        clazzInfoVO.setValidFlag(clazzInfoDTO.getValidFlag());
        clazzInfoVO.setRemarks(clazzInfoDTO.getRemarks());
        return clazzInfoVO;
    }


}