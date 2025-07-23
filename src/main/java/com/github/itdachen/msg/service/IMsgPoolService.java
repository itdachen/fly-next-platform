package com.github.itdachen.msg.service;

import com.github.itdachen.msg.sdk.dto.MsgPoolDTO;
import com.github.itdachen.msg.sdk.query.MsgPoolQuery;
import com.github.itdachen.msg.sdk.vo.MsgPoolVO;
import com.github.itdachen.framework.webmvc.service.IBizService;

/**
 * 消息池 业务接口
 *
 * @author 王大宸
 * @date 2025-07-11 22:52:18
 */
public interface IMsgPoolService extends IBizService<MsgPoolDTO, MsgPoolVO, MsgPoolQuery, String> {

    /***
     * 查询消息消息信息, 包括文件
     *
     * @author 王大宸
     * @date 2025/7/23 16:38
     * @param id id
     * @return com.github.itdachen.msg.sdk.vo.MsgPoolVO
     */
    MsgPoolVO findMsgPoolInfo(String id) throws Exception;


}
