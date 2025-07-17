package com.github.itdachen.msg.service;

import com.github.itdachen.msg.sdk.dto.MsgFileDTO;
import com.github.itdachen.msg.sdk.query.MsgFileQuery;
import com.github.itdachen.msg.sdk.vo.MsgFileVO;
import com.github.itdachen.framework.webmvc.service.IBizService;

/**
 * 消息附件 业务接口
 *
 * @author 王大宸
 * @date 2025-07-11 22:52:18
 */
public interface IMsgFileService extends IBizService< MsgFileDTO, MsgFileVO, MsgFileQuery, String > {

}
