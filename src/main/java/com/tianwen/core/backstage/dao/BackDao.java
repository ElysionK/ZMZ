package com.tianwen.core.backstage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.tianwen.core.backstage.dto.CategoryDto;
import com.tianwen.core.backstage.entity.Product;

@Repository
public interface BackDao {
	
	int findCategoryMaxSort();
	
	int addNewCategory(@Param("category") CategoryDto dto);
	
	List<CategoryDto> findAllCategories();
	
	Integer addNewProduct(Product product);
	
}
