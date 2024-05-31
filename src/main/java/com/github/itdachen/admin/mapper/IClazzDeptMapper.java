package com.github.itdachen.admin.mapper;

import com.github.itdachen.admin.entity.ClazzDept;
import com.github.itdachen.admin.sdk.query.ClazzDeptQuery;
import com.github.itdachen.admin.sdk.vo.ClazzDeptVO;
import com.github.itdachen.framework.context.tree.ZTreeNode;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 部门岗位关联表 持久层接口
 *
 * @author 王大宸
 * @date 2024-05-10 21:17:50
 */
public interface IClazzDeptMapper extends Mapper<ClazzDept> {

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2024-05-10 21:17:50
     * @param params params
     * @return com.github.itdachen.admin.sdk.vo.clazzDeptVO
     */
    List<ClazzDeptVO> list(ClazzDeptQuery params);

    /***
     * 查询岗位信息
     *
     * @author 王大宸
     * @date 2024/5/10 21:57
     * @param params params
     * @return java.util.List<com.github.itdachen.framework.context.tree.ZTreeNode>
     */
    List<ZTreeNode> clazzPage(ClazzDeptQuery params);

    /***
     * 根据id查询
     *
     * @author 王大宸
     * @date 2024-05-10 21:17:50
     * @param id 需要查询的数据id
     * @return com.github.itdachen.admin.sdk.vo.clazzDeptVo
     */
    ClazzDeptVO selectClazzDeptVO(String id);

    /***
     * 查询导出数据
     *
     * @author 王大宸
     * @date 2024-05-10 21:17:50
     * @param params 查询参数
     * @return java.util.LinkedHashMap
     */
    List<LinkedHashMap<String, String>> selectClazzDeptExpData(ClazzDeptQuery params);

    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2024-05-10 21:17:50
     * @param list java.util.List<com.github.itdachen.admin.entity.ClazzDept>
     */
    void batchSave(List<ClazzDept> list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2024-05-10 21:17:50
     * @param list java.util.List<com.github.itdachen.admin.entity.ClazzDept>
     */
    void batchUpdate(List<ClazzDept> list);



    /***
     * 获取有效的部门岗位
     *
     * @author 王大宸
     * @date 2024/5/15 21:00
     * @param deptId deptId
     * @return java.util.List<com.github.itdachen.framework.context.tree.ZTreeNode>
     */
    List<ZTreeNode> findClazzDept(@Param("tenantId") String tenantId,@Param("deptId")  String deptId);

}
