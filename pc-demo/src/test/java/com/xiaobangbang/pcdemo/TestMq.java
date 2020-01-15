package com.xiaobangbang.pcdemo;

import com.xiaobangbang.entity.User;
import com.xiaobangbang.rabbitmqproducer.senders.UserSender;
import com.xiaobangbnag.pojo.dto.MessageDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;



@SpringBootTest(classes = PcDemoApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestMq {

    @Resource
    private CustomerService customerService;
    @Resource
    private UserSender userSender;

    @Test
    public void testMq(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("key1","头部");
        map.put("key2","头部2");

        User user = new User();
        user.setName("Bob");
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setUser(user);
        messageDTO.setContext("aaaaaaaaaaaaaaaaaa");

        boolean b = userSender.sendMessage(messageDTO, map);
       /* if(b){
            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        }else {
            System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
        }*/

    }


}
