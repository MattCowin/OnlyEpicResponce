package com.revature.DBTables;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Position {

	public static void getPositionData(ResultSet rsp) throws SQLException {
		while (rsp.next()) {
			StringBuffer buf = new StringBuffer();
			buf.append(rsp.getInt("EMPLOYEE_ID")+" ");
			buf.append(rsp.getString("POSITION_NAME")+" ");
			System.out.println(buf.toString()+" ");
		}
	}
}
