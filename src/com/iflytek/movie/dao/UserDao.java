package com.iflytek.movie.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.iflytek.movie.po.User;


@Repository("userDao")
public interface UserDao {
	
	public void add(User user);
	
	public User getUser(@Param("email")String email,@Param("password")String password);
	
	public void updatePassword(@Param("userId")int userId,@Param("newPassword")String newPassword);
}
