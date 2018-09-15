package com.tianwen.core.backstage.dto;

public class OrderSubDetail {
	
	private Integer olid;
	private String productName;
	private Double originPrice;
	private Double discountPrice;
	private Double proNormalPrice;
	private Double proMemberPrice;
	private Integer num;
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
	public Double getOriginPrice() {
		return originPrice;
	}
	public void setOriginPrice(Double originPrice) {
		this.originPrice = originPrice;
	}
	public Double getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice;
	}
	public Double getProNormalPrice() {
		return proNormalPrice;
	}
	public void setProNormalPrice(Double proNormalPrice) {
		this.proNormalPrice = proNormalPrice;
	}
	public Double getProMemberPrice() {
		return proMemberPrice;
	}
	public void setProMemberPrice(Double proMemberPrice) {
		this.proMemberPrice = proMemberPrice;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	
}
