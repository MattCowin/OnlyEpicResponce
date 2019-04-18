package com.revature.test;

import java.util.List;

import org.junit.Test;

import com.revature.dao.ReimbursementsRequest;
import com.revature.model.DBReimbursments;

public class ConnectionFactoryTest {

	private ReimbursementsRequest eReqDao = new ReimbursementsRequest();
	
	@Test
	public void getAllReimbursements() {
		List<DBReimbursments> dbr = eReqDao.getAllReimbursments();
		
		System.out.println("ran #getAllReimbursements Test");
	}
}
