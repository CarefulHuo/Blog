package com.hwy.blog.fillter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginFilter implements Filter {

	public void doFilter(ServletRequest rq, ServletResponse rp, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) rq;
		HttpServletResponse response = (HttpServletResponse) rp;
		
		String [] URI = {"/","/jsp/login.jsp","/blogFind/findBlogs.action","/blogFind/findBlogByOne.action","/blogFind/fingGuiDangDate.action",
						  "/jsp/index.jsp","/blogAdmin/selectBlog.action","/blogAdmin/login.action","/blogFind/findBlogByDate.action",
						  "/jsp/abountme.jsp","/blogFind/aboutme.action","/blogFind/findStudentNote.action"};
		
		//项目路径
		String contextURI = request.getContextPath();
		//访问路径
		String requestURI = request.getRequestURI();
		//去除项目后的路径
		String resultURI = requestURI.substring(contextURI.length());
		for(int i=0 ;i<URI.length ;i++){
			if(resultURI.equals(URI[i])){
				arg2.doFilter(request, response);
				return;
			}
		}
		if(request.getSession().getAttribute("login_user")!=null){
			arg2.doFilter(request, response);
			return;
		}else{
			request.setAttribute("message", "请登录后访问！！！");
			request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
			return;
		}
		
		
	}

}
