package org.jhy.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "recharge")
public class Recharge extends BaseEntity {

	private static final long serialVersionUID = 4935218833868209768L;
	@Column(name = "price")
	private double price; // 充值金额
	@Column(name = "recharge_time")
	private long rechargeTime;// 充值时间
	public Recharge(){
		
	}
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	public long getRechargeTime() {
		return rechargeTime;
	}
	public void setRechargeTime(long rechargeTime) {
		this.rechargeTime = rechargeTime;
	}
	
}
