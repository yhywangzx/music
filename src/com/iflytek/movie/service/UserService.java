package com.iflytek.movie.service;

import com.iflytek.movie.po.User;

public interface UserService {
	
	public void add(User user);
	
	public User getUser(String email,String password);
	
	public void updatePassword(int userId,String newPassword);
}
