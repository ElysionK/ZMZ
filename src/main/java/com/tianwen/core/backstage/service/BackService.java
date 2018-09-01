package com.tianwen.core.backstage.service;

import java.util.List;

import com.tianwen.base.util.Pager;
import com.tianwen.common.util.JsonResponseResult;
import com.tianwen.core.backstage.dto.CategoryDto;
import com.tianwen.core.backstage.dto.ProductCondition;
import com.tianwen.core.backstage.entity.Banner;
import com.tianwen.core.backstage.entity.Product;

public interface BackService {

	JsonResponseResult addNewCategory(CategoryDto dto);
	
	List<CategoryDto> findAllCategories();
	
	Pager findAllProducts(ProductCondition condition, String pageNo);
	
	JsonResponseResult addNewProduct(Product product);
	
	List<Banner> findAllBanners();

	JsonResponseResult addNewBanner(Banner banner);

	JsonResponseResult updCategorySort(List<CategoryDto> categories);

	JsonResponseResult updCategory(CategoryDto dto);

	JsonResponseResult updBannerSort(List<Banner> banners);

	JsonResponseResult updBanner(Banner banner);

}
