package com.xiaobangbang.rabbitmqproducer.testDemo;

import com.xiaobangbang.rabbitmqproducer.senders.UserSender;

import javax.annotation.Resource;

/**
 * @author peyazhuo
 * @date 2020/1/8
 */
public class testaa {

    @Resource(name = "userSender")
    private static UserSender userSender;


    public static void main(String[] args) {
        System.out.println(userSender);
    }

}
