package com.bookStore.admin.order.service;

import java.util.List;

import com.bookStore.common.beans.Order;
import com.bookStore.common.beans.OrderItem;

public interface IAdminOrderService {

	List<Order> findAllOrders();

	List<OrderItem> findOrderItemById(String id);

	List<Order> findOrdersByCondition(String id, String name);

	int removeOrderById(String id);

}
