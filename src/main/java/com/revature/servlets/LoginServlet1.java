package com.revature.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.checks.MCheck;
import com.revature.checks.Validate;

/**
 * Servlet implementation class LoginServlet1
 */
public class LoginServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	
	 	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
	    String password = req.getParameter("password");
	    
	    if(Validate.checkUser(username, password)){
	        if(MCheck.checkManager(username)) {
	        	req.getSession().setAttribute("currentUser", username);
	        	RequestDispatcher dispatcher = getServletContext()
	        		      .getRequestDispatcher("/managerhome.jsp");
	        		    dispatcher.forward(req, resp);
	        }
	        else {
	        	req.getSession().setAttribute("currentUser", username);
	        	RequestDispatcher dispatcher = getServletContext()
	        		      .getRequestDispatcher("/userhome.jsp");
	        		    dispatcher.forward(req, resp);
	        }
	    }
	    else{
	       resp.sendRedirect("./index.html");
	    }
	}

}

