package com.revature.model;

import java.io.Serializable;
import java.util.Date;



public class DBUser implements Serializable {
	
	private int userId;
	private String username;
	private String password;
	private Date employeeId;

	
	
	public DBUser() {
		super();
		
	}
	
	public DBUser(int userId, String username, String password, Date employeeId) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.employeeId = employeeId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

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

	public Date getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Date employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		return "DBUser [userId=" + userId + ", username=" + username + ", password=" + password + ", employeeId="
				+ employeeId + "]";
	}

	

}