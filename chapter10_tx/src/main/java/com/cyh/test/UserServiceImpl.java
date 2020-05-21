package com.cyh.test;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class UserServiceImpl implements UserService {

    private JdbcTemplate jdbcTemplate;

    private PlatformTransactionManager transactionManager;

    public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}


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


	@Override
	public void saveWithPlatformTransactionManager(User user) {
        TransactionDefinition definition = new DefaultTransactionDefinition();  
        TransactionStatus status = transactionManager.getTransaction(definition);  
        try {
			doSave(user);
			transactionManager.commit(status);
		} catch (Exception e) {
			transactionManager.rollback(status);
			e.printStackTrace();
		}
	}
}
