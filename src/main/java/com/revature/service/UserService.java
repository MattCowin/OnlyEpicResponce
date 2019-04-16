package com.revature.service;

import java.sql.ResultSet;
import java.sql.SQLException;




public class UserService {

	public static void getUserData(ResultSet rsu) throws SQLException, ClassNotFoundException {		
		while (rsu.next()) {
			StringBuffer buf = new StringBuffer();
			buf.append(rsu.getInt("USER_ID")+" ");
			buf.append(rsu.getString("USERNAME")+" ");
			buf.append(rsu.getString("PASSWORD")+" ");
			buf.append(rsu.getInt("EMPLOYEE_ID")+" ");
			System.out.println(buf.toString()+" ");
		}
	}
}