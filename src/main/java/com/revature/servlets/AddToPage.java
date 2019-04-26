package com.revature.servlets;


import java.io.IOException;
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.service.ReimbursmentsService;
import com.revature.service.ReimbursmentsServiceImpl;

public class AddToPage {

		private static final ReimbursmentsService reimbursmentsService = new ReimbursmentsServiceImpl();
		private static final ObjectMapper mapper = new ObjectMapper();
		public AddToPage() {
			
		}

			public static Object process(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException, IOException {
				System.out.println(request.getMethod() + "request going to " + request.getRequestURI());
				if (request.getMethod().equalsIgnoreCase("POST")) {
					if (request.getRequestURI().replace("/OnlyEpicRequest", "").equals("/login")) {
						
					}
					if(request.getRequestURI().replace("/OnlyEpicRequest", "").equals("/InsertReimbursement")) {
						response.setContentType("application/json");
						//response.getOutputStream().write(mapper.writeValueAsBytes(reimbursmentsService.createReimbursments(request, response)));
					}
				}
				if (request.getMethod().equalsIgnoreCase("GET")) {
					if(request.getRequestURI().replace("/OnlyEpicRequest", "").equals("/MakeRequest")) {
						response.setContentType("application/json");
						response.getOutputStream().write(mapper.writeValueAsBytes(reimbursmentsService.getAllReimbursments(request, response)));
					}
				}
				if (request.getMethod().equalsIgnoreCase("GET")) {
					if(request.getRequestURI().replace("/OnlyEpicRequest", "").equals("/GetEmployeeInfo")) {
						response.setContentType("application/json");
						response.getOutputStream().write(mapper.writeValueAsBytes(reimbursmentsService.getAllReimbursments(request, response)));
					}
				}
				return "Not yet implemented";
			}
}
