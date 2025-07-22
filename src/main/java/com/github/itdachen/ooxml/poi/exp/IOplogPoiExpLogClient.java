package com.github.itdachen.ooxml.poi.exp;

import com.github.itdachen.ooxml.poi.entity.PoiExpModel;

/**
 * 导出日志入库
 *
 * @author 王大宸
 * @date 2025-07-22 11:22
 */
public interface IOplogPoiExpLogClient {


    /***
     * 添加日志
     *
     * @author 王大宸
     * @date 2025/7/22 11:23
     * @return void
     */
    void save(PoiExpModel poiExpModel);


}
