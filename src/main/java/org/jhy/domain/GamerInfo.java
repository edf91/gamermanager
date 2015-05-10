package org.jhy.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.jhy.utils.DataUtil;

@Table(name = "gamer_info")
@Entity
public class GamerInfo extends BaseEntity{
	private static final long serialVersionUID = -3368285086693212972L;
	@Column(name = "name")
	private String name; // 姓名
	
	@Transient
	private List<Equipment> equipments = new ArrayList<Equipment>();
	@Column(name = "equipmentIds")
	private String equipmentIds; // 装备ids
	@Column(name = "rechargeIds",columnDefinition = "TEXT")
	private String rechargeIds; // 充值id，根据,分隔
	private double totalPrice; // 充值总额
	@Column(name = "address")
	private String address; // 地址
	@Column(name = "gender")
	private Gender gender; // 性别
	@Column(name = "disabled")
	private boolean disabled = false;
	
	@Column(name = "birth_day")
	private long birthDay; // 出生年月日
	
	@Column(name = "level")
	private int level;
	
	@ManyToOne(cascade=CascadeType.REFRESH,optional=false)
	@JoinColumn(name = "socity_id")
	private Sociaty sociaty; // 公会
	
	@Column(name = "reg_time")
	private long regTime;// 注册时间
	
	@Column(name = "profession")
	private String profession; // 职业
	
	@Column(name = "email")
	private String email; // 电子邮箱
	
	@Column(name = "mobile")
	private String mobile; // 移动电话
	
	@Column(name = "telPhone")
	private String telPhone; // 固定电话
	
	
	public static List<GamerInfo> findAllEntities() {
		return findByHQL("FROM GamerInfo");
	}
	
	
	public List<Equipment> getEquipments() {
		String[] eqIds = DataUtil.strToArray(this.getEquipmentIds());
		if(eqIds != null && eqIds.length > 0)
		for (String id : eqIds) {
			equipments.add(Equipment.get(Equipment.class, id));
		}
		return equipments;
	}

	public String getEquipmentIds() {
		return equipmentIds;
	}

	public void setEquipmentIds(String equipmentIds) {
		this.equipmentIds = equipmentIds;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public long getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(long birthDay) {
		this.birthDay = birthDay;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public Sociaty getSociaty() {
		return sociaty;
	}
	public void setSociaty(Sociaty sociaty) {
		this.sociaty = sociaty;
	}
	public long getRegTime() {
		return regTime;
	}
	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public void setRegTime(long regTime) {
		this.regTime = regTime;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getTelPhone() {
		return telPhone;
	}
	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}


	public boolean isDisabled() {
		return disabled;
	}


	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}


	public String getRechargeIds() {
		return rechargeIds;
	}


	public double getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}


	public void setRechargeIds(String rechargeIds) {
		this.rechargeIds = rechargeIds;
	}
}
