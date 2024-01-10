package com.github.itdachen;

import com.alibaba.druid.spring.boot3.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Description: 项目启动入口
 * Created by 王大宸 on 2023-11-11 12:32
 * Created with IntelliJ IDEA.
 */
@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class})
// @SpringBootApplication
@MapperScan(basePackages = "com.github.itdachen.**.mapper")
public class NextAdminBootstrap {

    public static void main(String[] args) {
        // SpringBootBootstrap.run(NextAdminBootstrap.class);
        SpringApplication.run(NextAdminBootstrap.class, args);
    }

}