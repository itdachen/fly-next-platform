package com.github.itdachen.ooxml.poi.msg;

import com.github.itdachen.framework.context.userdetails.UserInfoDetails;
import com.github.itdachen.ooxml.poi.entity.MsgFileModel;
import com.github.itdachen.ooxml.poi.entity.MsgModel;

/**
 * 消息入库操作
 *
 * @author 王大宸
 * @date 2025-07-22 11:13
 */
public interface IOplogMsgClient {


    /***
     * 新增消息信息
     *
     * @author 王大宸
     * @date 2025/7/22 11:14
     * @param msgModel notifyMsgInfo
     * @return void
     */
    void save(MsgModel msgModel, UserInfoDetails userDetails);


    /***
     * 追加消息信息
     *
     * @author 王大宸
     * @date 2025/7/22 11:16
     * @param msgModel notifyMsgInfo
     * @return void
     */
    void appendContent(MsgModel msgModel);


    /***
     * 添加消息文件
     *
     * @author 王大宸
     * @date 2025/7/25 22:42
     * @param msgFileModel msgFileModel
     * @return void
     */
    void saveMsgFile(MsgFileModel msgFileModel);


}
