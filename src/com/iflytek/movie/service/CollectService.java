package com.iflytek.movie.service;

import java.util.List;

import com.iflytek.movie.po.Collect;

public interface CollectService {
	
	public void add(Collect collect);
	
	public void delete(int id);
	
	public int getTotalCollect(int userId,int pageSize);
	
	public List<Collect> getCollectList(int userId,int pageIndex,int pageSize);
	
	public Collect getCollect(int userId,int movieId);
}
