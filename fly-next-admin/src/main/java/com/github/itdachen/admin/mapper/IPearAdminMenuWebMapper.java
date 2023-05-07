package com.github.itdachen.admin.mapper;

import com.github.itdachen.security.user.PearAdminMenu;

import java.util.List;

/**
 * Description:
 * Created by 王大宸 on 2023/05/07 0:30
 * Created with IntelliJ IDEA.
 */
public interface IPearAdminMenuWebMapper {


    List<PearAdminMenu> findMenuAll(String parentId);

    List<PearAdminMenu> findChildrenMenu(String parentId, String userId);

}
