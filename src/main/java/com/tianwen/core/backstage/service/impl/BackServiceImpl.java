package com.tianwen.core.backstage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianwen.common.util.JsonResponseResult;
import com.tianwen.common.util.SysUtil;
import com.tianwen.core.backstage.dao.BackDao;
import com.tianwen.core.backstage.dto.CategoryDto;
import com.tianwen.core.backstage.entity.Banner;
import com.tianwen.core.backstage.entity.Product;
import com.tianwen.core.backstage.service.BackService;

@Service
public class BackServiceImpl implements BackService{
	
	@Autowired
	private BackDao backDao;

	@Override
	public JsonResponseResult addNewCategory(CategoryDto dto) {
		
		int maxSort = backDao.findCategoryMaxSort();
		
		if(SysUtil.isEmpty(maxSort)) {
			maxSort = 1; 
		}else{
			if(dto.getSort() <= maxSort) return JsonResponseResult.createFalied("排序序号必须大于现有的最大序号");
		}
		
		dto.setCreatetime(SysUtil.getTime());
		
		backDao.addNewCategory(dto);
		
		return JsonResponseResult.createSuccess();
	}

	@Override
	public List<CategoryDto> findAllCategories() {
		return backDao.findAllCategories();
	}
	
	
	

	@Override
	public JsonResponseResult addNewProduct(Product product) {
		
		backDao.addNewProduct(product);
		
		return JsonResponseResult.createSuccess();
	}

	@Override
	public List<Product> findAllProducts() {
		return null;
	}

	@Override
	public List<Banner> findAllBanners() {
		// TODO Auto-generated method stub
		return null;
	}

}
