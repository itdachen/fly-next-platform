package com.github.itdachen.oplog.service;

import com.github.itdachen.oplog.sdk.dto.OplogPageViewDTO;
import com.github.itdachen.oplog.sdk.query.OplogPageViewQuery;
import com.github.itdachen.oplog.sdk.vo.OplogPageViewVO;
import com.github.itdachen.framework.webmvc.service.IBizService;

/**
 * 页面访问日志 业务接口
 *
 * @author 王大宸
 * @date 2025-09-09 21:56:31
 */
public interface IOplogPageViewService extends IBizService< OplogPageViewDTO, OplogPageViewVO, OplogPageViewQuery, String > {

}
