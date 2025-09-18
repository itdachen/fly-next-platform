package com.github.itdachen.admin.service;

import com.github.itdachen.admin.sdk.dto.DeptLevelDTO;
import com.github.itdachen.admin.sdk.query.DeptLevelQuery;
import com.github.itdachen.admin.sdk.vo.DeptLevelVO;
import com.github.itdachen.framework.webmvc.service.IBizService;

/**
 * 部门等级 业务接口
 *
 * @author 王大宸
 * @date 2025-09-18 22:02:49
 */
public interface IDeptLevelService extends IBizService< DeptLevelDTO, DeptLevelVO, DeptLevelQuery, String > {

}
