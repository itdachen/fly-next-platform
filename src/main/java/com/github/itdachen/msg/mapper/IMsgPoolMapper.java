package com.github.itdachen.msg.mapper;

import com.github.itdachen.msg.entity.MsgPool;
import com.github.itdachen.msg.sdk.query.MsgPoolQuery;
import com.github.itdachen.msg.sdk.vo.MsgPoolVO;
import tk.mybatis.mapper.common.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 消息池 持久层接口
 *
 * @author 王大宸
 * @date 2025-07-11 22:52:18
 */
public interface IMsgPoolMapper extends Mapper< MsgPool > {

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2025-07-11 22:52:18
     * @param params params
     * @return com.github.itdachen.msg.sdk.vo.msgPoolVO
     */
    List< MsgPoolVO > list(MsgPoolQuery params);

    /***
     * 根据id查询
     *
     * @author 王大宸
     * @date 2025-07-11 22:52:18
     * @param id 需要查询的数据id
     * @return com.github.itdachen.msg.sdk.vo.msgPoolVo
     */
        MsgPoolVO selectMsgPoolVO( String id);

    /***
     * 查询导出数据
     *
     * @author 王大宸
     * @date 2025-07-11 22:52:18
     * @param params 查询参数
     * @return java.util.LinkedHashMap
     */
    List< LinkedHashMap< String, String > > selectMsgPoolExpData(MsgPoolQuery params);

    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2025-07-11 22:52:18
     * @param list java.util.List<com.github.itdachen.msg.entity.MsgPool>
     */
    void  batchSave(List< MsgPool > list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2025-07-11 22:52:18
     * @param list java.util.List<com.github.itdachen.msg.entity.MsgPool>
     */
    void batchUpdate(List< MsgPool > list);

}
