package com.github.itdachen.admin.service;

import com.github.itdachen.admin.entity.PositionInfo;
import com.github.itdachen.admin.sdk.dto.PositionInfoDto;
import com.github.itdachen.admin.sdk.query.PositionInfoQuery;
import com.github.itdachen.admin.sdk.vo.PositionInfoVo;
import com.github.itdachen.framework.webmvc.service.IBizService;

/**
 * 岗位信息 业务接口
 *
 * @author 王大宸
 * @date 2023-05-15 20:13:36
 */
public interface IPositionInfoService extends IBizService< PositionInfoDto, PositionInfoVo, PositionInfoQuery, String > {

}
