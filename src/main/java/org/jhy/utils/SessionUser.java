package org.jhy.utils;

public class SessionUser {
	public static final String SESSION_USER_NAME = "user";
	private String id;
	private String userAccount;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	
	
}
