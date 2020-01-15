package com.yangwulang.alibookstoreeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author yangwulang
 */
@SpringBootApplication
@EnableEurekaServer
public class AlibookstoreEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlibookstoreEurekaApplication.class, args);
    }

}
