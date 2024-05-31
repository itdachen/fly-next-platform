package com.github.itdachen.admin.controller;

import com.github.itdachen.admin.service.IAdmAreaService;
import com.github.itdachen.admin.sdk.dto.AdmAreaDTO;
import com.github.itdachen.admin.sdk.query.AdmAreaQuery;
import com.github.itdachen.admin.sdk.vo.AdmAreaVO;
import com.github.itdachen.framework.context.annotation.FuncTitle;
import com.github.itdachen.framework.context.tree.ZTreeNode;
import com.github.itdachen.framework.core.response.ServerResponse;
import com.github.itdachen.framework.webmvc.controller.BizController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 行政区划代码
 *
 * @author 王大宸
 * @date 2024-05-06 21:18:46
 */
@Controller
@RequestMapping("/admin/area")
@FuncTitle("行政区划代码")
public class AdmAreaController extends BizController<IAdmAreaService, AdmAreaDTO, AdmAreaVO, AdmAreaQuery, Long> {
    private static final Logger logger = LoggerFactory.getLogger(AdmAreaController.class);
    private static final String PATH_PREFIX = "admin/area";

    @GetMapping("/prov/list")
    @ResponseBody
    public ServerResponse<List<ZTreeNode>> findProvList() {
        return ServerResponse.ok(bizService.findProvList());
    }

    @GetMapping("/city/{code}/list")
    @ResponseBody
    public ServerResponse<List<ZTreeNode>> findCityList(@PathVariable("code") String code) {
        return ServerResponse.ok(bizService.findCityList(code));
    }


    @GetMapping("/county/{code}/list")
    @ResponseBody
    public ServerResponse<List<ZTreeNode>> findCountyList(@PathVariable("code") String code) {
        return ServerResponse.ok(bizService.findCountyList(code));
    }


}