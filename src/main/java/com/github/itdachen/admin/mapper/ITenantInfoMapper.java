package com.github.itdachen.admin.mapper;

import com.github.itdachen.admin.entity.TenantInfo;
import com.github.itdachen.admin.sdk.query.TenantInfoQuery;
import com.github.itdachen.admin.sdk.vo.TenantInfoVO;
import com.github.itdachen.framework.context.tree.ZTreeNode;
import tk.mybatis.mapper.common.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 租户/公司信息 持久层接口
 *
 * @author 王大宸
 * @date 2024-04-24 22:42:35
 */
public interface ITenantInfoMapper extends Mapper<TenantInfo> {

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2024-04-24 22:42:35
     * @param params params
     * @return com.github.itdachen.admin.sdk.vo.tenantInfoVO
     */
    List<TenantInfoVO> list(TenantInfoQuery params);

    /***
     * 获取下级树
     *
     * @author 王大宸
     * @date 2024/4/24 23:32
     * @param parentId parentId
     * @return java.util.List<com.github.itdachen.framework.context.tree.ZTreeNode>
     */
    List<ZTreeNode> findTenantChildrenTree(String parentId);

    /***
     * 获取下级树
     *
     * @author 王大宸
     * @date 2024/4/24 23:32
     * @return java.util.List<com.github.itdachen.framework.context.tree.ZTreeNode>
     */
    List<ZTreeNode> findTenantTree();

    /***
     * 根据id查询
     *
     * @author 王大宸
     * @date 2024-04-24 22:42:35
     * @param id 需要查询的数据id
     * @return com.github.itdachen.admin.sdk.vo.tenantInfoVo
     */
    TenantInfoVO selectTenantInfoVO(String id);

    /***
     * 获取已经存在的租户数量
     *
     * @author 王大宸
     * @date 2024/5/6 22:25
     * @return java.lang.Integer
     */
    Integer findTenantInfoCount();

    /***
     * 查询导出数据
     *
     * @author 王大宸
     * @date 2024-04-24 22:42:35
     * @param params 查询参数
     * @return java.util.LinkedHashMap
     */
    List<LinkedHashMap<String, String>> selectTenantInfoExpData(TenantInfoQuery params);

    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2024-04-24 22:42:35
     * @param list java.util.List<com.github.itdachen.admin.entity.TenantInfo>
     */
    void batchSave(List<TenantInfo> list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2024-04-24 22:42:35
     * @param list java.util.List<com.github.itdachen.admin.entity.TenantInfo>
     */
    void batchUpdate(List<TenantInfo> list);

}
