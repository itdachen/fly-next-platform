package com.github.itdachen.admin.service.impl;

import com.github.itdachen.framework.context.BizContextHandler;
import com.github.itdachen.framework.context.constants.YesOrNotConstant;
import com.github.itdachen.framework.context.tree.ZTreeNode;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.entity.EntityUtils;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.itdachen.admin.entity.ClazzDept;
import com.github.itdachen.admin.sdk.dto.ClazzDeptDTO;
import com.github.itdachen.admin.sdk.query.ClazzDeptQuery;
import com.github.itdachen.admin.sdk.vo.ClazzDeptVO;
import com.github.itdachen.admin.mapper.IClazzDeptMapper;
import com.github.itdachen.admin.service.IClazzDeptService;
import com.github.itdachen.admin.convert.ClazzDeptConvert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 部门岗位关联表 业务实现
 *
 * @author 王大宸
 * @date 2024-05-10 21:17:50
 */
@Service
public class ClazzDeptServiceImpl extends BizServiceImpl<IClazzDeptMapper, ClazzDept, ClazzDeptDTO, ClazzDeptVO, ClazzDeptQuery, String> implements IClazzDeptService {
    private static final Logger logger = LoggerFactory.getLogger(ClazzDeptServiceImpl.class);
    private static final ClazzDeptConvert bizConvert = new ClazzDeptConvert();

    public ClazzDeptServiceImpl() {
        super(bizConvert);
    }

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2024-05-10 21:17:50
     * @param params params
     * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.admin.sdk.vo.clazzDeptVo>
     */
    @Override
    public TableData<ClazzDeptVO> page(ClazzDeptQuery params) throws Exception {
        Page<ClazzDeptVO> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<ClazzDeptVO> list = bizMapper.list(params);
        return new TableData<ClazzDeptVO>(page.getTotal(), list);
    }


    /***
     * 新增
     *
     * @author 王大宸
     * @date 2024/5/10 22:48
     * @param clazzDeptDTO clazzDeptDTO
     * @return com.github.itdachen.admin.sdk.vo.ClazzDeptVO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ClazzDeptVO saveInfo(ClazzDeptDTO clazzDeptDTO) throws Exception {
        List<String> clazzIdList = new ArrayList<>(Arrays.asList(clazzDeptDTO.getClazzId().split(",")));
        if (clazzIdList.isEmpty()) {
            return null;
        }
        List<ClazzDept> list = new ArrayList<>();
        ClazzDept one;
        for (String clazzId : clazzIdList) {
            if (ZTreeNode.ROOT_ID.equals(clazzId)) {
                continue;
            }
            one = new ClazzDept();
            one.setId(EntityUtils.getId());
            one.setTenantId(BizContextHandler.getTenantId());
            one.setDeptId(clazzDeptDTO.getDeptId());
            one.setClazzId(clazzId);
            one.setAppId("");
            one.setValidFlag(YesOrNotConstant.Y);
            one.setClazzTitle("");
            list.add(one);
        }
        if (!list.isEmpty()) {
            bizMapper.batchSave(list);
        }
        return null;
    }

    @Override
    public TableData<ZTreeNode> clazzPage(ClazzDeptQuery params) throws Exception {
        Page<ZTreeNode> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<ZTreeNode> list = bizMapper.clazzPage(params);
        return new TableData<ZTreeNode>(page.getTotal(), list);
    }


    /***
     * 有效标志
     *
     * @author 王大宸
     * @date 2024/4/25 23:03
     * @param id id
     * @param checked checked
     * @return void
     */
    @Override
    public void validFlagChecked(String id, Boolean checked) throws Exception {
        ClazzDept info = new ClazzDept();
        info.setId(id);
        info.setValidFlag(checked ? YesOrNotConstant.Y : YesOrNotConstant.N);
        bizMapper.updateByPrimaryKeySelective(info);
    }


}
