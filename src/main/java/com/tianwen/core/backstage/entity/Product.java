package com.tianwen.core.backstage.entity;

public class Product {
	
	private Integer id;
	
	private String name;
	
	private Integer category;
	
	private String img;
	
	private Double orignalPrice;
	
	private Double discountPrice;
	
	private String breif;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Double getOrignalPrice() {
		return orignalPrice;
	}

	public void setOrignalPrice(Double orignalPrice) {
		this.orignalPrice = orignalPrice;
	}

	public Double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice;
	}

	public String getBreif() {
		return breif;
	}

	public void setBreif(String breif) {
		this.breif = breif;
	}
	
}
