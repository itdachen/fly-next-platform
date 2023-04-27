package com.github.itdachen.admin.convert;

import com.github.itdachen.admin.entity.DeptInfo;
import com.github.itdachen.admin.sdk.dto.DeptInfoDto;
import com.github.itdachen.admin.sdk.vo.DeptInfoVo;
import com.github.itdachen.framework.webmvc.convert.BizConvert;

/**
 * Description:
 * Created by 王大宸 on 2023/04/27 20:09
 * Created with IntelliJ IDEA.
 */
public class DeptInfoConvert extends BizConvert<DeptInfo, DeptInfoDto, DeptInfoVo> {

    @Override
    public DeptInfo toJavaObject(DeptInfoDto deptInfoDto) {
        if (null == deptInfoDto){
            return null;
        }
        DeptInfo deptInfo = new DeptInfo();
        deptInfo.setId(deptInfoDto.getId());
        deptInfo.setTitle(deptInfoDto.getTitle());
        deptInfo.setParentId(deptInfoDto.getParentId());
        deptInfo.setRemarks(deptInfoDto.getRemarks());
        deptInfo.setIsCanDel(deptInfoDto.getIsCanDel());
        deptInfo.setPersonCharge(deptInfoDto.getPersonCharge());
        return deptInfo;
    }


    @Override
    public DeptInfoVo toJavaObjectVo(DeptInfo deptInfo) {
        if (null == deptInfo){
            return null;
        }
        DeptInfoVo deptInfoVo = new DeptInfoVo();
        deptInfoVo.setId(deptInfo.getId());
        deptInfoVo.setTitle(deptInfo.getTitle());
        deptInfoVo.setParentId(deptInfo.getParentId());
        deptInfoVo.setRemarks(deptInfo.getRemarks());
        deptInfoVo.setIsCanDel(deptInfo.getIsCanDel());
        deptInfoVo.setPersonCharge(deptInfo.getPersonCharge());
        return deptInfoVo;
    }

    public static DeptInfo toJavaObject(DeptInfoVo deptInfoVo) {
        if (null == deptInfoVo){
            return null;
        }
        DeptInfo deptInfo = new DeptInfo();
        deptInfo.setId(deptInfoVo.getId());
        deptInfo.setTitle(deptInfoVo.getTitle());
        deptInfo.setParentId(deptInfoVo.getParentId());
        deptInfo.setRemarks(deptInfoVo.getRemarks());
        deptInfo.setIsCanDel(deptInfoVo.getIsCanDel());
        deptInfo.setPersonCharge(deptInfoVo.getPersonCharge());
        return deptInfo;
    }

    public static DeptInfoVo toJavaObjectVo(DeptInfoDto deptInfoDto) {
        if (null == deptInfoDto){
            return null;
        }
        DeptInfoVo deptInfoVo = new DeptInfoVo();
        deptInfoVo.setId(deptInfoDto.getId());
        deptInfoVo.setTitle(deptInfoDto.getTitle());
        deptInfoVo.setParentId(deptInfoDto.getParentId());
        deptInfoVo.setRemarks(deptInfoDto.getRemarks());
        deptInfoVo.setIsCanDel(deptInfoDto.getIsCanDel());
        deptInfoVo.setPersonCharge(deptInfoDto.getPersonCharge());
        return deptInfoVo;
    }

}
