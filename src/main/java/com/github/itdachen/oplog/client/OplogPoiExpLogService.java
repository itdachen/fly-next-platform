package com.github.itdachen.oplog.client;

import com.github.itdachen.framework.context.constants.YesOrNotConstant;
import com.github.itdachen.framework.context.id.IdUtils;
import com.github.itdachen.ooxml.poi.entity.OplogPoiModel;
import com.github.itdachen.ooxml.poi.log.IOOXmlPoiExpLogClient;
import com.github.itdachen.oplog.entity.OplogPoiExp;
import com.github.itdachen.oplog.mapper.IOplogPoiExpMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 导出日志入库
 *
 * @author 王大宸
 * @date 2025/7/23 22:52
 */
@Service
public class OplogPoiExpLogService implements IOOXmlPoiExpLogClient {

    private final IOplogPoiExpMapper oplogPoiExpMapper;

    public OplogPoiExpLogService(IOplogPoiExpMapper oplogPoiExpMapper) {
        this.oplogPoiExpMapper = oplogPoiExpMapper;
    }

    @Override
    public void save(OplogPoiModel oplogPoiModel) {
        OplogPoiExp oplogPoiExp = toOplogPoiExp(oplogPoiModel);
        oplogPoiExpMapper.insertSelective(oplogPoiExp);
    }


    public OplogPoiExp toOplogPoiExp(OplogPoiModel oplogPoiModel) {
        if (null == oplogPoiModel) {
            return null;
        }
        OplogPoiExp oplogPoiExp = new OplogPoiExp();
        oplogPoiExp.setId(oplogPoiModel.getId());
        oplogPoiExp.setTenantId(oplogPoiModel.getTenantId());
        oplogPoiExp.setTenantTitle(oplogPoiModel.getTenantTitle());
        oplogPoiExp.setPlatId(oplogPoiModel.getPlatId());
        oplogPoiExp.setPlatTitle(oplogPoiModel.getPlatTitle());
        oplogPoiExp.setAppId(oplogPoiModel.getAppId());
        oplogPoiExp.setAppTitle(oplogPoiModel.getAppTitle());
        oplogPoiExp.setAppVersion(oplogPoiModel.getAppVersion());
        oplogPoiExp.setUserId(oplogPoiModel.getUserId());
        oplogPoiExp.setNickName(oplogPoiModel.getNickName());
        oplogPoiExp.setRoleId(oplogPoiModel.getRoleId());
        oplogPoiExp.setRoleName(oplogPoiModel.getRoleName());
        oplogPoiExp.setProvId(oplogPoiModel.getProvId());
        oplogPoiExp.setProvTitle(oplogPoiModel.getProvTitle());
        oplogPoiExp.setCityId(oplogPoiModel.getCityId());
        oplogPoiExp.setCityTitle(oplogPoiModel.getCityTitle());
        oplogPoiExp.setCountyId(oplogPoiModel.getCountyId());
        oplogPoiExp.setCountyTitle(oplogPoiModel.getCountyTitle());
        oplogPoiExp.setDeptId(oplogPoiModel.getDeptId());
        oplogPoiExp.setDeptTitle(oplogPoiModel.getDeptTitle());
        oplogPoiExp.setDeptLevel(oplogPoiModel.getDeptLevel());
        oplogPoiExp.setDeptParentId(oplogPoiModel.getDeptParentId());
        oplogPoiExp.setMsgId(oplogPoiModel.getMsgId());
        oplogPoiExp.setFuncId(oplogPoiModel.getFuncId());
        oplogPoiExp.setFuncTitle(oplogPoiModel.getFuncTitle());
        oplogPoiExp.setHostIp(oplogPoiModel.getHostIp());
        oplogPoiExp.setHostAddress(oplogPoiModel.getHostAddress());
        oplogPoiExp.setHostOs(oplogPoiModel.getHostOs());
        oplogPoiExp.setHostBrowser(oplogPoiModel.getHostBrowser());
        oplogPoiExp.setHostUserAgent(oplogPoiModel.getHostUserAgent());
        oplogPoiExp.setRequestId(oplogPoiModel.getRequestId());
        oplogPoiExp.setRequestUri(oplogPoiModel.getRequestUri());
        oplogPoiExp.setRequestMethod(oplogPoiModel.getRequestMethod());
        oplogPoiExp.setRequestParams(oplogPoiModel.getRequestParams());
        oplogPoiExp.setDataTotal(oplogPoiModel.getDataTotal());
        oplogPoiExp.setFileName(oplogPoiModel.getFileName());
        oplogPoiExp.setFileUrl(oplogPoiModel.getFileUrl());
        oplogPoiExp.setFileSize(oplogPoiModel.getFileSize());
        oplogPoiExp.setFileTotal(oplogPoiModel.getFileTotal());
        oplogPoiExp.setExInfo(oplogPoiModel.getExInfo());
        oplogPoiExp.setRemarks(oplogPoiModel.getRemarks());
        oplogPoiExp.setExecuteTime(oplogPoiModel.getExecuteTime());
        oplogPoiExp.setRemoveFlag(YesOrNotConstant.N);

        /* 操作时间 */
        LocalDateTime now = LocalDateTime.now();
        oplogPoiExp.setMonthly(String.valueOf(now.getMonthValue()));
        oplogPoiExp.setYearly(String.valueOf(now.getYear()));
        oplogPoiExp.setCreateTime(now);
        oplogPoiExp.setCreateUserId(oplogPoiModel.getId());
        oplogPoiExp.setCreateUser(oplogPoiModel.getNickName());
        oplogPoiExp.setUpdateTime(now);
        oplogPoiExp.setUpdateUserId(oplogPoiModel.getId());
        oplogPoiExp.setUpdateUser(oplogPoiModel.getNickName());

        if (null == oplogPoiExp.getId() || oplogPoiExp.getId().isEmpty()) {
            oplogPoiExp.setId(IdUtils.getId());
        }

        return oplogPoiExp;
    }


}
