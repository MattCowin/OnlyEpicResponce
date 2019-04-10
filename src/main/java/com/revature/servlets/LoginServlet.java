package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
//		String password2 = request.getParameter("password2");
		
//		if(username != null && username.contentEquals("") && password1 != null && password1.contentEquals("")) {
			
		
//		response.sendRedirect("./Users/userhome.html");
		
		//we need to do some error ckecking: check to see if it is null or empty strings
//		}
		 if(username == null || username.contentEquals("") || password == null || password.contentEquals("")) { 
			//|| password2 == null || password2.contentEquals("")
			response.sendRedirect("./index.html");
		}
		log.info("The contex param is " + request.getServletContext().getInitParameter("someName"));
		
//		String paramValue = request.getServletContext().getInitParameter("someValue");
		
//		if(!password1.contentEquals(password2)) {
//			response.setContentType("text/html");
//			PrintWriter writeMe = response.getWriter();
//			writeMe.write("<table><th><tr><td>You</td></tr></th></table>");
//		}
		
		//sendRedirect vs Forward
//		sendRedirect and forward are both methods that you can use to direct the flow of traffic on your website. There is, however, a 
//		few differences between these methods. 
//		1. sendRedirect comes from the response object whereas forward comes from the request object (via the RequestDispatcher)
//		2. sendRedirect sends a response back to the client and creates a new request that is then sent back to the server
//		while forward simply forwards the request to the requested resource without leaving the server
//		3. sendRedirect shows the client the name of the requested resource (via the url) whereas forward masks the name of resource
		
		//this is a request dispacher. you get it from the request object
//		RequestDispatcher dispatchy = request.getRequestDispatcher("/Users/userhome.html");
//		dispatchy.forward(request, response);
		
		//send redirect 
		//response.sendRedirect("./Users/userhome.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
