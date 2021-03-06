package com.tianwen.core.order.entity;

public class Order {

	private Integer oid;
	private Integer mid;
	private Integer sum;
	private double normalPrice;
	private double memberPrice;
	private String orderTime;
	private String deliverTime;
	private Integer aid;
	private Integer status;
	
	
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public Integer getSum() {
		return sum;
	}
	public void setSum(Integer sum) {
		this.sum = sum;
	}
	public double getNormalPrice() {
		return normalPrice;
	}
	public void setNormalPrice(double normalPrice) {
		this.normalPrice = normalPrice;
	}
	public double getMemberPrice() {
		return memberPrice;
	}
	public void setMemberPrice(double memberPrice) {
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
	
	
}
