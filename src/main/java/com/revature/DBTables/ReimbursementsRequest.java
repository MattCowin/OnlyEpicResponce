package com.revature.DBTables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.dao.DBReimbursmentsDAO;
import com.revature.model.DBReimbursments;

public class ReimbursementsRequest implements DBReimbursmentsDAO{

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

		@Override
		public List<DBReimbursments> getAllReimbursments() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public DBReimbursments getReimbursmentsById(int userId) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public DBReimbursments createReimbursments(DBReimbursments Reimbursments) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public DBReimbursments updateReimbursments(DBReimbursments toBeUpdated) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long deleteReimbursments(DBReimbursments... toBeDeleted) {
			// TODO Auto-generated method stub
			return 0;
		}
}
