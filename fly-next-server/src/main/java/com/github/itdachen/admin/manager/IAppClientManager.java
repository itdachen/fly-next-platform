package com.github.itdachen.admin.manager;

import com.github.itdachen.framework.assets.tree.ZTreeNode;

import java.util.List;

/**
 * Description:
 * Created by 王大宸 on 2023-06-25 20:01
 * Created with IntelliJ IDEA.
 */
public interface IAppClientManager {

    List<ZTreeNode> arrangeAppMenu(List<ZTreeNode> apps);

    List<ZTreeNode> arrangeAppMenu(String contextPath, List<ZTreeNode> apps);

    ZTreeNode addRootZTreeNode(String contextPath, String rootName);

}
