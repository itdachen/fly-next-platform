package com.github.itdachen.admin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.itdachen.admin.entity.MakeUseLog;
import com.github.itdachen.admin.sdk.query.MakeUseLogQuery;
import com.github.itdachen.admin.sdk.vo.MakeUseLogVo;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.itdachen.admin.mapper.IMakeUseLogMapper;
import com.github.itdachen.admin.service.IMakeUseLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 日志表 业务实现
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:45
 */
@Service
public class MakeUseLogServiceImpl extends BizServiceImpl< IMakeUseLogMapper, MakeUseLog,  MakeUseLogVo, MakeUseLogQuery, String > implements IMakeUseLogService {
    private static final Logger logger = LoggerFactory.getLogger(MakeUseLogServiceImpl.class);

    /***
    * 分页
    *
    * @author 王大宸
    * @date 2023-04-04 21:44:45
    * @param params params
    * @return cn.edu.hubu.common.core.response.TableData<com.github.itdachen.admin.sdk.vo.makeUseLogVo>
    */
    @Override
    public TableData<MakeUseLogVo> page(MakeUseLogQuery params) throws Exception {
        Page<MakeUseLogVo> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<MakeUseLogVo> list = bizMapper.page(params);
        return new TableData<MakeUseLogVo>(page.getTotal(), list);
    }


}