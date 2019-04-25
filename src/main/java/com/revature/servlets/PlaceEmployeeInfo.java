package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.checks.DisplayEmpInfo;
import com.revature.model.DBEmployees;


/**
 * Servlet implementation class PlaceEmployeeInfo
 */
public class PlaceEmployeeInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final ObjectMapper mapper = new ObjectMapper();
    /**
     * @see HttpServlet#HttpServlet()
     */
	public PlaceEmployeeInfo() {
        JDBCConnection.getDatarFromDB();
     
    }
 
   
	/**   
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 resp.setContentType("text/html");
		 PrintWriter out = resp.getWriter(); 
		 RequestDispatcher dispatcher = req.getRequestDispatcher("userhome.jsp");
		 try{
		        Connection conn = JDBCConnection.getDatarFromDB();
		        PreparedStatement ps = conn.prepareStatement
		                            ("select * from employees where email=?");

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
				
				out.println(firstName);
		
		req.setAttribute("firstName", firstName); 
		dispatcher.forward( req, resp );
	}
		 catch (SQLException e) {
				throw new RuntimeException("Failed to get JDBC Connection");
		 }
	}
}
