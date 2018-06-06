package com.bookStore.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.bookStore.common.beans.User;



public class Login_Tag extends SimpleTagSupport{
	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		//这个域可以获取其他8个域的对象
		   PageContext context=(PageContext) this.getJspContext();
		   HttpServletRequest request=(HttpServletRequest) context.getRequest();
		   HttpServletResponse response=(HttpServletResponse) context.getResponse();
		  User login_user=(User) context.getSession().getAttribute("login_user");
		  if(login_user==null)
		  {
			  response.sendRedirect(request.getContextPath()+"/client/error/privilege.jsp");
		  }
		 
	}

}
