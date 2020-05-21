package com.cyh.propagation.test;

import lombok.Data;

/**
 * @author: yanhua.chen
 * @date: 2019/2/26 10:56
 */
@Data
public class OrderPo {
    private Integer id;
    private String userId;
    private String commodityCode;
    private Integer count;
    private Integer money;

    public OrderPo(String userId, String commodityCode, Integer count, Integer money) {
        this.userId = userId;
        this.commodityCode = commodityCode;
        this.count = count;
        this.money = money;
    }
}
