package com.cyh.ineffective.internal.invoke;

import javax.sql.DataSource;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.cyh.test.User;

/**
 * @author: yanhua.chen
 * @date: 2019/3/27 10:45
 */
public class FundPlatformDelegate implements ApplicationContextAware {

    private JdbcTemplate jdbcTemplate;
    private ApplicationContext applicationContext;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * this 调用将导致事务失效
     * @param user
     * @return
     */
    public boolean thisInvokingWillLeadToTxIneffective(User user) {
        try {
            return mockRpcInvoke(user);
        } catch (Exception ignore) {
            // 尝试调用远程接口，如果调用失败，返回False就行，后续可以走本地调用等逻辑
            // 但是远程调用后，会更新数据库，所以，需要加事务
            ignore.printStackTrace();
            return false;
        }
    }

    @Transactional(rollbackFor = Throwable.class)
    public boolean mockRpcInvoke(User user) {
        ////////////////////// 假设有远程调用，调用完成后更新数据库
        jdbcTemplate.update("INSERT INTO tx_user(name, age, sex) VALUES (?, ?, ?)",
                new Object[] {user.getName(), user.getAge(), user.getSex()});
        System.err.println("远程调用结束并取到结果，准备更新本地数据库-->" + (1 / Integer.valueOf(user.getSex())));
        return true;
    }

    /**
     * 通过代理调用，事务能够生效
     * @param user
     * @return
     */
    public boolean proxyInvoke(User user) {
        try {
            // 解决方案：再次从Spring容器中拿到当前Bean进行调用
            return applicationContext.getBean(FundPlatformDelegate.class).mockRpcInvoke(user);
        } catch (Exception ignore) {
            // 尝试调用远程接口，如果调用失败，返回False就行，后续可以走本地调用等逻辑
            // 但是远程调用后，会更新数据库，所以，需要加事务
            ignore.printStackTrace();
            return false;
        }
    }
}
