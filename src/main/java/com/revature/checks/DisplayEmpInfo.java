package com.revature.checks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.model.DBEmployees;
import com.revature.servlets.JDBCConnection;

public class DisplayEmpInfo {


	public static Object checkUser(){
     
     try{

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = JDBCConnection.getDatarFromDB();
        PreparedStatement ps = conn.prepareStatement
                            ("select * from employees");

        ResultSet rs =ps.executeQuery();
        Integer employeeId = rs.getInt("EMPLOYEE_ID");
		String firstName = rs.getString("FIRST_NAME");
		String lastName = rs.getString("LAST_NAME");
		String email = rs.getString("EMAIL");
		Integer mobile = rs.getInt("MOBILE");
		String address = rs.getString("ADDRESS");
		String city = rs.getString("CITY");
		String state = rs.getString("STATE");
		String countryCode = rs.getString("COUNTRY_CODE");
		Integer salary = rs.getInt("SALARY");
		Integer positionId = rs.getInt("POSITION_ID");
		DBEmployees emp = new DBEmployees();
		emp.setEmployeeId(employeeId);
		emp.setFirstName(firstName);
		emp.setLastName(lastName);
		emp.setEmail(email);
		emp.setMobile(mobile);
		emp.setAddress(address);
		emp.setCity(city);
		emp.setState(state);
		emp.setCountryCode(countryCode);
		emp.setSalary(salary);
		emp.setPositionId(positionId);
//        ps.setInt(1, employeeId);
//        ps.setString(2, firstName);
//        ps.setString(3, lastName);
//        ps.setString(4, email);
//        ps.setInt(5, mobile);
//        ps.setString(6, address);
//        ps.setString(7, city);
//        ps.setString(8, state);
//        ps.setString(9, countryCode);
//        ps.setInt(10, salary);
//        ps.setInt(11, positionId);
        
//        st = rs.next();
       
     }
     catch (ClassNotFoundException e) {
			throw new RuntimeException("Failed to locate Database Driver");
	 } 
     catch (SQLException e) {
			throw new RuntimeException("Failed to get JDBC Connection");
	 }
	return null;
                       
	}   
}
