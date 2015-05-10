package org.jhy.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "equipment")
public class Equipment extends BaseEntity {

	private static final long serialVersionUID = 6412683570137089961L;
	@Column(name = "name")
	private String name; // 名称
	@Column(name = "quality")
	private String quality; // 品质
	@Column(name = "price")
	private double price;// 价格
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}
