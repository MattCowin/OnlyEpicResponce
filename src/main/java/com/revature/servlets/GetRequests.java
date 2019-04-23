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

/**
 * Servlet implementation class GetRequests
 */
public class GetRequests extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final ObjectMapper mapper = new ObjectMapper(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetRequests() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @throws IOException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException  {
			resp.setContentType("text/html");
			System.out.println("getting printwriter");
			PrintWriter  pw = resp.getWriter();
			System.out.println("getting connection");
		try(Connection conn = JDBCConnection.getDatarFromDB()){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM REIMBURSEMENTS");
			ResultSet rs = (ResultSet) ps.executeQuery();	
			String str = "<table class='table' id='ReimbursementsTable'><thead><tr><th>ID</th><th>TYPE</th><th>AMOUNT</th><th>REASON</th><th>SUBMITTED BY</th><th>STATUS</th></tr></thead><tbody>";
			System.out.println("attempting to populate a table");
			while(rs.next()) {
				str += "<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td></tr>";
			}
			str += "</tbody></table>";
			pw.println(str);
			conn.close();
			pw.close();
		}
		catch(SQLException e) {
			throw new RuntimeException("There was an issue with retrieving your data.");
		}
	}


}
