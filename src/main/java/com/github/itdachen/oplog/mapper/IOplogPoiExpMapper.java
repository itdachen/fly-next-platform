package com.github.itdachen.oplog.mapper;

import com.github.itdachen.oplog.entity.OplogPoiExp;
import com.github.itdachen.oplog.sdk.query.OplogPoiExpQuery;
import com.github.itdachen.oplog.sdk.vo.OplogPoiExpVO;
import tk.mybatis.mapper.common.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 导出日志 持久层接口
 *
 * @author 王大宸
 * @date 2025-07-23 23:06:08
 */
public interface IOplogPoiExpMapper extends Mapper< OplogPoiExp > {

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2025-07-23 23:06:08
     * @param params params
     * @return com.github.itdachen.oplog.sdk.vo.oplogPoiExpVO
     */
    List< OplogPoiExpVO > list(OplogPoiExpQuery params);

    /***
     * 根据id查询
     *
     * @author 王大宸
     * @date 2025-07-23 23:06:08
     * @param id 需要查询的数据id
     * @return com.github.itdachen.oplog.sdk.vo.oplogPoiExpVo
     */
        OplogPoiExpVO selectOplogPoiExpVO( String id);

    /***
     * 查询导出数据
     *
     * @author 王大宸
     * @date 2025-07-23 23:06:08
     * @param params 查询参数
     * @return java.util.LinkedHashMap
     */
    List< LinkedHashMap< String, String > > selectOplogPoiExpExpData(OplogPoiExpQuery params);

    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2025-07-23 23:06:08
     * @param list java.util.List<com.github.itdachen.oplog.entity.OplogPoiExp>
     */
    void  batchSave(List< OplogPoiExp > list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2025-07-23 23:06:08
     * @param list java.util.List<com.github.itdachen.oplog.entity.OplogPoiExp>
     */
    void batchUpdate(List< OplogPoiExp > list);

}
