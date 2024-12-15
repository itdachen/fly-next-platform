package com.github.itdachen.admin.service.impl;

import com.github.itdachen.admin.mapper.IDictTypeMapper;
import com.github.itdachen.admin.sdk.vo.DictTypeVO;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.entity.EntityUtils;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.itdachen.admin.entity.DictData;
import com.github.itdachen.admin.sdk.dto.DictDataDTO;
import com.github.itdachen.admin.sdk.query.DictDataQuery;
import com.github.itdachen.admin.sdk.vo.DictDataVO;
import com.github.itdachen.admin.mapper.IDictDataMapper;
import com.github.itdachen.admin.service.IDictDataService;
import com.github.itdachen.admin.convert.DictDataConvert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 数据字典信息表 业务实现
 *
 * @author 王大宸
 * @date 2024-04-21 20:21:24
 */
@Service
public class DictDataServiceImpl extends BizServiceImpl<IDictDataMapper, DictData, DictDataDTO, DictDataVO, DictDataQuery, String> implements IDictDataService {
    private static final Logger logger = LoggerFactory.getLogger(DictDataServiceImpl.class);
    private static final DictDataConvert bizConvert = new DictDataConvert();
    private final IDictTypeMapper dictTypeMapper;

    public DictDataServiceImpl(IDictTypeMapper dictTypeMapper) {
        super(bizConvert);
        this.dictTypeMapper = dictTypeMapper;
    }


    /***
     * 分页
     *
     * @author 王大宸
     * @date 2024-04-21 20:21:24
     * @param params params
     * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.admin.sdk.vo.dictDataVo>
     */
    @Override
    public TableData<DictDataVO> page(DictDataQuery params) throws Exception {
        Page<DictDataVO> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<DictDataVO> list = bizMapper.list(params);
        return new TableData<DictDataVO>(page.getTotal(), list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DictDataVO saveInfo(DictDataDTO dictDataDTO) throws Exception {
        DictTypeVO dictTypeVO = dictTypeMapper.selectDictTypeVO(dictDataDTO.getTypeId());
        if (null == dictTypeVO) {
            throw new BizException("数据字典类型不存在, 请刷新数据");
        }
        DictData dictData = bizConvert.toJavaObject(dictDataDTO);
        dictData.setTypeLabel(dictTypeVO.getDictLabel());
        dictData.setDictType(dictTypeVO.getDictType());
        EntityUtils.setCreatAndUpdateInfo(dictData);
        bizMapper.insertSelective(dictData);
        return bizConvert.toJavaObjectVO(dictDataDTO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DictDataVO updateInfo(DictDataDTO dictDataDTO) throws Exception {
        DictData dictData = bizConvert.toJavaObject(dictDataDTO);
        EntityUtils.setUpdatedInfo(dictData);
        bizMapper.updateByPrimaryKeySelective(dictData);
        return bizConvert.toJavaObjectVO(dictDataDTO);
    }

}
