package com.iflytek.movie.service.impl;

import java.util.List;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;

import com.iflytek.movie.dao.CollectDao;
import com.iflytek.movie.po.Collect;
import com.iflytek.movie.service.CollectService;


@Service("collectService")
public class CollectServiceImpl implements CollectService {
	@Resource(name="collectDao")
	private CollectDao collectDao;
	
	@Override
	public void add(Collect collect) {
		collectDao.add(collect);
		
	}

	@Override
	public void delete(int id) {
		collectDao.delete(id);
		
	}

	@Override
	public int getTotalCollect(int userId,int pageSize) {
		int a = collectDao.getTotalCollect(userId);
		if( a % pageSize ==0){
			return a / pageSize;
		}else{
			return a / pageSize + 1;
		}
	}

	@Override
	public List<Collect> getCollectList(int userId, int pageIndex, int pageSize) {
		int count = (pageIndex - 1)*pageSize;
		return collectDao.getCollectList(userId, count, pageSize);
	}

	@Override
	public Collect getCollect(int userId, int movieId) {
		
		return collectDao.getCollect(userId, movieId);
	}

}
