package com.github.itdachen.msg.manager;

import com.github.itdachen.boot.oplog.ooxml.poi.entity.MsgFileModel;
import com.github.itdachen.boot.oplog.ooxml.poi.entity.MsgModel;
import com.github.itdachen.framework.context.userdetails.UserInfoDetails;
import com.github.itdachen.msg.sdk.vo.MsgPoolFileVO;
import com.github.itdachen.msg.sdk.vo.MsgPoolVO;

/**
 * IMsgPoolManager
 *
 * @author 王大宸
 * @date 2025-07-22 16:38
 */
public interface IMsgPoolManager {

    /***
     * 新增消息信息
     *
     * @author 王大宸
     * @date 2025/7/22 11:14
     * @param msgModel notifyMsgInfo
     * @return void
     */
    MsgPoolVO save(MsgModel msgModel, UserInfoDetails userDetails);


    /***
     * 追加消息信息
     *
     * @author 王大宸
     * @date 2025/7/22 11:16
     * @param msgModel notifyMsgInfo
     * @return void
     */
    MsgPoolVO appendContent(MsgModel msgModel);


    MsgPoolFileVO saveMsgFile(MsgFileModel msgFileModel);


}
