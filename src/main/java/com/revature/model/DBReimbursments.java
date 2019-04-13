package com.revature.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="REIMBURSEMENTS_REQUEST")
//DO
public class DBReimbursments implements Serializable {
	
	@Id 
	@Column(name="REIMBURSMENT_ID", precision=7, scale=0)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int reimbursmentId;
	@Column(name="REIMBURSMENT_TYPE", length=20)
	private String reimbursmentType;
	@Column(name="AMOUNT", length=6)
	private int amount;
	@Column(name="REASON", length=255)
	private String reason;
	@Column(name="EMPLOYEE_ID", length=4)
	private int employeeId;
	@Column(name="APPROVED_BY", length=4)
	private int approvedBy;
	@Column(name="STATUS", length=20)
	private String status;
	
	
	public DBReimbursments() {
		super();
		
	}
	
	public DBReimbursments(int reimbursmentId, String reimbursmentType, int amount, String reason, int employeeId,
			int approvedBy, String status) {
		super();
		this.reimbursmentId = reimbursmentId;
		this.reimbursmentType = reimbursmentType;
		this.amount = amount;
		this.reason = reason;
		this.employeeId = employeeId;
		this.approvedBy = approvedBy;
		this.status = status;
	}

	public int getReimbursmentId() {
		return reimbursmentId;
	}
	public void setReimbursmentId(int reimbursmentId) {
		this.reimbursmentId = reimbursmentId;
	}
	public String getReimbursmentType() {
		return reimbursmentType;
	}
	public void setReimbursmentType(String reimbursmentType) {
		this.reimbursmentType = reimbursmentType;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getApprovedBy() {
		return approvedBy;
	}
	public void setApprovedBy(int approvedBy) {
		this.approvedBy = approvedBy;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "DBReimbursments [reimbursmentId=" + reimbursmentId + ", reimbursmentType=" + reimbursmentType
				+ ", amount=" + amount + ", reason=" + reason + ", employeeId=" + employeeId + ", approvedBy="
				+ approvedBy + ", status=" + status + "]";
	}
	
	
}

