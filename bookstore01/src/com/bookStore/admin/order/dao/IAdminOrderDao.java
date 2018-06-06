package com.bookStore.admin.order.dao;

import java.util.List;
import java.util.Map;

import com.bookStore.common.beans.Order;
import com.bookStore.common.beans.OrderItem;

public interface IAdminOrderDao {

	List<Order> selectAllOrders();

	List<OrderItem> selectOrderItemById(String id);

	List<Order> selectOrdersByCondition(Map map);

	int deleteOrderById(String id);

}
