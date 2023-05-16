package com.github.itdachen.admin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.itdachen.admin.convert.WorkerIdentityConvert;
import com.github.itdachen.admin.entity.WorkerIdentity;
import com.github.itdachen.admin.sdk.dto.WorkerIdentityDto;
import com.github.itdachen.admin.sdk.query.WorkerIdentityQuery;
import com.github.itdachen.admin.sdk.vo.WorkerIdentityVo;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.itdachen.admin.mapper.IWorkerIdentityMapper;
import com.github.itdachen.admin.service.IWorkerIdentityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 职工身份 业务实现
 *
 * @author 王大宸
 * @date 2023-05-16 21:19:44
 */
@Service
public class WorkerIdentityServiceImpl extends BizServiceImpl< WorkerIdentity, WorkerIdentityDto,  WorkerIdentityVo, WorkerIdentityQuery, String > implements IWorkerIdentityService {
    private static final Logger logger = LoggerFactory.getLogger(WorkerIdentityServiceImpl.class);
    private static final WorkerIdentityConvert bizConvert = new WorkerIdentityConvert();
    private final IWorkerIdentityMapper bizMapper;

    public WorkerIdentityServiceImpl(IWorkerIdentityMapper workerIdentityMapper) {
        super(workerIdentityMapper, bizConvert);
        this.bizMapper = workerIdentityMapper;
    }

    /***
    * 分页
    *
    * @author 王大宸
    * @date 2023-05-16 21:19:44
    * @param params params
    * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.admin.sdk.vo.workerIdentityVo>
    */
    @Override
    public TableData< WorkerIdentityVo > page(WorkerIdentityQuery params) throws Exception {
        Page< WorkerIdentityVo > page = PageHelper.startPage(params.getPage(), params.getLimit());
        List< WorkerIdentityVo > list = bizMapper.page(params);
        return new TableData< WorkerIdentityVo >(page.getTotal(), list);
    }


}
