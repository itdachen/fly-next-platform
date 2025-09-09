package com.github.itdachen.oplog.service;

import com.github.itdachen.oplog.sdk.dto.OplogInfoDTO;
import com.github.itdachen.oplog.sdk.query.OplogInfoQuery;
import com.github.itdachen.oplog.sdk.vo.OplogInfoVO;
import com.github.itdachen.framework.webmvc.service.IBizService;

/**
 * 操作日志 业务接口
 *
 * @author 王大宸
 * @date 2025-09-09 17:52:15
 */
public interface IOplogInfoService extends IBizService< OplogInfoDTO, OplogInfoVO, OplogInfoQuery, String > {

}
