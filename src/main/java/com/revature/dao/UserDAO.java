package com.revature.dao;

import java.util.List;

import com.revature.DBTables.Users;
import com.revature.model.DBUser;

public interface UserDAO {
	
	List<DBUser> getAllUsers();
	Users getUsersById(int userId);
	Users createUsers(Users users);
	Users updateUsers(Users toBeUpdated);
	long deleteUsers(Users...toBeDeleted);
}


