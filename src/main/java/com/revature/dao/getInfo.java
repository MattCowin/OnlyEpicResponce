package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.servlets.JDBCConnection;

public class getInfo {

	public static void addToPage() {
		try(Connection conn = JDBCConnection.getDatarFromDB()){
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID=? ");
			 ResultSet rs = stmt.executeQuery();
			 	rs.getInt("EMPLOYEE_ID");
			 	rs.getString("FIRST_NAME");
			 	rs.getString("LAST_NAME");
			 	rs.getString("EMAIL");
			 	rs.getInt("MOBILE");
			 	rs.getString("ADDRESS");
			 	rs.getString("CITY");
			 	rs.getString("STATE");
			 	rs.getString("COUNTRY_CODE");
			 	rs.getInt("SALARY");
			 	rs.getInt("POSITION_ID");
			 rs.close();
		     stmt.close();
		     conn.close();
		}
		catch (SQLException e) {
			System.err.println(e);
			e.printStackTrace();
		}	
	}
	
	   	
}
