package com.github.itdachen;

import com.github.itdachen.framework.boot.runner.SpringBootBootstrap;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Description: 项目启动入口类
 * Created by 王大宸 on 2023/03/30 21:26
 * Created with IntelliJ IDEA.
 */
@SpringBootApplication
@MapperScan(basePackages = "com.github.itdachen.**.mapper")
public class NextAdminBootstrap {

    public static void main(String[] args) {
        SpringBootBootstrap.run(NextAdminBootstrap.class);
    }

}
