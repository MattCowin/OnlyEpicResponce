package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.revature.model.DBReimbursments;
import com.revature.servlets.JDBCConnection;

public class ReimbursementsRequest implements DBReimbursmentsDAO{

		private static final String SQL = "SELECT * FROM REIMBURSEMENTS";
		
		public static void getData() throws ClassNotFoundException{
			
		}

		@Override
		public List<DBReimbursments> getAllReimbursments(){
			List<DBReimbursments> Reimbursments = new ArrayList<>();
			try (Connection conn = JDBCConnection.getDatarFromDB()){
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery(SQL);
	            while (rs.next()) {
	            	Reimbursments.add(new DBReimbursments(rs.getInt("REIMBURSEMENT_ID"), rs.getString("REIMBURSEMENT_TYPE"), rs.getFloat("AMOUNT"), rs.getString("REASON"), rs.getInt("employee_id"), rs.getInt("APPROVED_BY"), rs.getString("STATUS")));
	           System.out.println(rs.getString("REIMBURSEMENT_TYPE"));
	            }
	            return Reimbursments;
	        }
	            catch (SQLException e) {
		            e.printStackTrace();
		        }
		       return null;        
		}

		@Override
		public DBReimbursments getReimbursmentsById(int userId) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public DBReimbursments createReimbursments(DBReimbursments Reimbursments) {
			try(Connection conn = JDBCConnection.getDatarFromDB()){
				PreparedStatement stmt = conn.prepareStatement("INSERT INTO REIMBURSEMENTS(REIMBURSEMENT_TYPE,AMOUNT,REASON,EMPLOYEE_ID,STATUS) VALUES(?,?,?,?,?)");
			
				stmt.setString(2, Reimbursments.getReimbursmentType());
				stmt.setFloat(3, Reimbursments.getAmount());
				stmt.setString(4, Reimbursments.getReason());
				stmt.setInt(5, Reimbursments.getEmployeeId());
				stmt.setString(7, Reimbursments.getStatus());
				
				int rowsAffected = stmt.executeUpdate();
				if(rowsAffected == 1)
					return Reimbursments;
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
			return new DBReimbursments();
		}

		@Override
		public DBReimbursments updateReimbursments(DBReimbursments toBeUpdated) {
			return null;
			
		}

		@Override
		public long deleteReimbursments(DBReimbursments... toBeDeleted) {
			// TODO Auto-generated method stub
			return 0;
		}

}
