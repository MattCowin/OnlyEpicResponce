package com.revature.DBTables;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReimbursementsRequest {

		public static void getData(ResultSet rsrr) throws SQLException {
			while (rsrr.next()) {
				StringBuffer buf = new StringBuffer();
				buf.append(rsrr.getInt("REIMBURSMENT_ID")+" ");
				buf.append(rsrr.getString("REIMBURSMENT_TYPE")+" ");
				buf.append(rsrr.getInt("AMOUNT")+" ");
				buf.append(rsrr.getString("REASON")+" ");
				buf.append(rsrr.getInt("EMPLOYEE_ID")+" ");
				buf.append(rsrr.getInt("APPROVED_BY")+" ");
				buf.append(rsrr.getString("STATUS")+" ");
				System.out.println(buf.toString()+" ");
			}
		}
}
