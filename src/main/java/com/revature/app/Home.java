package com.revature.app;

import java.util.List;

import com.revature.dao.UserDAO;
import com.revature.model.DBUser;

public class Home {

	public static void main(String[] args) {
		
		
		UserDAO userdao = new UserDAO();
		List<DBUser> list = userdao.getAllUsersById("");
		for(int i= 0; i< list.size(); i++) {
			System.out.println(list.get(i));
		}

		
		
	}

}
