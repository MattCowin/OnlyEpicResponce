package com.revature.servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.revature.service.ReimbursmentsService;
import com.revature.service.ReimbursmentsServiceImpl;

public class MakeRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ReimbursmentsService dao = new ReimbursmentsServiceImpl();
	ObjectMapper mapper = new ObjectMapper();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Entering MakeRequest.doGet");
		resp.setContentType("application/json");
		resp.getOutputStream().write(mapper.writeValueAsBytes(dao.getAllReimbursments(req, resp)));
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}