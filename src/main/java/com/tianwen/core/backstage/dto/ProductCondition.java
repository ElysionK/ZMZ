package com.tianwen.core.backstage.dto;

import java.io.Serializable;

import com.tianwen.base.util.Pager;

public class ProductCondition implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9062176909880623438L;
	
	private String name;
	private Integer category;
	private Double minPrice;
	private Double maxPrice;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCategory() {
		return category;
	}
	public void setCategory(Integer category) {
		this.category = category;
	}
	public Double getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}
	public Double getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(Double maxPrice) {
		this.maxPrice = maxPrice;
	}
	

}
