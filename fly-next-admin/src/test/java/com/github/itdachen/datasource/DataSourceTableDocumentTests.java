package com.github.itdachen.datasource;

import cn.smallbun.screw.core.Configuration;
import cn.smallbun.screw.core.engine.EngineConfig;
import cn.smallbun.screw.core.engine.EngineFileType;
import cn.smallbun.screw.core.engine.EngineTemplateType;
import cn.smallbun.screw.core.execute.DocumentationExecute;
import cn.smallbun.screw.core.process.ProcessConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 * Created by 王大宸 on 2023-06-27 16:10
 * Created with IntelliJ IDEA.
 */
@SpringBootTest
public class DataSourceTableDocumentTests {
    @Autowired
    private DataSource dataSource;

    @Test
    public void tableDocument() {
        EngineFileType fileType = EngineFileType.HTML;
//        EngineFileType fileType = EngineFileType.WORD;
//        EngineFileType fileType = EngineFileType.MD;


        // 生成文件配置
        EngineConfig engineConfig = EngineConfig.builder()
                // 生成文件路径
                .fileOutputDir("d:\\Downloads")
                // 生成之后是否打开目录
                .openOutputDir(false)
                // 文件类型: WORD, HTML, MD
                .fileType(fileType)
                //  .fileType(EngineFileType.HTML)
                // 生成模板实现
                .produceType(EngineTemplateType.freemarker)
                //自定义文件名称
                .fileName("数据库文档")
                .build();

        // 生成文档配置（包含以下自定义版本号、描述等配置连接）
        Configuration config = Configuration.builder()
                .version("1.0")
                .description("生成文档信息描述")
                .dataSource(dataSource)
                .engineConfig(engineConfig)
                .produceConfig(getProcessConfig())
                .build();

        // 执行生成
        new DocumentationExecute(config).execute();
    }

    private ProcessConfig getProcessConfig() {
        // 忽略表名
        List<String> ignoreTableName = Arrays.asList("aa", "test_group");
        // 忽略表前缀，如忽略a开头的数据库表
        List<String> ignorePrefix = Arrays.asList("a", "b");
        // 忽略表后缀
        List<String> ignoreSuffix = Arrays.asList("_test", "czb_");

        return ProcessConfig.builder()
                //根据名称指定表生成
                .designatedTableName(new ArrayList<>())
                //根据表前缀生成
                .designatedTablePrefix(new ArrayList<>())
                //根据表后缀生成
                .designatedTableSuffix(new ArrayList<>())
                //忽略表名
                .ignoreTableName(ignoreTableName)
                //忽略表前缀
                .ignoreTablePrefix(ignorePrefix)
                //忽略表后缀
                .ignoreTableSuffix(ignoreSuffix).build();
    }

}
