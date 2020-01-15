package com.xiaobangbang.pcdemo.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author peyazhuo
 * @date 2020/1/13
 */
@ConfigurationProperties(prefix = "yaml")
@Setter
@Getter
public class TestConfig {
    //TODO 未完成参数配置赋值

    private String str;

    private double num;

    //TODO 测试@value失败
    /*@Value("${spring.application.name}")
    private String name;*/

    //private List<String> list;

    //private List<User> users;

    public TestConfig() {
    }
}
