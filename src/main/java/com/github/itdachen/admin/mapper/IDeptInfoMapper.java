package com.github.itdachen.admin.mapper;

import com.github.itdachen.admin.entity.DeptInfo;
import com.github.itdachen.admin.sdk.query.DeptInfoQuery;
import com.github.itdachen.admin.sdk.vo.DeptInfoVO;
import com.github.itdachen.framework.context.tree.ZTreeNode;
import tk.mybatis.mapper.common.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 部门信息 持久层接口
 *
 * @author 王大宸
 * @date 2024-04-24 21:47:25
 */
public interface IDeptInfoMapper extends Mapper<DeptInfo> {

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2024-04-24 21:47:25
     * @param params params
     * @return com.github.itdachen.admin.sdk.vo.deptInfoVO
     */
    List<DeptInfoVO> list(DeptInfoQuery params);

    /***
     * 获取部门树信息
     *
     * @author 王大宸
     * @date 2024/4/24 22:32
     * @return java.util.List<com.github.itdachen.framework.context.tree.ZTreeNode>
     */
    List<ZTreeNode> findValidFlagDeptInfoTree(String tenantId, String parentId);

    /***
     * 根据id查询
     *
     * @author 王大宸
     * @date 2024-04-24 21:47:25
     * @param id 需要查询的数据id
     * @return com.github.itdachen.admin.sdk.vo.deptInfoVo
     */
    DeptInfoVO selectDeptInfoVO(String id);

    Integer hasDeptChildren(String deptId);

    /***
     * 查询导出数据
     *
     * @author 王大宸
     * @date 2024-04-24 21:47:25
     * @param params 查询参数
     * @return java.util.LinkedHashMap
     */
    List<LinkedHashMap<String, String>> selectDeptInfoExpData(DeptInfoQuery params);

    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2024-04-24 21:47:25
     * @param list java.util.List<com.github.itdachen.admin.entity.DeptInfo>
     */
    void batchSave(List<DeptInfo> list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2024-04-24 21:47:25
     * @param list java.util.List<com.github.itdachen.admin.entity.DeptInfo>
     */
    void batchUpdate(List<DeptInfo> list);

}
