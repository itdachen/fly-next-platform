package com.github.itdachen.auth.mapper;

import com.github.itdachen.auth.entity.MenuRoutePo;

import java.util.List;

/**
 * Description:
 * Created by 王大宸 on 2023/05/08 21:09
 * Created with IntelliJ IDEA.
 */
public interface INextMenuMapper {

    String findIdByParentId(String parentId);

    List<MenuRoutePo> userOAuthMenuAll(String clientId, String parentId);

    List<MenuRoutePo> userOAuthMenu(String clientId, String parentId, String userId);

    List<String> permissionAll(String clientId);

    List<String> userPermission(String clientId, String userId);

}
