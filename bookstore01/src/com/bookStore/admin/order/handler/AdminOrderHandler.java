package com.bookStore.admin.order.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bookStore.admin.order.service.IAdminOrderService;
import com.bookStore.common.beans.Order;
import com.bookStore.common.beans.OrderItem;

@Controller
@RequestMapping("/admin/orders")
public class AdminOrderHandler {
	
	@Autowired
	private IAdminOrderService adminOrderService;
	
	//全部查询
	@RequestMapping("/findAllOrders.do")
	public String findAllOrders(Model model) {
		List<Order> orders = adminOrderService.findAllOrders();
		model.addAttribute("orders", orders);
		return "/admin/orders/list.jsp";
	}
	
	//根据查询条件查找
	@RequestMapping("/findOrdersByCondition.do")
	public String findOrdersByCondition(String id,String receiverName,Model model) {
		List<Order> orders = adminOrderService.findOrdersByCondition(id,receiverName);
		model.addAttribute("id", id);
		model.addAttribute("receiverName", receiverName);
		model.addAttribute("orders", orders);
		return "/admin/orders/list.jsp";
		
	}
	//根据ID查看订单信息
	@RequestMapping("/findOrderById.do")
	public String findOrderById(String id,Model model) {
		List<OrderItem> items = adminOrderService.findOrderItemById(id);
		model.addAttribute("items", items);
		return "/admin/orders/view.jsp";
		
	}
	
	//根据ID删除订单
	@ResponseBody
	@RequestMapping("/removeOrderById.do")
	public String removeOrderById(String id) {
		int rows =  adminOrderService.removeOrderById(id);
		if(rows > 0) {
			//return "redirect:/admin/orders/findAllOrders.do";
			return "OK";
		}else {
			return "FAIL";
		}
		
	}
	
	

}
