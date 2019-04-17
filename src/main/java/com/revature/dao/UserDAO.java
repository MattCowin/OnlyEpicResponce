package com.revature.dao;

import java.util.List;

import com.revature.model.DBUser;

public interface UserDAO {
	
	List<DBUser> getAllUsers();
	DBUser getUsersById(int userId);
	DBUser createUsers(DBUser users);
	DBUser updateUsers(DBUser toBeUpdated);
	long deleteUsers(DBUser...toBeDeleted);
}


