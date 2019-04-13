package com.revature.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.revature.dao.UserDAO;
import com.revature.model.DBUser;

public class Home {

		
	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		

		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Matt", "Dumb0");
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery("SELECT * FROM REIMBURSEMENTS_REQUEST");
			rs.last();			
			System.out.println("number of rows " + rs.getRow());
		} catch (SQLException e) {
			System.err.println(e);
			e.printStackTrace();
		}
	
//		UserDAO userdao = new UserDAO();
//		List<DBUser> list = userdao.getAllUsersById("");
//		for(int i= 0; i< list.size(); i++) {
//			System.out.println(list.get(i));
//		}

		
		
	}

}
