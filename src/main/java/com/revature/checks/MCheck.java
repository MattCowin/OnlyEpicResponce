package com.revature.checks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.servlets.JDBCConnection;

public class MCheck {

	public static boolean checkManager(String email){
	     boolean st =false;
	     try{

	        Class.forName("oracle.jdbc.driver.OracleDriver");
	        Connection conn = JDBCConnection.getDatarFromDB();
	        PreparedStatement ps = conn.prepareStatement
	                            ("SELECT * FROM MANAGER WHERE EMAIL=?");
	        ps.setString(1, email);
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
