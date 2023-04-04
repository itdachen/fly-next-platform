package com.github.itdachen.admin.mapper;

import com.github.itdachen.admin.entity.DictData;
import com.github.itdachen.admin.sdk.query.DictDataQuery;
import com.github.itdachen.admin.sdk.vo.DataDictVo;
import com.github.itdachen.admin.sdk.vo.DictDataVo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 字典数据表 持久层接口
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:47
 */
public interface IDictDataMapper extends Mapper<DictData> {

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:47
     * @param params params
     * @return com.github.itdachen.admin.sdk.vo.dictDataVo
     */
    List<DictDataVo> page(DictDataQuery params);


    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:47
     * @param list java.util.List<com.github.itdachen.admin.entity.DictData>
     */
    void batchSave(List<DictData> list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:47
     * @param list java.util.List<com.github.itdachen.admin.entity.DictData>
     */
    void batchUpdate(List<DictData> list);

    /***
     * 获取数据字段
     *
     * @author 王大宸
     * @date 2023/4/4 21:57
     * @param dictType dictType
     * @param status status
     * @return java.util.List<com.github.itdachen.admin.sdk.vo.DataDictVo>
     */
    List<DataDictVo> findDictData(@Param("dictType")String dictType, @Param("status") String status);


    DictDataVo findByTypeAndValue(@Param("dictType") String dictType, @Param("dictValue")  String dictValue);

}
