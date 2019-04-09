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

		HttpSession mySession = request.getSession();		
		mySession.setAttribute("username", "Matt");
		mySession.setAttribute("userId", "1");
		mySession.setAttribute("password1", "1234");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
