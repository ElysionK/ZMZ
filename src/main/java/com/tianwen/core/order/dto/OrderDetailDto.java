package com.tianwen.core.order.dto;

import java.util.List;

import com.tianwen.core.order.entity.Address;

public class OrderDetailDto {

	private List<OrderDto> order;
	private Address address;
	public List<OrderDto> getOrder() {
		return order;
	}
	public void setOrder(List<OrderDto> order) {
		this.order = order;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
}
