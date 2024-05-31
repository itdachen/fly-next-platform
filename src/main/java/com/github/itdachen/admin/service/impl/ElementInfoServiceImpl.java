package com.github.itdachen.admin.service.impl;

import com.github.itdachen.admin.mapper.IMenuInfoMapper;
import com.github.itdachen.admin.sdk.vo.MenuInfoVO;
import com.github.itdachen.framework.context.constants.YesOrNotConstant;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.itdachen.admin.entity.ElementInfo;
import com.github.itdachen.admin.sdk.dto.ElementInfoDTO;
import com.github.itdachen.admin.sdk.query.ElementInfoQuery;
import com.github.itdachen.admin.sdk.vo.ElementInfoVO;
import com.github.itdachen.admin.mapper.IElementInfoMapper;
import com.github.itdachen.admin.service.IElementInfoService;
import com.github.itdachen.admin.convert.ElementInfoConvert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 认证资源信息(按钮信息) 业务实现
 *
 * @author 王大宸
 * @date 2024-04-20 22:16:39
 */
@Service
public class ElementInfoServiceImpl extends BizServiceImpl<IElementInfoMapper, ElementInfo, ElementInfoDTO, ElementInfoVO, ElementInfoQuery, String> implements IElementInfoService {
    private static final Logger logger = LoggerFactory.getLogger(ElementInfoServiceImpl.class);
    private static final ElementInfoConvert bizConvert = new ElementInfoConvert();

    @Autowired
    private IMenuInfoMapper menuInfoMapper;

    public ElementInfoServiceImpl() {
        super(bizConvert);
    }

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2024-04-20 22:16:39
     * @param params params
     * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.admin.sdk.vo.elementInfoVo>
     */
    @Override
    public TableData<ElementInfoVO> page(ElementInfoQuery params) throws Exception {
        Page<ElementInfoVO> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<ElementInfoVO> list = bizMapper.list(params);
        return new TableData<ElementInfoVO>(page.getTotal(), list);
    }

    @Override
    public ElementInfoVO saveInfo(ElementInfoDTO elementInfoDTO) throws Exception {
        setMenuTitle(elementInfoDTO);
        return super.saveInfo(elementInfoDTO);
    }


    @Override
    public ElementInfoVO updateInfo(ElementInfoDTO elementInfoDTO) throws Exception {
        ElementInfoVO elementInfoVO = bizMapper.selectElementInfoVO(elementInfoDTO.getId());
        elementInfoDTO.setMenuId(elementInfoVO.getMenuId());
        setMenuTitle(elementInfoDTO);
        return super.updateInfo(elementInfoDTO);
    }

    private void setMenuTitle(ElementInfoDTO elementInfoDTO) {
        MenuInfoVO menuInfoVO = menuInfoMapper.selectMenuInfoVO(elementInfoDTO.getMenuId());
        elementInfoDTO.setMenuTitle(menuInfoVO.getTitle());
        elementInfoDTO.setAppId(menuInfoVO.getAppId());
    }

    @Override
    public void validFlagChecked(String id, Boolean checked) throws Exception {
        ElementInfo elementInfo = new ElementInfo();
        elementInfo.setId(id);
        elementInfo.setValidFlag(checked ? YesOrNotConstant.Y : YesOrNotConstant.N);
        bizMapper.updateByPrimaryKeySelective(elementInfo);
    }

}
