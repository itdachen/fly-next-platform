package com.github.itdachen.admin.service.impl;

import com.github.itdachen.admin.entity.MenuInfo;
import com.github.itdachen.boot.autoconfigure.app.AppInfoProperties;
import com.github.itdachen.framework.context.constants.YesOrNotConstant;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.context.tree.ZTreeNode;
import com.github.itdachen.framework.core.constants.RootConstant;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.core.utils.StringUtils;
import com.github.itdachen.framework.webmvc.entity.EntityUtils;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.itdachen.admin.entity.TenantInfo;
import com.github.itdachen.admin.sdk.dto.TenantInfoDTO;
import com.github.itdachen.admin.sdk.query.TenantInfoQuery;
import com.github.itdachen.admin.sdk.vo.TenantInfoVO;
import com.github.itdachen.admin.mapper.ITenantInfoMapper;
import com.github.itdachen.admin.service.ITenantInfoService;
import com.github.itdachen.admin.convert.TenantInfoConvert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 租户/公司信息 业务实现
 *
 * @author 王大宸
 * @date 2024-04-24 22:42:35
 */
@Service
public class TenantInfoServiceImpl extends BizServiceImpl<ITenantInfoMapper, TenantInfo, TenantInfoDTO, TenantInfoVO, TenantInfoQuery, String> implements ITenantInfoService {
    private static final Logger logger = LoggerFactory.getLogger(TenantInfoServiceImpl.class);
    private static final TenantInfoConvert bizConvert = new TenantInfoConvert();
    private final AppInfoProperties appInfoProperties;

    public TenantInfoServiceImpl(AppInfoProperties appInfoProperties) {
        super(bizConvert);
        this.appInfoProperties = appInfoProperties;
    }

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2024-04-24 22:42:35
     * @param params params
     * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.admin.sdk.vo.tenantInfoVo>
     */
    @Override
    public TableData<TenantInfoVO> page(TenantInfoQuery params) throws Exception {
        Page<TenantInfoVO> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<TenantInfoVO> list = bizMapper.list(params);
        return new TableData<TenantInfoVO>(page.getTotal(), list);
    }

    /***
     * 新增
     *
     * @author 王大宸
     * @date 2024/4/25 20:40
     * @param tenantInfoDTO tenantInfoDTO
     * @return com.github.itdachen.admin.sdk.vo.TenantInfoVO
     */
    @Override
    public TenantInfoVO saveInfo(TenantInfoDTO tenantInfoDTO) throws Exception {
        TenantInfo javaObject = bizConvert.toJavaObject(tenantInfoDTO);
        if (StringUtils.isEmpty(javaObject.getTitleAs())) {
            javaObject.setTitleAs(javaObject.getTitle());
        }
        javaObject.setValidDel(YesOrNotConstant.Y);
        EntityUtils.setCreatAndUpdateInfo(javaObject);

        String area = javaObject.getCountyId();
        if (StringUtils.isEmpty(area)) {
            area = javaObject.getCityId() + "00";
        }
        if (StringUtils.isEmpty(area)) {
            area = javaObject.getProvId()+ "0000";
        }
       // area = String.format("%6s", area).replace(' ', '0');
        Integer tenantInfoCount = bizMapper.findTenantInfoCount();
        tenantInfoCount += 1;
        if (100000000 > tenantInfoCount) {
            tenantInfoCount = 100000000 + tenantInfoCount;
        }
        String id = area + tenantInfoCount;
        javaObject.setId(id);

        bizMapper.insertSelective(javaObject);
        return bizConvert.toJavaObjectVO(javaObject);
    }

    /***
     * 编辑
     *
     * @author 王大宸
     * @date 2024/4/25 20:40
     * @param tenantInfoDTO tenantInfoDTO
     * @return com.github.itdachen.admin.sdk.vo.TenantInfoVO
     */
    @Override
    public TenantInfoVO updateInfo(TenantInfoDTO tenantInfoDTO) throws Exception {
        TenantInfo javaObject = bizConvert.toJavaObject(tenantInfoDTO);
        javaObject.setValidDel(YesOrNotConstant.Y);
        EntityUtils.setUpdatedInfo(javaObject);
        if (StringUtils.isEmpty(javaObject.getTitleAs())) {
            javaObject.setTitleAs(javaObject.getTitle());
        }
        bizMapper.updateByPrimaryKeySelective(javaObject);
        return bizConvert.toJavaObjectVO(javaObject);
    }

    /***
     * 删除
     *
     * @author 王大宸
     * @date 2024/4/25 20:39
     * @param id id
     * @return int
     */
    @Override
    public int deleteByPrimaryKey(String id) throws Exception {
        TenantInfo tenantInfo = bizMapper.selectByPrimaryKey(id);
        if (YesOrNotConstant.N.equals(tenantInfo.getValidDel())) {
            throw new BizException("该公司不能被删除！");
        }
        return bizMapper.deleteByPrimaryKey(id);
    }

    /***
     * 获取树结构
     *
     * @author 王大宸
     * @date 2024/4/24 23:47
     * @return java.util.List<com.github.itdachen.framework.context.tree.ZTreeNode>
     */
    @Override
    public List<ZTreeNode> findTenantTree() throws Exception {
        List<ZTreeNode> list = bizMapper.findTenantChildrenTree(RootConstant.ROOT_ID);
        for (ZTreeNode zTreeNode : list) {
            zTreeNode.setOpen(true);
            zTreeNode.setIconOpen(appInfoProperties.getContextPath() + ZTreeNode.zTreeBuMenIcon);
            zTreeNode.setIconClose(appInfoProperties.getContextPath() + ZTreeNode.zTreeJiGuoIcon);
        }

        List<ZTreeNode> tenantTree = bizMapper.findTenantTree();
        for (ZTreeNode child : tenantTree) {
            child.setOpen(true);
            child.setIconOpen(appInfoProperties.getContextPath() + ZTreeNode.zTreeOpenIcon);
            child.setIconClose(appInfoProperties.getContextPath() + ZTreeNode.zTreeCloseIcon);
        }

        list.addAll(tenantTree);
        return list;
    }


    /***
     * 有效标志
     *
     * @author 王大宸
     * @date 2024/4/25 21:10
     * @param id id
     * @param checked checked
     * @return void
     */
    @Override
    public void validFlagChecked(String id, Boolean checked) throws Exception {
        TenantInfo tenantInfo1 = bizMapper.selectByPrimaryKey(id);
        if (YesOrNotConstant.N.equals(tenantInfo1.getValidDel())) {
            throw new BizException("该公司不能被更改状态！");
        }
        TenantInfo tenantInfo = new TenantInfo();
        tenantInfo.setId(id);
        tenantInfo.setValidFlag(checked ? YesOrNotConstant.Y : YesOrNotConstant.N);
        bizMapper.updateByPrimaryKeySelective(tenantInfo);
    }


}
