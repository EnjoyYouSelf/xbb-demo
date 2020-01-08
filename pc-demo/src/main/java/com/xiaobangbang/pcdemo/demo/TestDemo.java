package com.xiaobangbang.pcdemo.demo;

import javax.annotation.Resource;

/**
 * @author peyazhuo
 * @date 2020/1/8
 */
public class TestDemo {

    @Resource
    private static TestUserService testUserService;

    public static void main(String[] args) {
        System.out.println(testUserService);
    }


}
