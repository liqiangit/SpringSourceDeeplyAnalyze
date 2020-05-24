package com.cyh.test;

public interface SystemService {

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
    
    void save0(User user);
    void save1(User user);
    void save2(User user);
    void save3(User user);
    void save4(User user);
    void save5(User user);
    void save6(User user);
}
