package com.github.itdachen.admin.controller;

import com.github.itdachen.admin.sdk.dto.DeptInfoDto;
import com.github.itdachen.admin.service.IAppClientService;
import com.github.itdachen.admin.service.IDeptInfoService;
import com.github.itdachen.admin.entity.DeptInfo;
import com.github.itdachen.admin.sdk.query.DeptInfoQuery;
import com.github.itdachen.admin.sdk.vo.DeptInfoVo;
import com.github.itdachen.framework.assets.tree.ZTreeNode;
import com.github.itdachen.framework.context.annotation.CheckApiClient;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.core.constants.ClientConstant;
import com.github.itdachen.framework.core.response.ServerResponse;
import com.github.itdachen.framework.webmvc.controller.BizController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
public class DeptInfoController extends BizController<DeptInfoDto, DeptInfoVo, DeptInfoQuery, String> {
    private static final Logger logger = LoggerFactory.getLogger(DeptInfoController.class);
    private final IDeptInfoService bizService;
    public DeptInfoController(IDeptInfoService bizService) {
        super(bizService);
        this.bizService = bizService;
    }

    private static final String PATH_PREFIX = "admin/dept" ;


    /***
     * 跳转到信息管理界面
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:47
     * @return java.lang.String
     */
    @GetMapping(value = "/index")
    @PreAuthorize("hasAuthority('admin:dept:index')")
    public String index() {
        return PATH_PREFIX + "/index" ;
    }

    /***
     * 跳转到添加页面
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:47
     * @return java.lang.String
     */
    @GetMapping(value = "/{parentId}/add")
    @PreAuthorize("hasAuthority('admin:dept:save')")
    public String add(@PathVariable("parentId") String parentId, ModelMap modelMap) throws Exception {
        modelMap.put("parentId", parentId);
        return PATH_PREFIX + "/add" ;
    }

    /***
     * 跳转到修改页面
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:47
     * @param id         需要修改数据的id
     * @param modelMap   modelMap
     * @return java.lang.String
     */
    @GetMapping(value = "/edit/{id}")
    @PreAuthorize("hasAuthority('admin:dept:update')")
    public String edit(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("deptInfo", bizService.getById(id));
        return PATH_PREFIX + "/edit" ;
    }

    /***
     * 跳转到查看页面
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:47
     * @param id          需要查看数据的id
     * @param modelMap    modelMap
     * @return java.lang.String
     */
    @GetMapping(value = "/view/{id}")
    @PreAuthorize("hasAuthority('admin:dept:view')")
    public String see(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("deptInfo", bizService.getById(id));
        return PATH_PREFIX + "/see" ;
    }


    /***
     * 获取部门树
     *
     * @author 王大宸
     * @date 2023/4/4 23:46
     * @return com.github.itdachen.framework.core.response.ServerResponse<java.util.List < com.github.itdachen.framework.assets.tree.ZTreeNode>>
     */
    @GetMapping(value = "/zTree")
    @ResponseBody
    public ServerResponse<List<ZTreeNode>> zTree() throws BizException {
        return ServerResponse.okData(bizService.zTree());
    }

}