package com.bookStore.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookStore.common.beans.User;

public class AdminLogin implements Filter {

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		String url =request.getRequestURI();
		if(url.endsWith("/login.jsp")||url.endsWith("/login.do")) {
			arg2.doFilter(request, response);
		}else {
			User admin_user = (User) request.getSession().getAttribute("admin_user");
			if(admin_user != null) {
					arg2.doFilter(request, response);
				}else {
					response.sendRedirect(request.getContextPath()+"/admin/error/privilege.jsp");
					
				}
			}
		}
	}

