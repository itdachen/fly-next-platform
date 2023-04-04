package com.github.itdachen.admin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.itdachen.admin.entity.DeptInfo;
import com.github.itdachen.admin.sdk.query.DeptInfoQuery;
import com.github.itdachen.admin.sdk.vo.DeptInfoVo;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.itdachen.admin.mapper.IDeptInfoMapper;
import com.github.itdachen.admin.service.IDeptInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 部门管理 业务实现
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:47
 */
@Service
public class DeptInfoServiceImpl extends BizServiceImpl< IDeptInfoMapper, DeptInfo,  DeptInfoVo, DeptInfoQuery, String > implements IDeptInfoService {
    private static final Logger logger = LoggerFactory.getLogger(DeptInfoServiceImpl.class);

    /***
    * 分页
    *
    * @author 王大宸
    * @date 2023-04-04 21:44:47
    * @param params params
    * @return cn.edu.hubu.common.core.response.TableData<com.github.itdachen.admin.sdk.vo.deptInfoVo>
    */
    @Override
    public TableData<DeptInfoVo> page(DeptInfoQuery params) throws Exception {
        Page<DeptInfoVo> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<DeptInfoVo> list = bizMapper.page(params);
        return new TableData<DeptInfoVo>(page.getTotal(), list);
    }


}
