package com.github.itdachen.admin.mapper;

import com.github.itdachen.admin.entity.DictType;
import com.github.itdachen.admin.sdk.query.DictTypeQuery;
import com.github.itdachen.admin.sdk.vo.DictTypeVO;
import tk.mybatis.mapper.common.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 数据字典类型 持久层接口
 *
 * @author 王大宸
 * @date 2024-04-21 20:21:24
 */
public interface IDictTypeMapper extends Mapper< DictType > {

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2024-04-21 20:21:24
     * @param params params
     * @return com.github.itdachen.admin.sdk.vo.dictTypeVO
     */
    List< DictTypeVO > list(DictTypeQuery params);

    /***
     * 根据id查询
     *
     * @author 王大宸
     * @date 2024-04-21 20:21:24
     * @param id 需要查询的数据id
     * @return com.github.itdachen.admin.sdk.vo.dictTypeVo
     */
        DictTypeVO selectDictTypeVO( String id);

    /***
     * 查询导出数据
     *
     * @author 王大宸
     * @date 2024-04-21 20:21:24
     * @param params 查询参数
     * @return java.util.LinkedHashMap
     */
    List< LinkedHashMap< String, String > > selectDictTypeExpData(DictTypeQuery params);

    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2024-04-21 20:21:24
     * @param list java.util.List<com.github.itdachen.admin.entity.DictType>
     */
    void  batchSave(List< DictType > list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2024-04-21 20:21:24
     * @param list java.util.List<com.github.itdachen.admin.entity.DictType>
     */
    void batchUpdate(List< DictType > list);

}
