package com.xiaobangbang.pcdemo.newTest;

import com.xiaobangbang.elasticsearch.help.EsHelp;
import com.xiaobangbang.pcdemo.config.TestConfigXxx;
import com.xiaobangbang.pcdemo.entity.Student;
import com.xiaobangbang.rabbitmqproducer.senders.UserSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author peyazhuo
 * @date 2020/1/13
 */

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class XbbDemoTest {
    @Autowired
    private Student student;
    @Resource
    private UserSender userSender;
    @Resource
    private TestConfigXxx config;

    @Resource
    private EsHelp esHelp;

    @Test
    public void testConfig(){
        System.out.println("===========================");
        System.out.println("===========================");
        System.out.println("===========================");
        //config.soutConfig();
    }

    @Test
    public void testEs(){
        try {
            esHelp.searchForPage();
        } catch (IOException e) {
            System.out.println("==============出错=============");
        }


    }


}
