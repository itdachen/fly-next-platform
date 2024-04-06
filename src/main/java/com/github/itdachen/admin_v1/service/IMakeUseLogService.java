package com.github.itdachen.admin_v1.service;

import com.github.itdachen.admin_v1.sdk.dto.MakeUseLogDto;
import com.github.itdachen.admin_v1.sdk.query.MakeUseLogQuery;
import com.github.itdachen.admin_v1.sdk.vo.MakeUseLogVo;
import com.github.itdachen.framework.webmvc.service.IBizService;

/**
 * 日志表 业务接口
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:45
 */
public interface IMakeUseLogService extends IBizService<MakeUseLogDto, MakeUseLogVo, MakeUseLogQuery, String > {

}
