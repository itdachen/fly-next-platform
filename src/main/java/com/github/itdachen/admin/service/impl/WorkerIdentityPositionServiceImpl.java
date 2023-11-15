package com.github.itdachen.admin.service.impl;

import com.github.itdachen.admin.convert.IWorkerIdentityPosttionConvert;
import com.github.itdachen.admin.entity.WorkerIdentityPosition;
import com.github.itdachen.admin.mapper.IWorkerIdentityPositionMapper;
import com.github.itdachen.admin.sdk.dto.WorkerIdentityPositionDto;
import com.github.itdachen.admin.sdk.query.WorkerIdentityPositionQuery;
import com.github.itdachen.admin.sdk.vo.WorkerIdentityPositionVo;
import com.github.itdachen.admin.service.IWorkerIdentityPositionService;
import com.github.itdachen.framework.assets.tree.ZTreeNode;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.core.utils.StringUtils;
import com.github.itdachen.framework.webmvc.entity.EntityUtils;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 身份岗位 业务实现
 *
 * @author 王大宸
 * @date 2023-05-16 23:12:21
 */
@Service
public class WorkerIdentityPositionServiceImpl extends BizServiceImpl<IWorkerIdentityPositionMapper, IWorkerIdentityPosttionConvert, WorkerIdentityPosition, WorkerIdentityPositionDto, WorkerIdentityPositionVo, WorkerIdentityPositionQuery, String> implements IWorkerIdentityPositionService {
    private static final Logger logger = LoggerFactory.getLogger(WorkerIdentityPositionServiceImpl.class);

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2023-05-16 23:12:21
     * @param params params
     * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.admin.sdk.vo.workerIdentityPosttionVo>
     */
    @Override
    public TableData<WorkerIdentityPositionVo> page(WorkerIdentityPositionQuery params) throws Exception {
        Page<WorkerIdentityPositionVo> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<WorkerIdentityPositionVo> list = bizMapper.page(params);
        return new TableData<WorkerIdentityPositionVo>(page.getTotal(), list);
    }

    /***
     * 新增
     *
     * @author 王大宸
     * @date 2023/5/16 23:22
     * @param workerIdentityPositionDto workerIdentityPositionDto
     * @return com.github.itdachen.admin.sdk.vo.WorkerIdentityPositionVo
     */
    @Override
    public WorkerIdentityPositionVo saveInfo(WorkerIdentityPositionDto workerIdentityPositionDto) throws Exception {
        if (null == workerIdentityPositionDto) {
            throw new BizException("岗位信息不能为空");
        }

        bizMapper.removeIdentityPosition(workerIdentityPositionDto.getIdentityId(), workerIdentityPositionDto.getClientId());

        if (StringUtils.isEmpty(workerIdentityPositionDto.getPositionId())) {
            return null;
        }
        String positions = workerIdentityPositionDto.getPositionId();
        List<String> positionsList = new ArrayList<>(Arrays.asList(positions.split(",")));
        if (positionsList.isEmpty()) {
            return null;
        }

        List<WorkerIdentityPosition> list = new ArrayList<>();

        WorkerIdentityPosition one = null;
        for (String positionId : positionsList) {
            if (ZTreeNode.ROOT_ID.equals(positionId)) {
                continue;
            }
            one = new WorkerIdentityPosition();
            one.setId(EntityUtils.getId());
            one.setPositionId(positionId);
            one.setIdentityId(workerIdentityPositionDto.getIdentityId());
            one.setClientId(workerIdentityPositionDto.getClientId());
            list.add(one);
        }
        bizMapper.batchSave(list);
        return bizConvert.toJavaObjectVo(workerIdentityPositionDto);
    }

}
