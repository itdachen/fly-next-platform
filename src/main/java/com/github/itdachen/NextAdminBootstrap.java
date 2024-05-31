package com.github.itdachen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * ${NAME}
 *
 * @author 王大宸
 * @date 2024/4/3 22:11
 */
@EnableAsync
// @SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class})
@SpringBootApplication
@MapperScan(basePackages = "com.github.itdachen.**.mapper")
public class NextAdminBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(NextAdminBootstrap.class, args);
    }

}