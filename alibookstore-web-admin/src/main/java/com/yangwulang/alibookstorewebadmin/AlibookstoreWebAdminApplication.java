package com.yangwulang.alibookstorewebadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author yangwulang
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.yangwulang.userservice","com.yangwulang.alibookstorewebadmin"})
@EnableSwagger2
@MapperScan("com.yangwulang.dao")
public class AlibookstoreWebAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlibookstoreWebAdminApplication.class, args);
    }

}
