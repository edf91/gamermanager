package org.jhy.dto;

import java.util.Date;
import java.util.List;


public class GamerInfoDTO {
	private String id;
	private String name; // 姓名
	private String gender; // 性别
	private String birthDay; // 出生年月日
	private List<EquipmentDTO> equipmentDTOs;
	private int level;
	private String rechargeIds;// 充值ids
	private double totalPrice; // 充值总额
	private String sociatyName;
	private boolean disabled = false;
	private String address;
	private String sociatyId;
	private long regTime = new Date().getTime();// 注册时间
	private String profession; // 职业
	private String email; // 电子邮箱
	private String mobile; // 移动电话
	private String telPhone; // 固定电话
	
	
	public List<EquipmentDTO> getEquipmentDTOs() {
		return equipmentDTOs;
	}
	public void setEquipmentDTOs(List<EquipmentDTO> equipmentDTOs) {
		this.equipmentDTOs = equipmentDTOs;
	}
	public String getName() {
		return name;
	}
	public boolean isDisabled() {
		return disabled;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getSociatyName() {
		return sociatyName;
	}
	public void setSociatyName(String sociatyName) {
		this.sociatyName = sociatyName;
	}
	public String getSociatyId() {
		return sociatyId;
	}
	public void setSociatyId(String sociatyId) {
		this.sociatyId = sociatyId;
	}
	public long getRegTime() {
		return regTime;
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
	public String getRechargeIds() {
		return rechargeIds;
	}
	public void setRechargeIds(String rechargeIds) {
		this.rechargeIds = rechargeIds;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	
}
