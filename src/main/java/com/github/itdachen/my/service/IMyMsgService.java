package com.github.itdachen.my.service;

import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.msg.sdk.query.MsgPoolQuery;
import com.github.itdachen.msg.sdk.vo.MsgPoolFileVO;
import com.github.itdachen.msg.sdk.vo.MsgPoolVO;

/**
 * IMyMsgsERVICE
 *
 * @author 王大宸
 * @date 2025/7/24 21:13
 */
public interface IMyMsgService {

    TableData<MsgPoolVO> myMsgPage(MsgPoolQuery msgPoolQuery) throws Exception;

    MsgPoolVO readMsgFlag(String id) throws Exception;

    MsgPoolFileVO downloadFile(String id) throws Exception;

}
