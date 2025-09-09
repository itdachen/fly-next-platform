package com.github.itdachen.oplog.mapper;

import com.github.itdachen.oplog.entity.OplogPageView;
import com.github.itdachen.oplog.sdk.query.OplogPageViewQuery;
import com.github.itdachen.oplog.sdk.vo.OplogPageViewVO;
import tk.mybatis.mapper.common.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 页面访问日志 持久层接口
 *
 * @author 王大宸
 * @date 2025-09-09 21:56:31
 */
public interface IOplogPageViewMapper extends Mapper< OplogPageView > {

    /***
     * 查询数据总量
     *
     * @author 王大宸
     * @date 2025-09-09 21:56:31
     * @param params params
     * @return java.leng.Long
     */
    Long list_COUNT(OplogPageViewQuery params);

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2025-09-09 21:56:31
     * @param params params
     * @return com.github.itdachen.oplog.sdk.vo.oplogPageViewVO
     */
    List< OplogPageViewVO > list(OplogPageViewQuery params);

    /***
     * 根据id查询
     *
     * @author 王大宸
     * @date 2025-09-09 21:56:31
     * @param id 需要查询的数据id
     * @return com.github.itdachen.oplog.sdk.vo.oplogPageViewVo
     */
     OplogPageViewVO selectOplogPageViewVO( String id);

    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2025-09-09 21:56:31
     * @param list java.util.List<com.github.itdachen.oplog.entity.OplogPageView>
     */
    void  batchSave(List< OplogPageView > list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2025-09-09 21:56:31
     * @param list java.util.List<com.github.itdachen.oplog.entity.OplogPageView>
     */
    void batchUpdate(List< OplogPageView > list);

}
