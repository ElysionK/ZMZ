package com.tianwen.core.order.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.tianwen.core.backstage.entity.Product;
import com.tianwen.core.order.dto.AddressDto;
import com.tianwen.core.order.dto.OrderDto;
import com.tianwen.core.order.entity.Order;
import com.tianwen.core.order.entity.OrderSub;

@Repository
public interface OrderDao {
	
	List<Product> findAllProducts();
	
	Product findProductByPid(Integer pid);
	
	Integer addNewOrder(Order order);
	
	void addNewOrderSub(@Param("list") List<OrderSub> orderSub);
	
	List<OrderDto> findOrderInfoByOid(Integer oid);
	
	AddressDto findAddressById(Integer id);
	
	void updateOrder(Order order);
	
}
