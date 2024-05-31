package com.github.itdachen.admin.service.impl;

import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.itdachen.admin.entity.WhiteIpList;
import com.github.itdachen.admin.sdk.dto.WhiteIpListDTO;
import com.github.itdachen.admin.sdk.query.WhiteIpListQuery;
import com.github.itdachen.admin.sdk.vo.WhiteIpListVO;
import com.github.itdachen.admin.mapper.IWhiteIpListMapper;
import com.github.itdachen.admin.service.IWhiteIpListService;
import com.github.itdachen.admin.convert.WhiteIpListConvert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 菜单白名单 业务实现
 *
 * @author 王大宸
 * @date 2024-04-20 22:16:38
 */
@Service
public class WhiteIpListServiceImpl extends BizServiceImpl< IWhiteIpListMapper, WhiteIpList, WhiteIpListDTO,  WhiteIpListVO, WhiteIpListQuery, String > implements IWhiteIpListService {
    private static final Logger logger = LoggerFactory.getLogger(WhiteIpListServiceImpl.class);
    private static final WhiteIpListConvert bizConvert = new WhiteIpListConvert();

    public WhiteIpListServiceImpl() {
        super(bizConvert);
    }

    /***
    * 分页
    *
    * @author 王大宸
    * @date 2024-04-20 22:16:38
    * @param params params
    * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.admin.sdk.vo.whiteIpListVo>
    */
    @Override
    public TableData< WhiteIpListVO > page(WhiteIpListQuery params) throws Exception {
        Page< WhiteIpListVO > page = PageHelper.startPage(params.getPage(), params.getLimit());
        List< WhiteIpListVO > list = bizMapper.list(params);
        return new TableData< WhiteIpListVO >(page.getTotal(), list);
    }


}
