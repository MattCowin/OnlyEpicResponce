package com.revature.dao;

import java.util.List;


import com.revature.model.DBReimbursments;

public interface DBReimbursmentsDAO {

	List<DBReimbursments> getAllReimbursments();
	List<DBReimbursments> getAllReimbursments(String username);
	DBReimbursments getReimbursmentsById(int userId);
	DBReimbursments createReimbursments(DBReimbursments Reimbursments);
	DBReimbursments updateReimbursments(DBReimbursments toBeUpdated);
	long deleteReimbursments(DBReimbursments...toBeDeleted);
	List<DBReimbursments> getAllReimbursmentsByEmployeeId(int employee_id);
}
