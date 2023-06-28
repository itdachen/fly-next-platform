package com.github.itdachen.datasource;

import cn.smallbun.screw.core.engine.EngineFileType;
import com.github.itdachen.framework.code.TableDocsHelper;
import com.github.itdachen.framework.code.entity.TableDocsInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

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
        TableDocsInfo tableDocsInfo = TableDocsInfo.builder()
                .fileName("数据库表设计文档")
                .title("FlyNext 数据库文档")
                .fileType(EngineFileType.HTML)
                .openOutputDir(false)
                .fileOutputDir("d:\\Downloads")
                .version("V1.0.1")
                .description("基本表文档")
                .build();
        TableDocsHelper.document(tableDocsInfo, dataSource);
    }

}
