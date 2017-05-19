package com.iflytek.movie.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.iflytek.movie.po.Movie;

@Repository("movieDao")
public interface MovieDao {
	
	public void add(Movie movie);
	
	public void update(@Param("mname")String mname,@Param("director")String director,@Param("star")String star,@Param("movieId")int movieId);
	
	public Movie getMovie(int movieId);
	
	public void delete(int movieId);
	
	public int getTotalMovie();
	
	public List<Movie> getMovieList(@Param("pageIndex")int pageIndex,@Param("pageSize")int pageSize);
	
	public int getMyTotalPage(int userId);
	
	public List<Movie> getMyMovieList(@Param("userId")int userId,@Param("pageIndex")int pageIndex,@Param("pageSize")int pageSize);
	

}
