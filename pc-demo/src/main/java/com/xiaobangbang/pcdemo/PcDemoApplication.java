package com.xiaobangbang.pcdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@ComponentScan(basePackages = "com.xiaobangbang")
public class PcDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(PcDemoApplication.class, args);
    }
}
