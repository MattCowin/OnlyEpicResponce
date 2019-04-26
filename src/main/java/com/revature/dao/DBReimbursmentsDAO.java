package com.revature.dao;

import java.util.List;


import com.revature.model.DBReimbursments;

public interface DBReimbursmentsDAO {

	List<DBReimbursments> getAllReimbursments();
	List<DBReimbursments> getAllReimbursmentsByUser(String username);
	DBReimbursments getReimbursmentsById(int userId);
	DBReimbursments createReimbursments(DBReimbursments Reimbursments);
	DBReimbursments createReimbursments(DBReimbursments Reimbursments, String username);
	DBReimbursments updateReimbursments(DBReimbursments toBeUpdated);
	DBReimbursments updateReimbursmentById(DBReimbursments reimbursmentId);
	long deleteReimbursments(DBReimbursments...toBeDeleted);
	List<DBReimbursments> getAllReimbursmentsByEmployeeId(int employee_id);
}
