package com.tianwen.core.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianwen.common.util.JsonResponseResult;
import com.tianwen.common.util.SysUtils;
import com.tianwen.core.backstage.dao.BackDao;
import com.tianwen.core.backstage.entity.RegistCode;
import com.tianwen.core.user.dao.UserDao;
import com.tianwen.core.user.entity.User;
import com.tianwen.core.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BackDao backDao;

	@Override
	public JsonResponseResult doRegist(User user) {
		RegistCode registCode = backDao.findByCodeAndStatus(user.getRegistCode(), RegistCode.VALID);
		if (registCode == null) {
			return JsonResponseResult.createFalied("注册码无效");
		}
		User existUser = userDao.findUserByPhone(user.getPhone());
		if (existUser != null) {
			return JsonResponseResult.createFalied("手机号已被注册");
		}
		
		user.setPassword(SysUtils.retMd5Pwd(user.getPassword()));
		user.setRegistTime(SysUtils.getTime());
		userDao.addUser(user);
		
		RegistCode updRegistCode = new RegistCode(user.getRegistCode(), RegistCode.UN_VALIDE, user.getPhone());
		backDao.updRegistCode(updRegistCode);
		
		return JsonResponseResult.createSuccess();
	}

	@Override
	public JsonResponseResult doLogin(User user) {
		User existUser = userDao.findUserByPhoneAndPassword(user.getPhone(), SysUtils.retMd5Pwd(user.getPassword()));
		if (existUser == null) {
			return JsonResponseResult.createFalied("用户名或密码错误");
		} else {
			return JsonResponseResult.createSuccess();
		}
	}


}
