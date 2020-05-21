package com.cyh.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserServiceTransactionTest2 {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("userService.xml");
		try {
			User user = new User(null, "saveWithTransaction()", 28, "Male");
			context.getBean(UserService.class).save1(user);
			context.getBean(UserService.class).save3(user);
		} catch (Exception e) {
			log.warn(e.getMessage(), e);
		}
		context.close();
	}

}
