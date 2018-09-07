package com.tianwen.core.center.dto;

import java.util.List;

import com.tianwen.core.order.entity.Order;
import com.tianwen.core.user.entity.User;

public class CenterDto {
	
	private User user;
	private List<Order> onlineOrders;

	public CenterDto(User user, List<Order> onlineOrders) {
		this.user = user;
		this.onlineOrders = onlineOrders;
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

	
}
