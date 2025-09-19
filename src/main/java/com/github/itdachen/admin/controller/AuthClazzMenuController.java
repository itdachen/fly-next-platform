package com.github.itdachen.admin.controller;

import com.github.itdachen.admin.service.IAuthClazzMenuService;
import com.github.itdachen.admin.sdk.dto.AuthClazzMenuDTO;
import com.github.itdachen.admin.sdk.query.AuthClazzMenuQuery;
import com.github.itdachen.admin.sdk.vo.AuthClazzMenuVO;
import com.github.itdachen.auth.constants.AppConstants;
import com.github.itdachen.framework.context.annotation.FuncTitle;
import com.github.itdachen.framework.core.response.ServerResponse;
import com.github.itdachen.framework.webmvc.controller.BizController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * 岗位菜单
 *
 * @author 王大宸
 * @date 2024-05-15 21:32:13
 */
@Controller
@RequestMapping("/admin/auth/clazz/menu")
@FuncTitle("岗位菜单")
public class AuthClazzMenuController {
    private static final Logger logger = LoggerFactory.getLogger(AuthClazzMenuController.class);
    private static final String PATH_PREFIX = "admin/clazz";

    private final IAuthClazzMenuService authClazzMenuService;

    public AuthClazzMenuController(IAuthClazzMenuService authClazzMenuService) {
        this.authClazzMenuService = authClazzMenuService;
    }

    /***
     * 跳转到信息管理界面
     *
     * @author 王大宸
     * @date 2024-05-15 21:32:13
     * @return java.lang.String
     */
    @GetMapping(value = "/{clazzCode}/index")
    public String index(@PathVariable("clazzCode") String clazzCode, ModelMap modelMap) {
//        modelMap.put("clazzId", clazzId);
//        return PATH_PREFIX + "/app";

        modelMap.put("clazzId", clazzCode);
        modelMap.put("appId", AppConstants.APP_ID);
        return PATH_PREFIX + "/power";
    }

    /***
     * 跳转到添加页面
     *
     * @author 王大宸
     * @date 2024-05-15 21:32:13
     * @return java.lang.String
     */
    @GetMapping(value = "/clazz/{clazzId}/app/{appId}")
    public String add(@PathVariable("clazzId") String clazzId,
                      @PathVariable("appId") String appId,
                      ModelMap modelMap) {
        modelMap.put("clazzId", clazzId);
        modelMap.put("appId", appId);
        return PATH_PREFIX + "/power";
    }

    /***
     * 新增入库
     *
     * @author 王大宸
     * @date 2024/5/17 16:02
     * @param dto dto
     * @return com.github.itdachen.framework.core.response.ServerResponse<com.github.itdachen.admin.sdk.vo.AuthClazzMenuVO>
     */
    @PostMapping("")
    @ResponseBody
    public ServerResponse<AuthClazzMenuVO> saveInfo(@RequestBody AuthClazzMenuDTO dto) throws Exception {
        return ServerResponse.ok(authClazzMenuService.saveInfo(dto));
    }


}