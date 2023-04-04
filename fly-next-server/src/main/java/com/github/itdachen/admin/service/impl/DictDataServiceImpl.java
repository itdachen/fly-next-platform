package com.github.itdachen.admin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.itdachen.admin.entity.DictData;
import com.github.itdachen.admin.sdk.query.DictDataQuery;
import com.github.itdachen.admin.sdk.vo.DictDataVo;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.itdachen.admin.mapper.IDictDataMapper;
import com.github.itdachen.admin.service.IDictDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 字典数据表 业务实现
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:47
 */
@Service
public class DictDataServiceImpl extends BizServiceImpl< IDictDataMapper, DictData,  DictDataVo, DictDataQuery, String > implements IDictDataService {
    private static final Logger logger = LoggerFactory.getLogger(DictDataServiceImpl.class);

    /***
    * 分页
    *
    * @author 王大宸
    * @date 2023-04-04 21:44:47
    * @param params params
    * @return cn.edu.hubu.common.core.response.TableData<com.github.itdachen.admin.sdk.vo.dictDataVo>
    */
    @Override
    public TableData<DictDataVo> page(DictDataQuery params) throws Exception {
        Page<DictDataVo> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<DictDataVo> list = bizMapper.page(params);
        return new TableData<DictDataVo>(page.getTotal(), list);
    }


}
