package com.tianwen.core.index.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianwen.core.backstage.dao.BackDao;
import com.tianwen.core.backstage.dto.CategoryDto;
import com.tianwen.core.backstage.entity.Banner;
import com.tianwen.core.index.dto.IndexDto;
import com.tianwen.core.index.service.IndexService;

@Service
public class IndexServiceImpl implements IndexService {
	
	@Autowired
	private BackDao backDao;

	@Override
	public IndexDto getIndexDto() {
		IndexDto indexDto = new IndexDto();
		List<CategoryDto> categories = backDao.findAllCategories();
		List<Banner> banners = backDao.findAllBanners();
		
		indexDto.setCategories(categories);
		indexDto.setBanners(banners);
		
		return indexDto;
	}

}
