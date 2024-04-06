package com.github.itdachen.admin_v1.service.impl;

import com.github.itdachen.admin_v1.convert.IDictTypeConvert;
import com.github.itdachen.admin_v1.entity.DictType;
import com.github.itdachen.admin_v1.mapper.IDictDataMapper;
import com.github.itdachen.admin_v1.mapper.IDictTypeMapper;
import com.github.itdachen.admin_v1.sdk.dto.DictTypeDto;
import com.github.itdachen.admin_v1.sdk.query.DictTypeQuery;
import com.github.itdachen.admin_v1.sdk.vo.DataDictVo;
import com.github.itdachen.admin_v1.sdk.vo.DictDataVo;
import com.github.itdachen.admin_v1.sdk.vo.DictTypeVo;
import com.github.itdachen.admin_v1.service.IDictTypeService;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.entity.EntityUtils;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 字典类型表 业务实现
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:47
 */
@Service
public class DictTypeServiceImpl extends BizServiceImpl<IDictTypeMapper, IDictTypeConvert, DictType, DictTypeDto, DictTypeVo, DictTypeQuery, String> implements IDictTypeService {
    private static final Logger logger = LoggerFactory.getLogger(DictTypeServiceImpl.class);
    private final IDictDataMapper dictDataMapper;

    public DictTypeServiceImpl(IDictDataMapper dictDataMapper) {
        this.dictDataMapper = dictDataMapper;
    }


    /***
     * 分页
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:47
     * @param params params
     * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.admin.sdk.vo.dictTypeVo>
     */
    @Override
    public TableData<DictTypeVo> page(DictTypeQuery params) throws Exception {
        Page<DictTypeVo> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<DictTypeVo> list = bizMapper.page(params);
        return new TableData<DictTypeVo>(page.getTotal(), list);
    }

    /***
     * 新增
     *
     * @author 王大宸
     * @date 2022/8/23 22:59
     * @param dictTypeDto entity
     * @return com.itdachen.admin.entity.DictType
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public DictTypeVo saveInfo(DictTypeDto dictTypeDto) throws Exception {
        DictTypeVo vo = bizMapper.findByDictType(dictTypeDto.getDictType());
        if (null != vo) {
            throw new BizException("该数据字典类型已经存在");
        }
        return super.saveInfo(dictTypeDto);
    }

    /***
     * 更新
     *
     * @author 王大宸
     * @date 2022/8/23 23:03
     * @param dictTypeDto dictTypeDto
     * @return com.itdachen.admin.entity.DictType
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public DictTypeVo updateInfo(DictTypeDto dictTypeDto) throws Exception {
        DictTypeVo vo = bizMapper.findByDictType(dictTypeDto.getDictType());
        if (null != vo && !dictTypeDto.getId().equals(vo.getId())) {
            throw new BizException("该数据字典类型已经存在");
        }
        return super.updateInfo(dictTypeDto);
    }

    /***
     * 删除
     *
     * @author 王大宸
     * @date 2023/4/5 21:13
     * @param id id
     * @return int
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByPrimaryKey(String id) throws BizException {
        DictType dictType = bizMapper.selectByPrimaryKey(id);
        if (null == dictType) {
            return 0;
        }
        List<DataDictVo> list = dictDataMapper.findDictData(dictType.getDictType(), null);
        if (null != list && 0 < list.size()) {
            throw new BizException("该数据字典存在数据,请先删除数据字典数据");
        }
        return bizMapper.deleteByPrimaryKey(id);
    }

    /***
     * 更新状态
     *
     * @author 王大宸
     * @date 2023/4/5 21:13
     * @param id id
     * @param status status
     * @return com.github.itdachen.admin.sdk.vo.DictDataVo
     */
    @Override
    public DictDataVo updateStatus(String id, Boolean status) throws BizException {
        DictType dictType = new DictType();
        dictType.setId(id);
        dictType.setStatus("1");
        if (!status) {
            dictType.setStatus("0");
        }
        EntityUtils.setUpdatedInfo(dictType);
        bizMapper.updateByPrimaryKeySelective(dictType);
        return null;
    }

}
