package com.github.itdachen.admin.service.impl;

import com.github.itdachen.framework.context.constants.YesOrNotConstant;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.entity.EntityUtils;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.itdachen.admin.entity.DeptType;
import com.github.itdachen.admin.sdk.dto.DeptTypeDTO;
import com.github.itdachen.admin.sdk.query.DeptTypeQuery;
import com.github.itdachen.admin.sdk.vo.DeptTypeVO;
import com.github.itdachen.admin.mapper.IDeptTypeMapper;
import com.github.itdachen.admin.service.IDeptTypeService;
import com.github.itdachen.admin.convert.DeptTypeConvert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 部门类型管理 业务实现
 *
 * @author 王大宸
 * @date 2024-04-24 21:47:25
 */
@Service
public class DeptTypeServiceImpl extends BizServiceImpl<IDeptTypeMapper, DeptType, DeptTypeDTO, DeptTypeVO, DeptTypeQuery, String> implements IDeptTypeService {
    private static final Logger logger = LoggerFactory.getLogger(DeptTypeServiceImpl.class);
    private static final DeptTypeConvert bizConvert = new DeptTypeConvert();

    public DeptTypeServiceImpl() {
        super(bizConvert);
    }

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2024-04-24 21:47:25
     * @param params params
     * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.admin.sdk.vo.deptTypeVo>
     */
    @Override
    public TableData<DeptTypeVO> page(DeptTypeQuery params) throws Exception {
        Page<DeptTypeVO> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<DeptTypeVO> list = bizMapper.list(params);
        return new TableData<DeptTypeVO>(page.getTotal(), list);
    }

    /***
     * 新增
     *
     * @author 王大宸
     * @date 2024/4/25 21:55
     * @param deptTypeDTO deptTypeDTO
     * @return com.github.itdachen.admin.sdk.vo.DeptTypeVO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public DeptTypeVO saveInfo(DeptTypeDTO deptTypeDTO) throws Exception {
        if (null == deptTypeDTO.getId()) {
            throw new BizException("类型代码不能为空！");
        }
        DeptTypeVO deptTypeVO = bizMapper.selectDeptTypeVO(deptTypeDTO.getId());
        if (null != deptTypeVO) {
            throw new BizException("该类型代码已经存在");
        }
        DeptType javaObject = bizConvert.toJavaObject(deptTypeDTO);
        EntityUtils.setCreatAndUpdateInfo(javaObject);
        javaObject.setId(deptTypeDTO.getId());
        bizMapper.insertSelective(javaObject);
        return bizConvert.toJavaObjectVO(javaObject);
    }

    /***
     * 有效标志状态修改
     *
     * @author 王大宸
     * @date 2024/4/25 22:03
     * @param id id
     * @param checked checked
     * @return void
     */
    @Override
    public void validFlagChecked(String id, Boolean checked) throws Exception {
        String validFlag = YesOrNotConstant.N;
        if (checked) {
            validFlag = YesOrNotConstant.Y;
        }
        DeptType type = new DeptType();
        type.setId(id);
        type.setValidFlag(validFlag);
        bizMapper.updateByPrimaryKeySelective(type);
    }


}
