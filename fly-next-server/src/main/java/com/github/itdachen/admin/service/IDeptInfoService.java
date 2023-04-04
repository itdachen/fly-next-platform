package com.github.itdachen.admin.service;

import com.github.itdachen.admin.entity.DeptInfo;
import com.github.itdachen.admin.sdk.query.DeptInfoQuery;
import com.github.itdachen.admin.sdk.vo.DeptInfoVo;
import com.github.itdachen.framework.webmvc.service.IBizService;

/**
 * 部门管理 业务接口
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:47
 */
public interface IDeptInfoService extends IBizService< DeptInfo, DeptInfoVo, DeptInfoQuery, String > {

}
