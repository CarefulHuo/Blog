package com.bookStore.client.user.handler;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bookStore.client.user.service.IUserService;
import com.bookStore.common.beans.Order;
import com.bookStore.common.beans.OrderItem;
import com.bookStore.common.beans.User;
import com.bookStore.utils.ActiveCodeUtils;

@RequestMapping("/client/user")
@Controller
public class UserHandler {

	@Autowired
	private IUserService userService;

	@ResponseBody
	@RequestMapping("/findEmail.do")
	public String findEmail(String email) {
		User user = userService.findEmail(email);
		if (user != null) {
			return "EXIST";
		} else {
			return "OK";
		}

	}
	//注册用户页面内容，提交到这个方法
	@RequestMapping("/register.do")
	public String register(User user, HttpServletRequest request) {
		user.setActiveCode(ActiveCodeUtils.createActiveCode());
		int rows = userService.addUser(user, request);
		if (rows > 0) {
			return "/client/registersuccess.jsp";
		} else {
			return "/client/register.jsp";
		}

	}

	@RequestMapping("/activeUser.do")
	public String activeUser(String activeCode) {
		int rows = userService.activeUser(activeCode);
		if (rows > 0) {
			return "/client/myAccount.jsp";
		} else {
			return "/client/register.jsp";
		}

	}

	@RequestMapping("/myAccount.do")
	public String myAccount(HttpSession session,HttpServletRequest request) {
		User login_user = (User) session.getAttribute("login_user");
		System.out.println(login_user);
		if (login_user != null) {
			return "redirect:/client/myAccount.jsp";
		} else {
			// 调用自动登录方法
			login_user = autologin(request);
			if (login_user != null) {//自动 登陆中的user不为空，自动登陆成功
				session.setAttribute("login_user", login_user);
				return "redirect:/client/myAccount.jsp";
			} else {//自动登陆失败
				return "redirect:/client/login.jsp";
			}
		}

	}

	private User autologin( HttpServletRequest request) {
		User user = new User();
		String username = null;
		String password = null;
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if("bookstore_username".equals(cookie.getName())) {
				username = cookie.getValue();
			}
			if("bookstore_password".equals(cookie.getName())) {
				password = cookie.getValue();
			}
		}
		user.setUsername(username);
		user.setPassword(password);
		System.out.println("autologin--findUserByUNandPW"+ userService.findUserByUNandPW(user));
		return userService.findUserByUNandPW(user);
	}

	@RequestMapping("/login.do")
	public String login(User user, String remember, String autologin, HttpSession session, Model model,
			HttpServletResponse response, HttpServletRequest request) throws UnsupportedEncodingException {
		User login_user;
		login_user = userService.findUserByUNandPW(user);
		// 用户名和密码正确
		if (login_user != null) {

			// 用户状态激活
			if (login_user.getState() == 1) {
				session.setAttribute("login_user", login_user);

				if ("1".equals(autologin)) {// 自动登陆
					addCookie(autologin, login_user, response, request);
				} else if ("1".equals(remember)) {// 记住用户名
					addCookie(autologin, login_user, response, request);
				}
				if ("超级用户".equals(login_user.getRole())) {
					System.out.println("sfsdfsdfds");
					return "/admin/login/home.jsp";
				} else {
					return "/client/index.jsp";
				}
			} else {// 用户状态未激活
				model.addAttribute("errors", "该账号未激活，请您去激活！");
				return "/client/login.jsp";
			}
			// 用户名和密码不正确
		} else {
			model.addAttribute("errors", "用户名或者密码错误！");
			return "/client/login.jsp";
		}

	}
	
	@RequestMapping("/findOrderByUser.do")
	public String findOrderByUser(HttpSession session, Model model) {
		User login_user = (User) session.getAttribute("login_user");
		List<Order> orders = userService.findOrderByUser(login_user.getId());
		model.addAttribute("orders", orders);
		return "/client/orderlist.jsp";
		
	}
	
	@RequestMapping("/findOrderById.do")
	public String findOrderById(String id,Model model) {
		List<OrderItem> items = userService.findOrderItemById(id);
		model.addAttribute("items", items);
		return "/client/orderInfo.jsp";
		
	}
	
	@RequestMapping("delOrderById.do")
	public String delOrderById(String id,Model model,String flag) {
		
		if("1".equals(flag)) {
			model.addAttribute("del_errors", "已付款订单删除成功！");
			userService.removeOrderById(id);
		}else {
			model.addAttribute("del_errors", "未付款订单删除成功！");
			userService.removeOrderClientById(id);
		}
		return "redirect:/client/user/findOrderByUser.do";
		
		
	}
	

	public void addCookie(String flag, User user, HttpServletResponse response, HttpServletRequest request)
			throws UnsupportedEncodingException {
		Cookie cookie1 = new Cookie("bookstore_username", URLEncoder.encode(user.getUsername(), "utf-8"));
		cookie1.setPath(request.getContextPath() + "/");
		cookie1.setMaxAge(60 * 60 * 24 * 3);
		response.addCookie(cookie1);
		if ("1".equals(flag)) {
			Cookie cookie2 = new Cookie("bookstore_password", URLEncoder.encode(user.getPassword(), "utf-8"));
			cookie2.setPath(request.getContextPath() + "/");
			cookie2.setMaxAge(60 * 60 * 24 * 3);
			response.addCookie(cookie2);
		}
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session, HttpServletRequest request , HttpServletResponse response) {
		session.removeAttribute("login_user");
		Cookie cookie1 =new Cookie("bookstore_username",null);
		cookie1.setPath(request.getContextPath()+"/");
		Cookie cookie2 =new Cookie("bookstore_password",null);
		cookie2.setPath(request.getContextPath()+"/");
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		return "/client/login.jsp";
		
	}
	
	@RequestMapping("/userInfoModify.do")
	public String userInfoModify(User user,HttpSession session, Model model) {
		User login_user = (User) session.getAttribute("login_user");
		user.setId(login_user.getId());
		int rows = userService.modifyUser(user);
		if(rows > 0) {
			model.addAttribute("errors", "用户信息修改成功，请重新登录！");
			return "/client/login.jsp";
		}else {
			model.addAttribute("errors", "用户信息修改失败");
			return "/client/modifyuserinfo.jsp";
		}
		
	}

}
