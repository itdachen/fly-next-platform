package com.github.itdachen.admin.mapper;

import com.github.itdachen.admin.entity.DictType;
import com.github.itdachen.admin.sdk.query.DictTypeQuery;
import com.github.itdachen.admin.sdk.vo.DictTypeVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 字典类型表 持久层接口
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:47
 */
public interface IDictTypeMapper extends Mapper< DictType > {

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:47
     * @param params params
     * @return com.github.itdachen.admin.sdk.vo.dictTypeVo
     */
    List< DictTypeVo > page(DictTypeQuery params);



    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:47
     * @param list java.util.List<com.github.itdachen.admin.entity.DictType>
     */
    void  batchSave(List< DictType > list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:47
     * @param list java.util.List<com.github.itdachen.admin.entity.DictType>
     */
    void batchUpdate(List< DictType > list);

}
