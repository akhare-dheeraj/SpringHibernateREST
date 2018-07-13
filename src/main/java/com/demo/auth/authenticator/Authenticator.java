package com.demo.auth.authenticator;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.beans.User;
import com.demo.dao.UserDao;

public class Authenticator {
	
	@Autowired
	public UserDao userDao;
	
	public boolean authenticate(String username, String password) {
		User user = userDao.getUserByUserName(username);
		if(user.getPassword().equals(password))
			return true;
		return false;
	}
	
}
