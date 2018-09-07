package com.tianwen.core.order.service;

import java.util.HashMap;
import java.util.List;

import com.tianwen.core.backstage.entity.Product;
import com.tianwen.core.order.dto.OrderDetailDto;
import com.tianwen.core.order.entity.Order;

public interface OrderService {

	List<Product> findAllProducts();
	
	Integer addNewOrder(HashMap<String, Object> map);
	
	OrderDetailDto findOrderDetail(Integer oid);
	
	void confirmOrder(Order order);

}
