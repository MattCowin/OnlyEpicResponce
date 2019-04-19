package com.revature.servlets;


import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.service.ReimbursmentsService;
import com.revature.service.ReimbursmentsServiceImpl;

public class AddToPage {

		private static final ReimbursmentsService reimbursmentsService = new ReimbursmentsServiceImpl();
		public AddToPage() {
			
		}
		
		public static Object process(HttpServletRequest req, HttpServletResponse resp) {
			final String uri = req.getRequestURI().replace("/OnlyEpicRequest/ ", "");
			System.out.println("Inside AddToPage: " + req.getMethod() + " request going to " + uri);
			switch(uri) {
			case "/MakeRequest":{
				System.out.println("John found it");
				return reimbursmentsService.getAllReimbursments(req, resp);}
			default:
				return Collections.singletonMap("message", "Not yet implemented. Stuck at AddToPage process");
			}
		}
		
		public static Object processPost(HttpServletRequest req, HttpServletResponse resp) {
			final String uri = req.getRequestURI().replace("/OnlyEpicRequest/api", "");
			System.out.println("Inside AddToPage: " + req.getMethod() + " request going to " + uri);
			switch(uri) {
			case "/PutRequest":
				return reimbursmentsService.createReimbursments(req, resp);
			default:
				return Collections.singletonMap("message", "Not yet implemented. Stuck at AddToPage processPost");
			}
		}
}
