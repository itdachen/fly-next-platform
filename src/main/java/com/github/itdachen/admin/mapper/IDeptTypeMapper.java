package com.github.itdachen.admin.mapper;

import com.github.itdachen.admin.entity.DeptType;
import com.github.itdachen.admin.sdk.query.DeptTypeQuery;
import com.github.itdachen.admin.sdk.vo.DeptTypeVO;
import tk.mybatis.mapper.common.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 部门类型管理 持久层接口
 *
 * @author 王大宸
 * @date 2024-04-24 21:47:25
 */
public interface IDeptTypeMapper extends Mapper< DeptType > {

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2024-04-24 21:47:25
     * @param params params
     * @return com.github.itdachen.admin.sdk.vo.deptTypeVO
     */
    List< DeptTypeVO > list(DeptTypeQuery params);

    /***
     * 根据id查询
     *
     * @author 王大宸
     * @date 2024-04-24 21:47:25
     * @param id 需要查询的数据id
     * @return com.github.itdachen.admin.sdk.vo.deptTypeVo
     */
        DeptTypeVO selectDeptTypeVO( String id);

    /***
     * 查询导出数据
     *
     * @author 王大宸
     * @date 2024-04-24 21:47:25
     * @param params 查询参数
     * @return java.util.LinkedHashMap
     */
    List< LinkedHashMap< String, String > > selectDeptTypeExpData(DeptTypeQuery params);

    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2024-04-24 21:47:25
     * @param list java.util.List<com.github.itdachen.admin.entity.DeptType>
     */
    void  batchSave(List< DeptType > list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2024-04-24 21:47:25
     * @param list java.util.List<com.github.itdachen.admin.entity.DeptType>
     */
    void batchUpdate(List< DeptType > list);

}
