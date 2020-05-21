package com.cyh;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yanhua.chen@bkjk.com
 * @date 2019/5/21 22:35
 */
public class OrderServiceImplTest {


    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("userService.xml");
        OrderServiceImpl orderService = (OrderServiceImpl) context.getBean("orderService");
        orderService.addOrder();
    }

}
