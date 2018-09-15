package com.tianwen.core.backstage.dto;

import java.io.Serializable;

public class CategoryDto implements Serializable{

	private static final long serialVersionUID = -3957564965030772335L;
	
	private Integer id;
	private String name;
	private String img;
	private String createtime;
	private Integer sort;
	
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
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
}
