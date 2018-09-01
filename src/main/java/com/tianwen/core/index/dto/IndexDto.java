package com.tianwen.core.index.dto;

import java.util.List;

import com.tianwen.core.backstage.dto.CategoryDto;
import com.tianwen.core.backstage.entity.Banner;

public class IndexDto {
	
	private List<CategoryDto> categories;
	
	private List<Banner> banners;

	public List<CategoryDto> getCategories() {
		return categories;
	}

	public List<Banner> getBanners() {
		return banners;
	}

	public void setCategories(List<CategoryDto> categories) {
		this.categories = categories;
	}

	public void setBanners(List<Banner> banners) {
		this.banners = banners;
	}

}
