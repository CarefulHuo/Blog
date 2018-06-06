package com.hwy.blog.user.IService.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hwy.blog.common.beans.User;
import com.hwy.blog.user.IService.IuserSerivice;
import com.hwy.blog.user.dao.IUserDao;

@Service
public class userServiceImpl implements IuserSerivice {

	@Autowired
	private IUserDao userDao;
	
	public User findUser(User user) {
		return userDao.selectUser(user);
	}

}
