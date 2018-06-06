package com.bookStore.admin.user.handler;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookStore.admin.user.service.IAdminUserServcie;
import com.bookStore.common.beans.User;

@Controller
@RequestMapping("/admin/login")
public class AdminUserHandler {
	
	@Autowired
	private IAdminUserServcie adminUserServcie;
	
	@RequestMapping("/login.do")
	public String login(User user, String remember, String autologin, HttpSession session, Model model,
			HttpServletResponse response, HttpServletRequest request) throws UnsupportedEncodingException {
		User admin_user = adminUserServcie.findUserByUNandPW(user);
		// 用户名和密码正确
		if (admin_user != null) {
			session.setAttribute("admin_user", admin_user);
			
			return "/admin/login/home.jsp";
			// 用户名和密码不正确
		} else {
			model.addAttribute("errors", "用户名或者密码错误！");
			return "/admin/login/login.jsp";
		}

	}

	
}
