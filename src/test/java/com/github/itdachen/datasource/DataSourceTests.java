package com.github.itdachen.datasource;

import com.github.itdachen.boot.datasource.crypto.IDataSourceEncrypt;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * DataSourceTests
 *
 * @author 王大宸
 * @date 2025/2/22 14:10
 */
@SpringBootTest
public class DataSourceTests {

    @Autowired
    private IDataSourceEncrypt dataSourceEncrypt;

    @Test
    void dataSourceTests() {
        String url = "jdbc:mysql://127.0.0.1:3306/fly_next_admin?useUnicode=true&characterEncoding=UTF8&createDatabaseIfNotExist=true&useUnicode=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true&allowMultiQueries=true";
        String username = "root";
        String password = "root";
        System.err.println("url: " + dataSourceEncrypt.encrypt(url));
        System.err.println("username: " + dataSourceEncrypt.encrypt(username));
        System.err.println("password: " + dataSourceEncrypt.encrypt(password));
    }


}
