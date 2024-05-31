package com.github.itdachen.admin.service.impl;

import com.github.itdachen.admin.mapper.IDictDataMapper;
import com.github.itdachen.admin.sdk.vo.DataDictVO;
import com.github.itdachen.framework.context.annotation.Log;
import com.github.itdachen.framework.context.constants.YesOrNotConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * DictService
 *
 * @author 王大宸
 * @date 2024/4/21 20:47
 */
@Service("dict")
public class DictService {
    private static final Logger logger = LoggerFactory.getLogger(DictService.class);

    private final IDictDataMapper dictDataMapper;

    public DictService(IDictDataMapper dictDataMapper) {
        this.dictDataMapper = dictDataMapper;
    }

    public List<DataDictVO> data(String dictType) {
        try {
            return dictDataMapper.findDictData(dictType, YesOrNotConstant.Y);
        } catch (Exception e) {
            logger.error("获取数据字典失败: ", e);
            return new ArrayList<>();
        }
    }

}
