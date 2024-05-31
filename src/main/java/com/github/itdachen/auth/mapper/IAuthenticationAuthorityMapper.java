package com.github.itdachen.auth.mapper;

import java.util.List;
import java.util.Set;

/**
 * 用户权限
 *
 * @author 王大宸
 * @date 2024/4/29 23:22
 */
public interface IAuthenticationAuthorityMapper {


    /***
     * 获取应用所有权限
     *
     * @author 王大宸
     * @date 2024/4/29 23:55
     * @param appId appId
     * @return java.util.Set<java.lang.String>
     */
    List<String> findAppAuthority(String appId);


    List<String> findUserAuthority(String appId, List<String> list);
}
