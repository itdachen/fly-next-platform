package com.github.itdachen.auth.service;

import com.github.itdachen.framework.context.userdetails.UserInfoDetails;

import java.util.List;
import java.util.Set;

/**
 * IRoleAuthoritiesService
 *
 * @author 王大宸
 * @date 2024-10-21 17:45
 */
public interface IRoleAuthoritiesService {

    Set<String> roleAuthorities(UserInfoDetails userInfoDetails);

}
