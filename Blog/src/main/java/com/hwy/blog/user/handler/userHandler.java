package com.hwy.blog.user.handler;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hwy.blog.common.beans.User;
import com.hwy.blog.user.IService.IuserSerivice;

@Controller
@RequestMapping("/blogAdmin")
public class userHandler {
	
	@Autowired
	private IuserSerivice  userService; 
	
	//登录
	@RequestMapping("/login.action")
	public String login(User user,Model model,HttpSession session){
		User login_user = userService.findUser(user);
		String imageCode = (String) session.getAttribute("checkcode_session");
		if(user.getB_code().equals(null)){
			model.addAttribute("message","验证码为空！！！");
			return "/jsp/admin/login.jsp";
		}
		else if(!user.getB_code().equals(imageCode)){
			model.addAttribute("message","验证码错误！！！");
			return "/jsp/admin/login.jsp";
		}
		else if(login_user!=null){
			session.setAttribute("login_user", login_user);
			return "admin";
		}else{
			model.addAttribute("message","用户名或者密码错误！！！");
			return "/jsp/admin/login.jsp";
		}
	}
	//退出
	@RequestMapping("/loginOut.action")
	public String loginOut(HttpSession session){
		session.invalidate();
		return "/blogFind/findBlogs.action";
	}
}
