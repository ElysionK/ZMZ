package com.tianwen.core.backstage.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianwen.base.util.Pager;
import com.tianwen.common.util.JsonResponseResult;
import com.tianwen.common.util.SysUtil;
import com.tianwen.common.util.SysUtils;
import com.tianwen.core.backstage.dao.BackDao;
import com.tianwen.core.backstage.dto.CategoryDto;
import com.tianwen.core.backstage.dto.ProductCondition;
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
		product.setCreateTime(SysUtil.getTime());
		backDao.addNewProduct(product);
		
		return JsonResponseResult.createSuccess();
	}

	@Override
	public Pager findAllProducts(ProductCondition condition, String pageNo) {
		Pager pager = new Pager();
		HashMap<String, Object> param = SysUtils.transBean2Map(condition);
		pager.setPageNo(pageNo);
		pager.setTotalRows(param, backDao.countAllProducts(param));
		List<Product> list = backDao.findAllProducts(param);
		pager.setList(list);
		return pager;
	}

	public List<Banner> findAllBanners() {
		// TODO Auto-generated method stub
		return null;
	}

}
