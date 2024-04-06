package com.github.itdachen.admin_v1.service.impl;

import com.github.itdachen.admin_v1.convert.IWorkerInfoConvert;
import com.github.itdachen.admin_v1.entity.WorkerInfo;
import com.github.itdachen.admin_v1.mapper.IWorkerInfoMapper;
import com.github.itdachen.admin_v1.sdk.dto.WorkerInfoDto;
import com.github.itdachen.admin_v1.sdk.query.WorkerInfoQuery;
import com.github.itdachen.admin_v1.sdk.vo.WorkerInfoVo;
import com.github.itdachen.admin_v1.service.IWorkerInfoService;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 员工信息 业务实现
 *
 * @author 王大宸
 * @date 2023-05-16 19:37:24
 */
@Service
public class WorkerInfoServiceImpl extends BizServiceImpl<IWorkerInfoMapper, IWorkerInfoConvert, WorkerInfo, WorkerInfoDto, WorkerInfoVo, WorkerInfoQuery, String> implements IWorkerInfoService {
    private static final Logger logger = LoggerFactory.getLogger(WorkerInfoServiceImpl.class);

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2023-05-16 19:37:24
     * @param params params
     * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.admin.sdk.vo.workerInfoVo>
     */
    @Override
    public TableData<WorkerInfoVo> page(WorkerInfoQuery params) throws Exception {
        Page<WorkerInfoVo> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<WorkerInfoVo> list = bizMapper.page(params);
        return new TableData<WorkerInfoVo>(page.getTotal(), list);
    }


}
