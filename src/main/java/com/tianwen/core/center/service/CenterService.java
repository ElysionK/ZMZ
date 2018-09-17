package com.tianwen.core.center.service;

import java.util.List;

import com.tianwen.core.backstage.dto.OnlineOrderDetail;
import com.tianwen.core.backstage.entity.TOfflineOrder;
import com.tianwen.core.center.dto.CenterDto;
import com.tianwen.core.center.dto.OfflineOrderDto;
import com.tianwen.core.order.entity.Order;
import com.tianwen.core.user.entity.User;

public interface CenterService {

	CenterDto findCenterDto(User user);

	List<Order> listOnlineOrders(Integer userId);

	Order findOrderByOid(Integer oid);

	List<TOfflineOrder> listOfflineOrders(String memberNo);

	OfflineOrderDto findOfflineOrderDto(Integer id);

	OnlineOrderDetail findOnlineOrderDetailByOid(Integer oid);


}
