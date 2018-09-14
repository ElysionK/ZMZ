package com.tianwen.core.center.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tianwen.core.backstage.entity.TOfflineOrder;
import com.tianwen.core.center.dto.OfflineOrderDto;
import com.tianwen.core.center.dto.OrderSubDetailDto;
import com.tianwen.core.order.entity.Order;
import com.tianwen.core.order.entity.OrderSub;

public interface CenterDao {

	List<Order> listRecentOnlineOrder(@Param("mid") Integer userId, @Param("recentDay") int recentDay);

	List<Order> listOnlineOrders(@Param("mid") Integer userId);

	List<OrderSubDetailDto> listOrderSubDetailByOid(@Param("oid") Integer oid);

	Order findOrderByOid(@Param("oid") Integer oid);

	List<TOfflineOrder> listRecentOfflineOrder(@Param("mid") Integer userId, @Param("recentDay") int recentDay);

	List<TOfflineOrder> listOfflineOrders(@Param("memberNo") String memberNo);

	OfflineOrderDto findOfflineOrderDtoById(@Param("id") Integer id);

}
