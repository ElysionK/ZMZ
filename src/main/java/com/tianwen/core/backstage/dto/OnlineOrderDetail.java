package com.tianwen.core.backstage.dto;

import java.util.List;

public class OnlineOrderDetail {
	
	private Integer oid;
	private String phone;
	private String address;
	private Double normalPrice;
	private Double memberPrice;
	private String orderTime;
	private String deliverTime;
	private Integer status;
	private List<OrderSubDetail> orderSubDetails;
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Double getNormalPrice() {
		return normalPrice;
	}
	public void setNormalPrice(Double normalPrice) {
		this.normalPrice = normalPrice;
	}
	public Double getMemberPrice() {
		return memberPrice;
	}
	public void setMemberPrice(Double memberPrice) {
		this.memberPrice = memberPrice;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public String getDeliverTime() {
		return deliverTime;
	}
	public void setDeliverTime(String deliverTime) {
		this.deliverTime = deliverTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public List<OrderSubDetail> getOrderSubDetails() {
		return orderSubDetails;
	}
	public void setOrderSubDetails(List<OrderSubDetail> orderSubDetails) {
		this.orderSubDetails = orderSubDetails;
	}
	
	

}
