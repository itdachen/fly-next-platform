package com.github.itdachen.admin.service.impl;

import com.github.itdachen.admin.mapper.IAuthClazzRoleMapper;
import com.github.itdachen.admin.mapper.IClazzDeptMapper;
import com.github.itdachen.admin.mapper.IDeptInfoMapper;
import com.github.itdachen.admin.sdk.vo.DeptInfoVO;
import com.github.itdachen.boot.autoconfigure.app.AppInfoProperties;
import com.github.itdachen.framework.context.BizContextHandler;
import com.github.itdachen.framework.context.constants.YesOrNotConstant;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.context.tree.ZTreeNode;
import com.github.itdachen.framework.core.AssertUtils;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.entity.EntityUtils;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.itdachen.admin.entity.UserRoleInfo;
import com.github.itdachen.admin.sdk.dto.UserRoleInfoDTO;
import com.github.itdachen.admin.sdk.query.UserRoleInfoQuery;
import com.github.itdachen.admin.sdk.vo.UserRoleInfoVO;
import com.github.itdachen.admin.mapper.IUserRoleInfoMapper;
import com.github.itdachen.admin.service.IUserRoleInfoService;
import com.github.itdachen.admin.convert.UserRoleInfoConvert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 身份信息 业务实现
 *
 * @author 王大宸
 * @date 2024-04-27 20:42:58
 */
@Service
public class UserRoleInfoServiceImpl extends BizServiceImpl<IUserRoleInfoMapper, UserRoleInfo, UserRoleInfoDTO, UserRoleInfoVO, UserRoleInfoQuery, String> implements IUserRoleInfoService {
    private static final Logger logger = LoggerFactory.getLogger(UserRoleInfoServiceImpl.class);
    private static final UserRoleInfoConvert bizConvert = new UserRoleInfoConvert();

    @Autowired
    private IDeptInfoMapper deptInfoMapper;

    @Autowired
    private AppInfoProperties appInfoProperties;
    @Autowired
    private IClazzDeptMapper clazzDeptMapper;
    @Autowired
    private IAuthClazzRoleMapper authClazzRoleMapper;

    public UserRoleInfoServiceImpl() {
        super(bizConvert);
    }

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2024-04-27 20:42:58
     * @param params params
     * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.admin.sdk.vo.userRoleInfoVo>
     */
    @Override
    public TableData<UserRoleInfoVO> page(UserRoleInfoQuery params) throws Exception {
        Page<UserRoleInfoVO> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<UserRoleInfoVO> list = bizMapper.list(params);
        return new TableData<UserRoleInfoVO>(page.getTotal(), list);
    }


    /***
     * 新增
     *
     * @author 王大宸
     * @date 2024/4/27 22:00
     * @param userRoleInfoDTO userRoleInfoDTO
     * @return com.github.itdachen.admin.sdk.vo.UserRoleInfoVO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserRoleInfoVO saveInfo(UserRoleInfoDTO userRoleInfoDTO) throws Exception {
        DeptInfoVO deptInfoVO = deptInfoMapper.selectDeptInfoVO(userRoleInfoDTO.getDeptId());
        AssertUtils.isTrue(null == deptInfoVO, "部门数据不存在, 请刷新数据!");

        assert deptInfoVO != null;
        userRoleInfoDTO.setDeptTitle(deptInfoVO.getTitle());
        if (YesOrNotConstant.Y.equals(userRoleInfoDTO.getRoleFlag())) {
            UserRoleInfoVO userRoleInfoVO = bizMapper.findRoleFlag(userRoleInfoDTO.getUserId());
            AssertUtils.isTrue(null != userRoleInfoVO, "该人员主身份已经存在！");
        }
        UserRoleInfo userRoleInfo = bizConvert.toJavaObject(userRoleInfoDTO);
        EntityUtils.setCreatAndUpdateInfo(userRoleInfo);

        /* 添加身份ID */
        Integer userRoleTotal = bizMapper.findUserRoleTotal(userRoleInfo.getUserId());
        if (null == userRoleTotal) {
            userRoleTotal = 0;
        }
        userRoleTotal++;
        String userRoleTotalStr = String.format("%02d", userRoleTotal);
        String userRoleId = userRoleInfo.getUserId() + userRoleTotalStr;
        userRoleInfo.setId(userRoleId);

        bizMapper.insertSelective(userRoleInfo);
        return bizConvert.toJavaObjectVO(userRoleInfo);
    }

    /***
     * 编辑
     *
     * @author 王大宸
     * @date 2024/4/27 22:09
     * @param userRoleInfoDTO userRoleInfoDTO
     * @return com.github.itdachen.admin.sdk.vo.UserRoleInfoVO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserRoleInfoVO updateInfo(UserRoleInfoDTO userRoleInfoDTO) throws Exception {
        if (YesOrNotConstant.Y.equals(userRoleInfoDTO.getRoleFlag())) {
            UserRoleInfoVO db = bizMapper.selectUserRoleInfoVO(userRoleInfoDTO.getId());
            if (null == db) {
                throw new BizException("数据不存在, 请刷新数据！");
            }
            UserRoleInfoVO userRoleInfoVO = bizMapper.findRoleFlag(db.getUserId());
            if (null != userRoleInfoVO && !userRoleInfoDTO.getId().equals(userRoleInfoVO.getId())) {
                throw new BizException("该人员主身份已经存在！");
            }
        }
        UserRoleInfo javaObject = bizConvert.toJavaObject(userRoleInfoDTO);
        EntityUtils.setUpdatedInfo(javaObject);
        bizMapper.updateByPrimaryKeySelective(javaObject);
        return bizConvert.toJavaObjectVO(javaObject);
    }

    /***
     * 有效标志
     *
     * @author 王大宸
     * @date 2024/4/27 21:27
     * @param id id
     * @param checked checked
     * @return void
     */
    @Override
    public void validFlagChecked(String id, Boolean checked) throws Exception {
        UserRoleInfo info = new UserRoleInfo();
        info.setId(id);
        info.setValidFlag(checked ? YesOrNotConstant.Y : YesOrNotConstant.N);
        bizMapper.updateByPrimaryKeySelective(info);
    }

    /***
     * 获取部门岗位权限
     *
     * @author 王大宸
     * @date 2024/5/15 20:49
     * @param roleId 人员身份ID
     * @return java.util.List<com.github.itdachen.framework.context.tree.ZTreeNode>
     */
    @Override
    public List<ZTreeNode> deptClazzTree(String roleId) throws Exception {
        UserRoleInfoVO userRoleInfoVO = bizMapper.selectUserRoleInfoVO(roleId);
        if (null == userRoleInfoVO) {
            throw new BizException("人员身份数据不存在, 请刷新数据!");
        }
        DeptInfoVO deptInfoVO = deptInfoMapper.selectDeptInfoVO(userRoleInfoVO.getDeptId());
        if (null == deptInfoVO) {
            throw new BizException("部门数据不存在, 请刷新数据!");
        }

        List<ZTreeNode> list = new ArrayList<>();
        list.add(new ZTreeNode.Builder()
                .id(deptInfoVO.getId())
                .name(deptInfoVO.getTitle())
                .parentId(ZTreeNode.ROOT_PARENT_ID)
                .open(true)
                .openIcon(appInfoProperties.getContextPath() + ZTreeNode.zTreeBuMenIcon)
                .closeIcon(appInfoProperties.getContextPath() + ZTreeNode.zTreeJiGuoIcon)
                .build());
        List<ZTreeNode> clazzDept = clazzDeptMapper.findClazzDept(BizContextHandler.getTenantId(), deptInfoVO.getId());
        list.addAll(clazzDept);

        List<String> checkedRole = authClazzRoleMapper.findCheckedRole(BizContextHandler.getTenantId(), roleId);

        for (ZTreeNode treeNode : list) {
            if (!checkedRole.contains(treeNode.getId())) {
                continue;
            }
            treeNode.setChecked(true);
        }

        return list;
    }


}
