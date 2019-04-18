package com.revature.DBTables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.DBReimbursmentsDAO;
import com.revature.model.DBReimbursments;
import com.revature.model.DBUser;
import com.revature.servlets.JDBCConnection;

public class ReimbursementsRequest implements DBReimbursmentsDAO{

		private static final String SQL = "SELECT * FROM REIMBURSEMENTS";
		public static void getData() throws ClassNotFoundException{
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			try {
	        Connection conn = JDBCConnection.getDatarFromDB();
	        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	        ResultSet rs = stmt.executeQuery(SQL);
			while (rs.next()) {
				StringBuffer buf = new StringBuffer();
				buf.append(rs.getInt("REIMBURSMENT_ID")+" ");
				buf.append(rs.getString("REIMBURSMENT_TYPE")+" ");
				buf.append(rs.getInt("AMOUNT")+" ");
				buf.append(rs.getString("REASON")+" ");
				buf.append(rs.getInt("EMPLOYEE_ID")+" ");
				buf.append(rs.getInt("APPROVED_BY")+" ");
				buf.append(rs.getString("STATUS")+" ");
				System.out.println(buf.toString()+" ");
			} 
			}catch (SQLException e) {
				throw new RuntimeException("Failed to locate Oracle Database Driver");
			}
			
		}

		@Override
		public List<DBReimbursments> getAllReimbursments(HttpServletRequest req, HttpServletResponse resp){
			List<DBReimbursments> re = new ArrayList();
	        try (Connection conn = JDBCConnection.getDatarFromDB()){
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery("SELECT * FROM REIMBURSEMENTS WHERE REIMBURSEMENT_ID=?");
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
			String reimbursmentType = null;
			String amount = null;
			String reason = null; 
			String employeeId = null;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				 Connection conn = JDBCConnection.getDatarFromDB();
			        PreparedStatement ps = conn.prepareStatement
			                            ("INSERT INTO REIMBURSEMENTS(REIMBURSEMENT_TYPE,AMOUNT,REASON,EMPLOYEE_ID,STATUS) VALUES(?,?,?,?,?)");
			        ps.setString(1, reimbursmentType);
			        ps.setString(2, amount);
			        ps.setString(3, reason);
			        ps.setString(4, employeeId);
			        ps.setString(5, status);
			       int row = ps.executeUpdate();
			       if (row > 0) {
		               System.out.println("File uploaded and saved into database"); 
		            }
			} 
			catch (ClassNotFoundException e) {
				throw new RuntimeException("Failed to locate Database Driver");
			} 
			catch (SQLException e) {
				throw new RuntimeException("Failed to get JDBC Connection");
		 }
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
