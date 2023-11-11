package com.github.itdachen.admin.service.impl;

import com.github.itdachen.admin.convert.IPositionInfoConvert;
import com.github.itdachen.admin.entity.PositionInfo;
import com.github.itdachen.admin.mapper.IPositionInfoMapper;
import com.github.itdachen.admin.mapper.IWorkerIdentityPositionMapper;
import com.github.itdachen.admin.sdk.dto.PositionInfoDto;
import com.github.itdachen.admin.sdk.query.PositionInfoQuery;
import com.github.itdachen.admin.sdk.vo.PositionInfoVo;
import com.github.itdachen.admin.service.IPositionInfoService;
import com.github.itdachen.framework.context.constants.YesOrNotConstant;
import com.github.itdachen.framework.context.node.TreeNode;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 岗位信息 业务实现
 *
 * @author 王大宸
 * @date 2023-05-15 20:13:36
 */
@Service
public class PositionInfoServiceImpl extends BizServiceImpl<IPositionInfoMapper, IPositionInfoConvert, PositionInfo, PositionInfoDto, PositionInfoVo, PositionInfoQuery, String> implements IPositionInfoService {
    private static final Logger logger = LoggerFactory.getLogger(PositionInfoServiceImpl.class);
    private final IWorkerIdentityPositionMapper identityPositionMapper;

    public PositionInfoServiceImpl(IWorkerIdentityPositionMapper identityPositionMapper) {
        this.identityPositionMapper = identityPositionMapper;
    }

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2023-05-15 20:13:36
     * @param params params
     * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.admin.sdk.vo.positionInfoVo>
     */
    @Override
    public TableData<PositionInfoVo> page(PositionInfoQuery params) throws Exception {
        Page<PositionInfoVo> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<PositionInfoVo> list = bizMapper.page(params);
        return new TableData<PositionInfoVo>(page.getTotal(), list);
    }


    /***
     * 根据部门查询岗位
     *
     * @author 王大宸
     * @date 2023/5/16 22:46
     * @param deptId deptId
     * @return com.github.itdachen.framework.context.node.TreeNode<com.github.itdachen.admin.sdk.vo.MenuInfoVo, java.lang.String>
     */
    @Override
    public TreeNode<PositionInfoVo, String> findPositionByDept(String deptId, String identityId) throws Exception {
        List<PositionInfoVo> positions = bizMapper.findPositionByDept(deptId, YesOrNotConstant.YES);
        if (0 == positions.size()) {
            return new TreeNode<PositionInfoVo, String>(positions, new ArrayList<>());
        }
        positions.add(PositionInfoVo.builder()
                .title("请选择岗位")
                .id(deptId)
                .deptId("0")
                .build());
        List<String> position = identityPositionMapper.findPosition(identityId);
        return new TreeNode<PositionInfoVo, String>(positions, position);
    }
}
