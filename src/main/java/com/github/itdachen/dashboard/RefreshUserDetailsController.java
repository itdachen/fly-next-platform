package com.github.itdachen.dashboard;

import com.github.itdachen.auth.service.IAuthUserRoleService;
import com.github.itdachen.auth.service.IRoleAuthoritiesService;
import com.github.itdachen.boot.security.details.IRefreshUserDetails;
import com.github.itdachen.framework.context.userdetails.UserInfoDetails;
import com.github.itdachen.framework.core.response.ServerResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Set;

/**
 * 根据用户身份刷新用户信息
 *
 * @author 王大宸
 * @date 2024-10-21 17:30
 */
@Controller
@RequestMapping("/refresh/user/details")
public class RefreshUserDetailsController {

    private final IAuthUserRoleService userRoleService;
    private final IRefreshUserDetails refreshUserDetails;
    private final IRoleAuthoritiesService roleAuthoritiesService;

    public RefreshUserDetailsController(IAuthUserRoleService userRoleService,
                                        IRefreshUserDetails refreshUserDetails,
                                        IRoleAuthoritiesService roleAuthoritiesService) {
        this.userRoleService = userRoleService;
        this.refreshUserDetails = refreshUserDetails;
        this.roleAuthoritiesService = roleAuthoritiesService;
    }

    @PostMapping("/{roleId}")
    @ResponseBody
    public ServerResponse<Object> refreshUserDetails(HttpServletRequest request,
                                                     HttpServletResponse response,
                                                     @PathVariable("roleId") String roleId) throws Exception {
        UserInfoDetails userDetails = userRoleService.findUserRoleDetails(roleId);
        Set<String> strings = roleAuthoritiesService.roleAuthorities(userDetails);
        List<String> authorities = strings.stream().toList();
        refreshUserDetails.refreshUserDetails(request, response, userDetails, authorities);
        return ServerResponse.ok("身份信息切换成功！");
    }


}
