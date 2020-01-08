package com.xiaobangbang.pcdemo;

import com.xiaobangbang.config.service.CustomerService;
import com.xiaobangbang.pcdemo.demo.TestAutowire;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


@SpringBootTest(classes = PcDemoApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TestMq {

    @Resource
    private TestAutowire testAutowire;
    @Resource
    private CustomerService customerService;

    @Test
    public void testMq(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("key1","头部");
        map.put("key2","头部2");
        System.out.println("a");
        testAutowire.aa();
        customerService.printString("aaaaa");
        System.out.println("aa");
    }

}
