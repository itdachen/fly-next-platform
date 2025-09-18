package com.github.itdachen.admin.mapper;

import com.github.itdachen.admin.entity.DeptLevel;
import com.github.itdachen.admin.sdk.query.DeptLevelQuery;
import com.github.itdachen.admin.sdk.vo.DeptLevelVO;
import tk.mybatis.mapper.common.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 部门等级 持久层接口
 *
 * @author 王大宸
 * @date 2025-09-18 22:02:49
 */
public interface IDeptLevelMapper extends Mapper< DeptLevel > {

    /***
     * 查询数据总量
     *
     * @author 王大宸
     * @date 2025-09-18 22:02:49
     * @param params params
     * @return java.leng.Long
     */
    Long list_COUNT(DeptLevelQuery params);

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2025-09-18 22:02:49
     * @param params params
     * @return com.github.itdachen.admin.sdk.vo.deptLevelVO
     */
    List< DeptLevelVO > list(DeptLevelQuery params);

    /***
     * 根据id查询
     *
     * @author 王大宸
     * @date 2025-09-18 22:02:49
     * @param id 需要查询的数据id
     * @return com.github.itdachen.admin.sdk.vo.deptLevelVo
     */
     DeptLevelVO selectDeptLevelVO( String id);

    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2025-09-18 22:02:49
     * @param list java.util.List<com.github.itdachen.admin.entity.DeptLevel>
     */
    void  batchSave(List< DeptLevel > list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2025-09-18 22:02:49
     * @param list java.util.List<com.github.itdachen.admin.entity.DeptLevel>
     */
    void batchUpdate(List< DeptLevel > list);

}
