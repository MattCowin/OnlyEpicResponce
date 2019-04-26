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
 * Servlet implementation class DenyRequest
 */
public class DenyRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DenyRequest() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PreparedStatement stmt = null;
		try(Connection conn = JDBCConnection.getDatarFromDB()){
		    stmt = conn.prepareStatement("UPDATE REIMBURSEMENTS SET STATUS ='Denied' WHERE REIMBURSEMENT_ID=?");
		    stmt.setInt(1, Integer.valueOf(request.getParameter("reimbursmentId")));
		    stmt.setString(2, "Denied");
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


