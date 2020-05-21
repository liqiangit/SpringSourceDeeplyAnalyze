package com.cyh;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author yanhua.chen@bkjk.com
 * @date 2019/5/21 22:29
 */
public class OrderServiceImpl {

    private AccountServiceImpl accountService;

    public void setAccountService(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    @Transactional(rollbackFor = Throwable.class)
    public void addOrder() {
        accountService.reduceMoney();
    }


}
