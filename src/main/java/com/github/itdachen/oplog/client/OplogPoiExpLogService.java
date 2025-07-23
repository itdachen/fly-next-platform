package com.github.itdachen.oplog.client;

import com.github.itdachen.framework.context.constants.YesOrNotConstant;
import com.github.itdachen.framework.context.id.IdUtils;
import com.github.itdachen.ooxml.poi.entity.PoiExpModel;
import com.github.itdachen.ooxml.poi.exp.IOplogPoiExpLogClient;
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
public class OplogPoiExpLogService implements IOplogPoiExpLogClient {

    private final IOplogPoiExpMapper oplogPoiExpMapper;

    public OplogPoiExpLogService(IOplogPoiExpMapper oplogPoiExpMapper) {
        this.oplogPoiExpMapper = oplogPoiExpMapper;
    }

    @Override
    public void save(PoiExpModel poiExpModel) {
        OplogPoiExp oplogPoiExp = toOplogPoiExp(poiExpModel);
        oplogPoiExpMapper.insertSelective(oplogPoiExp);
    }


    public OplogPoiExp toOplogPoiExp(PoiExpModel poiExpModel) {
        if (null == poiExpModel) {
            return null;
        }
        OplogPoiExp oplogPoiExp = new OplogPoiExp();
        oplogPoiExp.setId(poiExpModel.getId());
        oplogPoiExp.setTenantId(poiExpModel.getTenantId());
        oplogPoiExp.setTenantTitle(poiExpModel.getTenantTitle());
        oplogPoiExp.setPlatId(poiExpModel.getPlatId());
        oplogPoiExp.setPlatTitle(poiExpModel.getPlatTitle());
        oplogPoiExp.setAppId(poiExpModel.getAppId());
        oplogPoiExp.setAppTitle(poiExpModel.getAppTitle());
        oplogPoiExp.setAppVersion(poiExpModel.getAppVersion());
        oplogPoiExp.setUserId(poiExpModel.getUserId());
        oplogPoiExp.setNickName(poiExpModel.getNickName());
        oplogPoiExp.setRoleId(poiExpModel.getRoleId());
        oplogPoiExp.setRoleName(poiExpModel.getRoleName());
        oplogPoiExp.setProvId(poiExpModel.getProvId());
        oplogPoiExp.setProvTitle(poiExpModel.getProvTitle());
        oplogPoiExp.setCityId(poiExpModel.getCityId());
        oplogPoiExp.setCityTitle(poiExpModel.getCityTitle());
        oplogPoiExp.setCountyId(poiExpModel.getCountyId());
        oplogPoiExp.setCountyTitle(poiExpModel.getCountyTitle());
        oplogPoiExp.setDeptId(poiExpModel.getDeptId());
        oplogPoiExp.setDeptTitle(poiExpModel.getDeptTitle());
        oplogPoiExp.setDeptLevel(poiExpModel.getDeptLevel());
        oplogPoiExp.setDeptParentId(poiExpModel.getDeptParentId());
        oplogPoiExp.setMsgId(poiExpModel.getMsgId());
        oplogPoiExp.setFuncId(poiExpModel.getFuncId());
        oplogPoiExp.setFuncTitle(poiExpModel.getFuncTitle());
        oplogPoiExp.setHostIp(poiExpModel.getHostIp());
        oplogPoiExp.setHostAddress(poiExpModel.getHostAddress());
        oplogPoiExp.setHostOs(poiExpModel.getHostOs());
        oplogPoiExp.setHostBrowser(poiExpModel.getHostBrowser());
        oplogPoiExp.setHostUserAgent(poiExpModel.getHostUserAgent());
        oplogPoiExp.setRequestId(poiExpModel.getRequestId());
        oplogPoiExp.setRequestUri(poiExpModel.getRequestUri());
        oplogPoiExp.setRequestMethod(poiExpModel.getRequestMethod());
        oplogPoiExp.setRequestParams(poiExpModel.getRequestParams());
        oplogPoiExp.setDataTotal(poiExpModel.getDataTotal());
        oplogPoiExp.setFileName(poiExpModel.getFileName());
        oplogPoiExp.setFileUrl(poiExpModel.getFileUrl());
        oplogPoiExp.setFileSize(poiExpModel.getFileSize());
        oplogPoiExp.setFileTotal(poiExpModel.getFileTotal());
        oplogPoiExp.setExInfo(poiExpModel.getExInfo());
        oplogPoiExp.setRemarks(poiExpModel.getRemarks());
        oplogPoiExp.setExecuteTime(poiExpModel.getExecuteTime());
        oplogPoiExp.setRemoveFlag(YesOrNotConstant.N);

        /* 操作时间 */
        LocalDateTime now = LocalDateTime.now();
        oplogPoiExp.setMonthly(String.valueOf(now.getMonthValue()));
        oplogPoiExp.setYearly(String.valueOf(now.getYear()));
        oplogPoiExp.setCreateTime(now);
        oplogPoiExp.setCreateUserId(poiExpModel.getId());
        oplogPoiExp.setCreateUser(poiExpModel.getNickName());
        oplogPoiExp.setUpdateTime(now);
        oplogPoiExp.setUpdateUserId(poiExpModel.getId());
        oplogPoiExp.setUpdateUser(poiExpModel.getNickName());

        if (null == oplogPoiExp.getId() || oplogPoiExp.getId().isEmpty()) {
            oplogPoiExp.setId(IdUtils.getId());
        }

        return oplogPoiExp;
    }


}
