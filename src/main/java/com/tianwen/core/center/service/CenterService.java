package com.tianwen.core.center.service;

import java.util.List;

import com.tianwen.common.util.JsonResponseResult;
import com.tianwen.core.center.dto.CenterDto;
import com.tianwen.core.order.entity.Order;

public interface CenterService {

	CenterDto findCenterDto(Integer userId);

	List<Order> listOnlineOrders(Integer userId);

	JsonResponseResult listOrderSubDetailByOid(Integer oid);

	Order findOrderByOid(Integer oid);

}
