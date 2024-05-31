package com.github.itdachen.admin.service;

import com.github.itdachen.admin.sdk.dto.ClazzInfoDTO;
import com.github.itdachen.admin.sdk.query.ClazzInfoQuery;
import com.github.itdachen.admin.sdk.vo.ClazzInfoVO;
import com.github.itdachen.framework.webmvc.service.IBizService;

/**
 * 岗位信息 业务接口
 *
 * @author 王大宸
 * @date 2024-04-25 22:40:02
 */
public interface IClazzInfoService extends IBizService< ClazzInfoDTO, ClazzInfoVO, ClazzInfoQuery, String > {


    /***
     * 有效标志
     *
     * @author 王大宸
     * @date 2024/4/20 21:20
     * @param id id
     * @param checked checked
     */
    void validFlagChecked(String id, Boolean checked) throws Exception;


}
