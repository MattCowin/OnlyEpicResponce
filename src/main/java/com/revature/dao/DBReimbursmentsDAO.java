package com.revature.dao;

import java.util.List;


import com.revature.model.DBReimbursments;

public interface DBReimbursmentsDAO {

	List<DBReimbursments> getAllReimbursments();
	DBReimbursments getReimbursmentsById(int userId);
	DBReimbursments createReimbursments(DBReimbursments Employees);
	DBReimbursments updateReimbursments(DBReimbursments toBeUpdated);
	long deleteTodo(DBReimbursments...toBeDeleted);
}
