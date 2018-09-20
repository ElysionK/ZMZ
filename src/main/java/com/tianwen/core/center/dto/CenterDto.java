package com.tianwen.core.center.dto;

import java.util.List;

import com.tianwen.core.backstage.entity.TOfflineOrder;
import com.tianwen.core.order.entity.Order;
import com.tianwen.core.user.entity.User;

public class CenterDto {
	
	private String phone;
	private Double totalMemberPriceOneYear;
	private List<Order> onlineOrders;
	private List<TOfflineOrder> offlineOrders;

	public CenterDto(String phone, Double totalMemberPriceOneYear, List<Order> onlineOrders, List<TOfflineOrder> offlineOrders) {
		this.phone = phone;
		this.totalMemberPriceOneYear = totalMemberPriceOneYear;
		this.onlineOrders = onlineOrders;
		this.offlineOrders = offlineOrders;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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
