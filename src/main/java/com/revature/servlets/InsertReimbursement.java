package com.revature.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertReimbursement
 */
public class InsertReimbursement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertReimbursement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(Connection conn = JDBCConnection.getDatarFromDB()){
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO REIMBURSEMENTS(REIMBURSEMENT_TYPE,AMOUNT,REASON,EMPLOYEE_ID,STATUS) VALUES(?,?,?,?,?)");
		
			stmt.setString(1, request.getParameter("reimbursmentType"));
			stmt.setFloat(2,  Float.valueOf(request.getParameter("amount")));
			stmt.setString(3, request.getParameter("reason"));
			stmt.setInt(4, Integer.valueOf(request.getParameter("employeeId")));
			stmt.setString(5, "Pending");
			
			stmt.executeUpdate();
			stmt.close();
			conn.close();
			RequestDispatcher dispatcher = getServletContext()
      		      .getRequestDispatcher("/createrequest.jsp");
      		    dispatcher.forward(request, response);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
