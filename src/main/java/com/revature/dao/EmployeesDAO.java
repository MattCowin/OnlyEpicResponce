package com.revature.dao;

import java.util.List;

import com.revature.model.DBEmployees;

public interface EmployeesDAO {

	List<DBEmployees> getAllEmployees();
	List<DBEmployees> getAllEmployees(String username);
	DBEmployees getEmployeesById(int userId);
	DBEmployees createEmployees(DBEmployees Employees);
	DBEmployees updateEmployees(DBEmployees toBeUpdated);
	long deleteTodo(DBEmployees...toBeDeleted);
}
