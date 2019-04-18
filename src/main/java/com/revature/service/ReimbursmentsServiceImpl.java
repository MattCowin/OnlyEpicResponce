 package com.revature.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.DBReimbursmentsDAO;
import com.revature.dao.ReimbursementsRequest;
import com.revature.model.DBReimbursments;

public class ReimbursmentsServiceImpl implements ReimbursmentsService {

	private final DBReimbursmentsDAO dao = new ReimbursementsRequest();
	private final ObjectMapper mapper = new ObjectMapper();
	@Override
	public List<DBReimbursments> getAllReimbursments(HttpServletRequest req, HttpServletResponse resp) {
		return dao.getAllReimbursments();
	}

	@Override
	public DBReimbursments getReimbursmentsById(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public DBReimbursments updateReimbursments(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DBReimbursments createReimbursments(HttpServletRequest req, HttpServletResponse resp) {
		try {
			DBReimbursments re = mapper.readValue(req.getInputStream(), DBReimbursments.class);
			return dao.createReimbursments(re);
			}
			catch (IOException e) {
				return null;
			}
	}

}
