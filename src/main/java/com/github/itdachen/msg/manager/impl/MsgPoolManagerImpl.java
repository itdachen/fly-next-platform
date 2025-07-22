package com.github.itdachen.msg.manager.impl;

import com.github.itdachen.framework.context.userdetails.UserInfoDetails;
import com.github.itdachen.msg.manager.IMsgPoolManager;
import com.github.itdachen.msg.mapper.IMsgFileMapper;
import com.github.itdachen.msg.mapper.IMsgPoolMapper;
import com.github.itdachen.ooxml.poi.entity.MsgFileModel;
import com.github.itdachen.ooxml.poi.entity.MsgModel;
import org.springframework.stereotype.Component;

/**
 * MsgPoolManagerImpl
 *
 * @author 王大宸
 * @date 2025-07-22 16:38
 */
@Component
public class MsgPoolManagerImpl implements IMsgPoolManager {

    private final IMsgFileMapper msgFileMapper;
    private final IMsgPoolMapper msgPoolMapper;

    public MsgPoolManagerImpl(IMsgFileMapper msgFileMapper, IMsgPoolMapper msgPoolMapper) {
        this.msgFileMapper = msgFileMapper;
        this.msgPoolMapper = msgPoolMapper;
    }


    @Override
    public void save(MsgModel msgModel, UserInfoDetails userDetails) {

    }

    @Override
    public void appendContent(MsgModel msgModel) {

    }

    @Override
    public void saveMsgFile(MsgFileModel msgFileModel) {

    }
}
