package com.xiaobangbang.pcdemo.crotroller;

import com.xiaobangbang.pcdemo.CustomerService;
import com.xiaobangbang.rabbitmqproducer.senders.UserSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author peyazhuo
 * @date 2020/1/8
 */
@RestController
@RequestMapping("/xbbDemo")
public class TestMqController {

    @Resource
    private CustomerService customerService;
    @Resource
    private UserSender userSender;

    @RequestMapping("/testMq")
    public String testMq(){
        customerService.printString("aaa");
        HashMap<String, Object> map = new HashMap<>();
        map.put("head","头部");
       /* boolean aaa = userSender.sendMessage("true", map);
        if(aaa){return "消息发送成功";}*/
        return "失败";
    }

}
