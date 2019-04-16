package com.revature.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.DBTables.Users;
import com.revature.dao.UserDAO;
import com.revature.model.DBUser;


import org.apache.log4j.Logger;

/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(LoginServlet.class);
	private final ObjectMapper mapper = new ObjectMapper();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
       
    }
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//getting the form parameters from the client
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			Users.getUserData();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Failed to locate Database Driver");
		} catch (SQLException e) {
			throw new RuntimeException("Failed to get JDBC Connection");
		}
		
    	if(username != null || Users.un.equals(username) || password != null || Users.pw.equals(password)) {
    		response.sendRedirect("./userhome.html");
    	}
//    	else if(username == null || username.contentEquals("") || password == null || password.contentEquals("")) { 
//			response.sendRedirect("./index.html");
//		}
		else {
			 response.sendRedirect("./index.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Entering DispatcherServlet.doPost");
		resp.setContentType("application/json");
		//resp.getOutputStream().write(mapper.writeValueAsBytes(RequestDispatcher.processPost(req, resp)));
	}

}



