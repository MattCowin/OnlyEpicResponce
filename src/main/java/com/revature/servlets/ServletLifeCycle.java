package com.revature.servlets;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class ServletLifeCycle extends HttpServlet {

//The service method gets invoked after the init method. during the service method the servlet calls the doGet, doPost, doDelete, ect.
	//HTTP method. do not override this method, EVER!!!!!!!!!!
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, resp);
	}
//when destroy is called, the servlet becomes eligible for garbage collection
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}
	//The init method is invoked by the web container if, and only if, an instance of the servlet does not already exist.
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

	
}
