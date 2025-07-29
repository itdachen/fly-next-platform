package com.github.itdachen.oplog.mapper;

import com.github.itdachen.oplog.entity.OplogPoiTest;
import com.github.itdachen.oplog.sdk.query.OplogPoiTestQuery;
import com.github.itdachen.oplog.sdk.vo.OplogPoiTestVO;
import tk.mybatis.mapper.common.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 导入导出测试 持久层接口
 *
 * @author 王大宸
 * @date 2025-07-28 16:55:09
 */
public interface IOplogPoiTestMapper extends Mapper<OplogPoiTest> {

    /***
     * 查询数据总条数
     *
     * @author 王大宸
     * @date 2025/7/29 18:47
     * @param params params
     * @return java.lang.Long
     */
    Long list_COUNT(OplogPoiTestQuery params);

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2025-07-28 16:55:09
     * @param params params
     * @return com.github.itdachen.oplog.sdk.vo.oplogPoiTestVO
     */
    List<OplogPoiTestVO> list(OplogPoiTestQuery params);

    /***
     * 根据id查询
     *
     * @author 王大宸
     * @date 2025-07-28 16:55:09
     * @param id 需要查询的数据id
     * @return com.github.itdachen.oplog.sdk.vo.oplogPoiTestVo
     */
    OplogPoiTestVO selectOplogPoiTestVO(String id);

    /***
     * 查询导出数据
     *
     * @author 王大宸
     * @date 2025-07-28 16:55:09
     * @param params 查询参数
     * @return java.util.LinkedHashMap
     */
    List<LinkedHashMap<String, String>> selectOplogPoiTestExpData(OplogPoiTestQuery params);

    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2025-07-28 16:55:09
     * @param list java.util.List<com.github.itdachen.oplog.entity.OplogPoiTest>
     */
    void batchSave(List<OplogPoiTest> list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2025-07-28 16:55:09
     * @param list java.util.List<com.github.itdachen.oplog.entity.OplogPoiTest>
     */
    void batchUpdate(List<OplogPoiTest> list);

}
