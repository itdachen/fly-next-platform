package com.github.itdachen.admin.service.impl;

import com.github.itdachen.framework.context.constants.YesOrNotConstant;
import com.github.itdachen.framework.webmvc.entity.EntityUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.itdachen.admin.entity.ElementInfo;
import com.github.itdachen.admin.sdk.query.ElementInfoQuery;
import com.github.itdachen.admin.sdk.vo.ElementInfoVo;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.itdachen.admin.mapper.IElementInfoMapper;
import com.github.itdachen.admin.service.IElementInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 按钮资源 业务实现
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:47
 */
@Service
public class ElementInfoServiceImpl extends BizServiceImpl<IElementInfoMapper, ElementInfo, ElementInfoVo, ElementInfoQuery, String> implements IElementInfoService {
    private static final Logger logger = LoggerFactory.getLogger(ElementInfoServiceImpl.class);

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:47
     * @param params params
     * @return cn.edu.hubu.common.core.response.TableData<com.github.itdachen.admin.sdk.vo.elementInfoVo>
     */
    @Override
    public TableData<ElementInfoVo> page(ElementInfoQuery params) throws Exception {
        Page<ElementInfoVo> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<ElementInfoVo> list = bizMapper.page(params);
        return new TableData<ElementInfoVo>(page.getTotal(), list);
    }

    /***
     * 修改状态
     *
     * @author 王大宸
     * @date 2023/4/5 22:39
     * @param id id
     * @param status status
     * @return void
     */
    @Override
    public void updateStatus(String id, Boolean status) throws Exception {
        ElementInfo element = new ElementInfo();
        element.setId(id);
        if (status) {
            element.setVisible(YesOrNotConstant.YES);
        } else {
            element.setVisible(YesOrNotConstant.NOT);
        }
        EntityUtils.setUpdatedInfo(element);
        bizMapper.updateByPrimaryKeySelective(element);
    }

}
