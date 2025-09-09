package com.github.itdachen.oplog.client;

import com.github.itdachen.boot.oplog.entity.LogInfo;
import com.github.itdachen.boot.oplog.manager.service.IOplogClientHandler;
import com.github.itdachen.framework.context.constants.YesOrNotConstant;
import com.github.itdachen.oplog.entity.OplogInfo;
import com.github.itdachen.oplog.mapper.IOplogInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 操作日志入库
 *
 * @author 王大宸
 * @date 2025-09-09 15:35
 */
@Service
public class NextAdminOplogClientHandlerImpl implements IOplogClientHandler {
    private static final Logger logger = LoggerFactory.getLogger(NextAdminOplogClientHandlerImpl.class);

    private final IOplogInfoMapper oplogInfoMapper;

    public NextAdminOplogClientHandlerImpl(IOplogInfoMapper oplogInfoMapper) {
        this.oplogInfoMapper = oplogInfoMapper;
    }

    @Override
    public void save(LogInfo oplogClient) {
        // logger.info("操作日志信息: {}", oplogClient.toString());

        OplogInfo oplogInfo = toJavaObject(oplogClient);
        if (null != oplogInfo) {
            oplogInfoMapper.insertSelective(oplogInfo);
        }
    }


    public OplogInfo toJavaObject(LogInfo oplogInfoDTO) {
        if (null == oplogInfoDTO) {
            return null;
        }
        OplogInfo oplogInfo = new OplogInfo();
        oplogInfo.setId(oplogInfoDTO.getId());
        oplogInfo.setPlatId(oplogInfoDTO.getPlatId());
        oplogInfo.setPlatTitle(oplogInfoDTO.getPlatTitle());
        oplogInfo.setAppId(oplogInfoDTO.getAppId());
        oplogInfo.setAppTitle(oplogInfoDTO.getAppTitle());
        oplogInfo.setAppVersion(oplogInfoDTO.getAppVersion());
        oplogInfo.setTenantId(oplogInfoDTO.getTenantId());
        oplogInfo.setTenantTitle(oplogInfoDTO.getTenantTitle());
        oplogInfo.setProvCode(oplogInfoDTO.getProvCode());
        oplogInfo.setProvName(oplogInfoDTO.getProvName());
        oplogInfo.setCityCode(oplogInfoDTO.getCityCode());
        oplogInfo.setCityName(oplogInfoDTO.getCityName());
        oplogInfo.setCountyCode(oplogInfoDTO.getCountyCode());
        oplogInfo.setCountyName(oplogInfoDTO.getCountyName());
        oplogInfo.setTownCode(oplogInfoDTO.getTownCode());
        oplogInfo.setTownName(oplogInfoDTO.getTownName());
        oplogInfo.setDeptId(oplogInfoDTO.getDeptId());
        oplogInfo.setDeptTitle(oplogInfoDTO.getDeptTitle());
        oplogInfo.setDeptLevel(oplogInfoDTO.getDeptLevel());
        oplogInfo.setDeptParentId(oplogInfoDTO.getDeptParentId());
        oplogInfo.setUserId(oplogInfoDTO.getUserId());
        oplogInfo.setNickName(oplogInfoDTO.getNickName());
        oplogInfo.setMenuTitle(oplogInfoDTO.getMenuTitle());
        oplogInfo.setOpCode(oplogInfoDTO.getOpCode());
        oplogInfo.setOpTitle(oplogInfoDTO.getOpTitle());
        oplogInfo.setOpVersion(oplogInfoDTO.getOpVersion());
        oplogInfo.setOpTime(oplogInfoDTO.getOpTime());
        oplogInfo.setHostIp(oplogInfoDTO.getHostIp());
        oplogInfo.setHostAddress(oplogInfoDTO.getHostAddress());
        oplogInfo.setHostOs(oplogInfoDTO.getHostOs());
        oplogInfo.setHostBrowser(oplogInfoDTO.getHostBrowser());
        oplogInfo.setUserAgent(oplogInfoDTO.getUserAgent());
        oplogInfo.setRequestId(oplogInfoDTO.getRequestId());
        oplogInfo.setRequestUri(oplogInfoDTO.getRequestUri());
        oplogInfo.setRequestMethod(oplogInfoDTO.getRequestMethod());
        oplogInfo.setRequestParams(oplogInfoDTO.getRequestParams());
        oplogInfo.setResponseJson(oplogInfoDTO.getResponseJson());
        oplogInfo.setResponseCode(oplogInfoDTO.getResponseCode());
        oplogInfo.setResponseStatus(oplogInfoDTO.getResponseStatus());
        oplogInfo.setResponseMsg(oplogInfoDTO.getResponseMsg());
        oplogInfo.setExInfo(oplogInfoDTO.getExInfo());
        oplogInfo.setRemarks(oplogInfoDTO.getRemarks());
        oplogInfo.setExecuteTime(oplogInfoDTO.getExecuteTime());

        oplogInfo.setRemoveFlag(YesOrNotConstant.N);

        LocalDateTime opTime = oplogInfo.getOpTime();
        oplogInfo.setYearly(String.valueOf(opTime.getYear()));
        oplogInfo.setMonthly(String.valueOf(opTime.getMonthValue()));
        oplogInfo.setCreateTime(opTime);
        oplogInfo.setCreateUserId(oplogInfo.getUserId());
        oplogInfo.setCreateUser(oplogInfo.getNickName());
        oplogInfo.setUpdateTime(opTime);
        oplogInfo.setUpdateUserId(oplogInfo.getUserId());
        oplogInfo.setUpdateUser(oplogInfo.getNickName());
        return oplogInfo;
    }


}
