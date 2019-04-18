package com.revature.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.revature.DBTables.Employees;
import com.revature.DBTables.Position;
import com.revature.DBTables.PositionList;
import com.revature.DBTables.Users;
import com.revature.dao.ReimbursementsRequest;
import com.revature.dao.UserDAO;
import com.revature.model.DBUser;

public class Home {

	
		
	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		
		try {
			Users.getUserData();
			//ReimbursementsRequest.getData();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Failed to get JDBC Connection");
		} catch (SQLException e) {
			throw new RuntimeException("Failed to locate Oracle Database Driver");
		}
		
		
	}

}
