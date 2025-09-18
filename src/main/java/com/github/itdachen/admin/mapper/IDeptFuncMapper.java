package com.github.itdachen.admin.mapper;

import com.github.itdachen.admin.entity.DeptFunc;
import com.github.itdachen.admin.sdk.query.DeptFuncQuery;
import com.github.itdachen.admin.sdk.vo.DeptFuncVO;
import tk.mybatis.mapper.common.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 部门职能管理 持久层接口
 *
 * @author 王大宸
 * @date 2025-09-18 23:03:17
 */
public interface IDeptFuncMapper extends Mapper< DeptFunc > {

    /***
     * 查询数据总量
     *
     * @author 王大宸
     * @date 2025-09-18 23:03:17
     * @param params params
     * @return java.leng.Long
     */
    Long list_COUNT(DeptFuncQuery params);

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2025-09-18 23:03:17
     * @param params params
     * @return com.github.itdachen.admin.sdk.vo.deptFuncVO
     */
    List< DeptFuncVO > list(DeptFuncQuery params);

    DeptFuncVO findDeptFuncByTitle(String tenantId,String title);

    /***
     * 根据id查询
     *
     * @author 王大宸
     * @date 2025-09-18 23:03:17
     * @param id 需要查询的数据id
     * @return com.github.itdachen.admin.sdk.vo.deptFuncVo
     */
     DeptFuncVO selectDeptFuncVO( String id);

    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2025-09-18 23:03:17
     * @param list java.util.List<com.github.itdachen.admin.entity.DeptFunc>
     */
    void  batchSave(List< DeptFunc > list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2025-09-18 23:03:17
     * @param list java.util.List<com.github.itdachen.admin.entity.DeptFunc>
     */
    void batchUpdate(List< DeptFunc > list);

}
