package com.cyh.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserServiceTransactionTest2 {

	public static void main(String[] args) throws InterruptedException {
//		Thread.sleep(30 * 1000);
		System.err.println("------------");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("userService.xml");
		System.err.println("------------");
//		try {
//			User user = new User(null, "save0()", 28, "Male");
//			context.getBean(UserService.class).save0(user);
//		} catch (Exception e) {
//			log.warn(e.getMessage(), e);
//		}
//		try {
//			User user = new User(null, "save1()", 28, "Male");
//			context.getBean(UserService.class).save1(user);
//		} catch (Exception e) {
//			log.warn(e.getMessage(), e);
//		}
//		try {
//			User user = new User(null, "save2()", 28, "Male");
//			context.getBean(UserService.class).save2(user);
//		} catch (Exception e) {
//			log.warn(e.getMessage(), e);
//		}
//		try {
//		User user = new User(null, "save3()", 28, "Male");
//		UserService userService=context.getBean(UserService.class);
//		System.err.println("------------");
//		userService.save3(user);
//		System.err.println("------------");
//		} catch (Exception e) {
//			log.warn(e.getMessage(), e);
//		}
//		try {
//			User user = new User(null, "save4()", 28, "Male");
//			context.getBean(UserService.class).save4(user);
//		} catch (Exception e) {
//			log.warn(e.getMessage(), e);
//		}
//		try {
//			User user = new User(null, "save5()", 28, "Male");
//			context.getBean(UserService.class).save5(user);
//		} catch (Exception e) {
//			log.warn(e.getMessage(), e);
//		}
		try {
			User user = new User(null, "save6()", 28, "Male");
			UserService userService=context.getBean(UserService.class);
			System.err.println("------------");
			userService.save6(user);
			System.err.println("------------");
		} catch (Exception e) {
			log.warn(e.getMessage(), e);
		}
//		try {
//			User user = new User(null, "save7()", 28, "Male");
//			context.getBean(UserService.class).save7(user);
//		} catch (Exception e) {
//			log.warn(e.getMessage(), e);
//		}
		context.close();
//		Thread.sleep(Integer.MAX_VALUE);
	}

}
