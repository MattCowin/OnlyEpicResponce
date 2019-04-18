package com.revature.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.revature.model.DBReimbursments;


public interface ReimbursmentsService {

	List<DBReimbursments> getAllReimbursments(HttpServletRequest req, HttpServletResponse resp);
    DBReimbursments getReimbursmentsById(HttpServletRequest req, HttpServletResponse resp); 
	DBReimbursments createReimbursments(HttpServletRequest req, HttpServletResponse resp);
	DBReimbursments updateReimbursments(HttpServletRequest req, HttpServletResponse resp);
}
