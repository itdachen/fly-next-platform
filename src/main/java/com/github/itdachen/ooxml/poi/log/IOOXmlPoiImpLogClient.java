package com.github.itdachen.ooxml.poi.log;

import com.github.itdachen.ooxml.poi.entity.OplogPoiModel;

/**
 * 导入日志入库
 *
 * @author 王大宸
 * @date 2025-07-28 11:29
 */
public interface IOOXmlPoiImpLogClient {

    void save(OplogPoiModel oplogPoiModel);


}
