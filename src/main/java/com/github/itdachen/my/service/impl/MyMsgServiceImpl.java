package com.github.itdachen.my.service.impl;

import com.github.itdachen.framework.context.BizContextHandler;
import com.github.itdachen.framework.context.constants.YesOrNotConstant;
import com.github.itdachen.framework.core.AssertUtils;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.entity.EntityUtils;
import com.github.itdachen.msg.convert.MsgPoolConvert;
import com.github.itdachen.msg.convert.MsgPoolFileConvert;
import com.github.itdachen.msg.entity.MsgPool;
import com.github.itdachen.msg.entity.MsgPoolFile;
import com.github.itdachen.msg.mapper.IMsgFileMapper;
import com.github.itdachen.msg.mapper.IMsgPoolMapper;
import com.github.itdachen.msg.sdk.query.MsgPoolQuery;
import com.github.itdachen.msg.sdk.vo.MsgPoolFileVO;
import com.github.itdachen.msg.sdk.vo.MsgPoolVO;
import com.github.itdachen.my.service.IMyMsgService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import jakarta.persistence.Column;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * MyMsgServiceImpl
 *
 * @author 王大宸
 * @date 2025/7/24 21:14
 */
@Service
public class MyMsgServiceImpl implements IMyMsgService {
    private static final MsgPoolConvert msgPoolConvert = new MsgPoolConvert();
    private static final MsgPoolFileConvert msgPoolFileConvert = new MsgPoolFileConvert();
    private final IMsgPoolMapper iMsgPoolMapper;
    private final IMsgFileMapper msgFileMapper;

    public MyMsgServiceImpl(IMsgPoolMapper iMsgPoolMapper,
                            IMsgFileMapper msgFileMapper) {
        this.iMsgPoolMapper = iMsgPoolMapper;
        this.msgFileMapper = msgFileMapper;
    }


    @Override
    public TableData<MsgPoolVO> myMsgPage(MsgPoolQuery msgPoolQuery) throws Exception {
        msgPoolQuery.setUserId(BizContextHandler.getUserId());
        msgPoolQuery.setTenantId(BizContextHandler.getTenantId());
        Page<MsgPoolVO> page = PageHelper.startPage(msgPoolQuery.getPage(), msgPoolQuery.getLimit());
        List<MsgPoolVO> list = iMsgPoolMapper.list(msgPoolQuery);
        return new TableData<MsgPoolVO>(page.getTotal(), list);
    }

    @Override
    public MsgPoolVO readMsgFlag(String id) throws Exception {
        MsgPool msgPool = iMsgPoolMapper.selectByPrimaryKey(id);
        AssertUtils.isTrue(null == msgPool, "消息数据不存在, 请刷新数据!");
        assert msgPool != null;
        if (YesOrNotConstant.Y.equals(msgPool.getReadFlag())) {
            return msgPoolConvert.toJavaObjectVO(msgPool);
        }
        msgPool.setReadFlag(YesOrNotConstant.Y);
        msgPool.setReadTime(LocalDateTime.now());
        EntityUtils.setUpdatedInfo(msgPool);
        iMsgPoolMapper.updateByPrimaryKey(msgPool);
        return msgPoolConvert.toJavaObjectVO(msgPool);
    }

    
    /***
     * 记录下载数量
     *
     * @author 王大宸
     * @date 2025/7/24 22:22
     * @param id id
     * @return com.github.itdachen.msg.sdk.vo.MsgPoolFileVO
     */
    @Override
    public MsgPoolFileVO downloadFile(String id) throws Exception {
        MsgPoolFile msgPoolFile = msgFileMapper.selectByPrimaryKey(id);
        AssertUtils.isTrue(null == msgPoolFile, "文件数据不存在, 请刷新数据!");
        assert msgPoolFile != null;

        if (YesOrNotConstant.N.equals(msgPoolFile.getReadFlag())) {
            msgPoolFile.setReadFlag(YesOrNotConstant.Y);
            msgPoolFile.setReadTime(LocalDateTime.now());
            msgPoolFile.setDownloadFlag(YesOrNotConstant.Y);
            msgPoolFile.setDownloadFirstTime(LocalDateTime.now());
        }
        msgPoolFile.setDownloadLastTime(LocalDateTime.now());

        Long downloadTotal = msgPoolFile.getDownloadTotal();
        if (null == downloadTotal) {
            downloadTotal = 0L;
        }
        msgPoolFile.setDownloadTotal(downloadTotal + 1);


        EntityUtils.setUpdatedInfo(msgPoolFile);
        msgFileMapper.updateByPrimaryKey(msgPoolFile);

        return msgPoolFileConvert.toJavaObjectVO(msgPoolFile);
    }
    
    
}
