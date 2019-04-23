package com.revature.servlets;

import java.util.Collections;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import com.revature.service.ReimbursmentsService;
import com.revature.service.ReimbursmentsServiceImpl;

/**
 * Servlet implementation class FrontControllerServlet
 */
public class FrontControllerServlet{
//	private static final long serialVersionUID = 1L;
	private static final Logger loge = Logger.getLogger(FrontControllerServlet.class);
	private static final ReimbursmentsService reimbursmentsService = new ReimbursmentsServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontControllerServlet() {
        super();  
    }
    public static Object process(HttpServletRequest req, HttpServletResponse resp) {
		final String uri = req.getRequestURI().replace("/OnlyEpicRequest/", "");
		System.out.println("Inside AddToPage: " + req.getMethod() + " request going to " + uri);
		switch(uri) {
		case "/GetRequests":
			return reimbursmentsService.getAllReimbursments(req, resp);
		default:
			return Collections.singletonMap("message", "Not yet implemented. Stuck at FrontController process");
		}
	}
	
	public static Object processPost(HttpServletRequest req, HttpServletResponse resp) {
		final String uri = req.getRequestURI().replace("/OnlyEpicRequest/createrequest", "");
		System.out.println("Inside AddToPage: " + req.getMethod() + " request going to " + uri);
		switch(uri) {
		case "/PutRequest":
			return reimbursmentsService.createReimbursments(req, resp);
		default:
			return Collections.singletonMap("message", "Not yet implemented. Stuck at FrontController processPost");
		}
	}
}
