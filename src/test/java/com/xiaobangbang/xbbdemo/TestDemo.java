package com.xiaobangbang.xbbdemo;

import org.junit.Test;

import java.util.Date;

/**
 * @author peyazhuo
 * @date 2019/12/20
 */
public class TestDemo {

    @Test
    public void testLinkHashMap(){
        System.out.println("master添加");
        System.out.println((int)(new Date().getTime()/1000));

        Long ll = new Long(2147483647);
        int i = ll.intValue();
        int ii = Integer.parseInt(String.valueOf(ll));
        System.out.println(ii+" "+i);

        System.out.println("删除");


        System.out.println("PEI提交");


        System.out.println("master");

        System.out.println(new Date()+"master");
    }
}
