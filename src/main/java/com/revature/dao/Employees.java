package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.DBEmployees;
import com.revature.servlets.JDBCConnection;

public class Employees implements EmployeesDAO{

	    private static final String SQL = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";
		public static void getEmployeeData() throws SQLException, ClassNotFoundException {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try {
				Connection conn = JDBCConnection.getDatarFromDB();
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEES");
				
				while (rs.next()) {
					StringBuffer buf = new StringBuffer();
					buf.append(rs.getInt("EMPLOYEE_ID")+" ");
					buf.append(rs.getString("FIRST_NAME")+" ");
					buf.append(rs.getString("LAST_NAME")+" ");
					buf.append(rs.getString("EMAIL")+" ");
					buf.append(rs.getInt("MOBILE")+" ");
					buf.append(rs.getString("ADDRESS")+" ");
					buf.append(rs.getString("CITY")+" ");
					buf.append(rs.getString("STATE")+" ");
					buf.append(rs.getInt("COUNTRY_CODE")+" ");
					buf.append(rs.getInt("SALARY")+" ");
					buf.append(rs.getInt("POSITION_ID")+" ");
					System.out.println(buf.toString()+" ");
				}
			} catch (SQLException e) {
				System.err.println(e);
				e.printStackTrace();
			}			
		}
		@Override
	    public List<DBEmployees> getAllEmployees() {
	        List<DBEmployees> emps = new ArrayList();
	        try (Connection conn = JDBCConnection.getDatarFromDB()){
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery("SELECT * FROM employees");
	            while (rs.next()) {
	                emps.add(new DBEmployees(rs.getInt("employee_id"), rs.getString("first_name"), rs.getString("last_name"),
	                        rs.getString("email"), rs.getInt("mobile"), rs.getString("address"), rs.getString("city"), rs.getString("state"),
	                        rs.getString("country_code"), rs.getInt("salary"), rs.getInt("position_id")));
	            }
	        } catch (SQLException e) {
	            System.err.println(e);
	        }
	            return emps;
	    }
		@Override
		public DBEmployees getEmployeesById(int empoyeeId) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public DBEmployees createEmployees(DBEmployees Employees) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public DBEmployees updateEmployees(DBEmployees toBeUpdated) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public long deleteTodo(DBEmployees... toBeDeleted) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		
}