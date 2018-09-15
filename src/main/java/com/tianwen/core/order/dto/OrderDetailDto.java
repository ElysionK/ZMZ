package com.tianwen.core.order.dto;

import java.util.List;

<<<<<<< HEAD
import com.tianwen.core.order.entity.Address;

public class OrderDetailDto {

	private List<OrderDto> order;
	private Address address;
=======
public class OrderDetailDto {

	private List<OrderDto> order;
	private AddressDto address;
>>>>>>> a656f0fd398429cbc4355a9fb2981e1567f7f9a3
	public List<OrderDto> getOrder() {
		return order;
	}
	public void setOrder(List<OrderDto> order) {
		this.order = order;
	}
<<<<<<< HEAD
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
=======
	public AddressDto getAddress() {
		return address;
	}
	public void setAddress(AddressDto address) {
>>>>>>> a656f0fd398429cbc4355a9fb2981e1567f7f9a3
		this.address = address;
	}
	
	
	
}
