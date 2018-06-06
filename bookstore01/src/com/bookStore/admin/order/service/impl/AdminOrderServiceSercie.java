package com.bookStore.admin.order.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bookStore.admin.order.dao.IAdminOrderDao;
import com.bookStore.admin.order.service.IAdminOrderService;
import com.bookStore.common.beans.Order;
import com.bookStore.common.beans.OrderItem;

@Controller
public class AdminOrderServiceSercie implements IAdminOrderService {
	
	@Autowired
	private IAdminOrderDao adminOrderDao;

	@Override
	public List<Order> findAllOrders() {
		return adminOrderDao.selectAllOrders();
	}

	@Override
	public List<OrderItem> findOrderItemById(String id) {
		return adminOrderDao.selectOrderItemById(id);
	}

	@Override
	public List<Order> findOrdersByCondition(String id, String name) {
		Map map = new HashMap();
		map.put("id", id);
		map.put("name", name);
		return adminOrderDao.selectOrdersByCondition(map);
	}

	@Override
	public int removeOrderById(String id) {
		return adminOrderDao.deleteOrderById(id);
	}

}
