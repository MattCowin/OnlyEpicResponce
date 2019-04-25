package com.revature.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.DBEmployees;

public interface EmployeeService{
	
	Object getAllEmployees(HttpServletRequest req, HttpServletResponse resp);
}
