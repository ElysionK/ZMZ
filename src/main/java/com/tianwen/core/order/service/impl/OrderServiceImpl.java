package com.tianwen.core.order.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianwen.common.util.SysUtils;
import com.tianwen.core.backstage.entity.Product;
import com.tianwen.core.order.dao.OrderDao;
import com.tianwen.core.order.entity.Order;
import com.tianwen.core.order.entity.OrderSub;
import com.tianwen.core.order.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;

	@Override
	public List<Product> findAllProducts() {
		return orderDao.findAllProducts();
	}

	@Override
	public void addNewOrder(HashMap<String, Object> map) {
		Order order = new Order();
		List<OrderSub> orderSubs = new ArrayList<>();
		double totalNormal = 0;
		double totalMember = 0;
		int count = 0;
		for (Entry<String, Object> entry : map.entrySet()) {
			Integer pid = Integer.parseInt(entry.getKey());
			Product product = orderDao.findProductByPid(pid);
			
			double normal = product.getOrignalPrice() * Integer.parseInt(entry.getValue().toString());
			double member = product.getDiscountPrice() * Integer.parseInt(entry.getValue().toString());
			OrderSub orderSub = new OrderSub();
			orderSub.setPid(pid);
			orderSub.setProNormalPrice(normal);
			orderSub.setProMemberPrice(member);
			orderSub.setSum(Integer.parseInt(entry.getValue().toString()));
			orderSubs.add(orderSub);
			
			totalNormal += normal;
			totalMember += member;
			count += Integer.parseInt(entry.getValue().toString());
		}
		order.setSum(count);
		order.setNormalPrice(totalNormal);
		order.setMemberPrice(totalMember);
		order.setMid(0);
		order.setOrderTime(SysUtils.getTime());
		
		Integer oid = orderDao.addNewOrder(order);
		List<OrderSub> fullOrder = orderSubs.stream().map(ordersub -> {
			ordersub.setOid(oid);
			return ordersub;
		}).collect(Collectors.toList());
		
		orderDao.addNewOrderSub(fullOrder);
	}

}
