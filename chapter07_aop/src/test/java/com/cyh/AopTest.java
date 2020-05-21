package com.cyh;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cyh2.NonAopBeanTest;

public class AopTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aop-context.xml");
        context.getBean(TestBean.class).test();
        System.err.println("==========================================================================");
        context.getBean(NonAopBeanTest.class).thisIsNonAopBeanMethod();
        System.err.println("==========================================================================");
    }

}
