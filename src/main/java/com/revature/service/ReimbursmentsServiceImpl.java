 package com.revature.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
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
		final String username = (String) req.getSession().getAttribute("currentUser");
		
		return dao.getAllReimbursments();
	}

	@Override
	public DBReimbursments getReimbursmentsById(HttpServletRequest req, HttpServletResponse resp) {
		final String reimbursmentId = req.getParameter("reimbursmentId");
		
		
		return dao.getReimbursmentsById(Integer.valueOf(reimbursmentId));
	}


	@Override
	public DBReimbursments updateReimbursments(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createReimbursments(HttpServletRequest req, HttpServletResponse resp) {
		final String username = (String) req.getSession().getAttribute("currentUser");
		final String reimbursmentType = (String) req.getParameter("reimbursmentType");
		final float amount = Float.valueOf("amount"); 
		final String reason = (String) req.getParameter("reason");
		final int employeeId = Integer.valueOf("employeeId");
		final String status = "Pending";
		DBReimbursments DBReimbursments = dao.createReimbursments(new DBReimbursments(0, reimbursmentType, amount, reason, employeeId,0, status));
		try {
			if(DBReimbursments == null) {
				req.getRequestDispatcher("/createrequest.jsp?error").forward(req, resp);
			}
			else {
				req.getRequestDispatcher("/createrequest.jsp").forward(req, resp);
			}
		}catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<DBReimbursments> getAllReimbursmentsByUser(HttpServletRequest req, HttpServletResponse resp) {
		final String username = (String) req.getSession().getAttribute("currentUser");
		
		return dao.getAllReimbursmentsByUser(username);
	}

}
