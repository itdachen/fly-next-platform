package com.github.itdachen.dashboard.service.impl;

import com.github.itdachen.admin.entity.MakeUseLog;
import com.github.itdachen.admin.mapper.IMakeUseLogMapper;
import com.github.itdachen.framework.oplog.entity.OplogClient;
import com.github.itdachen.framework.oplog.manager.service.IOplogClientService;
import org.springframework.stereotype.Service;

/**
 * Description: 操作日志入库
 * Created by 王大宸 on 2023/04/06 22:05
 * Created with IntelliJ IDEA.
 */
@Service
public class AdminMakeUseLogService implements IOplogClientService {

    private final IMakeUseLogMapper makeUseLogMapper;

    public AdminMakeUseLogService(IMakeUseLogMapper makeUseLogMapper) {
        this.makeUseLogMapper = makeUseLogMapper;
    }

    @Override
    public void save(OplogClient apiLogClient) {
        MakeUseLog build = MakeUseLog.builder()
                .id(apiLogClient.getId())
                .tenantId(apiLogClient.getTenantId())
                .serviceId(apiLogClient.getServiceId())
                .clientId(apiLogClient.getClientId())
                .requestId(apiLogClient.getRequestId())
                .menuTitle(apiLogClient.getMenuTitle())
                .makeUseType(apiLogClient.getMakeUseType())
                .logType(apiLogClient.getLogType())
                .makeUseIp(apiLogClient.getMakeUseIp())
                .makeUseAddress(apiLogClient.getMakeUseAddress())
                .makeUseStatus(apiLogClient.getMakeUseStatus())
                .userAgent(apiLogClient.getUserAgent())
                .requestUri(apiLogClient.getRequestUri())
                .requestMethod(apiLogClient.getRequestMethod())
                .params(apiLogClient.getParams())
                .jsonResult(apiLogClient.getJsonResult())
                .delFlag(apiLogClient.getDelFlag())
                .exception(apiLogClient.getException())
                .remarks(apiLogClient.getRemarks())
                .executeTime(apiLogClient.getExecuteTime())
                .msg(apiLogClient.getMsg())
                .createTime(apiLogClient.getCreateTime())
                .createUser(apiLogClient.getCreateUser())
                .createUserId(apiLogClient.getCreateUserId())
                .updateTime(apiLogClient.getUpdateTime())
                .updateUser(apiLogClient.getUpdateUser())
                .updateUserId(apiLogClient.getUpdateUserId())
                .build();
        makeUseLogMapper.insertSelective(build);
    }

}
