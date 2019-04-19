package com.revature.checks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.servlets.JDBCConnection;

public class GetName {

	public static boolean checkManager(String firstName, String lastName){
	     boolean st =false;
	     try{

	        Class.forName("oracle.jdbc.driver.OracleDriver");
	        Connection conn = JDBCConnection.getDatarFromDB();
	        PreparedStatement ps = conn.prepareStatement
	                            ("SELECT FIRST_NAME, LAST_NAME FROM EMPLOYEES WHERE EMAIL=?");
	        ps.setString(1, firstName);
	        ps.setString(2, lastName);
	        ResultSet rs =ps.executeQuery();
	        st = rs.next();
	       
	     }
	     catch (ClassNotFoundException e) {
				throw new RuntimeException("Failed to locate Database Driver");
		 } 
	     catch (SQLException e) {
				throw new RuntimeException("Failed to get JDBC Connection");
		 }
	        return st;                 
		}   
}
