package com.tianwen.core.center.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianwen.common.util.JsonResponseResult;
import com.tianwen.core.backstage.dao.BackDao;
import com.tianwen.core.backstage.dto.OnlineOrderDetail;
import com.tianwen.core.backstage.entity.TOfflineOrder;
import com.tianwen.core.center.dao.CenterDao;
import com.tianwen.core.center.dto.CenterDto;
import com.tianwen.core.center.dto.OfflineOrderDto;
import com.tianwen.core.center.dto.OrderSubDetailDto;
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
	
	@Autowired
	private BackDao backDao;

	@Override
	public CenterDto findCenterDto(User user) {
		Double totalMemberPriceOneYear = centerDao.findTotalMemberPriceOneYear(user.getId());
 		int recentLimit = 8;
		List<Order> onlineOrders = centerDao.listRecentOnlineOrder(user.getId(), recentLimit);
		List<TOfflineOrder> offlineOrders = centerDao.listRecentOfflineOrder(user.getPhone(), recentLimit);
		
		return new CenterDto(user.getPhone(), totalMemberPriceOneYear, onlineOrders, offlineOrders);
	}

	@Override
	public List<Order> listOnlineOrders(Integer userId) {
		return centerDao.listOnlineOrders(userId);
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
	public OfflineOrderDto findOfflineOrderDto(Integer id) {
		return centerDao.findOfflineOrderDtoById(id);
	}

	@Override
	public OnlineOrderDetail findOnlineOrderDetailByOid(Integer oid) {
		return backDao.findOnlineOrderDetailByOid(oid);
	}


}
