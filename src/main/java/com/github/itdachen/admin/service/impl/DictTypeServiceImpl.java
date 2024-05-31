package com.github.itdachen.admin.service.impl;

import com.github.itdachen.admin.mapper.IDictDataMapper;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.entity.EntityUtils;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.itdachen.admin.entity.DictType;
import com.github.itdachen.admin.sdk.dto.DictTypeDTO;
import com.github.itdachen.admin.sdk.query.DictTypeQuery;
import com.github.itdachen.admin.sdk.vo.DictTypeVO;
import com.github.itdachen.admin.mapper.IDictTypeMapper;
import com.github.itdachen.admin.service.IDictTypeService;
import com.github.itdachen.admin.convert.DictTypeConvert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 数据字典类型 业务实现
 *
 * @author 王大宸
 * @date 2024-04-21 20:21:24
 */
@Service
public class DictTypeServiceImpl extends BizServiceImpl<IDictTypeMapper, DictType, DictTypeDTO, DictTypeVO, DictTypeQuery, String> implements IDictTypeService {
    private static final Logger logger = LoggerFactory.getLogger(DictTypeServiceImpl.class);
    private static final DictTypeConvert bizConvert = new DictTypeConvert();

    private final IDictDataMapper dictDataMapper;

    public DictTypeServiceImpl(IDictDataMapper dictDataMapper) {
        super(bizConvert);
        this.dictDataMapper = dictDataMapper;
    }

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2024-04-21 20:21:24
     * @param params params
     * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.admin.sdk.vo.dictTypeVo>
     */
    @Override
    public TableData<DictTypeVO> page(DictTypeQuery params) throws Exception {
        Page<DictTypeVO> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<DictTypeVO> list = bizMapper.list(params);
        return new TableData<DictTypeVO>(page.getTotal(), list);
    }

    /***
     * 更新
     *
     * @author 王大宸
     * @date 2024/4/21 21:54
     * @param dto dto
     * @return com.github.itdachen.admin.sdk.vo.DictTypeVO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public DictTypeVO updateInfo(DictTypeDTO dto) throws Exception {
        DictType dictType = bizConvert.toJavaObject(dto);
        EntityUtils.setUpdatedInfo(dictType);
        bizMapper.updateByPrimaryKeySelective(dictType);
        dictDataMapper.updateByTypeId(dto);
        return bizConvert.toJavaObjectVO(dictType);
    }

    /***
     * 删除
     *
     * @author 王大宸
     * @date 2024/4/21 21:54
     * @param id id
     * @return int
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByPrimaryKey(String id) throws Exception {
        Integer count = dictDataMapper.findCountByTypeId(id);
        if (null != count && 0 < count) {
            throw new BizException("存在数据字典信息，请先删除数据字典信息！");
        }
        return bizMapper.deleteByPrimaryKey(id);
    }
}
