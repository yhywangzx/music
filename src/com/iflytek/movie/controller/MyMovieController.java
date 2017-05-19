package com.iflytek.movie.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iflytek.movie.po.Movie;
import com.iflytek.movie.po.User;
import com.iflytek.movie.service.MovieService;


@Controller
@Scope("prototype")
public class MyMovieController {
	@Autowired
	private MovieService movieService;
	
	@RequestMapping(value="/person/mymovielist",method = RequestMethod.GET)
	public ModelAndView myMovieList(HttpSession session){
		ModelAndView mv = new ModelAndView("person/mymovielist");
		
		User user = (User) session.getAttribute("User");
		
		int totalPage = movieService.getMyTotalPage(user.getId(), 5);
		List<Movie> movieList = movieService.getMyMovieList(user.getId(), 1, 5);
		
		mv.addObject("totalPage", totalPage);
		mv.addObject("movieList", movieList);
		mv.addObject("pageIndex", 1);
		
		return mv;
	
	}
	@RequestMapping(value="/person/mymovielist",method = RequestMethod.POST)
	public ModelAndView myMovieList(HttpSession session,int pageIndex){
		ModelAndView mv = new ModelAndView("person/mymovielist");
		
		User user = (User) session.getAttribute("User");
		
		int totalPage = movieService.getMyTotalPage(user.getId(), 5);
		List<Movie> movieList = movieService.getMyMovieList(user.getId(), pageIndex, 5);
		
		mv.addObject("totalPage", totalPage);
		mv.addObject("movieList", movieList);
		mv.addObject("pageIndex", pageIndex);
		
		return mv;
	}
	@RequestMapping(value="/person/uploadmovie",method = RequestMethod.GET)
	public String upLoadMovie(){
		return "person/uploadmovie";
	}
	
	@RequestMapping(value="/person/uploadmovie",method = RequestMethod.POST)
	public String upLoadMovie(HttpSession session,HttpServletRequest request){
		User user = (User) session.getAttribute("User");
		//对提交的数据进行处理，保存上传文件	
				boolean success = processUpload(request);
						
				if(success){
					//获取表单text控件的值
					String mname = request.getAttribute("mname").toString().trim();
					System.out.println(mname);
							
					String director = request.getAttribute("director").toString().trim();
					System.out.println(director);
					
					String star = request.getAttribute("star").toString().trim();
					System.out.println(star);
					
					String time = request.getAttribute("time").toString().trim();
					System.out.println(time);
					//获取文件上传的原始名称
					String fileName = request.getAttribute("upfile").toString().trim();
					System.out.println(fileName);
					
					//获取文件上传后，服务器上保存的名字
					String fileNameServer = request.getAttribute("upfileServer").toString();
					System.out.println(fileNameServer);
					
					request.setAttribute("upfile", fileNameServer);
					
					request.setAttribute("message", "上传成功");
					
					Movie movie = new Movie();
					movie.setUserId(user.getId());
					movie.setMname(mname);
					movie.setDirector(director);
					movie.setStar(star);
					movie.setTime(time);
					movie.setPath(fileNameServer);
					
					
					movieService.add(movie);
	}
				return "redirect:/person/mymovielist";
}
	private boolean processUpload(HttpServletRequest request) {
		boolean success = true;
		String message = null;
		// 获取文件需要上传到的路径
		String path = request.getServletContext().getRealPath("/movie");
		System.out.println(path);
		// 如果此文件夹不存在，则构造此文件夹
		File f = new File(path);
		if (!f.exists()) {
			f.mkdir();
		}
		// 构造出文件工厂，用于存放JSP页面中传递过来的文件
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 设置上传文件的保存路径
		factory.setRepository(f);
		// 设置缓存大小，如果文件大于缓存大小时，则先把文件放到缓存中
		factory.setSizeThreshold(1 * 1024 * 1024);

		ServletFileUpload upload = new ServletFileUpload(factory);
		// 设置可以上传文件大小的上界20MB
		upload.setSizeMax(20 * 1024 * 1024);
		try {
			// 可以上传多个文件
			List<FileItem> list = (List<FileItem>) upload.parseRequest(request);
			for (FileItem item : list) {
				// 获取表单的属性名字
				String name = item.getFieldName();

				if (item.isFormField()) {
					String value = item.getString();
					//解决乱码问题
					value = new String(value.getBytes("iso-8859-1"),"utf-8"); 
					request.setAttribute(name, value);
				} else {
					// 获得文件类型
					String contentType = item.getContentType();
					// 获得文件大小
					long fileSize = item.getSize();
					// 获取路径名
					String value = item.getName();
					// 索引到最后一个反斜杠
					int start = value.lastIndexOf("\\");
					// 截取 上传文件的 字符串名字，加1是 去掉反斜杠，
					String filename = value.substring(start + 1);

					if (filename != null && !filename.trim().equals("")) {
						// 如果上传的文件不是图片，那么不上传
						String allImgExt = ".mp4|.mp3|.png|.jpg|";
						String extName = filename.substring(filename.indexOf("."), filename.length());
						if (allImgExt.indexOf(extName + "|") == -1) {
							message = "该文件类型不允许上传。请上传 " + allImgExt
									+ " 类型的文件，当前文件类型为" + extName;
							success = false;
							break;
						}
						request.setAttribute(name, filename);
						// 随机数产生名称
						String newName = System.currentTimeMillis() + extName;
						request.setAttribute(name + "Server", newName);
						// 将文件保存到服务器中
						InputStream in = item.getInputStream();
						// 原文件名
						// OutputStream out = new FileOutputStream(new File(path, filename));
						// 随机数文件名
						OutputStream out = new FileOutputStream(new File(path,
								newName));
						int length = 0;
						byte[] buf = new byte[1024];
						while ((length = in.read(buf)) != -1) {
							out.write(buf, 0, length);
						}
						in.close();
						out.close();
					}
				}
			}
		} catch (FileUploadException e) {
			message = "文件的内容过大，请上传小于20MB的文件" ;
			success = false;
			e.printStackTrace();
		} catch (IOException e) {
			success = false;
			e.printStackTrace();
		}
		request.setAttribute("message", message);
		return success;
	}
	@RequestMapping(value="/person/updatemovie",method=RequestMethod.GET)
	public ModelAndView Update(int id){
		ModelAndView mv = new ModelAndView("person/updatemovie");
		mv.addObject("id", id);
		return mv;
		
	}
	@RequestMapping(value="/person/updatemovie",method=RequestMethod.POST)
	public String update(int id,String mname,String director,String star){
		movieService.update(mname, director, star,id);
		return "redirect:/person/mymovielist";
	}
	@RequestMapping(value="/download",method=RequestMethod.GET)
	public void download(int id,HttpServletRequest request,HttpServletResponse response){
		Movie movie = movieService.getMovie(id);
		processDownload(movie.getPath(), movie.getMname()+".mp3", request, response);
		
		
	}
	private boolean processDownload(String  fileName, String saveName,
			HttpServletRequest request, HttpServletResponse response) {

		boolean success = true;
		// 获取文件下载所在的路径
		String path = request.getServletContext().getRealPath("/movie");
		File fileLoad = new File(path, fileName); // 下载文件
		long fileLength = fileLoad.length(); // 文件大小
		byte[] buffer = new byte[1024]; // 缓冲字节数组
		try {
			response.reset();
			response.setHeader("Content-disposition", "attachment;filename=\""
					+ new String(saveName.getBytes("gb2312"), "ISO-8859-1")	+ "\"");
			response.setContentType("application/octet-stream");
			response.setHeader("Content_Length", String.valueOf(fileLength));

			OutputStream os = response.getOutputStream();
			FileInputStream in = new FileInputStream(fileLoad);
			int hasRead = 0;
			while ((hasRead = in.read(buffer)) != -1) {
				os.write(buffer, 0, hasRead);
			}
			os.flush();
			os.close();
			in.close();
		} catch (IOException e) {
			success = false;
			e.printStackTrace();
		}
		return success;
		
	}
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(int id){
		movieService.delete(id);
		return "redirect:/person/mymovielist";
		
	}
}