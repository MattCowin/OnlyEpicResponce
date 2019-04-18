package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.DBReimbursments;
import com.revature.model.DBUser;
import com.revature.servlets.JDBCConnection;

public class ReimbursementsRequest implements DBReimbursmentsDAO{

		private static final String SQL = "SELECT * FROM REIMBURSEMENTS";
		public static void getData() throws ClassNotFoundException{
			
		}

		@Override
		public List<DBReimbursments> getAllReimbursments(){
			List<DBReimbursments> re = new ArrayList();
			try (Connection conn = JDBCConnection.getDatarFromDB()){
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery("SELECT * FROM REIMBURSEMENTS");
	            while (rs.next()) {
	            	re.add(new DBReimbursments(rs.getInt("REIMBURSEMENT_ID"), rs.getString("REIMBURSEMENT_TYPE"), rs.getFloat("AMOUNT"), rs.getString("REASON"), rs.getInt("employee_id"), rs.getInt("APPROVED_BY"), rs.getString("STATUS")));
	            }
	        }
	            catch (SQLException e) {
		            System.err.println(e);
		        }
		        return re;        
		}

		@Override
		public DBReimbursments getReimbursmentsById(int userId) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public DBReimbursments createReimbursments(DBReimbursments Reimbursments) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public DBReimbursments updateReimbursments(DBReimbursments toBeUpdated) {
			
			String status = "Pending";
			String reimbursmentType;
			String amt;
			String reason; 
			String emplId;
			
			
			
//			try {
//				Class.forName("oracle.jdbc.driver.OracleDriver");
//				 Connection conn = JDBCConnection.getDatarFromDB();
//			        PreparedStatement ps = conn.prepareStatement
//			                            ("INSERT INTO REIMBURSEMENTS(REIMBURSEMENT_TYPE,AMOUNT,REASON,EMPLOYEE_ID,STATUS) VALUES(?,?,?,?,?)");
//			        ps.setString(1, reimbursmentType);
//			        ps.setFloat(2, amount);
//			        ps.setString(3, reason);
//			        ps.setInt(4, employeeId);
//			        ps.setString(5, status);
//			       int row = ps.executeUpdate();
//			       if (row > 0) {
//			    	   System.out.println(conn);
//		            }
//			} 
//			catch (ClassNotFoundException e) {
//				throw new RuntimeException("Failed to locate Database Driver");
//			} 
//			catch (SQLException e) {
//				System.out.println("What the F#@&");
//				throw new RuntimeException("Failed to get JDBC Connection");
//		    }
			return toBeUpdated;
		}

		@Override
		public long deleteReimbursments(DBReimbursments... toBeDeleted) {
			// TODO Auto-generated method stub
			return 0;
		}

//		@Override
//		public List<DBReimbursments> getAllReimbursments(HttpServletRequest req, HttpServletResponse resp) {
//			// TODO Auto-generated method stub
//			return null;
//		}
}
