package com.tianwen.core.order.service;

import java.util.HashMap;
import java.util.List;

import com.tianwen.core.backstage.entity.Product;

public interface OrderService {

	List<Product> findAllProducts();
	
	void addNewOrder(HashMap<String, Object> map);

}
