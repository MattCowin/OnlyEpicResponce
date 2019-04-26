package com.revature.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.Employees;
import com.revature.dao.EmployeesDAO;
import com.revature.model.DBEmployees;


public class EployeeServiceImpl implements EmployeeService{

		private final EmployeesDAO dao = (EmployeesDAO) new EployeeServiceImpl();
		private final ObjectMapper mapper = new ObjectMapper();
		
		
	@Override
	public Object getAllEmployees(HttpServletRequest request, HttpServletResponse response) {
		final String username = (String) request.getSession().getAttribute("currentUser");
		
		return dao.getAllEmployees(username);
		
	}

	
	
	
}
