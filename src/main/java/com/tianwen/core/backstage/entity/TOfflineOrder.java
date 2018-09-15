package com.tianwen.core.backstage.entity;

public class TOfflineOrder {
	
	private Integer id;
	private String memberNo;
	private String productName;
	private Double orignalPrice;
	private Double memberPrice;
	private Double preferentialPrice;
	private Double num;
	private String date;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getOrignalPrice() {
		return orignalPrice;
	}
	public void setOrignalPrice(Double orignalPrice) {
		this.orignalPrice = orignalPrice;
	}
	public Double getMemberPrice() {
		return memberPrice;
	}
	public void setMemberPrice(Double memberPrice) {
		this.memberPrice = memberPrice;
	}
	public Double getPreferentialPrice() {
		return preferentialPrice;
	}
	public void setPreferentialPrice(Double preferentialPrice) {
		this.preferentialPrice = preferentialPrice;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Double getNum() {
		return num;
	}
	public void setNum(Double num) {
		this.num = num;
	}

}
