package com.github.itdachen.admin.convert;

import com.github.itdachen.admin.entity.ClazzFunc;
import com.github.itdachen.admin.sdk.dto.ClazzFuncDTO;
import com.github.itdachen.admin.sdk.vo.ClazzFuncVO;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;

/**
 * 岗位职能管理 类型转换
 *
 * @author 王大宸
 * @date 2025-09-18 22:27:28
 */
public class ClazzFuncConvert implements IBizConvertMapper< ClazzFunc, ClazzFuncDTO, ClazzFuncVO > {

    @Override
    public ClazzFunc toJavaObject(ClazzFuncDTO clazzFuncDTO) {
        if (null == clazzFuncDTO){
            return null;
        }
        ClazzFunc clazzFunc = new ClazzFunc();
                clazzFunc.setId(clazzFuncDTO.getId());
                clazzFunc.setTenantId(clazzFuncDTO.getTenantId());
                clazzFunc.setFuncCode(clazzFuncDTO.getFuncCode());
                clazzFunc.setFuncTitle(clazzFuncDTO.getFuncTitle());
                clazzFunc.setValidFlag(clazzFuncDTO.getValidFlag());
                clazzFunc.setRemarks(clazzFuncDTO.getRemarks());
        return clazzFunc;
    }


    @Override
    public ClazzFuncVO toJavaObjectVO(ClazzFunc clazzFunc) {
        if (null == clazzFunc){
            return null;
        }
            ClazzFuncVO clazzFuncVO = new ClazzFuncVO();
                    clazzFuncVO.setId(clazzFunc.getId());
                    clazzFuncVO.setTenantId(clazzFunc.getTenantId());
                    clazzFuncVO.setFuncCode(clazzFunc.getFuncCode());
                    clazzFuncVO.setFuncTitle(clazzFunc.getFuncTitle());
                    clazzFuncVO.setValidFlag(clazzFunc.getValidFlag());
                    clazzFuncVO.setRemarks(clazzFunc.getRemarks());
        return clazzFuncVO;
    }

    public ClazzFunc toJavaObject(ClazzFuncVO clazzFuncVO) {
        if (null == clazzFuncVO){
            return null;
        }
        ClazzFunc clazzFunc = new ClazzFunc();
                clazzFunc.setId(clazzFuncVO.getId());
                clazzFunc.setTenantId(clazzFuncVO.getTenantId());
                clazzFunc.setFuncCode(clazzFuncVO.getFuncCode());
                clazzFunc.setFuncTitle(clazzFuncVO.getFuncTitle());
                clazzFunc.setValidFlag(clazzFuncVO.getValidFlag());
                clazzFunc.setRemarks(clazzFuncVO.getRemarks());
        return clazzFunc;
    }

    public ClazzFuncVO toJavaObjectVO(ClazzFuncDTO clazzFuncDTO) {
        if (null == clazzFuncDTO){
            return null;
        }
            ClazzFuncVO clazzFuncVO = new ClazzFuncVO();
                    clazzFuncVO.setId(clazzFuncDTO.getId());
                    clazzFuncVO.setTenantId(clazzFuncDTO.getTenantId());
                    clazzFuncVO.setFuncCode(clazzFuncDTO.getFuncCode());
                    clazzFuncVO.setFuncTitle(clazzFuncDTO.getFuncTitle());
                    clazzFuncVO.setValidFlag(clazzFuncDTO.getValidFlag());
                    clazzFuncVO.setRemarks(clazzFuncDTO.getRemarks());
        return clazzFuncVO;
    }


}