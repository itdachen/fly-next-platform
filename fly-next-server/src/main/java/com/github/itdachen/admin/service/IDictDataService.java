package com.github.itdachen.admin.service;

import com.github.itdachen.admin.entity.DictData;
import com.github.itdachen.admin.sdk.query.DictDataQuery;
import com.github.itdachen.admin.sdk.vo.DictDataVo;
import com.github.itdachen.framework.webmvc.service.IBizService;

/**
 * 字典数据表 业务接口
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:47
 */
public interface IDictDataService extends IBizService< DictData, DictDataVo, DictDataQuery, String > {

}
