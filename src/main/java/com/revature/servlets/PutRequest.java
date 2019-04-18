package com.revature.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class PutRequest
 */
public class PutRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final ObjectMapper mapper = new ObjectMapper();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PutRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Entering MakeRequest.doGet");
		resp.setContentType("application/json");
		resp.getOutputStream().write(mapper.writeValueAsBytes(AddToPage.process(req, resp)));
		System.out.println("Response sent successfully PutRequest from doGet!");
		 
       
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Entering MakeRequest.doPost");
		resp.setContentType("application/json");
		resp.getOutputStream().write(mapper.writeValueAsBytes(AddToPage.processPost(req, resp)));
		System.out.println("Response sent successfully PutRequest from doPost!");
	}
	          
}
