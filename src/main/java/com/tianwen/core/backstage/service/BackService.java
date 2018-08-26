package com.tianwen.core.backstage.service;

import java.util.List;

import com.tianwen.common.util.JsonResponseResult;
import com.tianwen.core.backstage.dto.CategoryDto;
import com.tianwen.core.backstage.entity.Banner;
import com.tianwen.core.backstage.entity.Product;

public interface BackService {

	JsonResponseResult addNewCategory(CategoryDto dto);
	
	List<CategoryDto> findAllCategories();
	
	List<Product> findAllProducts();

	JsonResponseResult addNewProduct(Product product);
	
	List<Banner> findAllBanners();
	
}
