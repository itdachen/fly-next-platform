package com.github.itdachen.admin_v1.mapper;

import com.github.itdachen.admin_v1.entity.MenuInfo;
import com.github.itdachen.admin_v1.sdk.query.MenuInfoQuery;
import com.github.itdachen.admin_v1.sdk.vo.MenuInfoVo;
import com.github.itdachen.framework.context.tree.ZTreeNode;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 菜单管理 持久层接口
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
public interface IMenuInfoMapper extends Mapper<MenuInfo> {

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:46
     * @param params params
     * @return com.github.itdachen.admin.sdk.vo.menuInfoVo
     */
    List<MenuInfoVo> page(MenuInfoQuery params);

    List<ZTreeNode> findZTree();

    Integer haveMenu(String parentId);

    /***
     * 获取菜单目录
     *
     * @author 王大宸
     * @date 2023/4/11 9:56
     * @return java.util.List
     */
    List<ZTreeNode> zTreeCatalog();

    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:46
     * @param list java.util.List<com.github.itdachen.admin.entity.MenuInfo>
     */
    void batchSave(List<MenuInfo> list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:46
     * @param list java.util.List<com.github.itdachen.admin.entity.MenuInfo>
     */
    void batchUpdate(List<MenuInfo> list);

    MenuInfoVo findMenuInfoVo(String id);


    List<MenuInfoVo> findMenuInfoByParentId(String parentId);


}
