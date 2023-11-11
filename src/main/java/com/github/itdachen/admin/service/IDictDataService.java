package com.github.itdachen.admin.service;

import com.github.itdachen.admin.sdk.dto.DictDataDto;
import com.github.itdachen.admin.sdk.query.DictDataQuery;
import com.github.itdachen.admin.sdk.vo.DictDataVo;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.webmvc.service.IBizService;

/**
 * 字典数据表 业务接口
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:47
 */
public interface IDictDataService extends IBizService<DictDataDto, DictDataVo, DictDataQuery, String> {


    /***
     * 修改状态
     *
     * @author 王大宸
     * @date 2023/4/5 21:17
     * @param id id
     * @param status status
     * @return com.github.itdachen.admin.sdk.vo.DictDataVo
     */
    DictDataVo updateStatus(String id, Boolean status) throws BizException;

}
