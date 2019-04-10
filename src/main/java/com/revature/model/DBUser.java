package com.revature.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DBUSER")
//DO
public class DBUser implements Serializable {
	@Id 
	@Column(name="USER_ID", precision=5, scale=0)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	@Column(name="USERNAME", length=20, nullable = false)
	private String username;
	@Column(name="CREATED_BY")
	private String createdBy;
	@Column(name="CREATED_DATE")
	private Date createdDate;

	public DBUser() {
	}

	public DBUser(int userId, String username, String createdBy,
			Date createdDate) {
		this.userId = userId;
		this.username = username;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}

	public DBUser(String username, String createdBy,
			Date createdDate) {
		this.username = username;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "DBUser [userId=" + userId + ", username=" + username + ", createdBy=" + createdBy + ", createdDate="
				+ createdDate + "]";
	}
	
}
