package com.github.itdachen.admin.service;

import com.github.itdachen.admin.sdk.dto.ClazzFuncDTO;
import com.github.itdachen.admin.sdk.query.ClazzFuncQuery;
import com.github.itdachen.admin.sdk.vo.ClazzFuncVO;
import com.github.itdachen.framework.webmvc.service.IBizService;

/**
 * 岗位职能管理 业务接口
 *
 * @author 王大宸
 * @date 2025-09-18 22:27:28
 */
public interface IClazzFuncService extends IBizService< ClazzFuncDTO, ClazzFuncVO, ClazzFuncQuery, String > {

}
