package com.iflytek.movie.service;

import java.util.List;

import com.iflytek.movie.po.Movie;

public interface MovieService {
	
	public void add(Movie movie);
	
	public void update(String mname,String director,String star,int movieId);
	
	public Movie getMovie(int movieId);
	
	public void delete(int movieId);
	
	public int getTotalMovie(int pageSize);
	
	public List<Movie> getMovieList(int pageIndex, int pageSize);
	
	public int getMyTotalPage(int userId,int pageSize);
	
	public List<Movie> getMyMovieList(int userId,int pageIndex, int pageSize);
}
