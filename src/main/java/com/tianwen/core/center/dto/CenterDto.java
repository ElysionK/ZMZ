package com.tianwen.core.center.dto;

import java.util.List;

import com.tianwen.core.backstage.entity.TOfflineOrder;
import com.tianwen.core.order.entity.Order;
import com.tianwen.core.user.entity.User;

public class CenterDto {
	
	private UserDto userDto;
	private Double totalMemberPriceOneYear;
	private List<Order> onlineOrders;
	private List<TOfflineOrder> offlineOrders;

	public CenterDto(UserDto userDto, List<Order> onlineOrders, List<TOfflineOrder> offlineOrders) {
		this.userDto = userDto;
		this.onlineOrders = onlineOrders;
		this.offlineOrders = offlineOrders;
	}

	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}

	public Double getTotalMemberPriceOneYear() {
		return totalMemberPriceOneYear;
	}

	public void setTotalMemberPriceOneYear(Double totalMemberPriceOneYear) {
		this.totalMemberPriceOneYear = totalMemberPriceOneYear;
	}

	public List<Order> getOnlineOrders() {
		return onlineOrders;
	}

	public void setOnlineOrders(List<Order> onlineOrders) {
		this.onlineOrders = onlineOrders;
	}

	public List<TOfflineOrder> getOfflineOrders() {
		return offlineOrders;
	}

	public void setOfflineOrders(List<TOfflineOrder> offlineOrders) {
		this.offlineOrders = offlineOrders;
	}

	
}
