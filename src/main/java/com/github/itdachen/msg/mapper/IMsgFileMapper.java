package com.github.itdachen.msg.mapper;

import com.github.itdachen.msg.entity.MsgFile;
import com.github.itdachen.msg.sdk.query.MsgFileQuery;
import com.github.itdachen.msg.sdk.vo.MsgFileVO;
import tk.mybatis.mapper.common.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 消息附件 持久层接口
 *
 * @author 王大宸
 * @date 2025-07-11 22:52:18
 */
public interface IMsgFileMapper extends Mapper< MsgFile > {

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2025-07-11 22:52:18
     * @param params params
     * @return com.github.itdachen.msg.sdk.vo.msgFileVO
     */
    List< MsgFileVO > list(MsgFileQuery params);

    /***
     * 根据id查询
     *
     * @author 王大宸
     * @date 2025-07-11 22:52:18
     * @param id 需要查询的数据id
     * @return com.github.itdachen.msg.sdk.vo.msgFileVo
     */
        MsgFileVO selectMsgFileVO( String id);

    /***
     * 查询导出数据
     *
     * @author 王大宸
     * @date 2025-07-11 22:52:18
     * @param params 查询参数
     * @return java.util.LinkedHashMap
     */
    List< LinkedHashMap< String, String > > selectMsgFileExpData(MsgFileQuery params);

    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2025-07-11 22:52:18
     * @param list java.util.List<com.github.itdachen.msg.entity.MsgFile>
     */
    void  batchSave(List< MsgFile > list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2025-07-11 22:52:18
     * @param list java.util.List<com.github.itdachen.msg.entity.MsgFile>
     */
    void batchUpdate(List< MsgFile > list);

}
