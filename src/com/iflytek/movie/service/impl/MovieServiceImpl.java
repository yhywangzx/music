package com.iflytek.movie.service.impl;

import java.util.List;





import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iflytek.movie.dao.CollectDao;
import com.iflytek.movie.dao.MovieDao;
import com.iflytek.movie.po.Movie;
import com.iflytek.movie.service.MovieService;

@Service("movieService")
public class MovieServiceImpl implements MovieService{
	@Resource(name="movieDao")
	private MovieDao movieDao;
	@Resource(name="collectDao")
	private CollectDao collectDao;
	
	@Override
	public void add(Movie movie) {
		movieDao.add(movie);
		
	}

	@Override
	public void update(String mname, String director, String star, int movieId) {
		movieDao.update(mname, director, star, movieId);
		
	}

	@Override
	public Movie getMovie(int movieId) {
		return movieDao.getMovie(movieId);
	}

	@Override
	public void delete(int movieId) {
		collectDao.deleteByUserId(movieId);
		movieDao.delete(movieId);
		
	}

	@Override
	public int getTotalMovie(int pageSize) {
		int a = movieDao.getTotalMovie();
		if(a % pageSize == 0 ){
			return a/pageSize;
		}else{
			return a/pageSize + 1;
		}
	}

	@Override
	public List<Movie> getMovieList(int pageIndex, int pageSize) {
		int count = (pageIndex-1)*pageSize;
		
		return movieDao.getMovieList(count, pageSize);
	}

	@Override
	public int getMyTotalPage(int userId,int pageSize) {
		int a = movieDao.getMyTotalPage(userId);
		if(a % pageSize ==0){
			return a/pageSize;
		}else{
			return a/pageSize+1;
		}
	}

	@Override
	public List<Movie> getMyMovieList(int userId, int pageIndex, int pageSize) {
		int count = (pageIndex-1)*pageSize;
		
		return movieDao.getMyMovieList(userId, count, pageSize);
	}

}
