package com.tianwen.core.user.service;

import com.tianwen.common.util.JsonResponseResult;
import com.tianwen.core.user.entity.User;

public interface UserService {

	JsonResponseResult doRegist(User user);

	JsonResponseResult doLogin(User user);
	
}
