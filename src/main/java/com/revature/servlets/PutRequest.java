package com.revature.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PutRequest
 */
public class PutRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PutRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String status = "Pending";
		String reimbursmentType;
		String amt;
		String reason; 
		String emplId;
		reimbursmentType = request.getParameter("reimbursmentType");
		amt = request.getParameter("amount");
		reason = request.getParameter("reason");
		emplId = request.getParameter("employeeId");
		int employeeId = Integer.parseInt(emplId);
		float amount = Float.parseFloat(amt);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 Connection conn = JDBCConnection.getDatarFromDB();
		        PreparedStatement ps = conn.prepareStatement
		                            ("INSERT INTO REIMBURSEMENTS(REIMBURSEMENT_TYPE,AMOUNT,REASON,EMPLOYEE_ID,STATUS) VALUES(?,?,?,?,?)");
		        ps.setString(1, reimbursmentType);
		        ps.setFloat(2, amount);
		        ps.setString(3, reason);
		        ps.setInt(4, employeeId);
		        ps.setString(5, status);
		       int row = ps.executeUpdate();
		       if (row > 0) {
		    	   System.out.println(conn);
	            }
		} 
		catch (ClassNotFoundException e) {
			throw new RuntimeException("Failed to locate Database Driver");
		} 
		catch (SQLException e) {
			System.out.println("What the F#@&");
			throw new RuntimeException("Failed to get JDBC Connection");
	    }
		 
       
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
        
	}

}
