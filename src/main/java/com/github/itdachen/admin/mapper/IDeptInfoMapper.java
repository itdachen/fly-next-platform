package com.github.itdachen.admin.mapper;

import com.github.itdachen.admin.entity.DeptInfo;
import com.github.itdachen.admin.sdk.query.DeptInfoQuery;
import com.github.itdachen.admin.sdk.vo.DeptInfoVo;
import com.github.itdachen.framework.context.tree.ZTreeNode;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 部门管理 持久层接口
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:47
 */
public interface IDeptInfoMapper extends Mapper<DeptInfo> {

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:47
     * @param params params
     * @return com.github.itdachen.admin.sdk.vo.deptInfoVo
     */
    List<DeptInfoVo> page(DeptInfoQuery params);

    Integer hasChildren(String parentId);

    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:47
     * @param list java.util.List<com.github.itdachen.admin.entity.DeptInfo>
     */
    void batchSave(List<DeptInfo> list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:47
     * @param list java.util.List<com.github.itdachen.admin.entity.DeptInfo>
     */
    void batchUpdate(List<DeptInfo> list);


    /***
     * 获取根目录
     *
     * @author 王大宸
     * @date 2023/4/4 23:48
     * @return com.github.itdachen.framework.context.tree.ZTreeNode
     */
    ZTreeNode findRootDept();

    /***
     * 部门树
     *
     * @author 王大宸
     * @date 2023/4/4 23:48
     * @return java.util.List<com.github.itdachen.framework.context.tree.ZTreeNode>
     */
    List<ZTreeNode> zTree();

    /***
     * 获取集合
     *
     * @author 王大宸
     * @date 2023/5/14 22:34
     * @return java.util.List<com.github.itdachen.admin.sdk.vo.DeptInfoVo>
     */
    List<DeptInfoVo> apiDeptInfoList();

    List<DeptInfoVo> findDeptInfoList(String parentId);

}
