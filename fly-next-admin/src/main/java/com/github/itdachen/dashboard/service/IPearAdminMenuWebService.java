package com.github.itdachen.dashboard.service;

import com.github.itdachen.dashboard.entity.PearAdminMenu;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

/**
 * Description:
 * Created by 王大宸 on 2023/05/07 0:16
 * Created with IntelliJ IDEA.
 */
public interface IPearAdminMenuWebService {


    /***
     * PearAdmin 后台管理系统
     *
     * @author 王大宸
     * @date 2023/5/6 23:55
     * @param client client
     * @return java.util.List<com.github.itdachen.admin.entity.PearAdminMenu>
     */
    List<PearAdminMenu> findPearAdminMenu(HttpServletRequest request, String client) throws Exception;


}
