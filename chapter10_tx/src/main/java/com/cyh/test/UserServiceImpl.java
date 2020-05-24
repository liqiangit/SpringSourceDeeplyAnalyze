package com.cyh.test;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class UserServiceImpl implements UserService {

	private JdbcTemplate jdbcTemplate;

	private AccountService accountService;

	private SystemService systemService;

	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}

	private PlatformTransactionManager transactionManager;

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

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
				new Object[] { user.getName(), user.getAge(), user.getSex() });

		int x = 1 / 0;
	}

	private void doSaveUser(User user) {
		jdbcTemplate.update("INSERT INTO tx_user(name, age, sex) VALUES (?, ?, ?)",
				new Object[] { user.getName(), user.getAge(), user.getSex() });
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
		TransactionDefinition definition1 = new DefaultTransactionDefinition();
		TransactionDefinition definition2 = new DefaultTransactionDefinition(
				TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		TransactionStatus status1 = transactionManager.getTransaction(definition1);
		TransactionStatus status2 = transactionManager.getTransaction(definition2);
		try {
			try {
				doSaveUser(user);
				transactionManager.commit(status2);
			} catch (Exception e) {
				transactionManager.rollback(status2);
				e.printStackTrace();
			}
			user.setAge(user.getAge() + 1);
			doSaveUser(user);
			int x = 1 / 0;
			transactionManager.commit(status1);
		} catch (Exception e) {
			transactionManager.rollback(status1);
			e.printStackTrace();
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
	@Override
	public void save1(User user) {
		user.setAge(1);
		doSaveUser(user);
		user.setAge(2);
		// 在本类开启REQUIRES_NEW不生效
		save2(user);
		user.setAge(3);
		doSaveUser(user);
		// int x = 1 / 0;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = RuntimeException.class)
	@Override
	public void save2(User user) {
		doSaveUser(user);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
	@Override
	public void save3(User user) {
		user.setAge(1);
		doSaveUser(user);
		user.setAge(2);
		// 在新类开启REQUIRES_NEW生效
		accountService.save2(user);
		user.setAge(3);
		doSaveUser(user);
		// int x = 1 / 0;
	}

	@Override
	public void save4(User user) {
		TransactionDefinition definition2 = new DefaultTransactionDefinition(
				TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status2 = transactionManager.getTransaction(definition2);
		try {
			accountService.save4(user);
			user.setAge(user.getAge() + 1);
			doSaveUser(user);
			int x = 1 / 0;
			transactionManager.commit(status2);
		} catch (Exception e) {
			transactionManager.rollback(status2);
			e.printStackTrace();
		}
	}

	@Override
	public void save5(User user) {
		TransactionDefinition definition2 = new DefaultTransactionDefinition(
				TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status2 = transactionManager.getTransaction(definition2);
		try {
			accountService.save5(user);
			user.setAge(user.getAge() + 1);
			doSaveUser(user);
			int x = 1 / 0;
			transactionManager.commit(status2);
		} catch (Exception e) {
			transactionManager.rollback(status2);
			e.printStackTrace();
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
	@Override
	public void save6(User user) {
		user.setAge(1);
		doSaveUser(user);
		user.setAge(2);
		accountService.save6(user);
		user.setAge(3);
		doSaveUser(user);
		user.setAge(4);
		systemService.save6(user);
//		 int x = 1 / 0;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
	@Override
	public void save7(User user) {
		user.setAge(1);
		doSaveUser(user);
		user.setAge(2);
		save8(user);
		user.setAge(3);
		doSaveUser(user);
		// int x = 1 / 0;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
	@Override
	public void save8(User user) {
		doSaveUser(user);
	}
}
