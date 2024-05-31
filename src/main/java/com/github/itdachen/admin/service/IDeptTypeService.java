package com.github.itdachen.admin.service;

import com.github.itdachen.admin.sdk.dto.DeptTypeDTO;
import com.github.itdachen.admin.sdk.query.DeptTypeQuery;
import com.github.itdachen.admin.sdk.vo.DeptTypeVO;
import com.github.itdachen.framework.webmvc.service.IBizService;

/**
 * 部门类型管理 业务接口
 *
 * @author 王大宸
 * @date 2024-04-24 21:47:25
 */
public interface IDeptTypeService extends IBizService< DeptTypeDTO, DeptTypeVO, DeptTypeQuery, String > {


    /***
     * 有效标志状态修改
     *
     * @author 王大宸
     * @date 2024/4/20 21:20
     * @param id id
     * @param checked checked
     */
    void validFlagChecked(String id, Boolean checked) throws Exception;

}
