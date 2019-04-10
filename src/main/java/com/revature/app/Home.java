package com.revature.app;

import java.util.List;

import com.revature.dao.UserDAO;
import com.revature.model.DBUser;

public class Home {

	public static void main(String[] args) {
		System.out.println("Maven + Hibernate + Oracle");
		
		UserDAO userdao = new UserDAO();
		List<DBUser> list = userdao.getUserByNameBySQL("bob");

		for(int i= 0; i< list.size(); i++) {
			System.out.println(list.get(i));
		}

		
		
	}

}
