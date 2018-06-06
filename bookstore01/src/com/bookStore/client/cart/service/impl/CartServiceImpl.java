package com.bookStore.client.cart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.client.cart.dao.ICartDao;
import com.bookStore.client.cart.service.ICartService;
import com.bookStore.common.beans.Order;
import com.bookStore.common.beans.OrderItem;

@Service
public class CartServiceImpl implements ICartService {
	
	@Autowired
	private ICartDao cartDao;


	@Override
	public void createOrder(Order order) {
		List<OrderItem> items = cartDao.selectOrderItemById(order.getId());
		for (OrderItem item : items) {
			cartDao.updateProductNum(item );
		}
		order.setPaystate(0);
		cartDao.insertOrder(order);
	}

	@Override
	public void addOrderItem(OrderItem item) {
		cartDao.insertOrderItem(item);
	}

	@Override
	public void paySuccess(String out_trade_no) {
		cartDao.updateOrder(out_trade_no);
	}

}
