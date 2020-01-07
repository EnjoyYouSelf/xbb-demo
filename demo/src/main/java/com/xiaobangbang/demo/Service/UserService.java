package com.xiaobangbang.demo.Service;

import org.springframework.scheduling.annotation.Async;

/**
 * @author peyazhuo
 * @date 2019/12/18
 */
public class UserService {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("开始调用");
        System.out.println(Thread.currentThread());
        UserService userService = new UserService();
        userService.asyncMethod("参数");
        System.out.println("结束主进程");

    }

    @Async
    public void asyncMethod(String str) throws InterruptedException {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getId());
        Thread.sleep(10000L);
        System.out.println(str);
        System.out.println("异步方法结束");
    }


}
