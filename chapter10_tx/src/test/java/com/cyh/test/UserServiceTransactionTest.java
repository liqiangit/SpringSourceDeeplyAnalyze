package com.cyh.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserServiceTransactionTest {
	static Logger log=LoggerFactory.getLogger(UserServiceTransactionTest.class);

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("userService.xml");
        try {
            User user = new User(null, "saveWithTransaction()", 28, "Male");
            context.getBean(UserService.class).saveWithTransaction(user);
        } catch (Exception e) {
            log.warn(e.getMessage(), e);
        }
        try {
            User user = new User(null, "saveWithoutTransaction()", 28, "Male");
            context.getBean(UserService.class).saveWithoutTransaction(user);
        } catch (Exception e) {
            log.warn(e.getMessage(), e);
        }
        try {
            User user = new User(null, "saveWithPlatformTransactionManager()", 28, "Male");
            context.getBean(UserService.class).saveWithPlatformTransactionManager(user);
        } catch (Exception e) {
            log.warn(e.getMessage(), e);
        }
        try {
            User user = new User(null, "UserServiceWithoutTransaction.save()", 29, "Male");
            context.getBean(UserServiceWithoutTransaction.class).save(user);
        } catch (Exception e) {
            log.warn(e.getMessage(), e);
        }
        context.close();
    }

}
