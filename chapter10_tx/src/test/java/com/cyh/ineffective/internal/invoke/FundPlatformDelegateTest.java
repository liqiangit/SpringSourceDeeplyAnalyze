package com.cyh.ineffective.internal.invoke;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cyh.test.User;

/**
 * @author: yanhua.chen
 * @date: 2019/3/27 10:58
 */

public class FundPlatformDelegateTest {

    private ApplicationContext applicationContext;

    @Before
    public void before() {
        this.applicationContext = new ClassPathXmlApplicationContext("ineffectiveTx.xml");
    }

    @Test
    public void test_thisInvokingWillLeadToTxIneffective() {
        User user = new User(null, "this调用导致事务失效，数据仍然可以写入数据库", 29, "0");
        FundPlatformDelegate fundPlatformDelegate = applicationContext.getBean(FundPlatformDelegate.class);
        fundPlatformDelegate.thisInvokingWillLeadToTxIneffective(user);
    }

    @Test
    public void test_proxyInvoke() {
        User user = new User(null, "代理调用事务能够生效（事务回滚、数据不入库）", 29, "0");
        FundPlatformDelegate fundPlatformDelegate = applicationContext.getBean(FundPlatformDelegate.class);
        fundPlatformDelegate.proxyInvoke(user);
    }


}
