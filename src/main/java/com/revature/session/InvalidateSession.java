package com.revature.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class InvailedSession
 */
public class InvalidateSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InvalidateSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//if we pass a value of false into the getSession  method, a new session will not be created. It will instead retrieve 
//		the existing session. If no such session exists, this method returns null.
		HttpSession session = request.getSession(false);
		
		//error checking before we
		
		if(session != null) {
			session.setMaxInactiveInterval(180);
			session.removeAttribute("currentUser");
			session.invalidate();
			response.sendRedirect("http://localhost:8088/OnlyEpicRequest");
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
