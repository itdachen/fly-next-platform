package com.github.itdachen.admin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.itdachen.admin.entity.DictType;
import com.github.itdachen.admin.sdk.query.DictTypeQuery;
import com.github.itdachen.admin.sdk.vo.DictTypeVo;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.itdachen.admin.mapper.IDictTypeMapper;
import com.github.itdachen.admin.service.IDictTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 字典类型表 业务实现
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:47
 */
@Service
public class DictTypeServiceImpl extends BizServiceImpl< IDictTypeMapper, DictType,  DictTypeVo, DictTypeQuery, String > implements IDictTypeService {
    private static final Logger logger = LoggerFactory.getLogger(DictTypeServiceImpl.class);

    /***
    * 分页
    *
    * @author 王大宸
    * @date 2023-04-04 21:44:47
    * @param params params
    * @return cn.edu.hubu.common.core.response.TableData<com.github.itdachen.admin.sdk.vo.dictTypeVo>
    */
    @Override
    public TableData<DictTypeVo> page(DictTypeQuery params) throws Exception {
        Page<DictTypeVo> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<DictTypeVo> list = bizMapper.page(params);
        return new TableData<DictTypeVo>(page.getTotal(), list);
    }


}
