package com.xiaobangbang.pcdemo.demo;

import com.xiaobangbang.config.service.CustomerService;
import com.xiaobangbang.rabbitmqproducer.senders.UserSender;

import javax.annotation.Resource;

/**
 * @author peyazhuo
 * @date 2020/1/8
 */

public class TestUserServiceImpl implements TestUserService{
    @Resource
    private CustomerService customerService;
    @Resource
    private UserSender userSender;
    @Override
    public void demo(String args) {
        System.out.println(userSender);
        customerService.printString("he");
    }
}
