package com.cyh.propagation.test;

import lombok.AllArgsConstructor;

/**
 * @author: yanhua.chen
 * @date: 2019/3/27 14:13
 */
@AllArgsConstructor
public enum ExceptionLocationEnum {

    NO("没有异常"), OUTER("外层事务异常"), INNER("内层事务异常");

    private String desc;

	private ExceptionLocationEnum(String desc) {
		this.desc = desc;
	}

}
