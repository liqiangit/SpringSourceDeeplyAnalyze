package com.cyh;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MybatisTest {

    @Test
    public void testMybatisIntegrateWithSpring() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = context.getBean(UserMapper.class).getUser(1);
        System.err.println(user);
    }


}
