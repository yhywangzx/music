package com.iflytek.movie.controller;



import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import org.springframework.web.servlet.ModelAndView;

import com.iflytek.movie.po.Collect;
import com.iflytek.movie.po.User;
import com.iflytek.movie.service.CollectService;


@Controller
@Scope("prototype")
public class MyCollectController {
	@Resource(name="collectService")
	private CollectService collectService;
	
	@RequestMapping(value="/person/collect",method=RequestMethod.GET)
	public String collect(HttpSession session,int id){
		
		
		User user = (User) session.getAttribute("User");
		
		Collect collect = collectService.getCollect(user.getId(),id);
		
		if (collect != null) {
			return "redirect:/movielist";
			
		} else {
			Collect c = new Collect();
			c.setMovieId(id);
			c.setUserId(user.getId());
			collectService.add(c);
			
			return "redirect:/person/mycollection";
			
		}
	}
	@RequestMapping(value="/person/mycollection",method=RequestMethod.GET)
	public ModelAndView myCollection(HttpSession session){
		ModelAndView mv =new ModelAndView("person/mycollection");
		
		User user = (User) session.getAttribute("User");
		
		int totalPage = collectService.getTotalCollect(user.getId(), 5);
		List<Collect> collectList = collectService.getCollectList(user.getId(), 1, 5);
		
		mv.addObject("collectList", collectList);
		mv.addObject("pageIndex", 1);
		mv.addObject("totalPage", totalPage);
		
		return mv;
	}
	@RequestMapping(value="/person/mycollection",method=RequestMethod.POST)
	public ModelAndView myCollection(HttpSession session,int pageIndex){
		ModelAndView mv =new ModelAndView("person/mycollection");
		
		User user = (User) session.getAttribute("User");
		
		int totalPage = collectService.getTotalCollect(user.getId(), 5);
		List<Collect> collectList = collectService.getCollectList(user.getId(), pageIndex, 5);
		
		mv.addObject("collectList", collectList);
		mv.addObject("pageIndex", pageIndex);
		mv.addObject("totalPage", totalPage);
		
		return mv;
	}
	@RequestMapping(value="/deletecollect",method=RequestMethod.GET)
	public String deleteCollect(int id){
		collectService.delete(id);
		
		return "redirect:/person/mycollection";
	}
}
