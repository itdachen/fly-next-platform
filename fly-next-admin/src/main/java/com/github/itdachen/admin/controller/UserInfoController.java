package com.github.itdachen.admin.controller;

import com.github.itdachen.admin.entity.SetUserPassword;
import com.github.itdachen.admin.service.IUserInfoService;
import com.github.itdachen.admin.entity.UserInfo;
import com.github.itdachen.admin.sdk.query.UserInfoQuery;
import com.github.itdachen.admin.sdk.vo.UserInfoVo;
import com.github.itdachen.framework.context.annotation.CheckApiClient;
import com.github.itdachen.framework.context.annotation.CurrentUser;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.context.userdetails.CurrentUserDetails;
import com.github.itdachen.framework.core.constants.ClientConstant;
import com.github.itdachen.framework.core.response.ServerResponse;
import com.github.itdachen.framework.webmvc.controller.BizController;
import com.github.itdachen.security.exception.ClientTokenException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * 用户信息
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
@Controller
@RequestMapping("/admin/user/info")
@CheckApiClient(title = "用户信息", clientId = ClientConstant.CLIENT_WEB)
public class UserInfoController extends BizController<IUserInfoService, UserInfo, UserInfoVo, UserInfoQuery, String> {
    private static final Logger logger = LoggerFactory.getLogger(UserInfoController.class);
    private static final String PATH_PREFIX = "admin/user" ;

    /***
     * 跳转到信息管理界面
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:46
     * @return java.lang.String
     */
    @GetMapping(value = "/index")
    @PreAuthorize("hasAuthority('admin:user:info:index')")
    public String index() {
        return PATH_PREFIX + "/index" ;
    }

    /***
     * 跳转到添加页面
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:46
     * @return java.lang.String
     */
    @GetMapping(value = "/{departId}/add")
    @PreAuthorize("hasAuthority('admin:user:info:save')")
    public String add(@PathVariable("departId") String departId,
                      ModelMap modelMap) {
        modelMap.put("departId", departId);
        return PATH_PREFIX + "/add" ;
    }

    /***
     * 跳转到修改页面
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:46
     * @param id         需要修改数据的id
     * @param modelMap   modelMap
     * @return java.lang.String
     */
    @GetMapping(value = "/edit/{id}")
    @PreAuthorize("hasAuthority('admin:user:info:update')")
    public String edit(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("userInfo", bizService.getById(id));
        return PATH_PREFIX + "/edit" ;
    }

    /***
     * 跳转到查看页面
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:46
     * @param id          需要查看数据的id
     * @param modelMap    modelMap
     * @return java.lang.String
     */
    @GetMapping(value = "/view/{id}")
    @PreAuthorize("hasAuthority('admin:user:info:view')")
    public String see(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("userInfo", bizService.getById(id));
        return PATH_PREFIX + "/see" ;
    }


    /***
     * 修改密码
     *
     * @author 王大宸
     * @date 2023/4/5 22:28
     * @param userPassword userPassword
     * @return com.github.itdachen.framework.core.response.ServerResponse<com.github.itdachen.admin.sdk.vo.UserInfoVo>
     */
    @PutMapping("/password")
    @ResponseBody
    public ServerResponse<UserInfoVo> password(@RequestBody SetUserPassword userPassword) throws BizException {
        bizService.password(userPassword);
        return ServerResponse.ok();
    }


    /***
     * 测试, 通过注解的方式, 获取账号的登录详细信息
     *
     * @author 王大宸
     * @date 2023/4/10 16:27
     * @param info info
     * @return com.github.itdachen.framework.core.response.ServerResponse<com.github.itdachen.security.user.CurrentUserInfo>
     */
    @GetMapping("/test/user/info")
    @ResponseBody
    public ServerResponse<CurrentUserDetails> getCurrentUser(@CurrentUser CurrentUserDetails info) throws ClientTokenException {
        System.err.println(info.getDeptId());
        System.err.println(info.toString());
        return ServerResponse.okData(info);
    }

}