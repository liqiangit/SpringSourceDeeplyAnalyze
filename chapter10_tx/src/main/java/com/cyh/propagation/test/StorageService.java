package com.cyh.propagation.test;

/**
 * @author: yanhua.chen
 * @date: 2019/2/26 11:07
 */
public interface StorageService {


    void saveWithTransaction_required(String commodityCode, Integer count, ExceptionLocationEnum locationEnum);

    void saveWithTransaction_requiresNew(String commodityCode, Integer count, ExceptionLocationEnum locationEnum);

    void saveWithTransaction_nested(String commodityCode, Integer count, ExceptionLocationEnum locationEnum);

    void saveWithTransaction_mandatory(String commodityCode, Integer count, ExceptionLocationEnum locationEnum);

    void saveWithTransaction_supports(String commodityCode, Integer count, ExceptionLocationEnum locationEnum);

    void saveWithTransaction_notSupported(String commodityCode, Integer count, ExceptionLocationEnum locationEnum);

}
