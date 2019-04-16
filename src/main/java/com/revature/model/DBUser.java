package com.revature.model;

import java.io.Serializable;
import java.util.Date;



public class DBUser implements Serializable {
	
	private int userId;
	private static String username;
	private static String password;
	private int employeeId;

	
	
	public DBUser() {
		super();
		
	}
	
	public DBUser(int userId, String username, String password, int employeeId) {
		super();
		this.userId = userId;
		DBUser.username = username;
		DBUser.password = password;
		this.employeeId = employeeId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public static String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public static String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		return "DBUser [userId=" + userId + ", username=" + username + ", password=" + password + ", employeeId="
				+ employeeId + "]";
	}

	

}