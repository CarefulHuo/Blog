package com.bookStore.admin.user.dao;

import com.bookStore.common.beans.User;

public interface IAdminUserDao {

	User selectUserByUNandPW(User user);

}
