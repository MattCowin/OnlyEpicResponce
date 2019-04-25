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


import com.revature.dao.Employees;
import com.revature.dao.ReimbursementsRequest;
import com.revature.dao.Users;

public class JDBCConnection {

//	private static final Properties props = getJdbcProperties();
	
//	public static void main(String[] args) {
//		System.out.println(JDBCConnection.getDatarFromDB());
//	}
	
	public static Connection getDatarFromDB()  {
		

		try {
			return DriverManager.getConnection(System.getenv("JDBC_URL"), 
					System.getenv("JDBC_USER"), System.getenv("JDBC_PASSWORD"));		
	    }
		 catch (SQLException e) {
			 throw new RuntimeException("Failed to get JDBC Connection");
			}
	}	
//	private static Properties getJdbcProperties() {
//        Properties props = new Properties();
//        try {
//            //Gets connection to src/main/resources
//            props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties"));
//        } catch (IOException e) {
//            throw new RuntimeException("Failed to load application.properties!");
//        }
//        return props;
//	}
}
