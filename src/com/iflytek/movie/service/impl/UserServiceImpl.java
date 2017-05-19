package com.iflytek.movie.service.impl;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;

import com.iflytek.movie.dao.UserDao;
import com.iflytek.movie.po.User;
import com.iflytek.movie.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource(name="userDao")
	private UserDao userDao;
	
	

	@Override
	public void add(User user) {
		userDao.add(user);
		
		
	}

	@Override
	public User getUser(String email, String password) {
		
		return userDao.getUser(email, password);
	}

	@Override
	public void updatePassword(int userId, String newPassword) {
		userDao.updatePassword(userId, newPassword);
		
	}

}
