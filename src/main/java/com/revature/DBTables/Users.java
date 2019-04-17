package com.revature.DBTables;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.UserDAO;
import com.revature.model.DBUser;
import com.revature.servlets.JDBCConnection;

public class Users implements UserDAO{
	
	 public static int userId;
	 public static String username;
	 public static String password;
	 public static int employeeId;
	 private static final String SQL = "SELECT * FROM USERS WHERE USER_ID =" + userId;
	// private static final String SQL1 = "SELECT USERNAME, PASSWORD FROM USERS";
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
		public DBUser getUsersById(int userId) {
			DBUser user = new DBUser();
			try {
				Connection conn = JDBCConnection.getDatarFromDB();
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SQL);
				
				while (rs.next()) {
					userId = rs.getInt("user_id");
					username = rs.getString("username");
					password = rs.getString("password");
					employeeId = rs.getInt("employee_id");
					user.setUserId(userId);
					user.setUsername(username);
					user.setPassword(password);
					user.setEmployeeId(employeeId);
				}
			} catch (SQLException e) {
				System.err.println(e);
				e.printStackTrace();
			}		
			return user;
		}

		@Override
		public DBUser createUsers(DBUser users) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public DBUser updateUsers(DBUser toBeUpdated) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long deleteUsers(DBUser... toBeDeleted) {
			// TODO Auto-generated method stub
			return 0;
		}
	
	
}
