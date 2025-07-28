package com.github.itdachen.oplog.service;

import com.github.itdachen.oplog.sdk.dto.OplogPoiImpDTO;
import com.github.itdachen.oplog.sdk.query.OplogPoiImpQuery;
import com.github.itdachen.oplog.sdk.vo.OplogPoiImpVO;
import com.github.itdachen.framework.webmvc.service.IBizService;

/**
 * 导入日志 业务接口
 *
 * @author 王大宸
 * @date 2025-07-28 15:55:31
 */
public interface IOplogPoiImpService extends IBizService< OplogPoiImpDTO, OplogPoiImpVO, OplogPoiImpQuery, String > {

}
