package com.xiaobangbang.pcdemo;

import org.springframework.stereotype.Service;

/**
 * @author peyazhuo
 * @date 2020/1/8
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
    @Override
    public void printString(String s) {
        System.out.println(s);
    }
}
