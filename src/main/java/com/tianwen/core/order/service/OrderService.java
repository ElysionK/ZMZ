package com.tianwen.core.order.service;

import java.util.HashMap;
import java.util.List;

import com.tianwen.core.backstage.entity.Product;
import com.tianwen.core.order.dto.CartDto;
import com.tianwen.core.order.dto.OrderDetailDto;
import com.tianwen.core.order.entity.Address;
import com.tianwen.core.order.entity.Cart;
import com.tianwen.core.order.entity.Order;

public interface OrderService {

	List<Product> findAllProducts();
	
	Integer addNewOrder(HashMap<String, Object> map);
	
	OrderDetailDto findOrderDetail(Integer oid, Integer id, Integer mid);
	
	void confirmOrder(Order order);
	
	void addCart(Integer mid, Integer pid, Integer count);
	
	List<Cart> findMembersCarts(Integer mid);
	
	List<CartDto> findMembersCartsDetail(Integer mid);
	
	void updCartChecked(HashMap<String, Object> map);
	
	List<Address> findMemberAddress(Integer mid);
	
	void addNewAddress(HashMap<String, Object> map);
	
	void updDefaultAdd(Address address, Integer mid);
	
	void updAddress(HashMap<String, Object> map);
	
	void delAddress(Integer id);
	
	Address findMemberAddressById(Integer id);
	
	void doConfirmOrder(HashMap<String, Object> map);

}
