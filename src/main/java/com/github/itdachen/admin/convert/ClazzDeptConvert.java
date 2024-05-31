package com.github.itdachen.admin.convert;

import com.github.itdachen.admin.entity.ClazzDept;
import com.github.itdachen.admin.sdk.dto.ClazzDeptDTO;
import com.github.itdachen.admin.sdk.vo.ClazzDeptVO;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;

/**
 * 部门岗位关联表 类型转换
 *
 * @author 王大宸
 * @date 2024-05-10 21:17:50
 */
public class ClazzDeptConvert implements IBizConvertMapper< ClazzDept, ClazzDeptDTO, ClazzDeptVO > {

    @Override
    public ClazzDept toJavaObject(ClazzDeptDTO clazzDeptDTO) {
        if (null == clazzDeptDTO){
            return null;
        }
        ClazzDept clazzDept = new ClazzDept();
                clazzDept.setId(clazzDeptDTO.getId());
                clazzDept.setTenantId(clazzDeptDTO.getTenantId());
                clazzDept.setAppId(clazzDeptDTO.getAppId());
                clazzDept.setDeptId(clazzDeptDTO.getDeptId());
                clazzDept.setClazzId(clazzDeptDTO.getClazzId());
                clazzDept.setClazzTitle(clazzDeptDTO.getClazzTitle());
                clazzDept.setValidFlag(clazzDeptDTO.getValidFlag());
        return clazzDept;
    }


    @Override
    public ClazzDeptVO toJavaObjectVO(ClazzDept clazzDept) {
        if (null == clazzDept){
            return null;
        }
            ClazzDeptVO clazzDeptVO = new ClazzDeptVO();
                    clazzDeptVO.setId(clazzDept.getId());
                    clazzDeptVO.setTenantId(clazzDept.getTenantId());
                    clazzDeptVO.setAppId(clazzDept.getAppId());
                    clazzDeptVO.setDeptId(clazzDept.getDeptId());
                    clazzDeptVO.setClazzId(clazzDept.getClazzId());
                    clazzDeptVO.setClazzTitle(clazzDept.getClazzTitle());
                    clazzDeptVO.setValidFlag(clazzDept.getValidFlag());
        return clazzDeptVO;
    }

    public ClazzDept toJavaObject(ClazzDeptVO clazzDeptVO) {
        if (null == clazzDeptVO){
            return null;
        }
        ClazzDept clazzDept = new ClazzDept();
                clazzDept.setId(clazzDeptVO.getId());
                clazzDept.setTenantId(clazzDeptVO.getTenantId());
                clazzDept.setAppId(clazzDeptVO.getAppId());
                clazzDept.setDeptId(clazzDeptVO.getDeptId());
                clazzDept.setClazzId(clazzDeptVO.getClazzId());
                clazzDept.setClazzTitle(clazzDeptVO.getClazzTitle());
                clazzDept.setValidFlag(clazzDeptVO.getValidFlag());
        return clazzDept;
    }

    public ClazzDeptVO toJavaObjectVO(ClazzDeptDTO clazzDeptDTO) {
        if (null == clazzDeptDTO){
            return null;
        }
            ClazzDeptVO clazzDeptVO = new ClazzDeptVO();
                    clazzDeptVO.setId(clazzDeptDTO.getId());
                    clazzDeptVO.setTenantId(clazzDeptDTO.getTenantId());
                    clazzDeptVO.setAppId(clazzDeptDTO.getAppId());
                    clazzDeptVO.setDeptId(clazzDeptDTO.getDeptId());
                    clazzDeptVO.setClazzId(clazzDeptDTO.getClazzId());
                    clazzDeptVO.setClazzTitle(clazzDeptDTO.getClazzTitle());
                    clazzDeptVO.setValidFlag(clazzDeptDTO.getValidFlag());
        return clazzDeptVO;
    }


}