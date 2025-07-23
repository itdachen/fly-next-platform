package com.github.itdachen.oplog.service;

import com.github.itdachen.oplog.sdk.dto.OplogPoiExpDTO;
import com.github.itdachen.oplog.sdk.query.OplogPoiExpQuery;
import com.github.itdachen.oplog.sdk.vo.OplogPoiExpVO;
import com.github.itdachen.framework.webmvc.service.IBizService;

/**
 * 导出日志 业务接口
 *
 * @author 王大宸
 * @date 2025-07-23 23:06:08
 */
public interface IOplogPoiExpService extends IBizService< OplogPoiExpDTO, OplogPoiExpVO, OplogPoiExpQuery, String > {

}
