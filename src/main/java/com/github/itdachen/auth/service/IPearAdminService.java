package com.github.itdachen.auth.service;

import com.github.itdachen.auth.entity.PearAdminRoute;
import com.github.itdachen.framework.context.userdetails.UserInfoDetails;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

/**
 * Pear Admin Layui 后台获取菜单 PearAdminRoute
 *
 * @author 王大宸
 * @date 2024/4/23 23:15
 */
public interface IPearAdminService {

    List<PearAdminRoute> pearAdminMenu(HttpServletRequest request, String appId, UserInfoDetails userInfoDetails);

}
