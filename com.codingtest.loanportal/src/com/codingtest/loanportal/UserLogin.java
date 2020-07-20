package com.codingtest.loanportal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emploginloan")
public class UserLogin {

	@Id
	private String username;
	private String password;
	private int role;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "UserLogin [username=" + username + ", password=" + password + ", role=" + role + "]";
	}
	
	
	
}
