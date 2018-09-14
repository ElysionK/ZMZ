package com.tianwen.core.backstage.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.tianwen.core.backstage.dto.CategoryDto;
import com.tianwen.core.backstage.dto.OnlineOrderDto;
import com.tianwen.core.backstage.entity.Banner;
import com.tianwen.core.backstage.entity.Product;
import com.tianwen.core.backstage.entity.RegistCode;
import com.tianwen.core.backstage.entity.TOfflineOrder;

@Repository
public interface BackDao {
	
	int findCategoryMaxSort();
	
	int addNewCategory(@Param("category") CategoryDto dto);
	
	List<CategoryDto> findAllCategories();
	
	Integer addNewProduct(@Param("product") Product product);

	Integer countAllProducts(HashMap<String, Object> map);
	
	List<Product> findAllProducts(HashMap<String, Object> map);

	List<Banner> findAllBanners();

	int findBannerMaxSort();

	int addNewBanner(@Param("banner") Banner banner);

	int updCategorySort(@Param("categories") List<CategoryDto> categories);

	Integer updCategory(@Param("category") CategoryDto dto);

	void updBannerSort(@Param("banners") List<Banner> banners);

	void updBanner(@Param("banner") Banner banner);

	int countAllRegistCode(HashMap<String, Object> param);
	
	int addRegistCode(@Param("codes") List<RegistCode> codes);

	List<RegistCode> findAllRegistCode(HashMap<String, Object> param);

	RegistCode findByCodeAndStatus(@Param("code") String registCode, @Param("status") int status);

	Integer updRegistCode(@Param("code") RegistCode updRegistCode);

	int countOfflineOrder(HashMap<String, Object> param);

	List<TOfflineOrder> listOfflineOrder(HashMap<String, Object> param);

	void addOfflineOrderList(@Param("orders") List<TOfflineOrder> orders);

	void updOfflineOrder(@Param("order") TOfflineOrder order);

	int countOnlineOrder(HashMap<String, Object> param);

	List<OnlineOrderDto> listOnlineOrder(HashMap<String, Object> param);

	OnlineOrderDto findOnlineOrderDtoByOid(@Param("oid") Integer oid);

	void delOfflineOrderById(@Param("id") Integer id);
	
}
