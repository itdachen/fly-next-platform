package com.github.itdachen.tools;

import com.github.itdachen.framework.assets.tree.ZTreeNode;
import com.github.itdachen.framework.code.constants.UiStyleConstant;
import com.github.itdachen.framework.code.entity.ProtoTable;
import com.github.itdachen.framework.code.entity.TableColumn;
import com.github.itdachen.framework.code.entity.TableInfo;
import com.github.itdachen.framework.code.sdk.dto.TableInfoDto;
import com.github.itdachen.framework.code.sdk.query.GenTableQuery;
import com.github.itdachen.framework.code.sdk.query.TableInfoQuery;
import com.github.itdachen.framework.code.sdk.vo.TableInfoVo;
import com.github.itdachen.framework.context.annotation.IgnoreResponseAdvice;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.core.response.ServerResponse;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.tools.service.ITableInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 代码生成业务表
 *
 * @author 王大宸
 * @date 2022-08-10 15:11:50
 */
@Controller
@RequestMapping("/tools/table/info")
public class TableInfoController {
    private static final Logger logger = LoggerFactory.getLogger(TableInfoController.class);
    private static final String PATH_PREFIX = "tools/code";

    private final ITableInfoService tableInfoService;

    public TableInfoController(ITableInfoService tableInfoService) {
        this.tableInfoService = tableInfoService;
    }


    @GetMapping(value = "/index")
    public String index() {
        return PATH_PREFIX + "/index";
    }

    /***
     * 跳转到导入页面
     *
     * @author 王大宸
     * @date 2022/8/14 15:41
     * @return java.lang.String
     */
    @GetMapping(value = "/import/index")
    public String importIndex() {
        return PATH_PREFIX + "/list";
    }

    /***
     * 跳转到编辑页面
     *
     * @author 王大宸
     * @date 2022/8/14 16:56
     * @param id id
     * @param modelMap modelMap
     * @return java.lang.String
     */
    @GetMapping(value = "/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap modelMap) {
        modelMap.put("id", id);
        return PATH_PREFIX + "/edit";
    }

    /***
     * 跳转到预览代码页面
     *
     * @author 王大宸
     * @date 2022/8/17 20:02
     * @param id id
     * @param modelMap modelMap
     * @return java.lang.String
     */
    @GetMapping(value = "/view/{id}")
    public String view(@PathVariable("id") String id, ModelMap modelMap) {
        modelMap.put("id", id);
        return PATH_PREFIX + "/preview";
    }

    /***
     * 跳转到添加菜单
     *
     * @author 王大宸
     * @date 2022/9/5 13:55
     * @return java.lang.String
     */
    @GetMapping("/dirt/menu")
    public String dirtMenu() {
        return PATH_PREFIX + "/menu";
    }

    /***
     * 跳转到新增表格页面
     *
     * @author 王大宸
     * @date 2023/2/16 14:59
     * @return java.lang.String
     */
    @GetMapping("/save/table")
    public String saveTable() throws BizException {
        return PATH_PREFIX + "/table";
    }

    /***
     * 跳转到添加字段页面
     *
     * @author 王大宸
     * @date 2023/2/16 10:53
     * @param id id
     * @param modelMap modelMap
     * @return java.lang.String
     */
    @GetMapping("/column/{id}")
    public String addColumn(@PathVariable("id") String id, ModelMap modelMap) {
        modelMap.put("tableId", id);
        return PATH_PREFIX + "/column";
    }

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2022-08-10 15:17:41
     * @param params  com.itdachen.tools.sdk.query.TableInfoQuery
     * @return com.itdachen.common.framework.core.response.ServerResponse<com.itdachen.common.framework.core.response.TableData < com.itdachen.tools.sdk.vo.TableInfoVo>>
     */
    @GetMapping(value = "/page")
    @ResponseBody
    public ServerResponse<TableData<TableInfoVo>> findTableInfoPage(TableInfoQuery params) throws BizException {
        return ServerResponse.okData(tableInfoService.findTableInfoPage(params));
    }

    /***
     * 修改
     *
     * @author 王大宸
     * @date 2022-08-10 15:17:41
     * @param tableInfoDto tableInfoDto
     * @return com.itdachen.common.framework.core.response.ServerResponse<com.itdachen.tools.sdk.dto.tableInfo>
     */
    @PutMapping(value = "/{id}")
    @ResponseBody
    public ServerResponse<TableInfoDto> updateTableInfo(@Validated @RequestBody TableInfoDto tableInfoDto) throws BizException {
        return ServerResponse.okData(tableInfoService.updateTableInfo(tableInfoDto));
    }

    /***
     * 根据id查询
     *
     * @author 王大宸
     * @date 2022-08-10 15:17:41
     * @param id 需要查询数据的id
     * @return com.itdachen.common.framework.core.response.ServerResponse<com.itdachen.tools.sdk.vo.TableInfoVo>
     */
    @GetMapping(value = "/{id}")
    @ResponseBody
    public ServerResponse<TableInfoVo> getTableInfoById(@PathVariable("id") String id) throws BizException {
        return ServerResponse.okData(tableInfoService.getTableInfoById(id));
    }

    /***
     * 删除
     *
     * @author 王大宸
     * @date 2022-08-10 15:17:41
     * @param id 需要删除数据的id
     * @return com.itdachen.common.framework.core.response.ServerResponse<com.itdachen.tools.sdk.vo.TableInfoVo>
     */
    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public ServerResponse<TableInfoVo> removeTableInfo(@PathVariable("id") String id) throws BizException {
        tableInfoService.removeTableInfo(id);
        return ServerResponse.ok();
    }

    /***
     * 查询数据库中的表
     *
     * @author 王大宸
     * @date 2022/8/14 15:53
     * @param query query
     * @return com.itdachen.common.framework.core.response.ServerResponse<com.itdachen.common.framework.core.response.TableData < com.itdachen.tools.entity.GenTable>>
     */
    @GetMapping(value = "/db/list")
    @ResponseBody
    public ServerResponse<TableData<ProtoTable>> dbList(GenTableQuery query) throws BizException {
        return ServerResponse.okData(tableInfoService.dbList(query));
    }

    /***
     * 导入, 数据入库
     *
     * @author 王大宸
     * @date 2022/8/14 16:24
     * @param tableNames tableName
     * @return com.itdachen.common.framework.core.response.ServerResponse<com.itdachen.tools.entity.GenTable>
     */
    @PostMapping(value = "/import/db")
    @ResponseBody
    public ServerResponse<ProtoTable> importGenTable(@RequestParam String tableNames) throws BizException {
        tableInfoService.importGenTable(tableNames, UiStyleConstant.LAY_UI);
        return ServerResponse.ok();
    }

    /***
     * 生成代码
     *
     * @author 王大宸
     * @date 2022/8/16 22:03
     * @param params params
     * @param response response
     * @return void
     */
    @GetMapping(value = "/code")
    @IgnoreResponseAdvice
    public void code(@RequestParam Map<String, String> params,
                     HttpServletResponse response) throws Exception {
        String ids = params.get("id");
        tableInfoService.downloadCode(ids.split(","), response);
    }

    /***
     * 预览代码
     *
     * @author 王大宸
     * @date 2022/8/16 23:20
     * @param id id
     * @return com.itdachen.common.framework.core.response.ServerResponse<java.util.Map < java.lang.String, java.lang.String>>
     */
    @GetMapping("/preview/{id}")
    @ResponseBody
    public ServerResponse<Map<String, String>> previewCode(@PathVariable("id") String id) throws Exception {
        return ServerResponse.okData(tableInfoService.previewCode(id));
    }

    /***
     * 获取目录菜单
     *
     * @author 王大宸
     * @date 2022/9/5 13:50
     * @return com.itdachen.framework.core.response.ServerResponse<java.util.List < com.itdachen.common.node.ZTreeNode>>
     */
    @GetMapping(value = "/dirt/zTree")
    @ResponseBody
    public ServerResponse<List<ZTreeNode>> dirtZTree() throws BizException {
        return ServerResponse.okData(tableInfoService.dirtZTree());
    }

    /***
     * 数据字典列表
     *
     * @author 王大宸
     * @date 2022/9/5 14:46
     * @return com.itdachen.framework.core.response.ServerResponse<java.util.List < com.itdachen.common.node.ZTreeNode>>
     */
    @GetMapping("/dict")
    @ResponseBody
    public ServerResponse<List<ZTreeNode>> dictList() throws BizException {
        return ServerResponse.okData(tableInfoService.dictList());
    }

    /***
     * 获取应用列表
     *
     * @author 王大宸
     * @date 2023/4/11 21:04
     * @return com.github.itdachen.framework.core.response.ServerResponse<java.util.List<com.github.itdachen.framework.assets.tree.ZTreeNode>>
     */
    @GetMapping("/app/list")
    @ResponseBody
    public ServerResponse<List<ZTreeNode>> appInfoList() throws BizException {
        return ServerResponse.okData(tableInfoService.appInfoList());
    }

    /***
     * 添加字段
     *
     * @author 王大宸
     * @date 2023/4/11 21:12
     * @param tableColumn tableColumn
     * @return com.github.itdachen.framework.core.response.ServerResponse<com.github.itdachen.framework.code.entity.TableColumn>
     */
    @PostMapping("/save/column")
    @ResponseBody
    public ServerResponse<TableColumn> saveTableColumn(@RequestBody TableColumn tableColumn) throws BizException {
        return ServerResponse.okData(tableInfoService.saveTableColumn(tableColumn));
    }


    /***
     * 新增表格
     *
     * @author 王大宸
     * @date 2023/4/11 21:25
     * @param tableInfo tableInfo
     * @return com.github.itdachen.framework.core.response.ServerResponse<com.github.itdachen.framework.code.entity.TableInfo>
     */
    @PostMapping("/save/table")
    @ResponseBody
    public ServerResponse<TableInfo> saveTable(@RequestBody TableInfo tableInfo) throws BizException {
        tableInfo.setUiStyle(UiStyleConstant.LAY_UI);
        return ServerResponse.okData(tableInfoService.saveTable(tableInfo));
    }



}