package com.github.itdachen.msg.convert;

import com.github.itdachen.msg.entity.MsgPool;
import com.github.itdachen.msg.sdk.dto.MsgPoolDTO;
import com.github.itdachen.msg.sdk.vo.MsgPoolVO;
import com.github.itdachen.framework.webmvc.convert.IBizConvertMapper;

/**
 * 消息池 类型转换
 *
 * @author 王大宸
 * @date 2025-07-11 22:52:18
 */
public class MsgPoolConvert implements IBizConvertMapper<MsgPool, MsgPoolDTO, MsgPoolVO> {

    @Override
    public MsgPool toJavaObject(MsgPoolDTO msgPoolDTO) {
        if (null == msgPoolDTO) {
            return null;
        }
        MsgPool msgPool = new MsgPool();
        msgPool.setId(msgPoolDTO.getId());
        msgPool.setTenantId(msgPoolDTO.getTenantId());
        msgPool.setTenantTitle(msgPoolDTO.getTenantTitle());
        msgPool.setPlatId(msgPoolDTO.getPlatId());
        msgPool.setPlatTitle(msgPoolDTO.getPlatTitle());
        msgPool.setAppId(msgPoolDTO.getAppId());
        msgPool.setAppTitle(msgPoolDTO.getAppTitle());
        msgPool.setAppVersion(msgPoolDTO.getAppVersion());
        msgPool.setUserId(msgPoolDTO.getUserId());
        msgPool.setNickName(msgPoolDTO.getNickName());
        msgPool.setRoleId(msgPoolDTO.getRoleId());
        msgPool.setRoleName(msgPoolDTO.getRoleName());
        msgPool.setProvId(msgPoolDTO.getProvId());
        msgPool.setProvTitle(msgPoolDTO.getProvTitle());
        msgPool.setCityId(msgPoolDTO.getCityId());
        msgPool.setCityTitle(msgPoolDTO.getCityTitle());
        msgPool.setCountyId(msgPoolDTO.getCountyId());
        msgPool.setCountyTitle(msgPoolDTO.getCountyTitle());
        msgPool.setDeptId(msgPoolDTO.getDeptId());
        msgPool.setDeptTitle(msgPoolDTO.getDeptTitle());
        msgPool.setDeptLevel(msgPoolDTO.getDeptLevel());
        msgPool.setDeptParentId(msgPoolDTO.getDeptParentId());
        msgPool.setHostIp(msgPoolDTO.getHostIp());
        msgPool.setHostAddress(msgPoolDTO.getHostAddress());
        msgPool.setHostOs(msgPoolDTO.getHostOs());
        msgPool.setHostBrowser(msgPoolDTO.getHostBrowser());
        msgPool.setHostUserAgent(msgPoolDTO.getHostUserAgent());
        msgPool.setMsgType(msgPoolDTO.getMsgType());
        msgPool.setMsgTypeTitle(msgPoolDTO.getMsgTypeTitle());
        msgPool.setClazzType(msgPoolDTO.getClazzType());
        msgPool.setClazzTitle(msgPoolDTO.getClazzTitle());
        msgPool.setTitle(msgPoolDTO.getTitle());
        msgPool.setContent(msgPoolDTO.getContent());
        msgPool.setReadFlag(msgPoolDTO.getReadFlag());
        msgPool.setReadTime(msgPoolDTO.getReadTime());
        msgPool.setRemoveTime(msgPoolDTO.getRemoveTime());
        msgPool.setRemoveUserId(msgPoolDTO.getRemoveUserId());
        msgPool.setRemoveNickName(msgPoolDTO.getRemoveNickName());
        msgPool.setYearly(msgPoolDTO.getYearly());
        msgPool.setMonthly(msgPoolDTO.getMonthly());
        return msgPool;
    }


    @Override
    public MsgPoolVO toJavaObjectVO(MsgPool msgPool) {
        if (null == msgPool) {
            return null;
        }
        MsgPoolVO msgPoolVO = new MsgPoolVO();
        msgPoolVO.setId(msgPool.getId());
        msgPoolVO.setTenantId(msgPool.getTenantId());
        msgPoolVO.setTenantTitle(msgPool.getTenantTitle());
        msgPoolVO.setPlatId(msgPool.getPlatId());
        msgPoolVO.setPlatTitle(msgPool.getPlatTitle());
        msgPoolVO.setAppId(msgPool.getAppId());
        msgPoolVO.setAppTitle(msgPool.getAppTitle());
        msgPoolVO.setAppVersion(msgPool.getAppVersion());
        msgPoolVO.setUserId(msgPool.getUserId());
        msgPoolVO.setNickName(msgPool.getNickName());
        msgPoolVO.setRoleId(msgPool.getRoleId());
        msgPoolVO.setRoleName(msgPool.getRoleName());
        msgPoolVO.setProvId(msgPool.getProvId());
        msgPoolVO.setProvTitle(msgPool.getProvTitle());
        msgPoolVO.setCityId(msgPool.getCityId());
        msgPoolVO.setCityTitle(msgPool.getCityTitle());
        msgPoolVO.setCountyId(msgPool.getCountyId());
        msgPoolVO.setCountyTitle(msgPool.getCountyTitle());
        msgPoolVO.setDeptId(msgPool.getDeptId());
        msgPoolVO.setDeptTitle(msgPool.getDeptTitle());
        msgPoolVO.setDeptLevel(msgPool.getDeptLevel());
        msgPoolVO.setDeptParentId(msgPool.getDeptParentId());
        msgPoolVO.setHostIp(msgPool.getHostIp());
        msgPoolVO.setHostAddress(msgPool.getHostAddress());
        msgPoolVO.setHostOs(msgPool.getHostOs());
        msgPoolVO.setHostBrowser(msgPool.getHostBrowser());
        msgPoolVO.setHostUserAgent(msgPool.getHostUserAgent());
        msgPoolVO.setMsgType(msgPool.getMsgType());
        msgPoolVO.setMsgTypeTitle(msgPool.getMsgTypeTitle());
        msgPoolVO.setClazzType(msgPool.getClazzType());
        msgPoolVO.setClazzTitle(msgPool.getClazzTitle());
        msgPoolVO.setTitle(msgPool.getTitle());
        msgPoolVO.setContent(msgPool.getContent());
        msgPoolVO.setReadFlag(msgPool.getReadFlag());
        msgPoolVO.setReadTime(msgPool.getReadTime());
        msgPoolVO.setRemoveTime(msgPool.getRemoveTime());
        msgPoolVO.setRemoveUserId(msgPool.getRemoveUserId());
        msgPoolVO.setRemoveNickName(msgPool.getRemoveNickName());
        msgPoolVO.setYearly(msgPool.getYearly());
        msgPoolVO.setMonthly(msgPool.getMonthly());
        return msgPoolVO;
    }

    public MsgPool toJavaObject(MsgPoolVO msgPoolVO) {
        if (null == msgPoolVO) {
            return null;
        }
        MsgPool msgPool = new MsgPool();
        msgPool.setId(msgPoolVO.getId());
        msgPool.setTenantId(msgPoolVO.getTenantId());
        msgPool.setTenantTitle(msgPoolVO.getTenantTitle());
        msgPool.setPlatId(msgPoolVO.getPlatId());
        msgPool.setPlatTitle(msgPoolVO.getPlatTitle());
        msgPool.setAppId(msgPoolVO.getAppId());
        msgPool.setAppTitle(msgPoolVO.getAppTitle());
        msgPool.setAppVersion(msgPoolVO.getAppVersion());
        msgPool.setUserId(msgPoolVO.getUserId());
        msgPool.setNickName(msgPoolVO.getNickName());
        msgPool.setRoleId(msgPoolVO.getRoleId());
        msgPool.setRoleName(msgPoolVO.getRoleName());
        msgPool.setProvId(msgPoolVO.getProvId());
        msgPool.setProvTitle(msgPoolVO.getProvTitle());
        msgPool.setCityId(msgPoolVO.getCityId());
        msgPool.setCityTitle(msgPoolVO.getCityTitle());
        msgPool.setCountyId(msgPoolVO.getCountyId());
        msgPool.setCountyTitle(msgPoolVO.getCountyTitle());
        msgPool.setDeptId(msgPoolVO.getDeptId());
        msgPool.setDeptTitle(msgPoolVO.getDeptTitle());
        msgPool.setDeptLevel(msgPoolVO.getDeptLevel());
        msgPool.setDeptParentId(msgPoolVO.getDeptParentId());
        msgPool.setHostIp(msgPoolVO.getHostIp());
        msgPool.setHostAddress(msgPoolVO.getHostAddress());
        msgPool.setHostOs(msgPoolVO.getHostOs());
        msgPool.setHostBrowser(msgPoolVO.getHostBrowser());
        msgPool.setHostUserAgent(msgPoolVO.getHostUserAgent());
        msgPool.setMsgType(msgPoolVO.getMsgType());
        msgPool.setMsgTypeTitle(msgPoolVO.getMsgTypeTitle());
        msgPool.setClazzType(msgPoolVO.getClazzType());
        msgPool.setClazzTitle(msgPoolVO.getClazzTitle());
        msgPool.setTitle(msgPoolVO.getTitle());
        msgPool.setContent(msgPoolVO.getContent());
        msgPool.setReadFlag(msgPoolVO.getReadFlag());
        msgPool.setReadTime(msgPoolVO.getReadTime());
        msgPool.setRemoveTime(msgPoolVO.getRemoveTime());
        msgPool.setRemoveUserId(msgPoolVO.getRemoveUserId());
        msgPool.setRemoveNickName(msgPoolVO.getRemoveNickName());
        msgPool.setYearly(msgPoolVO.getYearly());
        msgPool.setMonthly(msgPoolVO.getMonthly());
        return msgPool;
    }

    public MsgPoolVO toJavaObjectVO(MsgPoolDTO msgPoolDTO) {
        if (null == msgPoolDTO) {
            return null;
        }
        MsgPoolVO msgPoolVO = new MsgPoolVO();
        msgPoolVO.setId(msgPoolDTO.getId());
        msgPoolVO.setTenantId(msgPoolDTO.getTenantId());
        msgPoolVO.setTenantTitle(msgPoolDTO.getTenantTitle());
        msgPoolVO.setPlatId(msgPoolDTO.getPlatId());
        msgPoolVO.setPlatTitle(msgPoolDTO.getPlatTitle());
        msgPoolVO.setAppId(msgPoolDTO.getAppId());
        msgPoolVO.setAppTitle(msgPoolDTO.getAppTitle());
        msgPoolVO.setAppVersion(msgPoolDTO.getAppVersion());
        msgPoolVO.setUserId(msgPoolDTO.getUserId());
        msgPoolVO.setNickName(msgPoolDTO.getNickName());
        msgPoolVO.setRoleId(msgPoolDTO.getRoleId());
        msgPoolVO.setRoleName(msgPoolDTO.getRoleName());
        msgPoolVO.setProvId(msgPoolDTO.getProvId());
        msgPoolVO.setProvTitle(msgPoolDTO.getProvTitle());
        msgPoolVO.setCityId(msgPoolDTO.getCityId());
        msgPoolVO.setCityTitle(msgPoolDTO.getCityTitle());
        msgPoolVO.setCountyId(msgPoolDTO.getCountyId());
        msgPoolVO.setCountyTitle(msgPoolDTO.getCountyTitle());
        msgPoolVO.setDeptId(msgPoolDTO.getDeptId());
        msgPoolVO.setDeptTitle(msgPoolDTO.getDeptTitle());
        msgPoolVO.setDeptLevel(msgPoolDTO.getDeptLevel());
        msgPoolVO.setDeptParentId(msgPoolDTO.getDeptParentId());
        msgPoolVO.setHostIp(msgPoolDTO.getHostIp());
        msgPoolVO.setHostAddress(msgPoolDTO.getHostAddress());
        msgPoolVO.setHostOs(msgPoolDTO.getHostOs());
        msgPoolVO.setHostBrowser(msgPoolDTO.getHostBrowser());
        msgPoolVO.setHostUserAgent(msgPoolDTO.getHostUserAgent());
        msgPoolVO.setMsgType(msgPoolDTO.getMsgType());
        msgPoolVO.setMsgTypeTitle(msgPoolDTO.getMsgTypeTitle());
        msgPoolVO.setClazzType(msgPoolDTO.getClazzType());
        msgPoolVO.setClazzTitle(msgPoolDTO.getClazzTitle());
        msgPoolVO.setTitle(msgPoolDTO.getTitle());
        msgPoolVO.setContent(msgPoolDTO.getContent());
        msgPoolVO.setReadFlag(msgPoolDTO.getReadFlag());
        msgPoolVO.setReadTime(msgPoolDTO.getReadTime());
        msgPoolVO.setRemoveTime(msgPoolDTO.getRemoveTime());
        msgPoolVO.setRemoveUserId(msgPoolDTO.getRemoveUserId());
        msgPoolVO.setRemoveNickName(msgPoolDTO.getRemoveNickName());
        msgPoolVO.setYearly(msgPoolDTO.getYearly());
        msgPoolVO.setMonthly(msgPoolDTO.getMonthly());
        return msgPoolVO;
    }

}