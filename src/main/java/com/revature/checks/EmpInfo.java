package com.revature.checks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.servlets.JDBCConnection;

public class EmpInfo {

	private static void getEmpInfo()  {


		try {
			 Connection conn = JDBCConnection.getDatarFromDB();
		        PreparedStatement ps = conn.prepareStatement
		                            ("SELECT * FROM EMPLOYEES WHERE EMAIL=?");
		        ResultSet rs = ps.executeQuery();

		        while (rs.next()) {
		        	String employeeId = rs.getString("EMPLOYEE_ID");
		        	String firstName = rs.getString("FIRST_NAME");
		        	String lastName = rs.getString("LAST_NAME");
		        	String email = rs.getString("EMAIL");
		        	String mobile = rs.getString("MOBILE");
		        	String address = rs.getString("ADDRESS");
		        	String city = rs.getString("CITY");
		        	String state = rs.getString("STATE");
		        	String countryCode = rs.getString("COUNTRY_CODE");
		        	String salary = rs.getString("SALARY");
		        	String positionId = rs.getString("POSITION_ID");

				System.out.println("userid : " + employeeId);
				System.out.println("username : " + firstName);
				System.out.println("userid : " + firstName);
				System.out.println("username : " + lastName);
				

			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}
}
}











