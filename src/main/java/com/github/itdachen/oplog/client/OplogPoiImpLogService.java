package com.github.itdachen.oplog.client;

import com.github.itdachen.framework.context.constants.YesOrNotConstant;
import com.github.itdachen.framework.context.id.IdUtils;
import com.github.itdachen.ooxml.poi.entity.OplogPoiModel;
import com.github.itdachen.ooxml.poi.log.IOOXmlPoiImpLogClient;
import com.github.itdachen.oplog.entity.OplogPoiImp;
import com.github.itdachen.oplog.mapper.IOplogPoiImpMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 导入日志入库
 *
 * @author 王大宸
 * @date 2025-07-28 15:45
 */
@Service
public class OplogPoiImpLogService implements IOOXmlPoiImpLogClient {

    private final IOplogPoiImpMapper oplogPoiImpMapper;

    public OplogPoiImpLogService(IOplogPoiImpMapper oplogPoiImpMapper) {
        this.oplogPoiImpMapper = oplogPoiImpMapper;
    }

    @Override
    public void save(OplogPoiModel oplogPoiModel) {
        OplogPoiImp oplogPoiImp = toOplogPoiImp(oplogPoiModel);
        oplogPoiImpMapper.insertSelective(oplogPoiImp);
    }


    public OplogPoiImp toOplogPoiImp(OplogPoiModel oplogPoiModel) {
        if (null == oplogPoiModel) {
            return null;
        }
        OplogPoiImp oplogPoiImp = new OplogPoiImp();
        oplogPoiImp.setId(oplogPoiModel.getId());
        oplogPoiImp.setTenantId(oplogPoiModel.getTenantId());
        oplogPoiImp.setTenantTitle(oplogPoiModel.getTenantTitle());
        oplogPoiImp.setPlatId(oplogPoiModel.getPlatId());
        oplogPoiImp.setPlatTitle(oplogPoiModel.getPlatTitle());
        oplogPoiImp.setAppId(oplogPoiModel.getAppId());
        oplogPoiImp.setAppTitle(oplogPoiModel.getAppTitle());
        oplogPoiImp.setAppVersion(oplogPoiModel.getAppVersion());
        oplogPoiImp.setUserId(oplogPoiModel.getUserId());
        oplogPoiImp.setNickName(oplogPoiModel.getNickName());
        oplogPoiImp.setRoleId(oplogPoiModel.getRoleId());
        oplogPoiImp.setRoleName(oplogPoiModel.getRoleName());
        oplogPoiImp.setProvId(oplogPoiModel.getProvId());
        oplogPoiImp.setProvTitle(oplogPoiModel.getProvTitle());
        oplogPoiImp.setCityId(oplogPoiModel.getCityId());
        oplogPoiImp.setCityTitle(oplogPoiModel.getCityTitle());
        oplogPoiImp.setCountyId(oplogPoiModel.getCountyId());
        oplogPoiImp.setCountyTitle(oplogPoiModel.getCountyTitle());
        oplogPoiImp.setDeptId(oplogPoiModel.getDeptId());
        oplogPoiImp.setDeptTitle(oplogPoiModel.getDeptTitle());
        oplogPoiImp.setDeptLevel(oplogPoiModel.getDeptLevel());
        oplogPoiImp.setDeptParentId(oplogPoiModel.getDeptParentId());
        oplogPoiImp.setMsgId(oplogPoiModel.getMsgId());
        oplogPoiImp.setFuncId(oplogPoiModel.getFuncId());
        oplogPoiImp.setFuncTitle(oplogPoiModel.getFuncTitle());
        oplogPoiImp.setHostIp(oplogPoiModel.getHostIp());
        oplogPoiImp.setHostAddress(oplogPoiModel.getHostAddress());
        oplogPoiImp.setHostOs(oplogPoiModel.getHostOs());
        oplogPoiImp.setHostBrowser(oplogPoiModel.getHostBrowser());
        oplogPoiImp.setHostUserAgent(oplogPoiModel.getHostUserAgent());
        oplogPoiImp.setRequestId(oplogPoiModel.getRequestId());
        oplogPoiImp.setRequestUri(oplogPoiModel.getRequestUri());
        oplogPoiImp.setRequestMethod(oplogPoiModel.getRequestMethod());
        oplogPoiImp.setRequestParams(oplogPoiModel.getRequestParams());
        oplogPoiImp.setDataTotal(oplogPoiModel.getDataTotal());
        oplogPoiImp.setFileName(oplogPoiModel.getFileName());
        oplogPoiImp.setFileUrl(oplogPoiModel.getFileUrl());
        oplogPoiImp.setFileSize(oplogPoiModel.getFileSize());
        oplogPoiImp.setFileTotal(oplogPoiModel.getFileTotal());
        oplogPoiImp.setExInfo(oplogPoiModel.getExInfo());
        oplogPoiImp.setRemarks(oplogPoiModel.getRemarks());
        oplogPoiImp.setExecuteTime(oplogPoiModel.getExecuteTime());
        oplogPoiImp.setRemoveFlag(YesOrNotConstant.N);

        /* 操作时间 */
        LocalDateTime now = LocalDateTime.now();
        oplogPoiImp.setMonthly(String.valueOf(now.getMonthValue()));
        oplogPoiImp.setYearly(String.valueOf(now.getYear()));
        oplogPoiImp.setCreateTime(now);
        oplogPoiImp.setCreateUserId(oplogPoiModel.getId());
        oplogPoiImp.setCreateUser(oplogPoiModel.getNickName());
        oplogPoiImp.setUpdateTime(now);
        oplogPoiImp.setUpdateUserId(oplogPoiModel.getId());
        oplogPoiImp.setUpdateUser(oplogPoiModel.getNickName());

        if (null == oplogPoiImp.getId() || oplogPoiImp.getId().isEmpty()) {
            oplogPoiImp.setId(IdUtils.getId());
        }

        return oplogPoiImp;
    }


}
