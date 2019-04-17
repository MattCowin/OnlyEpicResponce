package com.revature.servlets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MakeRequest {

	private static final String SQL = "SELECT MAX(REIMBURSMENT_ID) FROM REIMBURSEMENTS_REQUEST";
	public static Object getLastRequest() {
		try {
			Connection conn = JDBCConnection.getDatarFromDB();
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		    ResultSet rs = stmt.executeQuery(SQL);
			
			while (rs.next()) {
				StringBuffer buf = new StringBuffer();
				buf.append(rs.getInt("REIMBURSMENT_ID")+" ");
				System.out.println(buf.toString()+" ");
			    
				System.out.println(rs);
			}
		} 
		 catch (SQLException e) {
			throw new RuntimeException("Failed to get JDBC Connection");
	    }
		return null;
	}
}
