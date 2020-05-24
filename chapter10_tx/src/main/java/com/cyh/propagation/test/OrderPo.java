package com.cyh.propagation.test;

import lombok.Data;

/**
 * @author: yanhua.chen
 * @date: 2019/2/26 10:56
 */

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
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCommodityCode() {
		return commodityCode;
	}

	public void setCommodityCode(String commodityCode) {
		this.commodityCode = commodityCode;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

}
