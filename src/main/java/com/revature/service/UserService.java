package com.revature.service;

import java.util.List;

import com.revature.dao.UserDAO;
import com.revature.model.DBUser;



public class UserService {

	public <Users> List<DBUser> getAllUsersById(){
		return new UserDAO().getAllUsersById(null);
	}
}
