package com.github.itdachen.oplog.mapper;

import com.github.itdachen.oplog.entity.OplogPoiImp;
import com.github.itdachen.oplog.sdk.query.OplogPoiImpQuery;
import com.github.itdachen.oplog.sdk.vo.OplogPoiImpVO;
import tk.mybatis.mapper.common.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 导入日志 持久层接口
 *
 * @author 王大宸
 * @date 2025-07-28 15:55:31
 */
public interface IOplogPoiImpMapper extends Mapper< OplogPoiImp > {

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2025-07-28 15:55:31
     * @param params params
     * @return com.github.itdachen.oplog.sdk.vo.oplogPoiImpVO
     */
    List< OplogPoiImpVO > list(OplogPoiImpQuery params);

    /***
     * 根据id查询
     *
     * @author 王大宸
     * @date 2025-07-28 15:55:31
     * @param id 需要查询的数据id
     * @return com.github.itdachen.oplog.sdk.vo.oplogPoiImpVo
     */
        OplogPoiImpVO selectOplogPoiImpVO( String id);

    /***
     * 查询导出数据
     *
     * @author 王大宸
     * @date 2025-07-28 15:55:31
     * @param params 查询参数
     * @return java.util.LinkedHashMap
     */
    List< LinkedHashMap< String, String > > selectOplogPoiImpExpData(OplogPoiImpQuery params);

    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2025-07-28 15:55:31
     * @param list java.util.List<com.github.itdachen.oplog.entity.OplogPoiImp>
     */
    void  batchSave(List< OplogPoiImp > list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2025-07-28 15:55:31
     * @param list java.util.List<com.github.itdachen.oplog.entity.OplogPoiImp>
     */
    void batchUpdate(List< OplogPoiImp > list);

}
