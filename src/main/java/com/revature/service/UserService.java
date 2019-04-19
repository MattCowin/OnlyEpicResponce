package com.revature.service;


import java.util.List;

import com.revature.dao.Users;
import com.revature.model.DBUser;

public class UserService {

	public List<DBUser> getAllUsers(){
		return new Users().getAllUsers();
	}
	
	public DBUser getUsersById(int userId) {
		return new Users().getUsersById(userId);
	}
	
	public void createUsers(DBUser users) {
		new Users().createUsers(users);
	}
	
	public void deleteUsers(DBUser users) {
		new Users().deleteUsers(users);
	}
}