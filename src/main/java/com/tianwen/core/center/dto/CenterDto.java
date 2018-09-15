package com.tianwen.core.center.dto;

import java.util.List;

import com.tianwen.core.backstage.entity.TOfflineOrder;
import com.tianwen.core.order.entity.Order;
import com.tianwen.core.user.entity.User;

public class CenterDto {
	
	private User user;
	private List<Order> onlineOrders;
	private List<TOfflineOrder> offlineOrders;

	public CenterDto(User user, List<Order> onlineOrders, List<TOfflineOrder> offlineOrders) {
		this.user = user;
		this.onlineOrders = onlineOrders;
		this.offlineOrders = offlineOrders;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
