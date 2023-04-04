package com.github.itdachen.admin.service;

import com.github.itdachen.admin.entity.DictType;
import com.github.itdachen.admin.sdk.query.DictTypeQuery;
import com.github.itdachen.admin.sdk.vo.DictTypeVo;
import com.github.itdachen.framework.webmvc.service.IBizService;

/**
 * 字典类型表 业务接口
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:47
 */
public interface IDictTypeService extends IBizService< DictType, DictTypeVo, DictTypeQuery, String > {

}
