package com.github.itdachen.admin.mapper;

import com.github.itdachen.admin.entity.ClazzFunc;
import com.github.itdachen.admin.sdk.query.ClazzFuncQuery;
import com.github.itdachen.admin.sdk.vo.ClazzFuncVO;
import com.github.itdachen.admin.sdk.vo.DeptFuncVO;
import tk.mybatis.mapper.common.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 岗位职能管理 持久层接口
 *
 * @author 王大宸
 * @date 2025-09-18 22:27:28
 */
public interface IClazzFuncMapper extends Mapper< ClazzFunc > {

    /***
     * 查询数据总量
     *
     * @author 王大宸
     * @date 2025-09-18 22:27:28
     * @param params params
     * @return java.leng.Long
     */
    Long list_COUNT(ClazzFuncQuery params);

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2025-09-18 22:27:28
     * @param params params
     * @return com.github.itdachen.admin.sdk.vo.clazzFuncVO
     */
    List< ClazzFuncVO > list(ClazzFuncQuery params);

    ClazzFuncVO findClazzFuncByTitle(String tenantId, String title);

    /***
     * 根据id查询
     *
     * @author 王大宸
     * @date 2025-09-18 22:27:28
     * @param id 需要查询的数据id
     * @return com.github.itdachen.admin.sdk.vo.clazzFuncVo
     */
     ClazzFuncVO selectClazzFuncVO( String id);

    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2025-09-18 22:27:28
     * @param list java.util.List<com.github.itdachen.admin.entity.ClazzFunc>
     */
    void  batchSave(List< ClazzFunc > list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2025-09-18 22:27:28
     * @param list java.util.List<com.github.itdachen.admin.entity.ClazzFunc>
     */
    void batchUpdate(List< ClazzFunc > list);

}
