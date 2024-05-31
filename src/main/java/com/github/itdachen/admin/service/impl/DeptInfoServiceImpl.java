package com.github.itdachen.admin.service.impl;

import com.github.itdachen.admin.entity.MenuInfo;
import com.github.itdachen.admin.mapper.ITenantInfoMapper;
import com.github.itdachen.admin.sdk.vo.TenantInfoVO;
import com.github.itdachen.boot.autoconfigure.app.AppInfoProperties;
import com.github.itdachen.framework.context.BizContextHandler;
import com.github.itdachen.framework.context.constants.DeptLevelConstants;
import com.github.itdachen.framework.context.constants.YesOrNotConstant;
import com.github.itdachen.framework.context.tree.ZTreeNode;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.core.utils.StringUtils;
import com.github.itdachen.framework.webmvc.entity.EntityUtils;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.itdachen.admin.entity.DeptInfo;
import com.github.itdachen.admin.sdk.dto.DeptInfoDTO;
import com.github.itdachen.admin.sdk.query.DeptInfoQuery;
import com.github.itdachen.admin.sdk.vo.DeptInfoVO;
import com.github.itdachen.admin.mapper.IDeptInfoMapper;
import com.github.itdachen.admin.service.IDeptInfoService;
import com.github.itdachen.admin.convert.DeptInfoConvert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 部门信息 业务实现
 *
 * @author 王大宸
 * @date 2024-04-24 21:47:25
 */
@Service
public class DeptInfoServiceImpl extends BizServiceImpl<IDeptInfoMapper, DeptInfo, DeptInfoDTO, DeptInfoVO, DeptInfoQuery, String> implements IDeptInfoService {
    private static final Logger logger = LoggerFactory.getLogger(DeptInfoServiceImpl.class);
    private static final DeptInfoConvert bizConvert = new DeptInfoConvert();

    private final ITenantInfoMapper tenantInfoMapper;
    private final AppInfoProperties appInfoProperties;

    public DeptInfoServiceImpl(ITenantInfoMapper tenantInfoMapper,
                               AppInfoProperties appInfoProperties) {
        super(bizConvert);
        this.tenantInfoMapper = tenantInfoMapper;
        this.appInfoProperties = appInfoProperties;
    }

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2024-04-24 21:47:25
     * @param params params
     * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.admin.sdk.vo.deptInfoVo>
     */
    @Override
    public TableData<DeptInfoVO> page(DeptInfoQuery params) throws Exception {
        Page<DeptInfoVO> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<DeptInfoVO> list = bizMapper.list(params);
        return new TableData<DeptInfoVO>(page.getTotal(), list);
    }


    @Override
    public DeptInfoVO saveInfo(DeptInfoDTO deptInfoDTO) throws Exception {
        DeptInfo deptInfo = bizConvert.toJavaObject(deptInfoDTO);
        deptInfo.setTenantId(BizContextHandler.getTenantId());
        EntityUtils.setCreatAndUpdateInfo(deptInfo);

        String deptId = "00" ;
        // 部门ID组成
        // 52 00 00 00 00 101 00
        // 省级编码(两位) 市州编码(两位) 区县编码(两位) 乡镇编码(两位) 村级/街道编码(两位) 部门职能编码(三位) 备用(两位)
        switch (deptInfoDTO.getDeptLevel()) {
            // 00000000 101 00
            case DeptLevelConstants.ROOT_LEVEL:  // 总部
                deptId = "1000000000" + deptInfo.getFuncCode() + "00" ;
                break;
            case DeptLevelConstants.PROV_LEVEL: // 省级
                // 5200000000 101 00
                deptId = deptInfo.getProvId() + "00000000" + deptInfo.getFuncCode() + "00" ;
                break;
            case DeptLevelConstants.CITY_LEVEL: // 市/州级
                // 5202 000000 101 0000
                deptId = deptInfo.getCityId() + "000000" + deptInfo.getFuncCode() + " 00" ;
                break;
            case DeptLevelConstants.COUNT_LEVEL:  // 区/县级
                // 520202000010100
                deptId = deptInfo.getCountyId() + "0000" + deptInfo.getFuncCode() + "00" ;
                break;
            case DeptLevelConstants.STREET_LEVEL:  // 街道/乡镇级(暂时不用)
                deptId = "00" + deptInfo.getFuncCode() + "00" ;
                break;
            case DeptLevelConstants.VILLAGE_LEVEL:  // 社区/村(暂时不用)
                deptId = deptInfo.getFuncCode() + "00" ;
                break;
            default:
                deptId = "1000000000" + deptInfo.getFuncCode() + "00" ;
        }
        deptId = deptId + BizContextHandler.getTenantId();
        deptInfo.setId(deptId);
        bizMapper.insertSelective(deptInfo);
        return bizConvert.toJavaObjectVO(deptInfoDTO);
    }

    /***
     * 获取部门树信息
     *
     * @author 王大宸
     * @date 2024/4/24 22:32
     * @return java.util.List<com.github.itdachen.framework.context.tree.ZTreeNode>
     */
    @Override
    public List<ZTreeNode> findDeptTree() throws Exception {
        TenantInfoVO tenantInfoVO = tenantInfoMapper.selectTenantInfoVO(BizContextHandler.getTenantId());

        List<ZTreeNode> list = new ArrayList<>();
        list.add(new ZTreeNode.Builder()
                .id(tenantInfoVO.getId())
                .name(tenantInfoVO.getTitle())
                .parentId(ZTreeNode.ROOT_PARENT_ID)
                .open(true)
                .openIcon(appInfoProperties.getContextPath() + ZTreeNode.zTreeBuMenIcon)
                .closeIcon(appInfoProperties.getContextPath() + ZTreeNode.zTreeJiGuoIcon)
                .build());

        List<ZTreeNode> treeNodes = findValidFlagDeptInfoTree(BizContextHandler.getTenantId());
        list.addAll(treeNodes);
        return list;
    }

    /***
     * 获取三级部门信息
     *
     * @author 王大宸
     * @date 2024/5/9 22:56
     * @return java.util.List<com.github.itdachen.framework.context.tree.ZTreeNode>
     */
    @Override
    public List<ZTreeNode> findThreeDeptTree() throws Exception {
        return null;
    }

    /***
     * 查询有效的部门树
     *
     * @author 王大宸
     * @date 2024/5/5 20:51
     * @param parentId parentId
     * @return java.util.List<com.github.itdachen.framework.context.tree.ZTreeNode>
     */
    public List<ZTreeNode> findValidFlagDeptInfoTree(String parentId) {
        List<ZTreeNode> list = bizMapper.findValidFlagDeptInfoTree(BizContextHandler.getTenantId(), parentId);
        List<ZTreeNode> deptTreeList = new ArrayList<>();
        for (ZTreeNode treeNode : list) {
            deptTreeList = findValidFlagDeptInfoTree(treeNode.getId());
            if (null == deptTreeList || deptTreeList.isEmpty()) {
                continue;
            }
            treeNode.setIconClose(appInfoProperties.getContextPath() + ZTreeNode.zTreeCloseIcon);
            treeNode.setIconOpen(appInfoProperties.getContextPath() + ZTreeNode.zTreeOpenIcon);
            treeNode.setOpen(true);
            treeNode.setChildren(deptTreeList);
        }
        return list;
    }


    @Override
    public void validFlagChecked(String id, Boolean checked) throws Exception {
        DeptInfo info = new DeptInfo();
        info.setId(id);
        info.setValidFlag(checked ? YesOrNotConstant.Y : YesOrNotConstant.N);
        bizMapper.updateByPrimaryKeySelective(info);
    }


}
