package com.tianwen.core.center.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianwen.core.center.dao.CenterDao;
import com.tianwen.core.center.dto.CenterDto;
import com.tianwen.core.center.service.CenterService;
import com.tianwen.core.order.entity.Order;
import com.tianwen.core.user.dao.UserDao;
import com.tianwen.core.user.entity.User;

@Service
public class CenterServiceImpl implements CenterService {
	
	@Autowired
	private CenterDao centerDao;
	
	@Autowired 
	private UserDao userDao;

	@Override
	public CenterDto findCenterDto(Integer userId) {
		User user = userDao.findUserById(userId);
		int recentDay = 3;
		List<Order> onlineOrders = centerDao.listRecentOnlineOrder(userId, recentDay);
		
		CenterDto dto = new CenterDto(user, onlineOrders);
		
		return dto;
	}

	@Override
	public List<Order> listOnlineOrders(Integer userId) {
		return centerDao.listOnlineOrders(userId);
	}

}
