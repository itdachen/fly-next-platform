package com.github.itdachen.datasource;

import com.github.itdachen.framework.datasource.DataSourceEncrypt;
import com.github.itdachen.framework.datasource.constants.DataSourceKeyConstant;
import com.github.itdachen.framework.datasource.encoder.DataSourceEncoder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Description: 数据库加密
 * Created by 王大宸 on 2023/04/17 23:01
 * Created with IntelliJ IDEA.
 */
@SpringBootTest
public class FlyNextAdminDatasourceTests {


    @Autowired
    private DataSourceEncrypt dataSourceEncrypt;
    @Autowired
    private DataSourceEncoder dataSourceEncoder;

    @Test
    void dataSourceEncoder() {
        String url = "jdbc:mysql://127.0.0.1:3306/fly-next?useUnicode=true&characterEncoding=UTF8&createDatabaseIfNotExist=true&useUnicode=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true&allowMultiQueries=true";
        String username = "root";
        String password = "root";

        final String encryptUrl = dataSourceEncrypt.encrypt(url, DataSourceKeyConstant.AES);
        final String encryptUsername = dataSourceEncrypt.encrypt(username, DataSourceKeyConstant.AES);
        final String encryptPassword = dataSourceEncrypt.encrypt(password, DataSourceKeyConstant.AES);

        System.err.println("加密后:");
        System.err.println("url: " + encryptUrl);
        System.err.println("username: " + encryptUsername);
        System.err.println("password: " + encryptPassword);
        System.err.println();
        System.err.println("解密后:");
        System.err.println("url: " + dataSourceEncoder.decrypt(encryptUrl));
        System.err.println("username: " + dataSourceEncoder.decrypt(encryptUsername));
        System.err.println("password: " + dataSourceEncoder.decrypt(encryptPassword));


    }

}
