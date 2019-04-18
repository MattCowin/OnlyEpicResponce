package com.revature.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.DBReimbursments;

public interface DBReimbursmentsDAO {

	List<DBReimbursments> getAllReimbursments();
	DBReimbursments getReimbursmentsById(int userId);
	DBReimbursments createReimbursments(DBReimbursments Reimbursments);
	DBReimbursments updateReimbursments(DBReimbursments toBeUpdated);
	long deleteReimbursments(DBReimbursments...toBeDeleted);
}
