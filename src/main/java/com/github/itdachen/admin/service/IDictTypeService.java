package com.github.itdachen.admin.service;

import com.github.itdachen.admin.sdk.dto.DictTypeDTO;
import com.github.itdachen.admin.sdk.query.DictTypeQuery;
import com.github.itdachen.admin.sdk.vo.DictTypeVO;
import com.github.itdachen.framework.webmvc.service.IBizService;

/**
 * 数据字典类型 业务接口
 *
 * @author 王大宸
 * @date 2024-04-21 20:21:24
 */
public interface IDictTypeService extends IBizService< DictTypeDTO, DictTypeVO, DictTypeQuery, String > {

}
