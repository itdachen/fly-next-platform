package com.github.itdachen.admin.service.impl;

import com.github.itdachen.admin.mapper.IDictDataMapper;
import com.github.itdachen.admin.sdk.constants.DictDataStatusConstant;
import com.github.itdachen.admin.sdk.vo.DataDictVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 数据字典, 提供给前端 thymeleaf 调用
 * Created by 王大宸 on 2023/04/04 21:55
 * Created with IntelliJ IDEA.
 */
@Service("dict")
public class DictService {

    private static final Logger logger = LoggerFactory.getLogger(DictService.class);

    private final IDictDataMapper dictDataMapper;

    public DictService(IDictDataMapper dictDataMapper) {
        this.dictDataMapper = dictDataMapper;
    }

    public List<DataDictVo> data(String dictType) {
        try {
            return dictDataMapper.findDictData(dictType, DictDataStatusConstant.IS_OK);
        } catch (Exception e) {
            logger.error("获取数据字典失败: ", e);
            return new ArrayList<>();
        }
    }

}
