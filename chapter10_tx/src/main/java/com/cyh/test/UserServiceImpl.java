package com.cyh.test;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

public class UserServiceImpl implements UserService {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public void saveWithTransaction(User user) {
        doSave(user);
    }

    private void doSave(User user) {
        jdbcTemplate.update("INSERT INTO tx_user(name, age, sex) VALUES (?, ?, ?)",
                new Object[] {user.getName(), user.getAge(), user.getSex()});

        int x = 1 / 0;
    }

    @Override
    public void saveWithoutTransaction(User user) {
        doSave(user);
    }
}
