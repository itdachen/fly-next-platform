package com.github.itdachen.admin;

import com.github.itdachen.admin.sdk.dto.PositionInfoDto;
import com.github.itdachen.admin.sdk.vo.MenuInfoVo;
import com.github.itdachen.admin.service.IPositionInfoService;
import com.github.itdachen.admin.sdk.query.PositionInfoQuery;
import com.github.itdachen.admin.sdk.vo.PositionInfoVo;
import com.github.itdachen.framework.context.annotation.CheckApiClient;
import com.github.itdachen.framework.context.node.TreeNode;
import com.github.itdachen.framework.core.constants.ClientConstant;
import com.github.itdachen.framework.core.response.ServerResponse;
import com.github.itdachen.framework.webmvc.controller.BizController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 岗位信息
 *
 * @author 王大宸
 * @date 2023-05-15 20:13:36
 */
@RestController
@RequestMapping("/admin/position/info")
@CheckApiClient(title = "岗位信息", clientId = ClientConstant.CLIENT_WEB)
public class PositionInfoController extends BizController<PositionInfoDto, PositionInfoVo, PositionInfoQuery, String> {
    private static final Logger logger = LoggerFactory.getLogger(PositionInfoController.class);
    private final IPositionInfoService bizService;

    public PositionInfoController(IPositionInfoService bizService) {
        super(bizService);
        this.bizService = bizService;
    }

    /***
     * 根据部门查询岗位
     *
     * @author 王大宸
     * @date 2023/5/16 22:47
     * @param deptId deptId
     * @return com.github.itdachen.framework.core.response.ServerResponse<com.github.itdachen.framework.context.node.TreeNode < com.github.itdachen.admin.sdk.vo.PositionInfoVo, java.lang.String>>
     */
    @GetMapping("/el/tree/{deptId}/identity/{identityId}")
    public ServerResponse<TreeNode<PositionInfoVo, String>> findPositionByDept(@PathVariable("deptId") String deptId,
                                                                               @PathVariable("identityId") String identityId) throws Exception {
        return ServerResponse.okData(bizService.findPositionByDept(deptId, identityId));
    }


}