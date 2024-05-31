package com.github.itdachen.admin.convert;

import com.github.itdachen.admin.entity.DeptInfo;
import com.github.itdachen.admin.sdk.dto.DeptInfoDTO;
import com.github.itdachen.admin.sdk.vo.DeptInfoVO;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;

/**
 * 部门信息 类型转换
 *
 * @author 王大宸
 * @date 2024-04-24 21:47:25
 */
public class DeptInfoConvert implements IBizConvertMapper<DeptInfo, DeptInfoDTO, DeptInfoVO> {

    @Override
    public DeptInfo toJavaObject(DeptInfoDTO deptInfoDTO) {
        if (null == deptInfoDTO) {
            return null;
        }
        DeptInfo deptInfo = new DeptInfo();
        deptInfo.setId(deptInfoDTO.getId());
        deptInfo.setTenantId(deptInfoDTO.getTenantId());
        deptInfo.setParentId(deptInfoDTO.getParentId());
        deptInfo.setTitle(deptInfoDTO.getTitle());
        deptInfo.setTitleAs(deptInfoDTO.getTitleAs());
        deptInfo.setTypeId(deptInfoDTO.getTypeId());
        deptInfo.setTypeTitle(deptInfoDTO.getTypeTitle());
        deptInfo.setDeptFlag(deptInfoDTO.getDeptFlag());
        deptInfo.setThatLevel(deptInfoDTO.getThatLevel());
        deptInfo.setDeptLevel(deptInfoDTO.getDeptLevel());
        deptInfo.setTelephone(deptInfoDTO.getTelephone());
        deptInfo.setMailBox(deptInfoDTO.getMailBox());
        deptInfo.setFacsimile(deptInfoDTO.getFacsimile());
        deptInfo.setFuncCode(deptInfoDTO.getFuncCode());
        deptInfo.setProvId(deptInfoDTO.getProvId());
        deptInfo.setProvTitle(deptInfoDTO.getProvTitle());
        deptInfo.setCityId(deptInfoDTO.getCityId());
        deptInfo.setCityTitle(deptInfoDTO.getCityTitle());
        deptInfo.setCountyId(deptInfoDTO.getCountyId());
        deptInfo.setCountyTitle(deptInfoDTO.getCountyTitle());
        deptInfo.setValidFlag(deptInfoDTO.getValidFlag());
        deptInfo.setRemarks(deptInfoDTO.getRemarks());
        return deptInfo;
    }


    @Override
    public DeptInfoVO toJavaObjectVO(DeptInfo deptInfo) {
        if (null == deptInfo) {
            return null;
        }
        DeptInfoVO deptInfoVO = new DeptInfoVO();
        deptInfoVO.setId(deptInfo.getId());
        deptInfoVO.setTenantId(deptInfo.getTenantId());
        deptInfoVO.setParentId(deptInfo.getParentId());
        deptInfoVO.setTitle(deptInfo.getTitle());
        deptInfoVO.setTitleAs(deptInfo.getTitleAs());
        deptInfoVO.setTypeId(deptInfo.getTypeId());
        deptInfoVO.setTypeTitle(deptInfo.getTypeTitle());
        deptInfoVO.setDeptFlag(deptInfo.getDeptFlag());
        deptInfoVO.setThatLevel(deptInfo.getThatLevel());
        deptInfoVO.setDeptLevel(deptInfo.getDeptLevel());
        deptInfoVO.setTelephone(deptInfo.getTelephone());
        deptInfoVO.setMailBox(deptInfo.getMailBox());
        deptInfoVO.setFacsimile(deptInfo.getFacsimile());
        deptInfoVO.setFuncCode(deptInfo.getFuncCode());
        deptInfoVO.setProvId(deptInfo.getProvId());
        deptInfoVO.setProvTitle(deptInfo.getProvTitle());
        deptInfoVO.setCityId(deptInfo.getCityId());
        deptInfoVO.setCityTitle(deptInfo.getCityTitle());
        deptInfoVO.setCountyId(deptInfo.getCountyId());
        deptInfoVO.setCountyTitle(deptInfo.getCountyTitle());
        deptInfoVO.setValidFlag(deptInfo.getValidFlag());
        deptInfoVO.setRemarks(deptInfo.getRemarks());
        return deptInfoVO;
    }

    public DeptInfo toJavaObject(DeptInfoVO deptInfoVO) {
        if (null == deptInfoVO) {
            return null;
        }
        DeptInfo deptInfo = new DeptInfo();
        deptInfo.setId(deptInfoVO.getId());
        deptInfo.setTenantId(deptInfoVO.getTenantId());
        deptInfo.setParentId(deptInfoVO.getParentId());
        deptInfo.setTitle(deptInfoVO.getTitle());
        deptInfo.setTitleAs(deptInfoVO.getTitleAs());
        deptInfo.setTypeId(deptInfoVO.getTypeId());
        deptInfo.setTypeTitle(deptInfoVO.getTypeTitle());
        deptInfo.setDeptFlag(deptInfoVO.getDeptFlag());
        deptInfo.setThatLevel(deptInfoVO.getThatLevel());
        deptInfo.setDeptLevel(deptInfoVO.getDeptLevel());
        deptInfo.setTelephone(deptInfoVO.getTelephone());
        deptInfo.setMailBox(deptInfoVO.getMailBox());
        deptInfo.setFacsimile(deptInfoVO.getFacsimile());
        deptInfo.setFuncCode(deptInfoVO.getFuncCode());
        deptInfo.setProvId(deptInfoVO.getProvId());
        deptInfo.setProvTitle(deptInfoVO.getProvTitle());
        deptInfo.setCityId(deptInfoVO.getCityId());
        deptInfo.setCityTitle(deptInfoVO.getCityTitle());
        deptInfo.setCountyId(deptInfoVO.getCountyId());
        deptInfo.setCountyTitle(deptInfoVO.getCountyTitle());
        deptInfo.setValidFlag(deptInfoVO.getValidFlag());
        deptInfo.setRemarks(deptInfoVO.getRemarks());
        return deptInfo;
    }

    public DeptInfoVO toJavaObjectVO(DeptInfoDTO deptInfoDTO) {
        if (null == deptInfoDTO) {
            return null;
        }
        DeptInfoVO deptInfoVO = new DeptInfoVO();
        deptInfoVO.setId(deptInfoDTO.getId());
        deptInfoVO.setTenantId(deptInfoDTO.getTenantId());
        deptInfoVO.setParentId(deptInfoDTO.getParentId());
        deptInfoVO.setTitle(deptInfoDTO.getTitle());
        deptInfoVO.setTitleAs(deptInfoDTO.getTitleAs());
        deptInfoVO.setTypeId(deptInfoDTO.getTypeId());
        deptInfoVO.setTypeTitle(deptInfoDTO.getTypeTitle());
        deptInfoVO.setDeptFlag(deptInfoDTO.getDeptFlag());
        deptInfoVO.setThatLevel(deptInfoDTO.getThatLevel());
        deptInfoVO.setDeptLevel(deptInfoDTO.getDeptLevel());
        deptInfoVO.setTelephone(deptInfoDTO.getTelephone());
        deptInfoVO.setMailBox(deptInfoDTO.getMailBox());
        deptInfoVO.setFacsimile(deptInfoDTO.getFacsimile());
        deptInfoVO.setFuncCode(deptInfoDTO.getFuncCode());
        deptInfoVO.setProvId(deptInfoDTO.getProvId());
        deptInfoVO.setProvTitle(deptInfoDTO.getProvTitle());
        deptInfoVO.setCityId(deptInfoDTO.getCityId());
        deptInfoVO.setCityTitle(deptInfoDTO.getCityTitle());
        deptInfoVO.setCountyId(deptInfoDTO.getCountyId());
        deptInfoVO.setCountyTitle(deptInfoDTO.getCountyTitle());
        deptInfoVO.setValidFlag(deptInfoDTO.getValidFlag());
        deptInfoVO.setRemarks(deptInfoDTO.getRemarks());
        return deptInfoVO;
    }


}