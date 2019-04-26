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

import com.revature.checks.MCheck;

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
		int id = Integer.valueOf(request.getParameter("reID"));
		PreparedStatement stmt = null;
		try(Connection conn = JDBCConnection.getDatarFromDB()){
		    stmt = conn.prepareStatement("UPDATE REIMBURSEMENTS SET STATUS =? WHERE REIMBURSEMENT_ID="+id);
//		    stmt.setInt(1, Integer.valueOf(request.getParameter("id")));
		    stmt.setString(1, request.getParameter("Status"));
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
		
		RequestDispatcher dispatcher = getServletContext()
    		      .getRequestDispatcher("/viewallreimbursements.jsp");
    		    dispatcher.forward(request, response);
	}

}
