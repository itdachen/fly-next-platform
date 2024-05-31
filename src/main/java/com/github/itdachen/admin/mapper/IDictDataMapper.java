package com.github.itdachen.admin.mapper;

import com.github.itdachen.admin.entity.DictData;
import com.github.itdachen.admin.sdk.dto.DictTypeDTO;
import com.github.itdachen.admin.sdk.query.DictDataQuery;
import com.github.itdachen.admin.sdk.vo.DataDictVO;
import com.github.itdachen.admin.sdk.vo.DictDataVO;
import tk.mybatis.mapper.common.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 数据字典信息表 持久层接口
 *
 * @author 王大宸
 * @date 2024-04-21 20:21:24
 */
public interface IDictDataMapper extends Mapper<DictData> {

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2024-04-21 20:21:24
     * @param params params
     * @return com.github.itdachen.admin.sdk.vo.dictDataVO
     */
    List<DictDataVO> list(DictDataQuery params);

    List<DataDictVO> findDictData(String dictType, String validFlag);

    /***
     * 根据id查询
     *
     * @author 王大宸
     * @date 2024-04-21 20:21:24
     * @param id 需要查询的数据id
     * @return com.github.itdachen.admin.sdk.vo.dictDataVo
     */
    DictDataVO selectDictDataVO(String id);
    
    /***
     * 更新字典类型字段
     *
     * @author 王大宸
     * @date 2024/4/21 21:50
     * @param dto dto
     * @return void
     */
    void updateByTypeId(DictTypeDTO dto);

    /***
     * 根据类型ID查询数量
     *
     * @author 王大宸
     * @date 2024/4/21 21:55
     * @param typeId typeId
     * @return java.lang.Integer
     */
    Integer findCountByTypeId(String typeId);

    /***
     * 查询导出数据
     *
     * @author 王大宸
     * @date 2024-04-21 20:21:24
     * @param params 查询参数
     * @return java.util.LinkedHashMap
     */
    List<LinkedHashMap<String, String>> selectDictDataExpData(DictDataQuery params);

    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2024-04-21 20:21:24
     * @param list java.util.List<com.github.itdachen.admin.entity.DictData>
     */
    void batchSave(List<DictData> list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2024-04-21 20:21:24
     * @param list java.util.List<com.github.itdachen.admin.entity.DictData>
     */
    void batchUpdate(List<DictData> list);

}
