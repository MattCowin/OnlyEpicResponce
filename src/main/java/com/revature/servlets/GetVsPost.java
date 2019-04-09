package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class GetVsPost extends HttpServlet{
//doGet is called whenever a GET request is made on the frontend
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			
		}
//doPost is called whenever a POST request is made on the frontend	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			
		}
//	GET VS POST
//	There are two primary differences between GET and POST requests.
//  -GEYT will post parameters to the url of a request where as POST will post the parameters to the body of a HTTP REQUEST
//  -GET has a character limit of about 2000 characters while POST is near limitless
}
