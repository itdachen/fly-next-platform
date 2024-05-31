package com.github.itdachen.admin.service;

import com.github.itdachen.admin.sdk.dto.ClazzDeptDTO;
import com.github.itdachen.admin.sdk.query.ClazzDeptQuery;
import com.github.itdachen.admin.sdk.vo.ClazzDeptVO;
import com.github.itdachen.framework.context.tree.ZTreeNode;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.service.IBizService;

/**
 * 部门岗位关联表 业务接口
 *
 * @author 王大宸
 * @date 2024-05-10 21:17:50
 */
public interface IClazzDeptService extends IBizService<ClazzDeptDTO, ClazzDeptVO, ClazzDeptQuery, String> {


    TableData<ZTreeNode> clazzPage(ClazzDeptQuery query) throws Exception;


    /***
     * 有效标志
     *
     * @author 王大宸
     * @date 2024/4/20 21:20
     * @param id id
     * @param checked checked
     */
    void validFlagChecked(String id, Boolean checked) throws Exception;


}
