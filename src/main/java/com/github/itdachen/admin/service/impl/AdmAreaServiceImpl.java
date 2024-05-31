package com.github.itdachen.admin.service.impl;

import com.github.itdachen.framework.context.tree.ZTreeNode;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.itdachen.admin.entity.AdmArea;
import com.github.itdachen.admin.sdk.dto.AdmAreaDTO;
import com.github.itdachen.admin.sdk.query.AdmAreaQuery;
import com.github.itdachen.admin.sdk.vo.AdmAreaVO;
import com.github.itdachen.admin.mapper.IAdmAreaMapper;
import com.github.itdachen.admin.service.IAdmAreaService;
import com.github.itdachen.admin.convert.AdmAreaConvert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 行政区划代码 业务实现
 *
 * @author 王大宸
 * @date 2024-05-06 21:18:46
 */
@Service
public class AdmAreaServiceImpl extends BizServiceImpl< IAdmAreaMapper, AdmArea, AdmAreaDTO,  AdmAreaVO, AdmAreaQuery, Long > implements IAdmAreaService {
    private static final Logger logger = LoggerFactory.getLogger(AdmAreaServiceImpl.class);
    private static final AdmAreaConvert bizConvert = new AdmAreaConvert();

    public AdmAreaServiceImpl() {
        super(bizConvert);
    }

    /***
    * 分页
    *
    * @author 王大宸
    * @date 2024-05-06 21:18:46
    * @param params params
    * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.admin.sdk.vo.admAreaVo>
    */
    @Override
    public TableData< AdmAreaVO > page(AdmAreaQuery params) throws Exception {
        Page< AdmAreaVO > page = PageHelper.startPage(params.getPage(), params.getLimit());
        List< AdmAreaVO > list = bizMapper.list(params);
        return new TableData< AdmAreaVO >(page.getTotal(), list);
    }


    @Override
    public List<ZTreeNode> findProvList() {
        return bizMapper.findProvList();
    }

    @Override
    public List<ZTreeNode> findCityList(String provCode) {
        return bizMapper.findCityList(provCode);
    }

    @Override
    public List<ZTreeNode> findCountyList(String cityCode) {
        return bizMapper.findCountyList(cityCode);
    }

}
