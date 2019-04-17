package com.revature.servlets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Validate {

	public static boolean checkUser(String username,String password){
     boolean st =false;
     try{

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = JDBCConnection.getDatarFromDB();
        PreparedStatement ps = conn.prepareStatement
                            ("select * from users where username=? and password=?");
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
