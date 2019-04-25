package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	    public  List<DBEmployees> getAllEmployees() {
	        List<DBEmployees> emps = new ArrayList();
	        try (Connection conn = JDBCConnection.getDatarFromDB()){
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery("SELECT * FROM employees");
	            while (rs.next()) {
	                emps.add(new DBEmployees(rs.getInt("employee_id"), rs.getString("first_name"), rs.getString("last_name"),
	                        rs.getString("email"), rs.getInt("mobile"), rs.getString("address"), rs.getString("city"), rs.getString("state"),
	                        rs.getString("country_code"), rs.getInt("salary"), rs.getInt("position_id"), rs.getString("username"), rs.getString("password")));
	            }
	        } catch (SQLException e) {
	            System.err.println(e);
	        }
	            return emps;
	    }
		@Override
		public DBEmployees getEmployeesById(int empoyeeId) {
			try {
				Connection conn = JDBCConnection.getDatarFromDB();
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID=?");
				
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
		@Override
		public Object getAllEmployees(String username) {
			try {
				Connection conn = JDBCConnection.getDatarFromDB();
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM EMPLOYEES WHERE USERNAME=?");
				ResultSet rs = stmt.executeQuery();
				
				
		        Integer employeeId = rs.getInt("EMPLOYEE_ID");
				String firstName = rs.getString("FIRST_NAME");
				String lastName = rs.getString("LAST_NAME");
				String email = rs.getString("EMAIL");
				Integer mobile = rs.getInt("MOBILE");
				String address = rs.getString("ADDRESS");
				String city = rs.getString("CITY");
				String state = rs.getString("STATE");
				String countryCode = rs.getString("COUNTRY_CODE");
				Integer salary = rs.getInt("SALARY");
				Integer positionId = rs.getInt("POSITION_ID");
				DBEmployees emp = new DBEmployees();
				emp.setEmployeeId(employeeId);
				emp.setFirstName(firstName);
				emp.setLastName(lastName);
				emp.setEmail(email);
				emp.setMobile(mobile);
				emp.setAddress(address);
				emp.setCity(city);
				emp.setState(state);
				emp.setCountryCode(countryCode);
				emp.setSalary(salary);
				emp.setPositionId(positionId);
			} catch (SQLException e) {
				System.err.println(e);
				e.printStackTrace();
			}
			 return null;
		}
		
		
}
