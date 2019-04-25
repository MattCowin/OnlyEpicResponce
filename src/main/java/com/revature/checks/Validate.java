package com.revature.checks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.servlets.JDBCConnection;

public class Validate {

	public static boolean checkUser(String username,String password){
     boolean st =false;
     try{

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = JDBCConnection.getDatarFromDB();
        PreparedStatement ps = conn.prepareStatement
                            ("select * from employees where username=? and password=?");//Switched from having a user table. may kill login function
        ps.setString(1, username);
        ps.setString(2, password);
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
