package com.xc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author cuilb
 * @Data 2022 06 28 10:15
 * @Description
 */
@SpringBootApplication
@MapperScan("com.xc.mapper")
public class TestMavenApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestMavenApplication.class, args);
    }

}
