package com.github.itdachen.oplog.client;

import com.github.itdachen.boot.oplog.entity.PageViewLog;
import com.github.itdachen.boot.oplog.manager.service.IPageViewClientHandler;
import com.github.itdachen.framework.context.constants.YesOrNotConstant;
import com.github.itdachen.oplog.entity.OplogPageView;
import com.github.itdachen.oplog.mapper.IOplogPageViewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * NextAdminPageViewClientHandler
 *
 * @author 王大宸
 * @date 2025/9/9 22:17
 */
@Service
public class NextAdminPageViewClientHandler implements IPageViewClientHandler {

    private final IOplogPageViewMapper pageViewMapper;

    public NextAdminPageViewClientHandler(IOplogPageViewMapper pageViewMapper) {
        this.pageViewMapper = pageViewMapper;
    }

    @Override
    public void save(PageViewLog pageViewLog) {
        OplogPageView oplogPageView = toJavaObject(pageViewLog);
        if (null == pageViewLog) {
            return;
        }
        pageViewMapper.insertSelective(oplogPageView);
    }


    public OplogPageView toJavaObject(PageViewLog pageViewLog) {
        if (null == pageViewLog) {
            return null;
        }
        OplogPageView oplogPageView = new OplogPageView();
        oplogPageView.setId(pageViewLog.getId());
        oplogPageView.setPlatId(pageViewLog.getPlatId());
        oplogPageView.setPlatTitle(pageViewLog.getPlatTitle());
        oplogPageView.setAppId(pageViewLog.getAppId());
        oplogPageView.setAppTitle(pageViewLog.getAppTitle());
        oplogPageView.setAppVersion(pageViewLog.getAppVersion());
        oplogPageView.setTenantId(pageViewLog.getTenantId());
        oplogPageView.setTenantTitle(pageViewLog.getTenantTitle());
        oplogPageView.setProvCode(pageViewLog.getProvCode());
        oplogPageView.setProvName(pageViewLog.getProvName());
        oplogPageView.setCityCode(pageViewLog.getCityCode());
        oplogPageView.setCityName(pageViewLog.getCityName());
        oplogPageView.setCountyCode(pageViewLog.getCountyCode());
        oplogPageView.setCountyName(pageViewLog.getCountyName());
        oplogPageView.setTownCode(pageViewLog.getTownCode());
        oplogPageView.setTownName(pageViewLog.getTownName());
        oplogPageView.setDeptId(pageViewLog.getDeptId());
        oplogPageView.setDeptTitle(pageViewLog.getDeptTitle());
        oplogPageView.setDeptLevel(pageViewLog.getDeptLevel());
        oplogPageView.setDeptParentId(pageViewLog.getDeptParentId());
        oplogPageView.setUserId(pageViewLog.getUserId());
        oplogPageView.setNickName(pageViewLog.getNickName());
        oplogPageView.setMenuTitle(pageViewLog.getMenuTitle());
        oplogPageView.setMenuId(pageViewLog.getMenuId());
        oplogPageView.setOpCode(pageViewLog.getOpCode());
        oplogPageView.setOpTitle(pageViewLog.getOpTitle());
        oplogPageView.setOpVersion(pageViewLog.getOpVersion());
        oplogPageView.setOpTime(pageViewLog.getOpTime());
        oplogPageView.setHostIp(pageViewLog.getHostIp());
        oplogPageView.setHostAddress(pageViewLog.getHostAddress());
        oplogPageView.setHostOs(pageViewLog.getHostOs());
        oplogPageView.setHostBrowser(pageViewLog.getHostBrowser());
        oplogPageView.setUserAgent(pageViewLog.getUserAgent());
        oplogPageView.setRequestId(pageViewLog.getRequestId());
        oplogPageView.setRequestUri(pageViewLog.getRequestUri());
        oplogPageView.setRequestMethod(pageViewLog.getRequestMethod());
        oplogPageView.setExInfo(pageViewLog.getExInfo());
        oplogPageView.setRemarks(pageViewLog.getRemarks());
        oplogPageView.setExecuteTime(pageViewLog.getExecuteTime());

        LocalDateTime opTime = pageViewLog.getOpTime();
        oplogPageView.setYearly(String.valueOf(opTime.getYear()));
        oplogPageView.setMonthly(String.valueOf(opTime.getMonthValue()));
        oplogPageView.setCreateTime(opTime);
        oplogPageView.setCreateUserId(pageViewLog.getUserId());
        oplogPageView.setCreateUser(pageViewLog.getNickName());
        oplogPageView.setUpdateTime(opTime);
        oplogPageView.setUpdateUserId(pageViewLog.getUserId());
        oplogPageView.setUpdateUser(pageViewLog.getNickName());
        oplogPageView.setRemoveFlag(YesOrNotConstant.N);

        return oplogPageView;
    }


}
