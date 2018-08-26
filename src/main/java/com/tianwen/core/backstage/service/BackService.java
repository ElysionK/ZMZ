package com.tianwen.core.backstage.service;

import java.util.List;

import com.tianwen.common.util.JsonResponseResult;
import com.tianwen.core.backstage.dto.CategoryDto;
<<<<<<< HEAD
import com.tianwen.core.backstage.entity.Banner;
=======
>>>>>>> f803b43d402831835b6cf7a762839d4cceee0543
import com.tianwen.core.backstage.entity.Product;

public interface BackService {

	JsonResponseResult addNewCategory(CategoryDto dto);
	
	List<CategoryDto> findAllCategories();
	
	List<Product> findAllProducts();

	JsonResponseResult addNewProduct(Product product);
	
<<<<<<< HEAD
	List<Banner> findAllBanners();
	
=======
>>>>>>> f803b43d402831835b6cf7a762839d4cceee0543
}
