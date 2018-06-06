package com.bookStore.admin.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.admin.user.dao.IAdminUserDao;
import com.bookStore.admin.user.service.IAdminUserServcie;
import com.bookStore.common.beans.User;

@Service
public class AdminUserServcieImpl implements IAdminUserServcie {
	
	@Autowired
	private IAdminUserDao adminUserDao;

	@Override
	public User findUserByUNandPW(User user) {
		
		return adminUserDao.selectUserByUNandPW(user);
	}

}
