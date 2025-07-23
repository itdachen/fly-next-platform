package com.github.itdachen.msg.service;

import com.github.itdachen.msg.sdk.dto.MsgPoolFileDTO;
import com.github.itdachen.msg.sdk.query.MsgPoolFileQuery;
import com.github.itdachen.msg.sdk.vo.MsgPoolFileVO;
import com.github.itdachen.framework.webmvc.service.IBizService;

/**
 * 消息附件 业务接口
 *
 * @author 王大宸
 * @date 2025-07-11 22:52:18
 */
public interface IMsgFileService extends IBizService<MsgPoolFileDTO, MsgPoolFileVO, MsgPoolFileQuery, String > {

}
