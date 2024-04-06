package com.github.itdachen.admin_v1.controller;

import com.github.itdachen.admin_v1.entity.SetUserPassword;
import com.github.itdachen.admin_v1.sdk.dto.UserInfoDto;
import com.github.itdachen.admin_v1.sdk.query.UserInfoQuery;
import com.github.itdachen.admin_v1.sdk.vo.UserInfoVo;
import com.github.itdachen.admin_v1.service.IUserInfoService;
import com.github.itdachen.boot.security.context.SecurityContextHandler;
import com.github.itdachen.boot.security.details.IRefreshUserDetails;
import com.github.itdachen.boot.security.user.CurrentUserInfo;
import com.github.itdachen.framework.context.annotation.CheckApiClient;
import com.github.itdachen.framework.context.annotation.CurrentUser;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.context.exception.ClientTokenException;
import com.github.itdachen.framework.context.userdetails.CurrentUserDetails;
import com.github.itdachen.framework.core.constants.ClientConstant;
import com.github.itdachen.framework.core.response.ServerResponse;
import com.github.itdachen.framework.webmvc.controller.BizController;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户信息
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
@Controller
@RequestMapping("/admin/user/info")
@CheckApiClient(title = "用户信息", clientId = ClientConstant.CLIENT_WEB)
public class UserInfoController extends BizController<IUserInfoService, UserInfoDto, UserInfoVo, UserInfoQuery, String> {
    private static final Logger logger = LoggerFactory.getLogger(UserInfoController.class);
    private static final String PATH_PREFIX = "admin/user";

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
        return PATH_PREFIX + "/index";
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
        return PATH_PREFIX + "/add";
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
        modelMap.put("userInfo", bizService.selectByPrimaryKey(id));
        return PATH_PREFIX + "/edit";
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
        modelMap.put("userInfo", bizService.selectByPrimaryKey(id));
        return PATH_PREFIX + "/see";
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


    @Autowired
    private IRefreshUserDetails refreshUserDetails;

    /***
     * 测试, 更改登录用户信息
     * http://127.0.0.1:8080/admin/user/info/reload/user/authority
     * @author 王大宸
     * @date 2023/4/17 21:07
     * @return com.github.itdachen.framework.core.response.ServerResponse<com.github.itdachen.admin.sdk.vo.UserInfoVo>
     */
    @GetMapping("/reload/user/authority")
    @ResponseBody
    public ServerResponse<Object> reloadUserAuthority(HttpServletRequest request, HttpServletResponse response) throws Exception {

        CurrentUserDetails userDetails = new CurrentUserDetails();
        userDetails.setNickName("张三111");
        userDetails.setDeptLevel("11111");
        userDetails.setDeptId("5201111");
        userDetails.setDeptTitle("贵阳111");

        List<String> list = new ArrayList<>();
        list.add("userDetails");

        refreshUserDetails.refreshUserDetails(request, response, userDetails, list);

        return ServerResponse.okData(SecurityContextHandler.getAuthentication());
    }


    /***
     * 获取修改之后的用户信息
     * http://127.0.0.1:8080/admin/user/info/reload/user/info
     * @author 王大宸
     * @date 2023/4/17 21:07
     * @return com.github.itdachen.framework.core.response.ServerResponse<com.github.itdachen.security.user.CurrentUserInfo>
     */
    @GetMapping("/reload/user/info")
    @ResponseBody
    public ServerResponse<CurrentUserInfo> getCurrentUser() throws ClientTokenException {
        return ServerResponse.okData((CurrentUserInfo) SecurityContextHandler.getUserInfo());
    }

    /***
     * 测试, 通过注解的方式, 获取账号的登录详细信息
     * http://127.0.0.1:8080/admin/user/info/test/user/info
     * @author 王大宸
     * @date 2023/4/10 16:27
     * @param info info
     * @return com.github.itdachen.framework.core.response.ServerResponse<com.github.itdachen.security.user.CurrentUserInfo>
     */
    @GetMapping("/test/user/info")
    @ResponseBody
    public ServerResponse<CurrentUserDetails> getCurrentUser(@CurrentUser CurrentUserDetails info) throws ClientTokenException {
        return ServerResponse.okData(info);
    }

}