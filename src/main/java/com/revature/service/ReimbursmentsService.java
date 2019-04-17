package com.revature.service;

import java.util.List;

import com.revature.DBTables.ReimbursementsRequest;
import com.revature.DBTables.Users;
import com.revature.model.DBReimbursments;
import com.revature.model.DBUser;

public class ReimbursmentsService {

	public List<DBReimbursments> getAllReimbursments(){
		return new ReimbursementsRequest().getAllReimbursments();
	}
	
	public DBReimbursments getReimbursmentsById(int reimbursmentId) {
		return new ReimbursementsRequest().getReimbursmentsById(reimbursmentId);
	}
	
	public void createReimbursments(DBReimbursments Reimbursments) {
		new ReimbursementsRequest().createReimbursments(Reimbursments);
	}
	
	public void updateReimbursments(DBReimbursments Reimbursments) {
		new ReimbursementsRequest().updateReimbursments(Reimbursments);
	}
}
