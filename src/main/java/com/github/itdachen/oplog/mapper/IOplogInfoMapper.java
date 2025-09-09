package com.github.itdachen.oplog.mapper;

import com.github.itdachen.oplog.entity.OplogInfo;
import com.github.itdachen.oplog.sdk.query.OplogInfoQuery;
import com.github.itdachen.oplog.sdk.vo.OplogInfoVO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 操作日志 持久层接口
 *
 * @author 王大宸
 * @date 2025-09-09 17:52:15
 */
public interface IOplogInfoMapper extends Mapper<OplogInfo> {

    /***
     * 查询数据总量
     *
     * @author 王大宸
     * @date 2025-09-09 17:52:15
     * @param params params
     * @return java.leng.Long @Param("params")
     */
    Long list_COUNT(OplogInfoQuery params);

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2025-09-09 17:52:15
     * @param params params
     * @return com.github.itdachen.oplog.sdk.vo.oplogInfoVO
     */
    List<OplogInfoVO> list(OplogInfoQuery params);

    /***
     * 根据id查询
     *
     * @author 王大宸
     * @date 2025-09-09 17:52:15
     * @param id 需要查询的数据id
     * @return com.github.itdachen.oplog.sdk.vo.oplogInfoVo
     */
    OplogInfoVO selectOplogInfoVO(String id);

    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2025-09-09 17:52:15
     * @param list java.util.List<com.github.itdachen.oplog.entity.OplogInfo>
     */
    void batchSave(List<OplogInfo> list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2025-09-09 17:52:15
     * @param list java.util.List<com.github.itdachen.oplog.entity.OplogInfo>
     */
    void batchUpdate(List<OplogInfo> list);

}
