package com.github.itdachen.admin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.itdachen.admin.convert.PositionInfoConvert;
import com.github.itdachen.admin.entity.PositionInfo;
import com.github.itdachen.admin.sdk.dto.PositionInfoDto;
import com.github.itdachen.admin.sdk.query.PositionInfoQuery;
import com.github.itdachen.admin.sdk.vo.PositionInfoVo;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.itdachen.admin.mapper.IPositionInfoMapper;
import com.github.itdachen.admin.service.IPositionInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 岗位信息 业务实现
 *
 * @author 王大宸
 * @date 2023-05-15 20:13:36
 */
@Service
public class PositionInfoServiceImpl extends BizServiceImpl< PositionInfo, PositionInfoDto,  PositionInfoVo, PositionInfoQuery, String > implements IPositionInfoService {
    private static final Logger logger = LoggerFactory.getLogger(PositionInfoServiceImpl.class);
    private static final PositionInfoConvert bizConvert = new PositionInfoConvert();
    private final IPositionInfoMapper bizMapper;

    public PositionInfoServiceImpl(IPositionInfoMapper positionInfoMapper) {
        super(positionInfoMapper, bizConvert);
        this.bizMapper = positionInfoMapper;
    }

    /***
    * 分页
    *
    * @author 王大宸
    * @date 2023-05-15 20:13:36
    * @param params params
    * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.admin.sdk.vo.positionInfoVo>
    */
    @Override
    public TableData< PositionInfoVo > page(PositionInfoQuery params) throws Exception {
        Page< PositionInfoVo > page = PageHelper.startPage(params.getPage(), params.getLimit());
        List< PositionInfoVo > list = bizMapper.page(params);
        return new TableData< PositionInfoVo >(page.getTotal(), list);
    }


}
