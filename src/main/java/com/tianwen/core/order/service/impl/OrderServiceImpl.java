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
import com.tianwen.core.order.dto.AddressDto;
<<<<<<< HEAD
import com.tianwen.core.order.dto.CartDto;
import com.tianwen.core.order.dto.OrderDetailDto;
import com.tianwen.core.order.dto.OrderDto;
import com.tianwen.core.order.entity.Address;
import com.tianwen.core.order.entity.Cart;
=======
import com.tianwen.core.order.dto.OrderDetailDto;
import com.tianwen.core.order.dto.OrderDto;
>>>>>>> a656f0fd398429cbc4355a9fb2981e1567f7f9a3
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
	public Integer addNewOrder(HashMap<String, Object> map) {
		Order order = new Order();
		List<OrderSub> orderSubs = new ArrayList<>();
		double totalNormal = 0;
		double totalMember = 0;
		int count = 0;
<<<<<<< HEAD
		List<Integer> delCids = new ArrayList<>();
		for (Entry<String, Object> entry : map.entrySet()) {
			Integer pid = Integer.parseInt(entry.getKey().split("\\|")[0]);
			Integer cid = Integer.parseInt(entry.getKey().split("\\|")[1]);
=======
		for (Entry<String, Object> entry : map.entrySet()) {
			Integer pid = Integer.parseInt(entry.getKey());
>>>>>>> a656f0fd398429cbc4355a9fb2981e1567f7f9a3
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
<<<<<<< HEAD
			
			delCids.add(cid);
		}
		
		orderDao.delCartByCid(delCids);
		
		order.setSum(count);
		order.setNormalPrice(totalNormal);
		order.setMemberPrice(totalMember);
		order.setMid(1);
=======
		}
		order.setSum(count);
		order.setNormalPrice(totalNormal);
		order.setMemberPrice(totalMember);
		order.setMid(0);
>>>>>>> a656f0fd398429cbc4355a9fb2981e1567f7f9a3
		order.setOrderTime(SysUtils.getTime());
		
		orderDao.addNewOrder(order);
		List<OrderSub> fullOrder = orderSubs.stream().map(ordersub -> {
			ordersub.setOid(order.getOid());
			return ordersub;
		}).collect(Collectors.toList());
		
		orderDao.addNewOrderSub(fullOrder);
		
		return order.getOid();
	}

	@Override
<<<<<<< HEAD
	public OrderDetailDto findOrderDetail(Integer oid, Integer id, Integer mid) {
		List<OrderDto> orderDto = orderDao.findOrderInfoByOid(oid);
		//AddressDto addressDto = orderDao.findAddressById(orderDto.get(0).getAid());
		Address address = null;
		if(id == 0){
			if(!SysUtils.isEmpty(orderDto.get(0).getAid())){
				address = orderDao.findMemberAddressById(orderDto.get(0).getAid());
			}
		}else{
			address = orderDao.findMemberAddressById(id);
		}
		OrderDetailDto orderDetailDto = new OrderDetailDto();
		orderDetailDto.setOrder(orderDto);
		orderDetailDto.setAddress(address);
=======
	public OrderDetailDto findOrderDetail(Integer oid) {
		List<OrderDto> orderDto = orderDao.findOrderInfoByOid(oid);
		AddressDto addressDto = orderDao.findAddressById(orderDto.get(0).getAid());
		OrderDetailDto orderDetailDto = new OrderDetailDto();
		orderDetailDto.setOrder(orderDto);
		orderDetailDto.setAddress(addressDto);
>>>>>>> a656f0fd398429cbc4355a9fb2981e1567f7f9a3
		return orderDetailDto;
	}

	@Override
	public void confirmOrder(Order order) {
		orderDao.updateOrder(order);
	}

<<<<<<< HEAD
	@Override
	public void addCart(Integer mid, Integer pid, Integer count) {
		Cart cart = orderDao.findCartByPid(pid, mid);
		if(SysUtils.isEmpty(cart)){
			cart = new Cart();
			cart.setPid(pid);
			cart.setMid(mid);
			cart.setQuantity(count);
			cart.setChecked(0);
			cart.setStatus(0);
			orderDao.addCart(cart);
		}else{
			cart.setQuantity(count);
			orderDao.updCartByCid(cart);
		}
	}

	@Override
	public List<Cart> findMembersCarts(Integer mid) {
		return orderDao.findMembersCarts(mid);
	}

	@Override
	public List<CartDto> findMembersCartsDetail(Integer mid) {
		return orderDao.findMembersCartsDetail(mid);
	}

	@Override
	public void updCartChecked(HashMap<String, Object> map) {
		orderDao.updCartChecked(map);
	}

	@Override
	public List<Address> findMemberAddress(Integer mid) {
		return orderDao.findMembersAddress(mid);
	}

	@Override
	public void addNewAddress(HashMap<String, Object> map) {
		orderDao.addNewAddress(map);
	}

	@Override
	public void updDefaultAdd(Address address, Integer mid) {
		orderDao.updDefaultAdd(mid);
		orderDao.updAddress(address);
	}

	@Override
	public void updAddress(HashMap<String, Object> map) {
		Address address = SysUtils.map2Bean(map, Address.class);
		orderDao.updAddress(address);
	}

	@Override
	public void delAddress(Integer id) {
		orderDao.delAddress(id);
	}

	@Override
	public Address findMemberAddressById(Integer id) {
		return orderDao.findMemberAddressById(id);
	}

	@Override
	public void doConfirmOrder(HashMap<String, Object> map) {
		orderDao.doConfirmOrder(map);
	}

=======
>>>>>>> a656f0fd398429cbc4355a9fb2981e1567f7f9a3
	
	
}
