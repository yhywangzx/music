package com.iflytek.movie.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iflytek.movie.po.Movie;
import com.iflytek.movie.service.MovieService;


@Controller
@Scope("prototype")
public class MovieController {
	@Resource(name="movieService")
	private MovieService movieService;
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index(){
		return "index";
	}
	@RequestMapping(value="/movielist",method=RequestMethod.GET)
	public ModelAndView movieList(){
		ModelAndView mv = new ModelAndView("movielist");
		
		int totalPage = movieService.getTotalMovie(5);
		List<Movie> movieList = movieService.getMovieList(1, 5);
		
		mv.addObject("totalPage", totalPage);
		mv.addObject("movielist", movieList);
		mv.addObject("pageIndex", 1);
		
		return mv;
	}
	@RequestMapping(value="/movielist",method=RequestMethod.POST)
	public ModelAndView movieList(int pageIndex){
		
		ModelAndView mv = new ModelAndView("movielist");
		
		int totalPage = movieService.getTotalMovie(5);
		List<Movie> movieList = movieService.getMovieList(pageIndex,5);
		
		mv.addObject("totalPage", totalPage);
		mv.addObject("movielist", movieList);
		mv.addObject("pageIndex", pageIndex);
		
		return mv;

	}
	@RequestMapping(value="/play",method=RequestMethod.GET)
	public ModelAndView play(int id){
		ModelAndView mv = new ModelAndView("play");
		Movie movie = movieService.getMovie(id);
		
		mv.addObject("movie", movie);
		
		return mv;
		
	}
}
