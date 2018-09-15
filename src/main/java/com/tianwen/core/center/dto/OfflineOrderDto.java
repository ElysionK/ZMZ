package com.tianwen.core.center.dto;

public class OfflineOrderDto {
	
	private Integer id;
	private String memberNo;
	private String productName;
	private Double orignalPrice;
	private Double memberPrice;
	private Double preferentialPrice;
	private Integer num;
	private String date;
	private Double totalOrignalPrice;
	private Double totalMemberPrice;
	private Double totalPreferentialPrice;
	
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
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Double getTotalOrignalPrice() {
		return totalOrignalPrice;
	}
	public void setTotalOrignalPrice(Double totalOrignalPrice) {
		this.totalOrignalPrice = totalOrignalPrice;
	}
	public Double getTotalMemberPrice() {
		return totalMemberPrice;
	}
	public void setTotalMemberPrice(Double totalMemberPrice) {
		this.totalMemberPrice = totalMemberPrice;
	}
	public Double getTotalPreferentialPrice() {
		return totalPreferentialPrice;
	}
	public void setTotalPreferentialPrice(Double totalPreferentialPrice) {
		this.totalPreferentialPrice = totalPreferentialPrice;
	}
	
	

}
