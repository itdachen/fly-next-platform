package com.github.itdachen.admin_v1.service.impl;

import com.github.itdachen.admin_v1.convert.IDictDataConvert;
import com.github.itdachen.admin_v1.entity.DictData;
import com.github.itdachen.admin_v1.mapper.IDictDataMapper;
import com.github.itdachen.admin_v1.sdk.constants.DictDataStatusConstant;
import com.github.itdachen.admin_v1.sdk.dto.DictDataDto;
import com.github.itdachen.admin_v1.sdk.query.DictDataQuery;
import com.github.itdachen.admin_v1.sdk.vo.DictDataVo;
import com.github.itdachen.admin_v1.service.IDictDataService;
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
 * 字典数据表 业务实现
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:47
 */
@Service
public class DictDataServiceImpl extends BizServiceImpl<IDictDataMapper, IDictDataConvert, DictData, DictDataDto, DictDataVo, DictDataQuery, String> implements IDictDataService {
    private static final Logger logger = LoggerFactory.getLogger(DictDataServiceImpl.class);

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2023/4/11 21:21
     * @param params params
     * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.admin.sdk.vo.DictDataVo>
     */
    @Override
    public TableData<DictDataVo> page(DictDataQuery params) throws Exception {
        Page<DictDataVo> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<DictDataVo> list = bizMapper.page(params);
        return new TableData<DictDataVo>(page.getTotal(), list);
    }

    /***
     * 新增
     *
     * @author 王大宸
     * @date 2023/4/5 21:18
     * @param dictDataDto dictDataDto
     * @return com.github.itdachen.admin.entity.DictData
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public DictDataVo saveInfo(DictDataDto dictDataDto) throws Exception {
        DictData dictData = bizConvert.toJavaObject(dictDataDto);
        DictDataVo data = bizMapper.findByTypeAndValue(dictData.getDictType(), dictData.getDictValue());
        if (null != data) {
            throw new BizException("该值已经存在");
        }
        EntityUtils.setCreatAndUpdateInfo(dictData);
        bizMapper.insertSelective(dictData);
        return bizConvert.toJavaObjectVo(dictData);
    }

    /***
     * 更新
     *
     * @author 王大宸
     * @date 2023/4/5 21:18
     * @param dictDataDto dictDataDto
     * @return com.github.itdachen.admin.entity.DictData
     */
    @Override
    public DictDataVo updateInfo(DictDataDto dictDataDto) throws Exception {
        DictData dictData = bizConvert.toJavaObject(dictDataDto);
        DictDataVo data = bizMapper.findByTypeAndValue(dictData.getDictType(), dictData.getDictValue());
        if (null != data && !dictData.getId().equals(data.getId())) {
            throw new BizException("该值已经存在");
        }
        EntityUtils.setUpdatedInfo(dictData);
        bizMapper.updateByPrimaryKeySelective(dictData);
        return bizConvert.toJavaObjectVo(dictData);
    }

    /***
     * 修改状态
     *
     * @author 王大宸
     * @date 2023/4/5 21:17
     * @param id id
     * @param status status
     * @return com.github.itdachen.admin.sdk.vo.DictDataVo
     */
    @Override
    public DictDataVo updateStatus(String id, Boolean status) throws BizException {
        DictData data = new DictData();
        data.setId(id);
        data.setStatus(DictDataStatusConstant.LOCKED_DICT_DATA);
        if (status) {
            data.setStatus(DictDataStatusConstant.IS_OK);
        }
        EntityUtils.setUpdatedInfo(data);
        bizMapper.updateByPrimaryKeySelective(data);
        return null;
    }

}
