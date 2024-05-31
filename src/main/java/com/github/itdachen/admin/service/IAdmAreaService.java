package com.github.itdachen.admin.service;

import com.github.itdachen.admin.sdk.dto.AdmAreaDTO;
import com.github.itdachen.admin.sdk.query.AdmAreaQuery;
import com.github.itdachen.admin.sdk.vo.AdmAreaVO;
import com.github.itdachen.framework.context.tree.ZTreeNode;
import com.github.itdachen.framework.webmvc.service.IBizService;

import java.util.List;

/**
 * 行政区划代码 业务接口
 *
 * @author 王大宸
 * @date 2024-05-06 21:18:46
 */
public interface IAdmAreaService extends IBizService< AdmAreaDTO, AdmAreaVO, AdmAreaQuery, Long > {


    List<ZTreeNode> findProvList();

    List<ZTreeNode> findCityList(String provCode);

    List<ZTreeNode> findCountyList(String cityCode);

}
