package com.revature.DBTables;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PositionList {
	
	public static void getPositionListData(ResultSet rspl) throws SQLException {
		while (rspl.next()) {
			StringBuffer buf = new StringBuffer();
			buf.append(rspl.getInt("PLIST_ID")+" ");
			buf.append(rspl.getInt("POSITION_ID")+" ");
			buf.append(rspl.getInt("EMPLOYEE_ID")+" ");
			System.out.println(buf.toString()+" ");
		}
	}
}
