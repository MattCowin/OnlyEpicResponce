package com.revature.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.revature.dao.UserDAO;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(LoginServlet.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//getting the form parameters from the client
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		RequestDispatcher DBusr = request.getRequestDispatcher(username);
		RequestDispatcher DBpwd = request.getRequestDispatcher(password);
		RequestDispatcher DBuname = request.getRequestDispatcher(username);
		
//		if(username != null && username.contentEquals("") && password1 != null && password1.contentEquals("")) {
			
		
//		response.sendRedirect("./Users/userhome.html");
		
		//we need to do some error ckecking: check to see if it is null or empty strings
//		}
		 if(username == null || DBuname.equals(username) || password == null || DBpwd.equals(password)) { 
			//|| password2 == null || password2.contentEquals("")
			response.sendRedirect("./userhome.html");
		}
		//log.info("The contex param is " + request.getServletContext().getInitParameter("someName"));
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}



