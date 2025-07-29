package com.github.itdachen.oplog.client;

import com.github.itdachen.boot.oplog.ooxml.poi.entity.OplogPoiModel;
import com.github.itdachen.boot.oplog.ooxml.poi.log.IOOXmlPoiLogClient;
import com.github.itdachen.framework.context.constants.YesOrNotConstant;
import com.github.itdachen.framework.context.id.IdUtils;
import com.github.itdachen.oplog.entity.OplogPoiExp;
import com.github.itdachen.oplog.entity.OplogPoiImp;
import com.github.itdachen.oplog.mapper.IOplogPoiExpMapper;
import com.github.itdachen.oplog.mapper.IOplogPoiImpMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 导入导出日志入库
 *
 * @author 王大宸
 * @date 2025-07-29 18:10
 */
@Service
public class FlyNextAdminOOXmlPoiLogClient implements IOOXmlPoiLogClient {

    private final IOplogPoiExpMapper oplogPoiExpMapper;
    private final IOplogPoiImpMapper oplogPoiImpMapper;

    public FlyNextAdminOOXmlPoiLogClient(IOplogPoiExpMapper oplogPoiExpMapper,
                                         IOplogPoiImpMapper oplogPoiImpMapper) {
        this.oplogPoiExpMapper = oplogPoiExpMapper;
        this.oplogPoiImpMapper = oplogPoiImpMapper;
    }


    /***
     * 导出日志入库
     *
     * @author 王大宸
     * @date 2025/7/29 18:19
     * @param oplogPoiModel oplogPoiModel
     * @return void
     */
    @Override
    public void saveOOXmlPoiExpLog(OplogPoiModel oplogPoiModel) {
        OplogPoiExp oplogPoiExp = toOplogPoiExp(oplogPoiModel);
        oplogPoiExpMapper.insertSelective(oplogPoiExp);
    }

    /***
     * 导入日志入库
     *
     * @author 王大宸
     * @date 2025/7/29 18:19
     * @param oplogPoiModel oplogPoiModel
     * @return void
     */
    @Override
    public void saveOOXmlPoiImpLog(OplogPoiModel oplogPoiModel) {
        OplogPoiImp oplogPoiImp = toOplogPoiImp(oplogPoiModel);
        oplogPoiImpMapper.insertSelective(oplogPoiImp);
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
