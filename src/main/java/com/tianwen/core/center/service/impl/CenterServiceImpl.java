package com.tianwen.core.center.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianwen.common.util.JsonResponseResult;
import com.tianwen.core.backstage.entity.TOfflineOrder;
import com.tianwen.core.center.dao.CenterDao;
import com.tianwen.core.center.dto.CenterDto;
import com.tianwen.core.center.dto.OfflineOrderDto;
import com.tianwen.core.center.dto.OrderSubDetailDto;
import com.tianwen.core.center.service.CenterService;
import com.tianwen.core.order.entity.Order;
import com.tianwen.core.order.entity.OrderSub;
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
		List<TOfflineOrder> offlineOrders = centerDao.listRecentOfflineOrder(userId, recentDay);
		
		
		return null;
	}

	@Override
	public List<Order> listOnlineOrders(Integer userId) {
		return centerDao.listOnlineOrders(userId);
	}

	@Override
	public JsonResponseResult listOrderSubDetailByOid(Integer oid) {
		JsonResponseResult result = JsonResponseResult.createSuccess();
		List<OrderSubDetailDto> dtos = centerDao.listOrderSubDetailByOid(oid);
		result.addData(dtos);
		return result;
	}

	@Override
	public Order findOrderByOid(Integer oid) {
		return centerDao.findOrderByOid(oid);
	}

	@Override
	public List<TOfflineOrder> listOfflineOrders(String memberNo) {
		return centerDao.listOfflineOrders(memberNo);
	}

	@Override
	public OfflineOrderDto findOfflineOrderDtoById(Integer id) {
		return centerDao.findOfflineOrderDtoById(id);
	}

}
