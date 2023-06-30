package com.github.itdachen.dashboard.service;

/**
 * Description: 刷新权限
 * Created by 王大宸 on 2023/05/07 0:22
 * Created with IntelliJ IDEA.
 */
public interface IRefreshAuthoritiesService {

    void refreshAuthorities(String clientId) throws Exception;

}
