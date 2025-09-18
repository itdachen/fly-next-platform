package com.github.itdachen.admin.convert;

import com.github.itdachen.admin.entity.DeptLevel;
import com.github.itdachen.admin.sdk.dto.DeptLevelDTO;
import com.github.itdachen.admin.sdk.vo.DeptLevelVO;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;

/**
 * 部门等级 类型转换
 *
 * @author 王大宸
 * @date 2025-09-18 22:02:49
 */
public class DeptLevelConvert implements IBizConvertMapper<DeptLevel, DeptLevelDTO, DeptLevelVO> {

    @Override
    public DeptLevel toJavaObject(DeptLevelDTO deptLevelDTO) {
        if (null == deptLevelDTO) {
            return null;
        }
        DeptLevel deptLevel = new DeptLevel();
        deptLevel.setId(deptLevelDTO.getId());
        deptLevel.setTenantId(deptLevelDTO.getTenantId());
        deptLevel.setLevelCode(deptLevelDTO.getLevelCode());
        deptLevel.setLevelTitle(deptLevelDTO.getLevelTitle());
        deptLevel.setValidFlag(deptLevelDTO.getValidFlag());
        deptLevel.setRemarks(deptLevelDTO.getRemarks());
        return deptLevel;
    }


    @Override
    public DeptLevelVO toJavaObjectVO(DeptLevel deptLevel) {
        if (null == deptLevel) {
            return null;
        }
        DeptLevelVO deptLevelVO = new DeptLevelVO();
        deptLevelVO.setId(deptLevel.getId());
        deptLevelVO.setTenantId(deptLevel.getTenantId());
        deptLevelVO.setLevelCode(deptLevel.getLevelCode());
        deptLevelVO.setLevelTitle(deptLevel.getLevelTitle());
        deptLevelVO.setValidFlag(deptLevel.getValidFlag());
        deptLevelVO.setRemarks(deptLevel.getRemarks());
        return deptLevelVO;
    }

    public DeptLevel toJavaObject(DeptLevelVO deptLevelVO) {
        if (null == deptLevelVO) {
            return null;
        }
        DeptLevel deptLevel = new DeptLevel();
        deptLevel.setId(deptLevelVO.getId());
        deptLevel.setTenantId(deptLevelVO.getTenantId());
        deptLevel.setLevelCode(deptLevelVO.getLevelCode());
        deptLevel.setLevelTitle(deptLevelVO.getLevelTitle());
        deptLevel.setValidFlag(deptLevelVO.getValidFlag());
        deptLevel.setRemarks(deptLevelVO.getRemarks());
        return deptLevel;
    }

    public DeptLevelVO toJavaObjectVO(DeptLevelDTO deptLevelDTO) {
        if (null == deptLevelDTO) {
            return null;
        }
        DeptLevelVO deptLevelVO = new DeptLevelVO();
        deptLevelVO.setId(deptLevelDTO.getId());
        deptLevelVO.setTenantId(deptLevelDTO.getTenantId());
        deptLevelVO.setLevelCode(deptLevelDTO.getLevelCode());
        deptLevelVO.setLevelTitle(deptLevelDTO.getLevelTitle());
        deptLevelVO.setValidFlag(deptLevelDTO.getValidFlag());
        deptLevelVO.setRemarks(deptLevelDTO.getRemarks());
        return deptLevelVO;
    }


}