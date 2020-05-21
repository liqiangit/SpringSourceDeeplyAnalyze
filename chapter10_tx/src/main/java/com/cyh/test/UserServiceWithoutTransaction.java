package com.cyh.test;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserServiceWithoutTransaction {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * 抛出异常，但是没有事务，所以，Sql还是会正常提交执行
     * 用于和有事务的方法进行对比测试
     * @param user
     */
    public void save(User user) {
        jdbcTemplate.update("INSERT INTO tx_user(name, age, sex) VALUES (?, ?, ?)",
                new Object[] {user.getName(), user.getAge(), user.getSex()});

        throw new NullPointerException("test for null pointer exception");
    }
}
