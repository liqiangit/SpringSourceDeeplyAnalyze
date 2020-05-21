package com.cyh.propagation.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: yanhua.chen
 * @date: 2019/2/26 11:20
 */
public class OrderServiceTest {

    private ClassPathXmlApplicationContext applicationContext;

    @Before
    public void before() {
        applicationContext = new ClassPathXmlApplicationContext("userService.xml");
    }

    @After
    public void after() {
        applicationContext.close();
    }

    /********************* REQUIRED ********************************************/
    @Test
    public void test_saveWithTransaction_required_noException() {
        OrderService orderService = applicationContext.getBean(OrderService.class);
        OrderPo po = new OrderPo("cyh", "lightSuite", 1, 1699);
        orderService.saveWithTransaction_required(po, ExceptionLocationEnum.NO);
    }

    /**
     * 事务传播属性为 REQUIRED 且 INNER 事务异常 == 全部回滚
     */
    @Test
    public void test_saveWithTransaction_required_innerException() {
        OrderService orderService = applicationContext.getBean(OrderService.class);
        OrderPo po = new OrderPo("cyh", "lightSuite", 1, 1699);
        orderService.saveWithTransaction_required(po, ExceptionLocationEnum.INNER);
    }

    /**
     * 事务传播属性为 REQUIRED 且 OUTER 事务异常 == 全部回滚
     */
    @Test
    public void test_saveWithTransaction_required_outerException() {
        OrderService orderService = applicationContext.getBean(OrderService.class);
        OrderPo po = new OrderPo("cyh", "lightSuite", 1, 1699);
        orderService.saveWithTransaction_required(po, ExceptionLocationEnum.OUTER);
    }



    /********************* REQUIRES_NEW ********************************************/
    @Test
    public void test_saveWithTransaction_requiresNew_noException() {
        OrderService orderService = applicationContext.getBean(OrderService.class);
        OrderPo po = new OrderPo("cyh", "lightSuite", 1, 1699);
        orderService.saveWithTransaction_requiresNew(po, ExceptionLocationEnum.NO);
    }

    /**
     * 事务传播属性为 REQUIRES_NEW 且 INNER 事务异常 == 全部回滚
     */
    @Test
    public void test_saveWithTransaction_requiresNew_innerException() {
        OrderService orderService = applicationContext.getBean(OrderService.class);
        OrderPo po = new OrderPo("cyh", "lightSuite", 1, 1699);
        orderService.saveWithTransaction_requiresNew(po, ExceptionLocationEnum.INNER);
    }

    /**
     * 事务传播属性为 REQUIRES_NEW 且 OUTER 事务异常 == 外部回滚、内部不回滚
     */
    @Test
    public void test_saveWithTransaction_requiresNew_outerException() {
        OrderService orderService = applicationContext.getBean(OrderService.class);
        OrderPo po = new OrderPo("cyh", "lightSuite", 1, 1699);
        orderService.saveWithTransaction_requiresNew(po, ExceptionLocationEnum.OUTER);
    }



    /********************* NESTED ********************************************/
    @Test
    public void test_saveWithTransaction_nested_noException() {
        OrderService orderService = applicationContext.getBean(OrderService.class);
        OrderPo po = new OrderPo("cyh", "lightSuite", 1, 1699);
        orderService.saveWithTransaction_nested(po, ExceptionLocationEnum.NO);
    }

    /**
     * 事务传播属性为 NESTED 且 INNER 事务异常 == 全部回滚
     */
    @Test
    public void test_saveWithTransaction_nested_innerException() {
        OrderService orderService = applicationContext.getBean(OrderService.class);
        OrderPo po = new OrderPo("cyh", "lightSuite", 1, 1699);
        orderService.saveWithTransaction_nested(po, ExceptionLocationEnum.INNER);
    }

    /**
     * 事务传播属性为 NESTED 且 OUTER 事务异常 == 全部回滚
     */
    @Test
    public void test_saveWithTransaction_nested_outerException() {
        OrderService orderService = applicationContext.getBean(OrderService.class);
        OrderPo po = new OrderPo("cyh", "lightSuite", 1, 1699);
        orderService.saveWithTransaction_nested(po, ExceptionLocationEnum.OUTER);
    }



    /********************* MANDATORY ********************************************/
    @Test
    public void test_saveWithTransaction_mandatory_noException() {
        OrderService orderService = applicationContext.getBean(OrderService.class);
        OrderPo po = new OrderPo("cyh", "lightSuite", 1, 1699);
        orderService.saveWithTransaction_mandatory(po, ExceptionLocationEnum.NO);
    }

    /**
     * 事务传播属性为 MANDATORY 且 INNER 事务异常 == 全部回滚
     */
    @Test
    public void test_saveWithTransaction_mandatory_innerException() {
        OrderService orderService = applicationContext.getBean(OrderService.class);
        OrderPo po = new OrderPo("cyh", "lightSuite", 1, 1699);
        orderService.saveWithTransaction_mandatory(po, ExceptionLocationEnum.INNER);
    }

    /**
     * 事务传播属性为 MANDATORY 且 OUTER 事务异常 == 全部回滚
     */
    @Test
    public void test_saveWithTransaction_mandatory_outerException() {
        OrderService orderService = applicationContext.getBean(OrderService.class);
        OrderPo po = new OrderPo("cyh", "lightSuite", 1, 1699);
        orderService.saveWithTransaction_mandatory(po, ExceptionLocationEnum.OUTER);
    }



    /********************* SUPPORTS ********************************************/
    @Test
    public void test_saveWithTransaction_supports_noException() {
        OrderService orderService = applicationContext.getBean(OrderService.class);
        OrderPo po = new OrderPo("cyh", "lightSuite", 1, 1699);
        orderService.saveWithTransaction_supports(po, ExceptionLocationEnum.NO);
    }

    /**
     * 事务传播属性为 SUPPORTS 且 INNER 事务异常 == 全部回滚
     */
    @Test
    public void test_saveWithTransaction_supports_innerException() {
        OrderService orderService = applicationContext.getBean(OrderService.class);
        OrderPo po = new OrderPo("cyh", "lightSuite", 1, 1699);
        orderService.saveWithTransaction_supports(po, ExceptionLocationEnum.INNER);
    }

    /**
     * 事务传播属性为 SUPPORTS 且 OUTER 事务异常 == 全部回滚
     */
    @Test
    public void test_saveWithTransaction_supports_outerException() {
        OrderService orderService = applicationContext.getBean(OrderService.class);
        OrderPo po = new OrderPo("cyh", "lightSuite", 1, 1699);
        orderService.saveWithTransaction_supports(po, ExceptionLocationEnum.OUTER);
    }



    /********************* NOT_SUPPORTED ********************************************/
    @Test
    public void test_saveWithTransaction_notSupported_noException() {
        OrderService orderService = applicationContext.getBean(OrderService.class);
        OrderPo po = new OrderPo("cyh", "lightSuite", 1, 1699);
        orderService.saveWithTransaction_notSupported(po, ExceptionLocationEnum.NO);
    }

    /**
     * 事务传播属性为 NOT_SUPPORTED 且 INNER 事务异常 == 内部不回滚、外部回滚
     */
    @Test
    public void test_saveWithTransaction_notSupported_innerException() {
        OrderService orderService = applicationContext.getBean(OrderService.class);
        OrderPo po = new OrderPo("cyh", "lightSuite", 1, 1699);
        orderService.saveWithTransaction_notSupported(po, ExceptionLocationEnum.INNER);
    }

    /**
     * 事务传播属性为 NOT_SUPPORTED 且 OUTER 事务异常 == 内部不回滚、外部回滚
     */
    @Test
    public void test_saveWithTransaction_notSupported_outerException() {
        OrderService orderService = applicationContext.getBean(OrderService.class);
        OrderPo po = new OrderPo("cyh", "lightSuite", 1, 1699);
        orderService.saveWithTransaction_notSupported(po, ExceptionLocationEnum.OUTER);
    }
}
