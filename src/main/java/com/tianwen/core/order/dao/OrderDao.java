package com.tianwen.core.order.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.tianwen.core.backstage.entity.Product;
import com.tianwen.core.order.dto.AddressDto;
import com.tianwen.core.order.dto.CartDto;
import com.tianwen.core.order.dto.OrderDto;
import com.tianwen.core.order.entity.Address;
import com.tianwen.core.order.entity.Cart;
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
	
	Cart findCartByPid(@Param("pid") Integer pid, @Param("mid") Integer mid);
	
	List<Cart> findMembersCarts(Integer mid);
	
	List<CartDto> findMembersCartsDetail(Integer mid);
	
	void updCartByCid(Cart cart);
	
	void addCart(Cart cart);
	
	void updCartChecked(HashMap<String, Object> map);
	
	void delCartByCid(List<Integer> list);
	
	List<Address> findMembersAddress(Integer mid);
	
	Address findMemberAddressById(Integer id);
	
	void addNewAddress(HashMap<String, Object> map);
	
	void delAddress(Integer id);
	
	void updAddress(Address address);
	
	void updDefaultAdd(Integer mid);
	
	void doConfirmOrder(HashMap<String, Object> map);

}
