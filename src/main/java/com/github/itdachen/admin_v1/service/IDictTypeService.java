package com.github.itdachen.admin_v1.service;

import com.github.itdachen.admin_v1.sdk.dto.DictTypeDto;
import com.github.itdachen.admin_v1.sdk.query.DictTypeQuery;
import com.github.itdachen.admin_v1.sdk.vo.DictDataVo;
import com.github.itdachen.admin_v1.sdk.vo.DictTypeVo;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.webmvc.service.IBizService;

/**
 * 字典类型表 业务接口
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:47
 */
public interface IDictTypeService extends IBizService<DictTypeDto, DictTypeVo, DictTypeQuery, String> {


    /***
     * 更新状态
     *
     * @author 王大宸
     * @date 2023/4/5 21:13
     * @param id id
     * @param status status
     * @return com.github.itdachen.admin.sdk.vo.DictDataVo
     */
    DictDataVo updateStatus(String id, Boolean status) throws BizException;

}
