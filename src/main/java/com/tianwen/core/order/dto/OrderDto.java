package com.tianwen.core.order.dto;

public class OrderDto {

	private Integer pid;
	private String name;
	private Integer total;
	private Double normalPrice;
	private Double memberPrice;
	private Double proNormalPrice;
	private Double proMemberPrice;
	private Integer sum;
	private Integer aid;
	private Integer oid;
	
	
	
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
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
	public Integer getSum() {
		return sum;
	}
	public void setSum(Integer sum) {
		this.sum = sum;
	}

	
}
