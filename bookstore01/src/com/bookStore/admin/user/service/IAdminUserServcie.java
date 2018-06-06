package com.bookStore.admin.user.service;

import com.bookStore.common.beans.User;

public interface IAdminUserServcie {

	User findUserByUNandPW(User user);

}
