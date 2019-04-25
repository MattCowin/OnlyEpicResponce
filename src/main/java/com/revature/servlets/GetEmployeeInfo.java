package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.checks.EmpInfo;
import com.revature.dao.getInfo;
import com.revature.model.DBEmployees;

/**
 * Servlet implementation class GetEmployeeInfo
 */
public class GetEmployeeInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final ObjectMapper mapper = new ObjectMapper();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetEmployeeInfo() {
        JDBCConnection.getDatarFromDB();
     
    }
 
   
	/**   
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		System.out.println("getting printwriter");
		PrintWriter  pw = resp.getWriter();
		try (Connection conn = JDBCConnection.getDatarFromDB()){
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM EMPLOYEES");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
            	int employeeId = rs.getInt("EMPLOYEE_ID");
            	String firstName = rs.getString("FIRST_NAME");
            	String lastName = rs.getString("LAST_NAME");
            	String email = rs.getString("EMAIL");
            	int mobile = rs.getInt("MOBILE");
            	String address = rs.getString("ADDRESS");
            	String city = rs.getString("CITY");
            	String state = rs.getString("STATE");
				String countryCode = rs.getString("COUNTRY_CODE");
				int salary = rs.getInt("SALARY");
				
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
            }
		}
            catch(SQLException e){
            	throw new RuntimeException("There was an issue with retrieving your data.");
            }
				
				
				
				
		resp.setContentType("application/json");
		resp.getOutputStream().write(mapper.writeValueAsBytes(AddToPage.process(req, resp)));
	
	}
}