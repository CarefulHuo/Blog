package com.bookStore.client.cart.dao;

import java.util.List;

import com.bookStore.common.beans.Order;
import com.bookStore.common.beans.OrderItem;

public interface ICartDao {

	void insertOrder(Order order);

	void insertOrderItem(OrderItem item);

	void updateOrder(String out_trade_no);

	List<OrderItem> selectOrderItemById(String id);

	void updateProductNum(OrderItem item);

}
