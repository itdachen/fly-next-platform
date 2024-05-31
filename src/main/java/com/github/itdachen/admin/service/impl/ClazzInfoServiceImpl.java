package com.github.itdachen.admin.service.impl;

import com.github.itdachen.framework.context.constants.YesOrNotConstant;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.entity.EntityUtils;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.itdachen.admin.entity.ClazzInfo;
import com.github.itdachen.admin.sdk.dto.ClazzInfoDTO;
import com.github.itdachen.admin.sdk.query.ClazzInfoQuery;
import com.github.itdachen.admin.sdk.vo.ClazzInfoVO;
import com.github.itdachen.admin.mapper.IClazzInfoMapper;
import com.github.itdachen.admin.service.IClazzInfoService;
import com.github.itdachen.admin.convert.ClazzInfoConvert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 岗位信息 业务实现
 *
 * @author 王大宸
 * @date 2024-04-25 22:40:02
 */
@Service
public class ClazzInfoServiceImpl extends BizServiceImpl<IClazzInfoMapper, ClazzInfo, ClazzInfoDTO, ClazzInfoVO, ClazzInfoQuery, String> implements IClazzInfoService {
    private static final Logger logger = LoggerFactory.getLogger(ClazzInfoServiceImpl.class);
    private static final ClazzInfoConvert bizConvert = new ClazzInfoConvert();

    public ClazzInfoServiceImpl() {
        super(bizConvert);
    }

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2024-04-25 22:40:02
     * @param params params
     * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.admin.sdk.vo.clazzInfoVo>
     */
    @Override
    public TableData<ClazzInfoVO> page(ClazzInfoQuery params) throws Exception {
        Page<ClazzInfoVO> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<ClazzInfoVO> list = bizMapper.list(params);
        return new TableData<ClazzInfoVO>(page.getTotal(), list);
    }

    /***
     * 新增
     *
     * @author 王大宸
     * @date 2024/5/9 22:51
     * @param clazzInfoDTO clazzInfoDTO
     * @return com.github.itdachen.admin.sdk.vo.ClazzInfoVO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ClazzInfoVO saveInfo(ClazzInfoDTO clazzInfoDTO) throws Exception {
        ClazzInfo clazzInfo = bizConvert.toJavaObject(clazzInfoDTO);
        EntityUtils.setCreatAndUpdateInfo(clazzInfo);
        bizMapper.insertSelective(clazzInfo);
        return bizConvert.toJavaObjectVO(clazzInfo);
    }

    /***
     * 编辑
     *
     * @author 王大宸
     * @date 2024/5/9 22:51
     * @param clazzInfoDTO clazzInfoDTO
     * @return com.github.itdachen.admin.sdk.vo.ClazzInfoVO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ClazzInfoVO updateInfo(ClazzInfoDTO clazzInfoDTO) throws Exception {
        ClazzInfo clazzInfo = bizConvert.toJavaObject(clazzInfoDTO);
        EntityUtils.setUpdatedInfo(clazzInfo);
        bizMapper.updateByPrimaryKeySelective(clazzInfo);
        return bizConvert.toJavaObjectVO(clazzInfo);
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
        ClazzInfo info = new ClazzInfo();
        info.setId(id);
        info.setValidFlag(checked ? YesOrNotConstant.Y : YesOrNotConstant.N);
        bizMapper.updateByPrimaryKeySelective(info);
    }


}
