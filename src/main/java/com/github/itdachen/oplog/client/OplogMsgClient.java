package com.github.itdachen.oplog.client;

import com.github.itdachen.boot.oplog.ooxml.poi.entity.MsgFileModel;
import com.github.itdachen.boot.oplog.ooxml.poi.entity.MsgModel;
import com.github.itdachen.boot.oplog.ooxml.poi.msg.IOplogMsgClient;
import com.github.itdachen.framework.context.userdetails.UserInfoDetails;
import com.github.itdachen.msg.manager.IMsgPoolManager;
import org.springframework.stereotype.Service;

/**
 * 操作日志消息入库
 *
 * @author 王大宸
 * @date 2025-07-22 16:35
 */
@Service
public class OplogMsgClient implements IOplogMsgClient {

    private final IMsgPoolManager msgPoolManager;

    public OplogMsgClient(IMsgPoolManager msgPoolManager) {
        this.msgPoolManager = msgPoolManager;
    }


    @Override
    public void save(MsgModel msgModel, UserInfoDetails userDetails) {
        msgPoolManager.save(msgModel, userDetails);
    }

    @Override
    public void appendContent(MsgModel msgModel) {
        msgPoolManager.appendContent(msgModel);
    }

    @Override
    public void saveMsgFile(MsgFileModel msgFileModel) {
        msgPoolManager.saveMsgFile(msgFileModel);
    }

}
