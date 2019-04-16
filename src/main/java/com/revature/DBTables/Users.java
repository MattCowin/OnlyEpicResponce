package com.revature.DBTables;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.UserDAO;
import com.revature.model.DBEmployees;
import com.revature.model.DBUser;
import com.revature.servlets.JDBCConnection;

public class Users implements UserDAO{
	
	 private static final String SQL = "SELECT * FROM USERS";
	 private static final String SQL1 = "SELECT USERNAME, PASSWORD FROM USERS";
	 public static String un = null;
	 public static String pw = null;
		public static void getUserData() throws SQLException, ClassNotFoundException {
	
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try {
				Connection conn = JDBCConnection.getDatarFromDB();
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SQL);
				
				while (rs.next()) {
					StringBuffer buf = new StringBuffer();
					buf.append(rs.getInt("USER_ID")+" ");
					buf.append(rs.getString("USERNAME")+" ");
					buf.append(rs.getString("PASSWORD")+" ");
					buf.append(rs.getInt("EMPLOYEE_ID")+" ");
					System.out.println(buf.toString()+" ");
				    un = rs.getString(2);
				    pw = rs.getString(3);
					System.out.println(un +"  " + pw);
				}
			} catch (SQLException e) {
				System.err.println(e);
				e.printStackTrace();
			}			
		}
		
		public List<DBUser> getAllUsers() {
			List<DBUser> usr = new ArrayList();
	        try (Connection conn = JDBCConnection.getDatarFromDB()){
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
	            while (rs.next()) {
	            	usr.add(new DBUser(rs.getInt("user_id"), rs.getString("username"), rs.getString("password"), rs.getInt("employee_id")));
	            }
	        }
	            catch (SQLException e) {
		            System.err.println(e);
		        }
		        return usr;
		}
		@Override
		public Users getUsersById(int userId) {
			
			return null;
		}
		@Override
		public Users createUsers(Users users) {
			
			return null;
		}
		@Override
		public Users updateUsers(Users toBeUpdated) {
			
			return null;
		}
		@Override
		public long deleteUsers(Users... toBeDeleted) {
			
			return 0;
		}
	
	
}
