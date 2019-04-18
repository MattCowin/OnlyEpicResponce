package com.revature.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.revature.model.DBReimbursments;


public interface ReimbursmentsService {

	public List<DBReimbursments> getAllReimbursments(HttpServletRequest req, HttpServletResponse resp);
	
	public DBReimbursments getReimbursmentsById(HttpServletRequest req, HttpServletResponse resp); 
	
	public void createReimbursments(HttpServletRequest req, HttpServletResponse resp);
	
	public void updateReimbursments(HttpServletRequest req, HttpServletResponse resp);
}
