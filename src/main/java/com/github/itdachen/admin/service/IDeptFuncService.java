package com.github.itdachen.admin.service;

import com.github.itdachen.admin.sdk.dto.DeptFuncDTO;
import com.github.itdachen.admin.sdk.query.DeptFuncQuery;
import com.github.itdachen.admin.sdk.vo.DeptFuncVO;
import com.github.itdachen.framework.webmvc.service.IBizService;

/**
 * 部门职能管理 业务接口
 *
 * @author 王大宸
 * @date 2025-09-18 23:03:17
 */
public interface IDeptFuncService extends IBizService< DeptFuncDTO, DeptFuncVO, DeptFuncQuery, String > {

}
