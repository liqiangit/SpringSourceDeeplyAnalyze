package com.cyh.test;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class AccountServiceImpl implements AccountService {

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
    private void doSave2(User user) {
        jdbcTemplate.update("INSERT INTO tx_user(name, age, sex) VALUES (?, ?, ?)",
                new Object[] {user.getName(), user.getAge(), user.getSex()});
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


	@Override
	public void save0(User user) {
        TransactionDefinition definition = new DefaultTransactionDefinition();  
        TransactionStatus status1 = transactionManager.getTransaction(definition);  
        try {
        	try {
				TransactionStatus status2 = transactionManager.getTransaction(definition);  
				jdbcTemplate.update("INSERT INTO tx_user(name, age, sex) VALUES (?, ?, ?)",
				        new Object[] {user.getName(), user.getAge(), user.getSex()});
				transactionManager.commit(status2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            jdbcTemplate.update("INSERT INTO tx_user(name, age, sex) VALUES (?, ?, ?)",
                    new Object[] {user.getName(), user.getAge()+1, user.getSex()});
            int x = 1 / 0;
            transactionManager.commit(status1);
		} catch (Exception e) {
			transactionManager.rollback(status1);
			e.printStackTrace();
		}
	}
    @Transactional(propagation=Propagation.REQUIRED,rollbackFor = RuntimeException.class)	
	@Override
	public void save1(User user) {
    	user.setAge(1);
		doSave2(user);
    	user.setAge(2);
		save2(user);
    	user.setAge(3);
		doSave2(user);
        int x = 1 / 0;
	}

    @Transactional(propagation=Propagation.REQUIRES_NEW,rollbackFor = RuntimeException.class)	
	@Override
	public void save2(User user) {
		doSave2(user);		
	}


	@Override
	public void save3(User user) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void save4(User user) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void save5(User user) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void save6(User user) {
		// TODO Auto-generated method stub
		
	}
}
