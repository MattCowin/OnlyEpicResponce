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
import com.revature.DBTables.ReimbursementsRequest;
import com.revature.DBTables.Users;
import com.revature.dao.UserDAO;
import com.revature.model.DBUser;

public class Home {

	
		
	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		
		try {
			Users.getUserData();		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
