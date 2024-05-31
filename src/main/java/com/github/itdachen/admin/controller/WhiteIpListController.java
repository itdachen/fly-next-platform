package com.github.itdachen.admin.controller;

import com.github.itdachen.admin.service.IWhiteIpListService;
import com.github.itdachen.admin.sdk.dto.WhiteIpListDTO;
import com.github.itdachen.admin.sdk.query.WhiteIpListQuery;
import com.github.itdachen.admin.sdk.vo.WhiteIpListVO;
import com.github.itdachen.framework.context.annotation.FuncTitle;
import com.github.itdachen.framework.webmvc.controller.BizController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 菜单白名单
 *
 * @author 王大宸
 * @date 2024-04-20 22:16:38
 */
@Controller
@RequestMapping("/admin/white/ip/list")
@FuncTitle("菜单白名单")
public class WhiteIpListController extends BizController<IWhiteIpListService, WhiteIpListDTO, WhiteIpListVO, WhiteIpListQuery, String> {
    private static final Logger logger = LoggerFactory.getLogger(WhiteIpListController.class);
    private static final String PATH_PREFIX = "admin" ;

    /***
     * 跳转到信息管理界面
     *
     * @author 王大宸
     * @date 2024-04-20 22:16:38
     * @return java.lang.String
     */
    @GetMapping(value = "/index")
    @PreAuthorize("hasAuthority('admin:white:ip:list:index')")
    public String index() {
        return PATH_PREFIX + "/index" ;
    }

    /***
     * 跳转到添加页面
     *
     * @author 王大宸
     * @date 2024-04-20 22:16:38
     * @return java.lang.String
     */
    @GetMapping(value = "/add")
    @PreAuthorize("hasAuthority('admin:white:ip:list:save')")
    public String add() {
        return PATH_PREFIX + "/add" ;
    }

    /***
     * 跳转到修改页面
     *
     * @author 王大宸
     * @date 2024-04-20 22:16:38
     * @param id id
     * @param modelMap   modelMap
     * @return java.lang.String
     */
    @GetMapping(value = "/edit/{id}")
    @PreAuthorize("hasAuthority('admin:white:ip:list:update')")
    public String edit(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("whiteIpList", bizService.selectByPrimaryKey(id));
        return PATH_PREFIX + "/edit" ;
    }

    /***
     * 跳转到查看页面
     *
     * @author 王大宸
     * @date 2024-04-20 22:16:38
     * @param id 需要查看数据的 id
     * @param modelMap    modelMap
     * @return java.lang.String
     */
    @GetMapping(value = "/view/{id}")
    @PreAuthorize("hasAuthority('admin:white:ip:list:view')")
    public String view(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("whiteIpList", bizService.selectByPrimaryKey(id));
        return PATH_PREFIX + "/view" ;
    }


}