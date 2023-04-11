package com.github.itdachen.admin.service.impl;

import com.github.itdachen.framework.assets.tree.ZTreeNode;
import com.github.itdachen.framework.context.constants.YesOrNotConstant;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.webmvc.entity.EntityUtils;
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
public class DeptInfoServiceImpl extends BizServiceImpl<IDeptInfoMapper, DeptInfo, DeptInfoVo, DeptInfoQuery, String> implements IDeptInfoService {
    private static final Logger logger = LoggerFactory.getLogger(DeptInfoServiceImpl.class);

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2023/4/11 21:10
     * @param params params
     * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.admin.sdk.vo.DeptInfoVo>
     */
    @Override
    public TableData<DeptInfoVo> page(DeptInfoQuery params) throws Exception {
        Page<DeptInfoVo> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<DeptInfoVo> list = bizMapper.page(params);
        return new TableData<DeptInfoVo>(page.getTotal(), list);
    }

    /***
     * 新增
     *
     * @author 王大宸
     * @date 2023/4/5 0:46
     * @param entity entity
     * @return com.github.itdachen.admin.entity.DeptInfo
     */
    @Override
    public DeptInfo save(DeptInfo entity) throws Exception {
        entity.setIsCanDel(YesOrNotConstant.YES);
        return super.save(entity);
    }

    /***
     * 更新
     *
     * @author 王大宸
     * @date 2023/4/5 0:46
     * @param entity entity
     * @return com.github.itdachen.admin.entity.DeptInfo
     */
    @Override
    public DeptInfo update(DeptInfo entity) throws Exception {
        DeptInfo dept = bizMapper.selectByPrimaryKey(entity.getId());
        if (YesOrNotConstant.NOT.equals(dept.getIsCanDel())) {
            if (YesOrNotConstant.YES.equals(entity.getIsCanDel())) {
                throw new BizException("非法操作");
            }
        }
        EntityUtils.setUpdatedInfo(entity);
        bizMapper.updateByPrimaryKeySelective(entity);
        return entity;
    }

    /***
     * 删除
     *
     * @author 王大宸
     * @date 2023/4/5 0:48
     * @param id id
     * @return int
     */
    @Override
    public int remove(String id) throws Exception {
        DeptInfo dept = bizMapper.selectByPrimaryKey(id);
        if (null == dept) {
            return 0;
        }
        if (YesOrNotConstant.NOT.equals(dept.getIsCanDel())) {
            throw new BizException("该部门不能删除");
        }
        Integer integer = bizMapper.hasChildren(id);
        if (null != integer) {
            throw new BizException("该部门存在子部门, 请先删除子部门");
        }
        return bizMapper.deleteByPrimaryKey(id);
    }


    /***
     * 获取部门树
     *
     * @author 王大宸
     * @date 2023/4/4 23:46
     * @return java.util.List<com.github.itdachen.framework.assets.tree.ZTreeNode>
     */
    @Override
    public List<ZTreeNode> zTree() throws BizException {
        ZTreeNode rootDept = bizMapper.findRootDept();
        if (null == rootDept) {
            rootDept = new ZTreeNode.Builder()
                    .id("ROOT")
                    .name("王牌平台")
                    .parentId("0")
                    .build();
        }
        rootDept.setOpen(true);
        rootDept.setIconOpen(ZTreeNode.zTreeBuMenIcon);
        rootDept.setIconClose(ZTreeNode.zTreeJiGuoIcon);

        List<ZTreeNode> zTreeNode = bizMapper.zTree();
        zTreeNode.forEach(item -> {
            item.setOpen(true);
            item.setIconOpen(ZTreeNode.zTreeOpenIcon);
            item.setIconClose(ZTreeNode.zTreeCloseIcon);
        });
        zTreeNode.add(rootDept);

        return zTreeNode;
    }

}
