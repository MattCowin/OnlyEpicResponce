package com.revature.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.DBTables.Employees;
import com.revature.DBTables.Position;
import com.revature.DBTables.PositionList;
import com.revature.DBTables.ReimbursementsRequest;
import com.revature.DBTables.Users;

public class JDBCConnection {

	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; 
	private static final String UNAME = "Matt";
	private static final String PSSWORD = "Dumb0";
	
	public static Connection getDatarFromDB()  {
		

		try {
			return DriverManager.getConnection(URL, UNAME, PSSWORD);			
	    }
		 catch (SQLException e) {
				System.err.println(e);
				e.printStackTrace();
			}
		return null;
	}
}
