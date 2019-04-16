package com.revature.dao;

import java.util.List;

import com.revature.DBTables.Employees;
import com.revature.DBTables.Users;
import com.revature.model.DBEmployees;

public interface EmployeesDAO {

	List<DBEmployees> getAllEmployees();
	DBEmployees getEmployeesById(int userId);
	DBEmployees createEmployees(DBEmployees Employees);
	DBEmployees updateEmployees(DBEmployees toBeUpdated);
	long deleteTodo(DBEmployees...toBeDeleted);
}
