package com.revature.servlets;

import java.io.IOException;


import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Servlet implementation class PlaceEmployeeInfo
 */
public class PlaceEmployeeInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final ObjectMapper mapper = new ObjectMapper();
    /**
     * @see HttpServlet#HttpServlet()
     */
	public PlaceEmployeeInfo() {
        JDBCConnection.getDatarFromDB();
     
    }
 
   
	/**   
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/json");
		resp.getOutputStream().write(mapper.writeValueAsBytes(AddToPage.process(req, resp)));
	}

}
