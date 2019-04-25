package com.revature.model;


public class DBReimbursments  {
	
	
	private int reimbursmentId;
	private String reimbursmentType;
	private float amount;
	private String reason;
	private int employeeId;
	private int approvedBy;
	private String status;
	
	
	public DBReimbursments() {
		
	}


	public DBReimbursments(int reimbursmentId, String reimbursmentType, float amount, String reason, int employeeId,
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


	public float getAmount() {
		return amount;
	}


	public void setAmount(float amount) {
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

