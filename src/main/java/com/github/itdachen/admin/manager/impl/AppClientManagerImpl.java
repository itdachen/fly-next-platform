package com.github.itdachen.admin.manager.impl;

import com.github.itdachen.admin.manager.IAppClientManager;
import com.github.itdachen.framework.context.tree.ZTreeNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Created by 王大宸 on 2023-06-25 20:02
 * Created with IntelliJ IDEA.
 */
@Component
public class AppClientManagerImpl implements IAppClientManager {

    /**
     * 项目上下文
     */
    @Value("${server.servlet.context-path:contextPath}")
    private String contextPath;


    @Override
    public List<ZTreeNode> arrangeAppMenu(List<ZTreeNode> apps) {
        return arrangeAppMenu(contextPath, apps);
    }

    @Override
    public List<ZTreeNode> arrangeAppMenu(String path, List<ZTreeNode> apps) {
        if ("contextPath".equals(path)) {
            path = "";
        }
        if (null == apps || apps.isEmpty()) {
            apps = new ArrayList<>();
            apps.add(addRootZTreeNode(path, "请选择菜单"));
            return apps;
        }

        for (ZTreeNode app : apps) {
            app.setOpen(true);
            app.setIconOpen(path + ZTreeNode.zTreeOpenIcon);
            app.setIconClose(path + ZTreeNode.zTreeCloseIcon);
        }

        if (1 < apps.size()) {
            apps.add(addRootZTreeNode(path, "请选择菜单"));
        }

        return apps;
    }

    @Override
    public ZTreeNode addRootZTreeNode(String path, String rootName) {
        if ("contextPath".equals(path)) {
            path = "";
        }
        return new ZTreeNode.Builder()
                .id(ZTreeNode.ROOT_ID)
                .name(rootName)
                .parentId(ZTreeNode.ROOT_PARENT_ID)
                .open(true)
                .openIcon(path + ZTreeNode.zTreeBuMenIcon)
                .closeIcon(path + ZTreeNode.zTreeJiGuoIcon)
                .build();
    }

}
