package com.github.itdachen.admin.mapper;

import com.github.itdachen.admin.entity.ElementInfo;
import com.github.itdachen.admin.sdk.dto.MenuInfoDTO;
import com.github.itdachen.admin.sdk.query.ElementInfoQuery;
import com.github.itdachen.admin.sdk.vo.ElementInfoVO;
import com.github.itdachen.framework.context.tree.ZTreeNode;
import tk.mybatis.mapper.common.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 认证资源信息(按钮信息) 持久层接口
 *
 * @author 王大宸
 * @date 2024-04-20 22:16:39
 */
public interface IElementInfoMapper extends Mapper<ElementInfo> {

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2024-04-20 22:16:39
     * @param params params
     * @return com.github.itdachen.admin.sdk.vo.elementInfoVO
     */
    List<ElementInfoVO> list(ElementInfoQuery params);

    /***
     * 根据id查询
     *
     * @author 王大宸
     * @date 2024-04-20 22:16:39
     * @param id 需要查询的数据id
     * @return com.github.itdachen.admin.sdk.vo.elementInfoVo
     */
    ElementInfoVO selectElementInfoVO(String id);

    /***
     * 更新菜单标题
     *
     * @author 王大宸
     * @date 2024/4/22 0:17
     * @param menuInfoDTO menuInfoDTO
     * @return void
     */
    void updateMenuTitle(MenuInfoDTO menuInfoDTO);

    /***
     * 查询导出数据
     *
     * @author 王大宸
     * @date 2024-04-20 22:16:39
     * @param params 查询参数
     * @return java.util.LinkedHashMap
     */
    List<LinkedHashMap<String, String>> selectElementInfoExpData(ElementInfoQuery params);

    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2024-04-20 22:16:39
     * @param list java.util.List<com.github.itdachen.admin.entity.ElementInfo>
     */
    void batchSave(List<ElementInfo> list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2024-04-20 22:16:39
     * @param list java.util.List<com.github.itdachen.admin.entity.ElementInfo>
     */
    void batchUpdate(List<ElementInfo> list);

    List<ZTreeNode> findElementInfoTree(String menuId);

    List<ZTreeNode> findElementInfoAllTree();

    List<ZTreeNode> findElementInfoVTree(String menuId, List<String> list);

}
