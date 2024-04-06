package com.github.itdachen.admin_v1.service;

import com.github.itdachen.admin_v1.sdk.dto.MenuInfoDto;
import com.github.itdachen.admin_v1.sdk.query.MenuInfoQuery;
import com.github.itdachen.admin_v1.sdk.vo.MenuInfoVo;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.context.tree.ZTreeNode;
import com.github.itdachen.framework.webmvc.service.IBizService;

import java.util.List;

/**
 * 菜单管理 业务接口
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
public interface IMenuInfoService extends IBizService<MenuInfoDto, MenuInfoVo, MenuInfoQuery, String> {


    /***
     * 查询菜单树
     *
     * @author 王大宸
     * @date 2023/4/5 14:26
     * @return java.util.List<com.github.itdachen.framework.context.tree.ZTreeNode>
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


    MenuInfoVo findMenuInfoVo(String id) throws Exception;

    /***
     * 获取目录菜单
     *
     * @author 王大宸
     * @date 2023/4/11 9:54
     * @return java.util.List
     */
    List<ZTreeNode> findCatalogZTree() throws BizException;

    /***
     * 查询上级菜单
     *
     * @author 王大宸
     * @date 2023/4/11 10:16
     * @param parentId parentId
     * @return java.lang.String
     */
    String findMenuParentTitle(String parentId) throws BizException;

}
