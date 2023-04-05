package com.github.itdachen.admin.service;

import com.github.itdachen.admin.entity.MenuInfo;
import com.github.itdachen.admin.sdk.query.MenuInfoQuery;
import com.github.itdachen.admin.sdk.vo.MenuInfoVo;
import com.github.itdachen.framework.assets.tree.ZTreeNode;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.webmvc.service.IBizService;

import java.util.List;

/**
 * 菜单管理 业务接口
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
public interface IMenuInfoService extends IBizService<MenuInfo, MenuInfoVo, MenuInfoQuery, String> {


    /***
     * 查询菜单树
     *
     * @author 王大宸
     * @date 2023/4/5 14:26
     * @return java.util.List<com.github.itdachen.framework.assets.tree.ZTreeNode>
     */
    List<ZTreeNode> zTree();

    /***
     * 修改状态
     *
     * @author 王大宸
     * @date 2023/4/5 14:26
     * @param id id
     * @param status status
     * @return MenuVo
     */
    MenuInfoVo updateStatus(String id, Boolean status) throws BizException;


}
