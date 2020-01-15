package com.xiaobangbang.rabbitmq;

import com.xiaobangbang.pcdemo.CustomerService;

import javax.annotation.Resource;

/**
 * @author peyazhuo
 * @date 2020/1/8
 */
public class ServiceXX {
    @Resource
    private CustomerService customerService;

    public void main(String[] args) {
        customerService.printString("aaa");
    }

}
