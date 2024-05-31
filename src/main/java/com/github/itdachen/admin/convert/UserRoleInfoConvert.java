package com.github.itdachen.admin.convert;

import com.github.itdachen.admin.entity.UserRoleInfo;
import com.github.itdachen.admin.sdk.dto.UserRoleInfoDTO;
import com.github.itdachen.admin.sdk.vo.UserRoleInfoVO;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;

/**
 * 身份信息 类型转换
 *
 * @author 王大宸
 * @date 2024-04-27 20:42:58
 */
public class UserRoleInfoConvert implements IBizConvertMapper< UserRoleInfo, UserRoleInfoDTO, UserRoleInfoVO > {

    @Override
    public UserRoleInfo toJavaObject(UserRoleInfoDTO userRoleInfoDTO) {
        if (null == userRoleInfoDTO){
            return null;
        }
        UserRoleInfo userRoleInfo = new UserRoleInfo();
        userRoleInfo.setId(userRoleInfoDTO.getId());
        userRoleInfo.setTenantId(userRoleInfoDTO.getTenantId());
        userRoleInfo.setUserId(userRoleInfoDTO.getUserId());
        userRoleInfo.setNickName(userRoleInfoDTO.getNickName());
        userRoleInfo.setRoleName(userRoleInfoDTO.getRoleName());
        userRoleInfo.setRoleFlag(userRoleInfoDTO.getRoleFlag());
        userRoleInfo.setValidFlag(userRoleInfoDTO.getValidFlag());
        userRoleInfo.setDeptId(userRoleInfoDTO.getDeptId());
        userRoleInfo.setDeptTitle(userRoleInfoDTO.getDeptTitle());
        userRoleInfo.setStartTime(userRoleInfoDTO.getStartTime());
        userRoleInfo.setEndTime(userRoleInfoDTO.getEndTime());
        userRoleInfo.setOrderNum(userRoleInfoDTO.getOrderNum());
        userRoleInfo.setRemarks(userRoleInfoDTO.getRemarks());
        return userRoleInfo;
    }


    @Override
    public UserRoleInfoVO toJavaObjectVO(UserRoleInfo userRoleInfo) {
        if (null == userRoleInfo){
            return null;
        }
        UserRoleInfoVO userRoleInfoVO = new UserRoleInfoVO();
        userRoleInfoVO.setId(userRoleInfo.getId());
        userRoleInfoVO.setTenantId(userRoleInfo.getTenantId());
        userRoleInfoVO.setUserId(userRoleInfo.getUserId());
        userRoleInfoVO.setNickName(userRoleInfo.getNickName());
        userRoleInfoVO.setRoleName(userRoleInfo.getRoleName());
        userRoleInfoVO.setRoleFlag(userRoleInfo.getRoleFlag());
        userRoleInfoVO.setValidFlag(userRoleInfo.getValidFlag());
        userRoleInfoVO.setDeptId(userRoleInfo.getDeptId());
        userRoleInfoVO.setDeptTitle(userRoleInfo.getDeptTitle());
        userRoleInfoVO.setStartTime(userRoleInfo.getStartTime());
        userRoleInfoVO.setEndTime(userRoleInfo.getEndTime());
        userRoleInfoVO.setOrderNum(userRoleInfo.getOrderNum());
        userRoleInfoVO.setRemarks(userRoleInfo.getRemarks());
        return userRoleInfoVO;
    }

    public UserRoleInfo toJavaObject(UserRoleInfoVO userRoleInfoVO) {
        if (null == userRoleInfoVO){
            return null;
        }
        UserRoleInfo userRoleInfo = new UserRoleInfo();
        userRoleInfo.setId(userRoleInfoVO.getId());
        userRoleInfo.setTenantId(userRoleInfoVO.getTenantId());
        userRoleInfo.setUserId(userRoleInfoVO.getUserId());
        userRoleInfo.setNickName(userRoleInfoVO.getNickName());
        userRoleInfo.setRoleName(userRoleInfoVO.getRoleName());
        userRoleInfo.setRoleFlag(userRoleInfoVO.getRoleFlag());
        userRoleInfo.setValidFlag(userRoleInfoVO.getValidFlag());
        userRoleInfo.setDeptId(userRoleInfoVO.getDeptId());
        userRoleInfo.setDeptTitle(userRoleInfoVO.getDeptTitle());
        userRoleInfo.setStartTime(userRoleInfoVO.getStartTime());
        userRoleInfo.setEndTime(userRoleInfoVO.getEndTime());
        userRoleInfo.setOrderNum(userRoleInfoVO.getOrderNum());
        userRoleInfo.setRemarks(userRoleInfoVO.getRemarks());
        return userRoleInfo;
    }

    public UserRoleInfoVO toJavaObjectVO(UserRoleInfoDTO userRoleInfoDTO) {
        if (null == userRoleInfoDTO){
            return null;
        }
        UserRoleInfoVO userRoleInfoVO = new UserRoleInfoVO();
        userRoleInfoVO.setId(userRoleInfoDTO.getId());
        userRoleInfoVO.setTenantId(userRoleInfoDTO.getTenantId());
        userRoleInfoVO.setUserId(userRoleInfoDTO.getUserId());
        userRoleInfoVO.setNickName(userRoleInfoDTO.getNickName());
        userRoleInfoVO.setRoleName(userRoleInfoDTO.getRoleName());
        userRoleInfoVO.setRoleFlag(userRoleInfoDTO.getRoleFlag());
        userRoleInfoVO.setValidFlag(userRoleInfoDTO.getValidFlag());
        userRoleInfoVO.setDeptId(userRoleInfoDTO.getDeptId());
        userRoleInfoVO.setDeptTitle(userRoleInfoDTO.getDeptTitle());
        userRoleInfoVO.setStartTime(userRoleInfoDTO.getStartTime());
        userRoleInfoVO.setEndTime(userRoleInfoDTO.getEndTime());
        userRoleInfoVO.setOrderNum(userRoleInfoDTO.getOrderNum());
        userRoleInfoVO.setRemarks(userRoleInfoDTO.getRemarks());
        return userRoleInfoVO;
    }


}