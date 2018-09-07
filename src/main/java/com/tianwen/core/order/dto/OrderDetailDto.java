package com.tianwen.core.order.dto;

import java.util.List;

public class OrderDetailDto {

	private List<OrderDto> order;
	private AddressDto address;
	public List<OrderDto> getOrder() {
		return order;
	}
	public void setOrder(List<OrderDto> order) {
		this.order = order;
	}
	public AddressDto getAddress() {
		return address;
	}
	public void setAddress(AddressDto address) {
		this.address = address;
	}
	
	
	
}
