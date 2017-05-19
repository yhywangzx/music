package com.iflytek.movie.dao;

import static org.junit.Assert.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import com.iflytek.movie.po.User;



public class TestUserDao {

	private static SqlSession session;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//读取mybaties配置文件
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
		
		//打开session,后期用于获取接口对象
		session = sessionFactory.openSession();
	}

	@Test
	public void testAdd() {
		UserDao dao = session.getMapper(UserDao.class);
		
		User user = new User();
		user.setEmail("1111@qq.com");
		user.setName("王子祥");
		user.setPassword("123456");
		
		dao.add(user);
		session.commit();
		
	}

}
