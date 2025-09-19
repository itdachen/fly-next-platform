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
        if (null == clazzInfoDTO) {
            return null;
        }
        ClazzInfo clazzInfo = new ClazzInfo();
        clazzInfo.setId(clazzInfoDTO.getId());
        clazzInfo.setTenantId(clazzInfoDTO.getTenantId());
        clazzInfo.setDeptFuncCode(clazzInfoDTO.getDeptFuncCode());
        clazzInfo.setDeptFuncTitle(clazzInfoDTO.getDeptFuncTitle());
        clazzInfo.setThatLevelCode(clazzInfoDTO.getThatLevelCode());
        clazzInfo.setThatLevelTitle(clazzInfoDTO.getThatLevelTitle());
        clazzInfo.setClazzFuncCode(clazzInfoDTO.getClazzFuncCode());
        clazzInfo.setClazzFuncTitle(clazzInfoDTO.getClazzFuncTitle());
        clazzInfo.setClazzCode(clazzInfoDTO.getClazzCode());
        clazzInfo.setClazzTitle(clazzInfoDTO.getClazzTitle());
        clazzInfo.setValidFlag(clazzInfoDTO.getValidFlag());
        clazzInfo.setRemarks(clazzInfoDTO.getRemarks());
        return clazzInfo;
    }


    @Override
    public ClazzInfoVO toJavaObjectVO(ClazzInfo clazzInfo) {
        if (null == clazzInfo) {
            return null;
        }
        ClazzInfoVO clazzInfoVO = new ClazzInfoVO();
        clazzInfoVO.setId(clazzInfo.getId());
        clazzInfoVO.setTenantId(clazzInfo.getTenantId());
        clazzInfoVO.setDeptFuncCode(clazzInfo.getDeptFuncCode());
        clazzInfoVO.setDeptFuncTitle(clazzInfo.getDeptFuncTitle());
        clazzInfoVO.setThatLevelCode(clazzInfo.getThatLevelCode());
        clazzInfoVO.setThatLevelTitle(clazzInfo.getThatLevelTitle());
        clazzInfoVO.setClazzFuncCode(clazzInfo.getClazzFuncCode());
        clazzInfoVO.setClazzFuncTitle(clazzInfo.getClazzFuncTitle());
        clazzInfoVO.setClazzCode(clazzInfo.getClazzCode());
        clazzInfoVO.setClazzTitle(clazzInfo.getClazzTitle());
        clazzInfoVO.setValidFlag(clazzInfo.getValidFlag());
        clazzInfoVO.setRemarks(clazzInfo.getRemarks());
        return clazzInfoVO;
    }

    public ClazzInfo toJavaObject(ClazzInfoVO clazzInfoVO) {
        if (null == clazzInfoVO) {
            return null;
        }
        ClazzInfo clazzInfo = new ClazzInfo();
        clazzInfo.setId(clazzInfoVO.getId());
        clazzInfo.setTenantId(clazzInfoVO.getTenantId());
        clazzInfo.setDeptFuncCode(clazzInfoVO.getDeptFuncCode());
        clazzInfo.setDeptFuncTitle(clazzInfoVO.getDeptFuncTitle());
        clazzInfo.setThatLevelCode(clazzInfoVO.getThatLevelCode());
        clazzInfo.setThatLevelTitle(clazzInfoVO.getThatLevelTitle());
        clazzInfo.setClazzFuncCode(clazzInfoVO.getClazzFuncCode());
        clazzInfo.setClazzFuncTitle(clazzInfoVO.getClazzFuncTitle());
        clazzInfo.setClazzCode(clazzInfoVO.getClazzCode());
        clazzInfo.setClazzTitle(clazzInfoVO.getClazzTitle());
        clazzInfo.setValidFlag(clazzInfoVO.getValidFlag());
        clazzInfo.setRemarks(clazzInfoVO.getRemarks());
        return clazzInfo;
    }

    public ClazzInfoVO toJavaObjectVO(ClazzInfoDTO clazzInfoDTO) {
        if (null == clazzInfoDTO) {
            return null;
        }
        ClazzInfoVO clazzInfoVO = new ClazzInfoVO();
        clazzInfoVO.setId(clazzInfoDTO.getId());
        clazzInfoVO.setTenantId(clazzInfoDTO.getTenantId());
        clazzInfoVO.setDeptFuncCode(clazzInfoDTO.getDeptFuncCode());
        clazzInfoVO.setDeptFuncTitle(clazzInfoDTO.getDeptFuncTitle());
        clazzInfoVO.setThatLevelCode(clazzInfoDTO.getThatLevelCode());
        clazzInfoVO.setThatLevelTitle(clazzInfoDTO.getThatLevelTitle());
        clazzInfoVO.setClazzFuncCode(clazzInfoDTO.getClazzFuncCode());
        clazzInfoVO.setClazzFuncTitle(clazzInfoDTO.getClazzFuncTitle());
        clazzInfoVO.setClazzCode(clazzInfoDTO.getClazzCode());
        clazzInfoVO.setClazzTitle(clazzInfoDTO.getClazzTitle());
        clazzInfoVO.setValidFlag(clazzInfoDTO.getValidFlag());
        clazzInfoVO.setRemarks(clazzInfoDTO.getRemarks());
        return clazzInfoVO;
    }


}