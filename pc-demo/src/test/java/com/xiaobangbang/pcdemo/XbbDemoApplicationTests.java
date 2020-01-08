package com.xiaobangbang.pcdemo;

import org.assertj.core.util.Arrays;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Parameterized;

import java.util.Collection;

/**
 *测试参数化流程
 * @date 2019/12/20
 * @author peyazhuo
 * @since: v1.0
 * @version v1.0
 */
@RunWith(Parameterized.class)
public class XbbDemoApplicationTests {

    private static XxxService xxxService;
    // 测试数据
    private int num;
    // 定义期望值
    private boolean expect;
    // 每个测试用例进行初始化@BeforeClass需要静态方法
    @BeforeClass
    public static void initTest(){
        xxxService = new XxxService();
    }

    // 需要构造函数（且只有一个构造函数，与下面Parameters对应）
    public XbbDemoApplicationTests(int num) {
        this.num = num;
    }
    // 定义测试数据
    @Parameterized.Parameters
    public static Collection numData(){
        Object[][] objects = {
                {7},
                {20},
                {2}
        };
        return Arrays.asList(objects);
    }

    @Test
    public void testXxxService(){
        try {
            Assert.assertTrue("需为偶数",this.xxxService.validNum(this.num));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 运行测试案例
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(XbbDemoApplicationTests.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());

    }
}
