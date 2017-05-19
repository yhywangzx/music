package com.iflytek.movie.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iflytek.movie.po.User;
import com.iflytek.movie.service.UserService;


@Controller
@Scope("prototype")
public class UserController {
	
	@Resource(name="userService")
	private UserService userService;
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String register(){
		return "register";
	}
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public ModelAndView register(User user,String psw){
		ModelAndView mv = new ModelAndView("register");
		
		if(!psw.equals(user.getPassword())){
			mv.addObject("error", "两次密码不一致");
			mv.addObject("email", user.getEmail());
			mv.addObject("name", user.getName());
			
		}else{
			userService.add(user);
			mv.setViewName("redirect:/login");
		}
		return mv;
		
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView login(@CookieValue(value="email",defaultValue="") String email){
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("email", email);
		return mv;
	}
	@ResponseBody
	@RequestMapping(value="/login",method =RequestMethod.POST,produces="text/html; charset=UTF-8")
	public String login(String email,String password,HttpSession session,HttpServletResponse response){
		User user = userService.getUser(email, password);
	if(user != null){
			
			//保存当前用户信息
			session.setAttribute("User", user);
			
			//保存账号到本地
			Cookie c = new Cookie("email", email);
			c.setMaxAge(24*60*60);
			
			response.addCookie(c);
			
			
			return "true";
			
		}else{
			return "false";
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/person/checkpassword",method=RequestMethod.POST,produces="text/html; charset=UTF-8")
	public String checkPassword(HttpSession session,String oldpwd){
		User user = (User) session.getAttribute("User");
		if(user.getPassword().equals(oldpwd)){
			return "true";
		}else{
			return "flase";
		}
	}
	@RequestMapping(value="/person/pwdupdate",method=RequestMethod.GET)
	public String pwdUpdate(){
		return "person/pwdupdate";
	}
	@RequestMapping(value="/person/pwdupdate",method=RequestMethod.POST)
	public ModelAndView pwdUpdate(HttpSession session,String oldpwd,String newpwd,String password,HttpServletResponse response,HttpServletRequest request){
		ModelAndView mv = new ModelAndView("person/pwdupdate");
		
		User user = (User) session.getAttribute("User");
		
		if(oldpwd.equals(user.getPassword())){
			mv.addObject("newmsg", "新密码不能与旧密码相同");
			mv.addObject("oldpwd", oldpwd);
			
		}
		if(newpwd.equals(oldpwd)){
			mv.addObject("newmsg", "新密码不能与旧密码相同");
			mv.addObject("newpwd", newpwd);
			
		}
		if(!newpwd.equals(password)){
			mv.addObject("passwordmsg", "两次密码不一致");
			mv.addObject("password", password);
			
		}
		
		userService.updatePassword(user.getId(), password);
		session.removeAttribute("User");
		
		
		String script = "<script>parent.window.location.href='"
				+ request.getContextPath() + "/login'</script>";
		PrintWriter out;
		
			try {
				out = response.getWriter();
				out.print(script);
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return mv;
		
	}
	@RequestMapping(value="/cancel",method=RequestMethod.GET)
	public String cancel(HttpSession session){
		session.removeAttribute("User");
		return "redirect:/login";
	}
}
