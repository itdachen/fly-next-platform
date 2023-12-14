package com.github.itdachen.admin.controller;

import com.github.itdachen.admin.entity.SetUserPassword;
import com.github.itdachen.admin.sdk.dto.UserInfoDto;
import com.github.itdachen.admin.sdk.query.UserInfoQuery;
import com.github.itdachen.admin.sdk.vo.UserInfoVo;
import com.github.itdachen.admin.service.IUserInfoService;
import com.github.itdachen.framework.context.BizContextHandler;
import com.github.itdachen.framework.context.annotation.CheckApiClient;
import com.github.itdachen.framework.context.annotation.CurrentUser;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.context.userdetails.CurrentUserDetails;
import com.github.itdachen.framework.core.constants.ClientConstant;
import com.github.itdachen.framework.core.response.ServerResponse;
import com.github.itdachen.framework.security.context.SecurityContextHandler;
import com.github.itdachen.framework.security.exception.ClientTokenException;
import com.github.itdachen.framework.security.user.CurrentUserInfo;
import com.github.itdachen.framework.webmvc.controller.BizController;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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
    private SecurityContextRepository securityContextRepository;

    /***
     * 测试, 更改登录用户信息
     * http://127.0.0.1:8080/admin/user/info/reload/user/authority
     * @author 王大宸
     * @date 2023/4/17 21:07
     * @return com.github.itdachen.framework.core.response.ServerResponse<com.github.itdachen.admin.sdk.vo.UserInfoVo>
     */
    @GetMapping("/reload/user/authority")
    @ResponseBody
    public ServerResponse<Object> reloadUserAuthority(HttpServletRequest request, HttpServletResponse response) throws ClientTokenException {

        /* 当前权限 */
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CurrentUserInfo userInfo = (CurrentUserInfo) authentication.getPrincipal();
        userInfo.setDeptId("12345678");
        userInfo.setGrade("21");

        // 更新SecurityContextRepository
        securityContextRepository.saveContext(SecurityContextHolder.getContext(), request, response);

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
        System.err.println(BizContextHandler.getDeptId());
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
        System.err.println(info.getDeptId());
        return ServerResponse.okData(info);
    }

}