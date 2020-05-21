package com.cyh.test;

public interface UserService {

    /**
     * 有事务
     * @param user
     */
    void saveWithTransaction(User user);

    /**
     * 没有事务
     * @param user
     */
    void saveWithoutTransaction(User user);
    /**
     * 有事务
     * @param user
     */
    void saveWithPlatformTransactionManager(User user);
}
