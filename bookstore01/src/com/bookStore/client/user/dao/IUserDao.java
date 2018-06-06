package com.bookStore.client.user.dao;

import java.util.List;

import com.bookStore.common.beans.Order;
import com.bookStore.common.beans.OrderItem;
import com.bookStore.common.beans.User;

public interface IUserDao {

	User selectEmail(String email);

	int insertUser(User user);

	int updateUserByActiveCode(String activeCode);

	User selectUserByUNandPW(User user);

	int updateUserById(User user);

	List<Order> selectOrderByUser(Integer id);

	List<OrderItem> selectOrderItemById(String id);

	void deleteOrderById(String id);

	void deleteOrderItemById(String id);

	void updateProductNum(OrderItem item);

}
