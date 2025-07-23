package com.github.itdachen.msg.mapper;

import com.github.itdachen.msg.entity.MsgPoolFile;
import com.github.itdachen.msg.sdk.query.MsgPoolFileQuery;
import com.github.itdachen.msg.sdk.vo.MsgPoolFileVO;
import tk.mybatis.mapper.common.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 消息附件 持久层接口
 *
 * @author 王大宸
 * @date 2025-07-11 22:52:18
 */
public interface IMsgFileMapper extends Mapper<MsgPoolFile> {

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2025-07-11 22:52:18
     * @param params params
     * @return com.github.itdachen.msg.sdk.vo.msgFileVO
     */
    List<MsgPoolFileVO> list(MsgPoolFileQuery params);

    /***
     * 根据id查询
     *
     * @author 王大宸
     * @date 2025-07-11 22:52:18
     * @param id 需要查询的数据id
     * @return com.github.itdachen.msg.sdk.vo.msgFileVo
     */
    MsgPoolFileVO selectMsgPoolFileVO(String id);

    List<MsgPoolFileVO> findMsgPoolFileList(String msgId);

    /***
     * 查询导出数据
     *
     * @author 王大宸
     * @date 2025-07-11 22:52:18
     * @param params 查询参数
     * @return java.util.LinkedHashMap
     */
    List<LinkedHashMap<String, String>> selectMsgFileExpData(MsgPoolFileQuery params);

    /***
     * 批量添加
     *
     * @author 王大宸
     * @date 2025-07-11 22:52:18
     * @param list java.util.List<com.github.itdachen.msg.entity.MsgFile>
     */
    void batchSave(List<MsgPoolFile> list);

    /***
     * 批量修改
     *
     * @author 王大宸
     * @date 2025-07-11 22:52:18
     * @param list java.util.List<com.github.itdachen.msg.entity.MsgFile>
     */
    void batchUpdate(List<MsgPoolFile> list);

}
