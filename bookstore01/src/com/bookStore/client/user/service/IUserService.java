package com.bookStore.client.user.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bookStore.common.beans.Order;
import com.bookStore.common.beans.OrderItem;
import com.bookStore.common.beans.User;

public interface IUserService {

	User findEmail(String email);

	int addUser(User user, HttpServletRequest request);

	int activeUser(String activeCode);

	User findUserByUNandPW(User user);

	int modifyUser(User user);

	List<Order> findOrderByUser(Integer id);

	List<OrderItem> findOrderItemById(String id);

	void removeOrderById(String id);

	void removeOrderClientById(String id);

}
