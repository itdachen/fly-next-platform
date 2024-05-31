package com.github.itdachen.admin.convert;

import com.github.itdachen.admin.entity.DeptType;
import com.github.itdachen.admin.sdk.dto.DeptTypeDTO;
import com.github.itdachen.admin.sdk.vo.DeptTypeVO;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;

/**
 * 部门类型管理 类型转换
 *
 * @author 王大宸
 * @date 2024-04-24 21:47:25
 */
public class DeptTypeConvert implements IBizConvertMapper< DeptType, DeptTypeDTO, DeptTypeVO > {

    @Override
    public DeptType toJavaObject(DeptTypeDTO deptTypeDTO) {
        if (null == deptTypeDTO){
            return null;
        }
        DeptType deptType = new DeptType();
                deptType.setId(deptTypeDTO.getId());
                deptType.setTitle(deptTypeDTO.getTitle());
                deptType.setValidFlag(deptTypeDTO.getValidFlag());
                deptType.setRemarks(deptTypeDTO.getRemarks());
        return deptType;
    }


    @Override
    public DeptTypeVO toJavaObjectVO(DeptType deptType) {
        if (null == deptType){
            return null;
        }
            DeptTypeVO deptTypeVO = new DeptTypeVO();
                    deptTypeVO.setId(deptType.getId());
                    deptTypeVO.setTitle(deptType.getTitle());
                    deptTypeVO.setValidFlag(deptType.getValidFlag());
                    deptTypeVO.setRemarks(deptType.getRemarks());
        return deptTypeVO;
    }

    public DeptType toJavaObject(DeptTypeVO deptTypeVO) {
        if (null == deptTypeVO){
            return null;
        }
        DeptType deptType = new DeptType();
                deptType.setId(deptTypeVO.getId());
                deptType.setTitle(deptTypeVO.getTitle());
                deptType.setValidFlag(deptTypeVO.getValidFlag());
                deptType.setRemarks(deptTypeVO.getRemarks());
        return deptType;
    }

    public DeptTypeVO toJavaObjectVO(DeptTypeDTO deptTypeDTO) {
        if (null == deptTypeDTO){
            return null;
        }
            DeptTypeVO deptTypeVO = new DeptTypeVO();
                    deptTypeVO.setId(deptTypeDTO.getId());
                    deptTypeVO.setTitle(deptTypeDTO.getTitle());
                    deptTypeVO.setValidFlag(deptTypeDTO.getValidFlag());
                    deptTypeVO.setRemarks(deptTypeDTO.getRemarks());
        return deptTypeVO;
    }


}