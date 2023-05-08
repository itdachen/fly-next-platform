package com.github.itdachen.auth.controller;

import com.github.itdachen.auth.entity.NextMenuRoute;
import com.github.itdachen.auth.service.INextMenuService;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.core.response.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/***
 * 获取用户菜单
 *
 * @author 王大宸
 * @date 2023/5/8 21:03
 */
@RestController
@RequestMapping("/next/menu")
public class AuthorizedNextMenuController {

    private final INextMenuService nextMenuService;

    public AuthorizedNextMenuController(INextMenuService nextMenuService) {
        this.nextMenuService = nextMenuService;
    }

    /***
     *  获取菜单/路由
     *
     * @author 王大宸
     * @date 2023/5/8 21:06
     * @return com.github.itdachen.framework.core.response.ServerResponse<java.util.List<com.github.itdachen.auth.entity.NextMenuRoute>>
     */
    @GetMapping(value = "/routes")
    public ServerResponse<List<NextMenuRoute>> findNextMenuRoutes() throws Exception {
        return ServerResponse.okData(nextMenuService.findNextMenuRoutes());
    }

    /***
     * 获取按钮全选
     *
     * @author 王大宸
     * @date 2022/7/6 16:42
     * @return com.itdachen.framework.core.response.ServerResponse<java.util.List<java.lang.String>>
     */
    @GetMapping(value = "/permission")
    public ServerResponse<List<String>> findNextPermission() throws Exception {
        return ServerResponse.okData(nextMenuService.findNextPermission());
    }


}
