package com.cyh.propagation.test;

/**
 * @author: yanhua.chen
 * @date: 2019/2/26 11:07
 */
public interface OrderService {


    /**
     * 事务传播属性为 REQUIRED
     * @param po
     * @param locationEnum
     */
    void saveWithTransaction_required(OrderPo po, ExceptionLocationEnum locationEnum);

    /**
     * 事务传播属性为 REQUIRES_NEW
     * @param po
     * @param locationEnum
     */
    void saveWithTransaction_requiresNew(OrderPo po, ExceptionLocationEnum locationEnum);

    /**
     * 事务传播属性为 NESTED
     * @param po
     * @param locationEnum
     */
    void saveWithTransaction_nested(OrderPo po, ExceptionLocationEnum locationEnum);

    /**
     * 事务传播属性为 MANDATORY
     * @param po
     * @param locationEnum
     */
    void saveWithTransaction_mandatory(OrderPo po, ExceptionLocationEnum locationEnum);

    /**
     * 事务传播属性为 NEVER
     * @param po
     * @param locationEnum
     */
    void saveWithTransaction_never(OrderPo po, ExceptionLocationEnum locationEnum);

    /**
     * 事务传播属性为 SUPPORTS
     * @param po
     * @param locationEnum
     */
    void saveWithTransaction_supports(OrderPo po, ExceptionLocationEnum locationEnum);

    /**
     * 事务传播属性为 NOT_SUPPORTED
     * @param po
     * @param locationEnum
     */
    void saveWithTransaction_notSupported(OrderPo po, ExceptionLocationEnum locationEnum);



}
