package com.cyh;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yanhua.chen@bkjk.com
 * @date 2019/5/21 22:30
 */
public class AccountServiceImpl implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void reduceMoney() {
        try {
            AccountServiceImpl accountService = (AccountServiceImpl) this.applicationContext.getBean("accountService");
            accountService.internalLogic();
        } catch (Exception e) {
            System.err.println("try catch 不抛出异常" + e.getMessage());
        }
    }

    @Transactional(rollbackFor = Throwable.class)
    public void internalLogic() {
        throw new RuntimeException("cyh_test_exception");
    }
}
