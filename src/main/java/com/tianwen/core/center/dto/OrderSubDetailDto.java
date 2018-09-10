package com.tianwen.core.center.dto;

public class OrderSubDetailDto {
	
	private Integer olid;
	private String productName;
	private double proNormalPrice;
	private double proMemberPrice;
	private Integer sum;
	
	public Integer getOlid() {
		return olid;
	}
	public void setOlid(Integer olid) {
		this.olid = olid;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProNormalPrice() {
		return proNormalPrice;
	}
	public void setProNormalPrice(double proNormalPrice) {
		this.proNormalPrice = proNormalPrice;
	}
	public double getProMemberPrice() {
		return proMemberPrice;
	}
	public void setProMemberPrice(double proMemberPrice) {
		this.proMemberPrice = proMemberPrice;
	}
	public Integer getSum() {
		return sum;
	}
	public void setSum(Integer sum) {
		this.sum = sum;
	}
	
	

}
