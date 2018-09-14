package com.tianwen.core.backstage.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.tianwen.base.util.Pager;
import com.tianwen.common.util.JsonResponseResult;
import com.tianwen.core.backstage.dto.CategoryDto;
import com.tianwen.core.backstage.dto.OfflineOrderCondition;
import com.tianwen.core.backstage.dto.OnlineOrderCondition;
import com.tianwen.core.backstage.dto.OnlineOrderDto;
import com.tianwen.core.backstage.dto.ProductCondition;
import com.tianwen.core.backstage.dto.RegistCodeCondition;
import com.tianwen.core.backstage.entity.Banner;
import com.tianwen.core.backstage.entity.Product;
import com.tianwen.core.backstage.entity.TOfflineOrder;
import com.tianwen.core.order.entity.Order;

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

	JsonResponseResult findAllRegistCode(String pageNo, RegistCodeCondition condition);

	JsonResponseResult addRegistCode(Integer codeCount);

	JsonResponseResult listOfflineOrder(String pageNo, OfflineOrderCondition condition);

	JsonResponseResult addOfflineOrderList(MultipartFile mainFile) throws IOException;

	JsonResponseResult updOfflineOrder(TOfflineOrder order);

	JsonResponseResult listOnlineOrder(String pageNo, OnlineOrderCondition condition);

	OnlineOrderDto findOrderDtoByOid(Integer oid);

	JsonResponseResult delOfflineOrderById(Integer id);


}
