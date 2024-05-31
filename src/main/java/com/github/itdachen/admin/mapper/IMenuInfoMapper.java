package com.github.itdachen.admin.mapper;

import com.github.itdachen.admin.entity.MenuInfo;
import com.github.itdachen.admin.sdk.dto.MenuInfoDTO;
import com.github.itdachen.admin.sdk.query.MenuInfoQuery;
import com.github.itdachen.admin.sdk.vo.MenuInfoVO;
import com.github.itdachen.framework.context.tree.ZTreeNode;
import tk.mybatis.mapper.common.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 菜单信息 持久层接口
 *
 * @author 王大宸
 * @date 2024-04-20 22:16:39
 */
public interface IMenuInfoMapper extends Mapper<MenuInfo> {

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2024-04-20 22:16:39
     * @param params params
     * @return com.github.itdachen.admin.sdk.vo.menuInfoVO
     */
    List<MenuInfoVO> list(MenuInfoQuery params);

    /***
     * 根据id查询
     *
     * @author 王大宸
     * @date 2024-04-20 22:16:39
     * @param id 需要查询的数据id
     * @return com.github.itdachen.admin.sdk.vo.menuInfoVo
     */
    MenuInfoVO selectMenuInfoVO(String id);

    /***
     * 查询导出数据
     *
     * @author 王大宸
     * @date 2024-04-20 22:16:39
     * @param params 查询参数
     * @return java.util.LinkedHashMap
     */
    List<LinkedHashMap<String, String>> selectMenuInfoExpData(MenuInfoQuery params);

    List<ZTreeNode> findMenuZTree(String appId);


    /***
     * 获取菜单目录树
     *
     * @author 王大宸
     * @date 2024/4/24 21:00
     * @param appId appId
     * @return java.util.List<com.github.itdachen.framework.context.tree.ZTreeNode>
     */
    List<ZTreeNode> findAppCatalogTree(String appId);

    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2024-04-20 22:16:39
     * @param list java.util.List<com.github.itdachen.admin.entity.MenuInfo>
     */
    void batchSave(List<MenuInfo> list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2024-04-20 22:16:39
     * @param list java.util.List<com.github.itdachen.admin.entity.MenuInfo>
     */
    void batchUpdate(List<MenuInfo> list);

    /***
     * 更新上级菜单
     *
     * @author 王大宸
     * @date 2024/4/22 0:17
     * @param menuInfoDTO menuInfoDTO
     * @return void
     */
    void updateParentTitle(MenuInfoDTO menuInfoDTO);


    /***
     * 获取菜单树
     *
     * @author 王大宸
     * @date 2024/5/24 16:31
     * @param parentID 上级菜单ID
     * @param list 可用的菜单集合
     * @return java.util.List<com.github.itdachen.framework.context.tree.ZTreeNode>
     */
    List<ZTreeNode> findMenuTree(String parentID, List<String> list);

}
