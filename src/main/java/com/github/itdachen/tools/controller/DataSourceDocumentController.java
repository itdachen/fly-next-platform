package com.github.itdachen.tools.controller;

import cn.smallbun.screw.core.engine.EngineFileType;
import com.github.itdachen.framework.code.TableDocsHelper;
import com.github.itdachen.framework.code.entity.TableDocsInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;

/***
 * 生成数据库文档
 *
 * @author 王大宸
 * @date 2023/6/27 16:01
 */
@Controller
@RequestMapping("/db/docs")
public class DataSourceDocumentController {

    private final DataSource dataSource;

    public DataSourceDocumentController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @GetMapping("/{type}")
    @ResponseBody
    public void document(@PathVariable("type") String type) {
        EngineFileType fileType;
        if ("MD".equalsIgnoreCase(type)) {
            fileType = EngineFileType.MD;
        } else if ("WORD".equalsIgnoreCase(type)) {
            fileType = EngineFileType.WORD;
        } else {
            fileType = EngineFileType.HTML;
        }

        TableDocsInfo tableDocsInfo = TableDocsInfo.builder()
                .fileName("FLY-NEXT 数据库表设计文档")
                .title("FLY-NEXT 数据库表设计文档")
                .fileType(fileType)
                .openOutputDir(false)
                .fileOutputDir("d:\\Downloads")
                .version("V1.0.1")
                .description("基本表文档")
                .build();
        TableDocsHelper.document(tableDocsInfo, dataSource);
    }

}
