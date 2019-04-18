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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(amount);
		result = prime * result + approvedBy;
		result = prime * result + employeeId;
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		result = prime * result + reimbursmentId;
		result = prime * result + ((reimbursmentType == null) ? 0 : reimbursmentType.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DBReimbursments other = (DBReimbursments) obj;
		if (Float.floatToIntBits(amount) != Float.floatToIntBits(other.amount))
			return false;
		if (approvedBy != other.approvedBy)
			return false;
		if (employeeId != other.employeeId)
			return false;
		if (reason == null) {
			if (other.reason != null)
				return false;
		} else if (!reason.equals(other.reason))
			return false;
		if (reimbursmentId != other.reimbursmentId)
			return false;
		if (reimbursmentType == null) {
			if (other.reimbursmentType != null)
				return false;
		} else if (!reimbursmentType.equals(other.reimbursmentType))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DBReimbursments [reimbursmentId=" + reimbursmentId + ", reimbursmentType=" + reimbursmentType
				+ ", amount=" + amount + ", reason=" + reason + ", employeeId=" + employeeId + ", approvedBy="
				+ approvedBy + ", status=" + status + "]";
	}
	
	
}

