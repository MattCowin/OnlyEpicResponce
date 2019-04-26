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

import oracle.sql.STRUCT;

public class ReimbursementsRequest implements DBReimbursmentsDAO{

		
		
		public static void getData() throws ClassNotFoundException{
			
		}
		
	
		@Override
		public List<DBReimbursments> getAllReimbursments(){
			List<DBReimbursments> Reimbursments = new ArrayList<>();
			try (Connection conn = JDBCConnection.getDatarFromDB()){
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM REIMBURSEMENTS ORDER BY REIMBURSEMENT_ID");
	            ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {
	            	Reimbursments.add(new DBReimbursments(rs.getInt("REIMBURSEMENT_ID"), 
	            			rs.getString("REIMBURSEMENT_TYPE"), rs.getFloat("AMOUNT"), rs.getString("REASON"), 
	            			rs.getInt("EMPLOYEE_ID"), rs.getInt("APPROVED_BY"), rs.getString("STATUS")));
	          // System.out.println(rs.getString("REIMBURSEMENT_TYPE"));
	            	
	            }
	            return Reimbursments;
	        }
	            catch (SQLException e) {
		            e.printStackTrace();
		        }
		       return Reimbursments;        
		}
		
		@Override
		public List<DBReimbursments> getAllReimbursmentsByEmployeeId(int employee_id){
			final List<DBReimbursments> reimbursments = new ArrayList<>();
			try(Connection conn = JDBCConnection.getDatarFromDB()){
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM REIMBURSEMENTS WHERE EMPLOYEE_ID=? ");
				stmt.setInt(1, employee_id);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()){
					reimbursments.add(new DBReimbursments(rs.getInt("REIMBURSEMENT_ID"), rs.getString("REIMBURSEMENT_TYPE"), rs.getFloat("AMOUNT"), rs.getString("REASON"), rs.getInt("EMPLOYEE_ID"), rs.getInt("APPROVED_BY"), rs.getString("STATUS")));
				
				
				
				}
				return reimbursments;
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			return reimbursments;
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
			
				stmt.setString(1, Reimbursments.getReimbursmentType());
				stmt.setFloat(2, Reimbursments.getAmount());
				stmt.setString(3, Reimbursments.getReason());
				stmt.setInt(4, Reimbursments.getEmployeeId());
				stmt.setString(5, Reimbursments.getStatus());
				
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
			PreparedStatement stmt = null;
			try(Connection conn = JDBCConnection.getDatarFromDB()){
			    stmt = conn.prepareStatement("INSERT INTO REIMBURSEMENTS(APPROVED_BY, STATUS) WHERE EMPLOYEE_ID=?");
			    stmt.setInt(1, toBeUpdated.getApprovedBy());
				stmt.setString(2, toBeUpdated.getStatus());
				stmt.executeUpdate();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return updateReimbursments(toBeUpdated);
		}
		
		public DBReimbursments updateReimbursmentById(DBReimbursments reimbursmentId) {
			PreparedStatement stmt = null;
			try(Connection conn = JDBCConnection.getDatarFromDB()){
			    stmt = conn.prepareStatement("UPDATE REIMBURSEMENTS SET STATUS ='Approved' WHERE REIMBURSEMENT_ID=?");
				
			    
				stmt.executeUpdate();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return updateReimbursments(reimbursmentId);
		}

		@Override
		public long deleteReimbursments(DBReimbursments... toBeDeleted) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public List<DBReimbursments> getAllReimbursmentsByUser(String username) {
			List<DBReimbursments> Reimbursments = new ArrayList<>();
			try (Connection conn = JDBCConnection.getDatarFromDB()){
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM REIMBURSEMENTS WHERE USERNAME=" + username + "ORDER BY REIMBURSEMENT_ID");
				stmt.setString(1, username);
	            ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {
	            	Reimbursments.add(new DBReimbursments(rs.getInt("REIMBURSEMENT_ID"), rs.getString("REIMBURSEMENT_TYPE"), rs.getFloat("AMOUNT"), rs.getString("REASON"), rs.getInt("employeeId"), rs.getInt("APPROVED_BY"), rs.getString("STATUS")));
	           System.out.println(rs.getString("REIMBURSEMENT_TYPE"));
	            }
	            return Reimbursments;
	        }
	            catch (SQLException e) {
	            	System.err.println("SQL State: " + e.getSQLState());
	    			System.err.println("Error Code: " + e.getErrorCode());
	    			throw new RuntimeException("Failed to get all Reimbursements");
		        }
		            
		}


		@Override
		public DBReimbursments createReimbursments(DBReimbursments Reimbursments, String username) {
			try (Connection conn = JDBCConnection.getDatarFromDB()){
				PreparedStatement stmt = conn.prepareStatement("INSERT INTO REIMBURSEMENTS(REIMBURSEMENT_TYPE,AMOUNT,REASON,EMPLOYEE_ID,STATUS) VALUES(?,?,?,?,?)");
				stmt.setString(1, Reimbursments.getReimbursmentType());
				stmt.setFloat(2,  Reimbursments.getAmount());
				stmt.setString(3, Reimbursments.getReason());
				stmt.setInt(4, Reimbursments.getEmployeeId());
				stmt.setString(5, "Pending");
				if(stmt.executeUpdate() ==1)
					return Reimbursments;
				else
					return null;
			}
			catch(SQLException e) {
				System.err.println("SQL State: " + e.getSQLState());
				System.err.println("Error Code: " + e.getErrorCode());
				throw new RuntimeException("Failed to get all Reimbursements");
			}
		}


//		try {
//					 Connection conn = JDBCConnection.getDatarFromDB();
//				        PreparedStatement ps = conn.prepareStatement
//				                            ("SELECT * FROM EMPLOYEES WHERE EMAIL=?");
//				        ResultSet rs = ps.executeQuery();
//		
//				        while (rs.next()) {
//				        	String employeeId = rs.getString("EMPLOYEE_ID");
//				        	String firstName = rs.getString("FIRST_NAME");
//				        	String lastName = rs.getString("LAST_NAME");
//				        	String email = rs.getString("EMAIL");
//				        	String mobile = rs.getString("MOBILE");
//				        	String address = rs.getString("ADDRESS");
//				        	String city = rs.getString("CITY");
//				        	String state = rs.getString("STATE");
//				        	String countryCode = rs.getString("COUNTRY_CODE");
//				        	String salary = rs.getString("SALARY");
//				        	String positionId = rs.getString("POSITION_ID");
//		
//						System.out.println("userid : " + employeeId);
//						System.out.println("username : " + firstName);
//						System.out.println("userid : " + firstName);
//						System.out.println("username : " + lastName);
//						
//		
//					}
//		
//				} catch (SQLException e) {
//		
//					System.out.println(e.getMessage());
//		
//				}

}
