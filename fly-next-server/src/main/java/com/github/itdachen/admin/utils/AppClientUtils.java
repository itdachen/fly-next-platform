package com.github.itdachen.admin.utils;

import com.github.itdachen.framework.assets.tree.ZTreeNode;
import com.github.itdachen.framework.boot.runner.handler.ContextPathHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Created by 王大宸 on 2023/02/02 15:21
 * Created with IntelliJ IDEA.
 */
public class AppClientUtils {

    public static List<ZTreeNode> arrangeAppMenu(List<ZTreeNode> apps) {
       return arrangeAppMenu(ContextPathHandler.contextPath(), apps);
    }

    /***
     * 返回菜单树时,应用校验
     *
     * @author 王大宸
     * @date 2021/11/23 21:52
     * @param apps
     * @return java.util.List<com.itdachen.common.model.ZTreeNode>
     */
    public static List<ZTreeNode> arrangeAppMenu(String contextPath, List<ZTreeNode> apps) {
        if (null == apps || 0 == apps.size()) {
            apps = new ArrayList<>();
            apps.add(addRootZTreeNode(contextPath, "请选择菜单"));
            return apps;
        }

        apps.forEach(item -> {
            item.setOpen(true);
            item.setIconOpen(contextPath + ZTreeNode.zTreeOpenIcon);
            item.setIconClose(contextPath + ZTreeNode.zTreeCloseIcon);
        });

        if (1 < apps.size()) {
            apps.add(addRootZTreeNode(contextPath, "请选择菜单"));
        }

        return apps;
    }

    public static ZTreeNode addRootZTreeNode(String contextPath, String rootName) {
        return new ZTreeNode.Builder()
                .id(ZTreeNode.ROOT_ID)
                .name(rootName)
                .parentId(ZTreeNode.ROOT_PARENT_ID)
                .open(true)
                .openIcon(contextPath + ZTreeNode.zTreeBuMenIcon)
                .closeIcon(contextPath + ZTreeNode.zTreeJiGuoIcon)
                .build();
    }

}
