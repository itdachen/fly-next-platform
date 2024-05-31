package com.github.itdachen.admin.controller;

import com.github.itdachen.admin.sdk.vo.PlatformInfoVO;
import com.github.itdachen.admin.service.IAppInfoService;
import com.github.itdachen.admin.sdk.dto.AppInfoDTO;
import com.github.itdachen.admin.sdk.query.AppInfoQuery;
import com.github.itdachen.admin.sdk.vo.AppInfoVO;
import com.github.itdachen.framework.context.annotation.FuncTitle;
import com.github.itdachen.framework.core.response.ServerResponse;
import com.github.itdachen.framework.webmvc.controller.BizController;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * 应用信息
 *
 * @author 王大宸
 * @date 2024-04-19 21:22:54
 */
@Controller
@RequestMapping("/admin/app/info")
@FuncTitle("应用信息")
public class AppInfoController extends BizController<IAppInfoService, AppInfoDTO, AppInfoVO, AppInfoQuery, String> {
    private static final Logger logger = LoggerFactory.getLogger(AppInfoController.class);
    private static final String PATH_PREFIX = "admin/app";

    /***
     * 跳转到信息管理界面
     *
     * @author 王大宸
     * @date 2024-04-19 21:22:54
     * @return java.lang.String
     */
    @GetMapping(value = "/index")
    @PreAuthorize("hasAuthority('admin:app:info:index')")
    public String index() {
        return PATH_PREFIX + "/index";
    }

    /***
     * 跳转到添加页面
     *
     * @author 王大宸
     * @date 2024-04-19 21:22:54
     * @return java.lang.String
     */
    @GetMapping(value = "/add")
    @PreAuthorize("hasAuthority('admin:app:info:save')")
    public String add() {
        return PATH_PREFIX + "/add";
    }

    /***
     * 跳转到修改页面
     *
     * @author 王大宸
     * @date 2024-04-19 21:22:54
     * @param id id
     * @param modelMap   modelMap
     * @return java.lang.String
     */
    @GetMapping(value = "/edit/{id}")
    @PreAuthorize("hasAuthority('admin:app:info:update')")
    public String edit(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("appInfo", bizService.selectByPrimaryKey(id));
        return PATH_PREFIX + "/edit";
    }

    /***
     * 跳转到查看页面
     *
     * @author 王大宸
     * @date 2024-04-19 21:22:54
     * @param id 需要查看数据的 id
     * @param modelMap    modelMap
     * @return java.lang.String
     */
    @GetMapping(value = "/view/{id}")
    @PreAuthorize("hasAuthority('admin:app:info:view')")
    public String view(@PathVariable("id") String id, ModelMap modelMap) throws Exception {
        modelMap.put("appInfo", bizService.selectByPrimaryKey(id));
        return PATH_PREFIX + "/view";
    }

    /***
     * 更改有效标志状态
     *
     * @author 王大宸
     * @date 2024/4/20 21:21
     * @param id id
     * @param checked checked
     * @return com.github.itdachen.framework.core.response.ServerResponse<com.github.itdachen.admin.sdk.vo.PlatformInfoVO>
     */
    @PostMapping("/{id}/valid/{checked}")
    @ResponseBody
    @PreAuthorize("hasAuthority('admin:app:info:checked')")
    public ServerResponse<AppInfoVO> validFlagChecked(@PathVariable("id") String id,
                                                      @PathVariable("checked") Boolean checked) throws Exception {
        bizService.validFlagChecked(id, checked);
        return ServerResponse.ok();
    }

    /***
     * 查询集合
     *
     * @author 王大宸
     * @date 2024/4/20 22:33
     * @return com.github.itdachen.framework.core.response.ServerResponse<java.util.List < com.github.itdachen.admin.sdk.vo.AppInfoVO>>
     */
    @GetMapping("/list")
    @ResponseBody
    public ServerResponse<List<AppInfoVO>> findAppInfoList() throws Exception {
        return ServerResponse.ok(bizService.findAppInfoList());
    }


    @GetMapping("/exp/test")
    @ResponseBody
    public void expTest(HttpServletRequest request,
                        HttpServletResponse response) throws Exception {

        bizService.dataExpToExcel(request, response, new AppInfoQuery());

//        Workbook workbook = new XSSFWorkbook();
//
//        Sheet sheet = workbook.createSheet("Sheet1");
//
//        // 写入表头
//        Row headerRow = sheet.createRow(0);
//        headerRow.createCell(0).setCellValue("姓名");
//        headerRow.createCell(1).setCellValue("年龄");
//        headerRow.createCell(2).setCellValue("性别");
//
//        // 写入数据行
//        Row dataRow = sheet.createRow(1);
//        dataRow.createCell(0).setCellValue("张三");
//        dataRow.createCell(1).setCellValue(20);
//        dataRow.createCell(2).setCellValue("男");
//
//        try {
//            String path = "d:/upload/output.xlsx";
//            FileOutputStream outputStream = new FileOutputStream(path);
//            workbook.write(outputStream);
//            outputStream.close();
//        } catch(IOException e) {
//            e.printStackTrace();
//        }
//        workbook.close();




    }


}