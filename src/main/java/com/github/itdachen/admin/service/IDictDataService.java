package com.github.itdachen.admin.service;

import com.github.itdachen.admin.sdk.dto.DictDataDTO;
import com.github.itdachen.admin.sdk.query.DictDataQuery;
import com.github.itdachen.admin.sdk.vo.DictDataVO;
import com.github.itdachen.framework.webmvc.service.IBizService;

/**
 * 数据字典信息表 业务接口
 *
 * @author 王大宸
 * @date 2024-04-21 20:21:24
 */
public interface IDictDataService extends IBizService< DictDataDTO, DictDataVO, DictDataQuery, String > {

}
