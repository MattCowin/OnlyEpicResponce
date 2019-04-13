package com.revature.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JDBCConnection {

	
	public void getUserFromDB(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException   {
		
		 try {

	            Class.forName("oracle.jdbc.driver.OracleDriver");

	        } catch (ClassNotFoundException e) {

	            System.out.println("Where is your Oracle JDBC Driver?");
	            e.printStackTrace();
	            return;

	        }

	        System.out.println("Oracle JDBC Driver Registered!");

	        Connection connection = null;

	        try {

	            connection = DriverManager.getConnection(
	                    "jdbc:oracle:thin:@localhost:1521:xe", "Matt", "Dumb0");

	        } catch (SQLException e) {

	            System.out.println("Connection Failed! Check output console");
	            e.printStackTrace();
	            return;

	        }

	        if (connection != null) {
	            System.out.println("You made it, take control your database now!");
	        } else {
	            System.out.println("Failed to make connection!");
	        }
	    }

}
