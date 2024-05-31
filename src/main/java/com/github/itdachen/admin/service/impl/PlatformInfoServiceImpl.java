package com.github.itdachen.admin.service.impl;

import com.github.itdachen.admin.sdk.vo.AppInfoVO;
import com.github.itdachen.framework.context.constants.YesOrNotConstant;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.itdachen.admin.entity.PlatformInfo;
import com.github.itdachen.admin.sdk.dto.PlatformInfoDTO;
import com.github.itdachen.admin.sdk.query.PlatformInfoQuery;
import com.github.itdachen.admin.sdk.vo.PlatformInfoVO;
import com.github.itdachen.admin.mapper.IPlatformInfoMapper;
import com.github.itdachen.admin.service.IPlatformInfoService;
import com.github.itdachen.admin.convert.PlatformInfoConvert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 平台信息 业务实现
 *
 * @author 王大宸
 * @date 2024-04-20 16:04:52
 */
@Service
public class PlatformInfoServiceImpl extends BizServiceImpl<IPlatformInfoMapper, PlatformInfo, PlatformInfoDTO, PlatformInfoVO, PlatformInfoQuery, String> implements IPlatformInfoService {
    private static final Logger logger = LoggerFactory.getLogger(PlatformInfoServiceImpl.class);
    private static final PlatformInfoConvert bizConvert = new PlatformInfoConvert();

    public PlatformInfoServiceImpl() {
        super(bizConvert);
    }

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2024-04-20 16:04:52
     * @param params params
     * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.admin.sdk.vo.platformInfoVo>
     */
    @Override
    public TableData<PlatformInfoVO> page(PlatformInfoQuery params) throws Exception {
        Page<PlatformInfoVO> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<PlatformInfoVO> list = bizMapper.list(params);
        return new TableData<PlatformInfoVO>(page.getTotal(), list);
    }

    /***
     * 新增
     *
     * @author 王大宸
     * @date 2024/4/20 21:34
     * @param platformInfoDTO platformInfoDTO
     * @return com.github.itdachen.admin.sdk.vo.PlatformInfoVO
     */
    @Override
    public PlatformInfoVO saveInfo(PlatformInfoDTO platformInfoDTO) throws Exception {
        platformInfoDTO.setValidDel(YesOrNotConstant.Y);
        return super.saveInfo(platformInfoDTO);
    }

    /***
     * 获取所有的平台信息
     *
     * @author 王大宸
     * @date 2024/4/20 21:34
     * @return java.util.List<com.github.itdachen.admin.sdk.vo.PlatformInfoVO>
     */
    @Override
    public List<PlatformInfoVO> findPlatformInfoList() throws Exception {
        PlatformInfoQuery params = new PlatformInfoQuery();
        params.setValidFlag(YesOrNotConstant.Y);
        return bizMapper.list(params);
    }

    /***
     * 删除
     *
     * @author 王大宸
     * @date 2024/4/20 21:56
     * @param id id
     * @return int
     */
    @Override
    public int deleteByPrimaryKey(String id) throws Exception {
        PlatformInfoVO appInfoVO = bizMapper.selectPlatformInfoVO(id);
        if (YesOrNotConstant.N.equals(appInfoVO.getValidDel())) {
            throw new BizException("该平台无法被删除！");
        }
        return bizMapper.deleteByPrimaryKey(id);
    }

    /***
     * 有效标志
     *
     * @author 王大宸
     * @date 2024/4/20 21:20
     * @param id id
     * @param checked checked
     */
    @Override
    public void validFlagChecked(String id, Boolean checked) throws Exception {
        PlatformInfoVO platformInfoVO = bizMapper.selectPlatformInfoVO(id);
        if (YesOrNotConstant.N.equals(platformInfoVO.getValidDel())) {
            throw new BizException("不能修改该平台状态！");
        }
        PlatformInfo platformInfo = new PlatformInfo();
        platformInfo.setId(id);
        platformInfo.setValidFlag(checked ? YesOrNotConstant.Y : YesOrNotConstant.N);
        bizMapper.updateByPrimaryKeySelective(platformInfo);
    }

}
