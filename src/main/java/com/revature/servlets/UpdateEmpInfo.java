package com.revature.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
			response.sendRedirect("./createrequest.jsp");
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
