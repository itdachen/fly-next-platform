package com.github.itdachen.auth.manager;

import com.github.itdachen.framework.context.userdetails.UserInfoDetails;

import java.util.List;

/**
 * 用户菜单
 *
 * @author 王大宸
 * @date 2024-05-24 16:57
 */
public interface IUserMenuManager {


    List<String> canUsableMenu(String appId, UserInfoDetails userInfoDetails);

}
