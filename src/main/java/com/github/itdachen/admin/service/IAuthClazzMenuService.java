package com.github.itdachen.admin.service;

import com.github.itdachen.admin.sdk.dto.AuthClazzMenuDTO;
import com.github.itdachen.admin.sdk.query.AuthClazzMenuQuery;
import com.github.itdachen.admin.sdk.vo.AuthClazzMenuVO;
import com.github.itdachen.framework.webmvc.service.IBizService;

/**
 * 岗位菜单 业务接口
 *
 * @author 王大宸
 * @date 2024-05-15 21:32:13
 */
public interface IAuthClazzMenuService extends IBizService< AuthClazzMenuDTO, AuthClazzMenuVO, AuthClazzMenuQuery, String > {

}
