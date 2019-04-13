package com.revature.dao;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.DBUser;
import com.revature.service.UserService;
import com.revature.servlets.LoginServlet;

public class UserDAO {
	
	public void checkUserInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		
		String DBusr = request.getParameter("user_id");
		String DBuname = request.getParameter("username");
		String DBpwd = request.getParameter("password");
		
	}
	

	public List<DBUser> getAllUsers(String string) {
		
		return null;
	}



	public List<DBUser> getAllUsersById(String string) {
		
		return null;
	}
	
}


