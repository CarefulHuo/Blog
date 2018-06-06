package com.bookStore.client.cart.service;

import com.bookStore.common.beans.Order;
import com.bookStore.common.beans.OrderItem;

public interface ICartService {

	void addOrderItem(OrderItem item);

	void createOrder(Order order);

	void paySuccess(String out_trade_no);

}
