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
 * Servlet implementation class UpdateEpmInfo
 */
public class UpdateEmpInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmpInfo() {
        JDBCConnection.getDatarFromDB();
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(Connection conn = JDBCConnection.getDatarFromDB()){
			PreparedStatement stmt = conn.prepareStatement("UPDATE EMPLOYEES SET EMAIL=?, MOBILE=?, ADDRESS=?, CITY=?, STATE=?, COUNTRY_CODE=? WHERE EMAIL=?");
		
			stmt.setString(1, request.getParameter("Email"));
			stmt.setInt(2,  Integer.valueOf(request.getParameter("MOBILE")));
			stmt.setString(3, request.getParameter("ADDRESS"));
			stmt.setString(3, request.getParameter("CITY"));
			stmt.setString(3, request.getParameter("STATE"));
			stmt.setString(3, request.getParameter("ZIP"));			
			
			stmt.executeUpdate();
			stmt.close();
			conn.close();
			RequestDispatcher dispatcher = getServletContext()
	      		      .getRequestDispatcher("/userhome.jsp");
	      		    dispatcher.forward(request, response);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
