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
 * Servlet implementation class UpdateReimbursementById
 */
public class UpdateReimbursementById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateReimbursementById() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PreparedStatement stmt = null;
		try(Connection conn = JDBCConnection.getDatarFromDB()){
		    stmt = conn.prepareStatement("UPDATE REIMBURSEMENTS SET STATUS ='Approved' WHERE REIMBURSEMENT_ID=?");
		    stmt.setString(1, "Approved");
			stmt.executeUpdate();
			stmt.close();
			conn.close();
			RequestDispatcher dispatcher = getServletContext()
      		      .getRequestDispatcher("/viewallreimbursements.jsp");
      		    dispatcher.forward(request, response);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
