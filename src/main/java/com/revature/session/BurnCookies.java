package com.revature.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BurnCookies
 */
public class BurnCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BurnCookies() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookies[] = request.getCookies();
		
		for(Cookie c : cookies) {
			if(c.getName().equals("Whatever cookie I'm looking for")) {
				c.setMaxAge(0);
				response.addCookie(c);
			}
		}
		
		//generic way, not advised 
		//If you want to delete a cookie, you have to set its max age to 0
//		cookies[0].setMaxAge(0);
//		
//		response.addCookie(cookies[0]);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
