package com.github.itdachen.admin_v1.mapper;

import com.github.itdachen.admin_v1.entity.ElementInfo;
import com.github.itdachen.admin_v1.sdk.query.ElementInfoQuery;
import com.github.itdachen.admin_v1.sdk.vo.ElementInfoVo;
import com.github.itdachen.admin_v1.sdk.vo.MenuInfoVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 按钮资源 持久层接口
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:47
 */
public interface IElementInfoMapper extends Mapper<ElementInfo> {

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:47
     * @param params params
     * @return com.github.itdachen.admin.sdk.vo.elementInfoVo
     */
    List<ElementInfoVo> page(ElementInfoQuery params);

    void remove(String menuId);


    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:47
     * @param list java.util.List<com.github.itdachen.admin.entity.ElementInfo>
     */
    void batchSave(List<ElementInfo> list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:47
     * @param list java.util.List<com.github.itdachen.admin.entity.ElementInfo>
     */
    void batchUpdate(List<ElementInfo> list);

    /***
     * 根据菜单ID查询按钮, 返回菜单类型
     *
     * @author 王大宸
     * @date 2023/5/9 21:07
     * @param menuId menuId
     * @return java.util.List<com.github.itdachen.admin.sdk.vo.MenuInfoVo>
     */
    List<MenuInfoVo> findElementInfo(String menuId);

}
