package com.xiaobangbang.pcdemo.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author peyazhuo
 * @date 2020/1/14
 */
@Component
@EnableConfigurationProperties(TestConfig.class)
public class TestConfigXxx {

    @Resource
    private TestConfig testConfig;

    /*@Value("${spring.application.name}")
    private String appName;
    @Value("${yaml.str}")
    private String str2;
    @Value("${yaml.num}")
    private Double num2;

    public void soutConfig(){
        System.out.println(testConfig.getStr()+"  "+testConfig.getNum());
        System.out.println(appName+"  "+str2+" "+num2);
    }*/

    public TestConfigXxx() {
    }
}
