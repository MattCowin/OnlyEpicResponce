package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class FrontControllerServlet
 */
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger loge = Logger.getLogger(FrontControllerServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontControllerServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		loge.info("Our Front Controller is working properly");
		//The getRequestURI returns the URI this request is looking for
		String uri = request.getRequestURI();
		//allows you to split the string into several pieces and returns an array of those pieces
		String[] uriPieces =uri.split("/");
		//retrieving the last piece of the uri
		String lastPiece = uriPieces[uriPieces.length -1];
		//this looks like "something" -.do
		String servletName = lastPiece.substring(0, lastPiece.length() -3).toLowerCase();
		
		switch(servletName) {
		case "loginservlet":
			request.getRequestDispatcher("LoginServlet").forward(request, response);
			break;
		default:
			
			response.setContentType("text/plain");
			PrintWriter pwr = response.getWriter();
			pwr.write("The servlet you have requested doesn't exist");
			//response.sendError(404);
			break;
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
