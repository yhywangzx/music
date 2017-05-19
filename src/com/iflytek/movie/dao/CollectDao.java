package com.iflytek.movie.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.iflytek.movie.po.Collect;

@Repository("collectDao")
public interface CollectDao {
	
	public void add(Collect collect);
	
	public void delete(int id);
	
	public void deleteByUserId(int movieId);
	
	public int getTotalCollect(int userId);
	
	public List<Collect> getCollectList(@Param("userId")int userId,@Param("pageIndex")int pageIndex,@Param("pageSize")int pageSize);
	
	public Collect getCollect(@Param("userId")int userId,@Param("movieId")int movieId);
}
