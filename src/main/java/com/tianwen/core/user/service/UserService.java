package com.tianwen.core.user.service;

import java.util.List;

import com.tianwen.common.util.JsonResponseResult;
import com.tianwen.core.user.entity.Area;
import com.tianwen.core.user.entity.User;

public interface UserService {

	JsonResponseResult doRegist(User user);

	JsonResponseResult doLogin(User user);
	
}
