package org.jhy.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User extends BaseEntity{
	private static final long serialVersionUID = 6634147352368568069L;
	public static final String INIT_PASSWORD = "888888";
	private String userAccount;
	private String email;
	private String password = INIT_PASSWORD;
	private boolean disabled = false;
	
	public User(){
		
	}
	public boolean doLogin() {
		return !findByHQL("FROM User u WHERE u.userAccount = ? AND u.password = ?", this.getUserAccount(),this.getPassword()).isEmpty();
	}
	public void resetPassword() {
		this.setPassword(INIT_PASSWORD);
		this.update();
	}
	
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	
}
