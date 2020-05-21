package com.cyh.propagation.test;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: yanhua.chen
 * @date: 2019/2/26 11:07
 */
public class StorageServiceImpl implements StorageService {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class, propagation = Propagation.REQUIRED)
    public void saveWithTransaction_required(String commodityCode, Integer count, ExceptionLocationEnum locationEnum) {
        doSave(commodityCode, count, locationEnum, Propagation.REQUIRED.name());
    }

    @Override
    @Transactional(rollbackFor = Throwable.class, propagation = Propagation.REQUIRES_NEW)
    public void saveWithTransaction_requiresNew(String commodityCode, Integer count,
            ExceptionLocationEnum locationEnum) {
        doSave(commodityCode, count, locationEnum, Propagation.REQUIRES_NEW.name());
    }

    @Override
    @Transactional(rollbackFor = Throwable.class, propagation = Propagation.NESTED)
    public void saveWithTransaction_nested(String commodityCode, Integer count, ExceptionLocationEnum locationEnum) {
        doSave(commodityCode, count, locationEnum, Propagation.NESTED.name());
    }

    @Override
    @Transactional(rollbackFor = Throwable.class, propagation = Propagation.MANDATORY)
    public void saveWithTransaction_mandatory(String commodityCode, Integer count, ExceptionLocationEnum locationEnum) {
        doSave(commodityCode, count, locationEnum, Propagation.MANDATORY.name());
    }

    @Override
    @Transactional(rollbackFor = Throwable.class, propagation = Propagation.SUPPORTS)
    public void saveWithTransaction_supports(String commodityCode, Integer count, ExceptionLocationEnum locationEnum) {
        doSave(commodityCode, count, locationEnum, Propagation.SUPPORTS.name());
    }

    @Override
    @Transactional(rollbackFor = Throwable.class, propagation = Propagation.NOT_SUPPORTED)
    public void saveWithTransaction_notSupported(String commodityCode, Integer count,
            ExceptionLocationEnum locationEnum) {
        doSave(commodityCode, count, locationEnum, Propagation.NOT_SUPPORTED.name());
    }

    private void doSave(String commodityCode, Integer count, ExceptionLocationEnum locationEnum, String s) {
        jdbcTemplate.update("UPDATE storage_tbl SET count = count - ? WHERE commodity_code = ?",
                new Object[] {count, commodityCode});
        if (ExceptionLocationEnum.INNER == locationEnum) {
            throw new RuntimeException(String.format("事务传播属性为 %s 且 Inner 事务异常", s));
        }
    }
}
