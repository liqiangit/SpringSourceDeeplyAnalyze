package com.cyh.propagation.test;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: yanhua.chen
 * @date: 2019/2/26 11:07
 */
public class OrderServiceImpl implements OrderService {
    private JdbcTemplate jdbcTemplate;
    private StorageService storageService;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void setStorageService(StorageService storageService) {
        this.storageService = storageService;
    }


    /**
     * 事务传播属性为 REQUIRED
     * @param po
     * @param locationEnum
     */
    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void saveWithTransaction_required(OrderPo po, ExceptionLocationEnum locationEnum) {
        jdbcTemplate.update("INSERT INTO order_tbl(user_id, commodity_code, count, money) VALUES (?, ?, ?, ?)",
                new Object[] {po.getUserId(), po.getCommodityCode(), po.getCount(), po.getMoney()});
        storageService.saveWithTransaction_required(po.getCommodityCode(), po.getCount(), locationEnum);
        if (ExceptionLocationEnum.OUTER == locationEnum) {
            throw new RuntimeException("事务传播属性为 REQUIRED 且 Outer 事务异常");
        }
    }

    /**
     * 事务传播属性为 REQUIRES_NEW
     * @param po
     * @param locationEnum
     */
    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void saveWithTransaction_requiresNew(OrderPo po, ExceptionLocationEnum locationEnum) {
        jdbcTemplate.update("INSERT INTO order_tbl(user_id, commodity_code, count, money) VALUES (?, ?, ?, ?)",
                new Object[] {po.getUserId(), po.getCommodityCode(), po.getCount(), po.getMoney()});
        storageService.saveWithTransaction_requiresNew(po.getCommodityCode(), po.getCount(), locationEnum);
        if (ExceptionLocationEnum.OUTER == locationEnum) {
            throw new RuntimeException("事务传播属性为 REQUIRES_NEW 且 Outer 事务异常");
        }
    }

    /**
     * 事务传播属性为 NESTED
     * @param po
     * @param locationEnum
     */
    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void saveWithTransaction_nested(OrderPo po, ExceptionLocationEnum locationEnum) {
        jdbcTemplate.update("INSERT INTO order_tbl(user_id, commodity_code, count, money) VALUES (?, ?, ?, ?)",
                new Object[] {po.getUserId(), po.getCommodityCode(), po.getCount(), po.getMoney()});
        storageService.saveWithTransaction_nested(po.getCommodityCode(), po.getCount(), locationEnum);
        if (ExceptionLocationEnum.OUTER == locationEnum) {
            throw new RuntimeException("事务传播属性为 NESTED 且 Outer 事务异常");
        }
    }

    /**
     * 事务传播属性为 MANDATORY
     * @param po
     * @param locationEnum
     */
    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void saveWithTransaction_mandatory(OrderPo po, ExceptionLocationEnum locationEnum) {
        jdbcTemplate.update("INSERT INTO order_tbl(user_id, commodity_code, count, money) VALUES (?, ?, ?, ?)",
                new Object[] {po.getUserId(), po.getCommodityCode(), po.getCount(), po.getMoney()});
        storageService.saveWithTransaction_mandatory(po.getCommodityCode(), po.getCount(), locationEnum);
        if (ExceptionLocationEnum.OUTER == locationEnum) {
            throw new RuntimeException("事务传播属性为 MANDATORY 且 Outer 事务异常");
        }
    }

    /**
     * 事务传播属性为 NEVER
     * @param po
     * @param locationEnum
     */
    @Override
    public void saveWithTransaction_never(OrderPo po, ExceptionLocationEnum locationEnum) {

    }

    /**
     * 事务传播属性为 SUPPORTS
     * @param po
     * @param locationEnum
     */
    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void saveWithTransaction_supports(OrderPo po, ExceptionLocationEnum locationEnum) {
        jdbcTemplate.update("INSERT INTO order_tbl(user_id, commodity_code, count, money) VALUES (?, ?, ?, ?)",
                new Object[] {po.getUserId(), po.getCommodityCode(), po.getCount(), po.getMoney()});
        storageService.saveWithTransaction_supports(po.getCommodityCode(), po.getCount(), locationEnum);
        if (ExceptionLocationEnum.OUTER == locationEnum) {
            throw new RuntimeException("事务传播属性为 SUPPORTS 且 Outer 事务异常");
        }
    }

    /**
     * 事务传播属性为 NOT_SUPPORTED
     * @param po
     * @param locationEnum
     */
    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void saveWithTransaction_notSupported(OrderPo po, ExceptionLocationEnum locationEnum) {
        jdbcTemplate.update("INSERT INTO order_tbl(user_id, commodity_code, count, money) VALUES (?, ?, ?, ?)",
                new Object[] {po.getUserId(), po.getCommodityCode(), po.getCount(), po.getMoney()});
        storageService.saveWithTransaction_notSupported(po.getCommodityCode(), po.getCount(), locationEnum);
        if (ExceptionLocationEnum.OUTER == locationEnum) {
            throw new RuntimeException("事务传播属性为 NOT_SUPPORTED 且 Outer 事务异常");
        }
    }
}
