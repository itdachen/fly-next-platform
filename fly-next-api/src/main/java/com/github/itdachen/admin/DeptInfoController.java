package com.github.itdachen.admin;

import com.github.itdachen.admin.sdk.dto.DeptInfoDto;
import com.github.itdachen.admin.sdk.query.DeptInfoQuery;
import com.github.itdachen.admin.sdk.vo.DeptInfoVo;
import com.github.itdachen.admin.service.IDeptInfoService;
import com.github.itdachen.framework.context.annotation.CheckApiClient;
import com.github.itdachen.framework.core.constants.ClientConstant;
import com.github.itdachen.framework.core.response.ServerResponse;
import com.github.itdachen.framework.webmvc.controller.BizController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 部门管理
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:47
 */
@Controller
@RequestMapping("/admin/dept/info")
@CheckApiClient(title = "部门管理", clientId = ClientConstant.CLIENT_WEB)
public class DeptInfoController extends BizController<IDeptInfoService, DeptInfoDto, DeptInfoVo, DeptInfoQuery, String> {
    private static final Logger logger = LoggerFactory.getLogger(DeptInfoController.class);
    
    /***
     * 获取集合
     *
     * @author 王大宸
     * @date 2023/5/14 22:35
     * @return com.github.itdachen.framework.core.response.ServerResponse<java.util.List<com.github.itdachen.admin.sdk.vo.DeptInfoVo>>
     */
    @GetMapping("/tree")
    @ResponseBody
    public ServerResponse<List<DeptInfoVo>> deptInfoTree() throws Exception {
        return ServerResponse.okData(bizService.apiDeptInfoList());
    }


}