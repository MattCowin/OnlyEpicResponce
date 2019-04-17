package com.revature.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class JSession
 */

//Session management entails managing a clients session by tracking their interactions with your web application. There are several
//ways of managing a client's session, but we will primarily use two
//-cookies
//-JSession
//a cookie is stored on the client as a key value pair. AJSession is a specialized cookie that is accompanied by a session id on the
//server side.
public class JSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Returns a session if there is one. Creates one if not
		HttpSession session = request.getSession();
		  session.getAttribute("username");
		  session.getAttribute("userId");
		  session.getAttribute("password");
	      Integer accessCount;
	      synchronized(session) {
	         accessCount = (Integer)session.getAttribute("accessCount");
	         if (accessCount == null) {
	            accessCount = 0;  
	         } else {
	            accessCount = new Integer(accessCount + 1);
	         }
	         session.setAttribute("accessCount", accessCount);
	      }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
