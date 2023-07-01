package com.github.itdachen.dashboard.service;

import com.github.itdachen.dashboard.sdk.dto.LoginRecordDTO;
import com.github.itdachen.dashboard.sdk.query.LoginRecordQuery;
import com.github.itdachen.dashboard.sdk.vo.LoginRecordVO;
import com.github.itdachen.framework.webmvc.service.IBizService;

/**
 * 登录日志 业务接口
 *
 * @author 王大宸
 * @date 2023-06-30 22:39:02
 */
public interface ILoginRecordService extends IBizService< LoginRecordDTO, LoginRecordVO, LoginRecordQuery, String > {

}
