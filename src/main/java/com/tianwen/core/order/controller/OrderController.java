package com.tianwen.core.order.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tianwen.base.controller.BaseController;
import com.tianwen.common.util.JsonResponseResult;
import com.tianwen.core.backstage.entity.Product;
import com.tianwen.core.order.dto.CartDto;
import com.tianwen.core.order.dto.OrderDetailDto;
import com.tianwen.core.order.entity.Address;
import com.tianwen.core.order.entity.Cart;
import com.tianwen.core.order.entity.Order;
import com.tianwen.core.order.service.OrderService;

@Scope("prototype")
@Controller
@RequestMapping(value = "/order")
public class OrderController extends BaseController{
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping(value = "/index")
	public ModelAndView toIndex(){
		return new ModelAndView("/order/index");
	}
	
	@PostMapping(value = "/ajaxLoadData")
	@ResponseBody
	public JsonResponseResult ajaxLoadData(){
		JsonResponseResult result = JsonResponseResult.createSuccess();
		Integer mid = 1;
		List<Product> products = orderService.findAllProducts();
		List<Cart> carts = orderService.findMembersCarts(mid);
		
		List<HashMap<String, Object>> categories = products.stream().map(product -> {
			HashMap<String, Object> map = new HashMap<>();
			map.put("id", product.getCategory());
			map.put("name", product.getCategoryName());
			return map;
		}).distinct().collect(Collectors.toList());
		
		List<Integer> temp = new ArrayList<>();
		List<HashMap<String, Object>> list = new ArrayList<>();
		List<Product> tempPro = null;
		for (int i = 0; i < products.size(); i++) {
			Integer key = products.get(i).getCategory();
			if(!temp.contains(key)){
				HashMap<String, Object> map = new HashMap<>();
				tempPro = new ArrayList<>();
				map.put("title", products.get(i).getCategoryName());
				map.put("product", tempPro);
				list.add(map);
				temp.add(key);
			}
			tempPro.add(products.get(i));
		}
		
		result.addData(list);
		result.addData(categories);
		result.addData(carts);
		
		return result;
	}
	
	@PostMapping(value = "/addNewOrder")
	@ResponseBody
	public JsonResponseResult addNewOrder(@RequestBody HashMap<String, Object> map){
		JsonResponseResult result = JsonResponseResult.createSuccess();
		
		Integer oid = orderService.addNewOrder(map);
		result.addData(oid);
		
		return result;
	}
	
	/**
	 * id是地址ID, 直接过来是0选默认地址 从地址选过来带地址主键
	 * @param oid
	 * @return
	 */
	@GetMapping(value = "/confirm/{oid}/{id}")
	public ModelAndView toConfirm(@PathVariable(name = "oid") Integer oid, @PathVariable(name = "id") Integer id){
		Integer mid = 1;
		OrderDetailDto dto = orderService.findOrderDetail(oid, id, mid);
		ModelAndView mView = new ModelAndView();
		mView.addObject("data", dto);
		mView.addObject("oid", oid);
		mView.setViewName("/order/confirm");
		return mView;
	}
	
	@PostMapping(value = "/confirmOrder")
	@ResponseBody
	public JsonResponseResult confirmOrder(Order order){
		order.setStatus(2);
		orderService.confirmOrder(order);
		return JsonResponseResult.createSuccess();
	}
	
	@PostMapping(value = "/addCart")
	@ResponseBody
	public JsonResponseResult addCart(@RequestBody HashMap<String, Object> map){
		Integer mid = 1;
		Integer pid = Integer.parseInt(map.get("pid").toString());
		Integer count = Integer.parseInt(map.get("count").toString());
		orderService.addCart(mid, pid, count);
		return JsonResponseResult.createSuccess();
	}
	
	@GetMapping(value = "/toCart")
	public ModelAndView toCart(){
		Integer mid = 1;
		List<CartDto> carts = orderService.findMembersCartsDetail(mid);
		return new ModelAndView("/order/cart", "data", carts);
	}
	
	@PostMapping(value = "/updCartChecked")
	@ResponseBody
	public JsonResponseResult updCartChecked(@RequestBody HashMap<String, Object> map){
		Integer mid = 1;
		map.put("mid", mid);
		orderService.updCartChecked(map);
		return JsonResponseResult.createSuccess();
	}
	
	@GetMapping(value = "/toAddress/{oid}")
	public ModelAndView toAddress(@PathVariable(name = "oid") Integer oid){
		Integer mid = 1;
		List<Address> addresses = orderService.findMemberAddress(mid);
		ModelAndView mView = new ModelAndView();
		mView.addObject("data", addresses);
		mView.addObject("oid", oid);
		mView.setViewName("/order/addresses");
		return mView;
	}
	
	@GetMapping(value = "/toAddAddress/{oid}")
	public ModelAndView toAddAddress(@PathVariable(name = "oid") Integer oid){
		return new ModelAndView("/order/addNewadd", "oid", oid);
	}
	
	@PostMapping(value = "/addNewAddress")
	@ResponseBody
	public JsonResponseResult addNewAddress(@RequestBody HashMap<String, Object> map){
		Integer mid = 1;
		map.put("mid", mid);
		map.put("isDefault", 0);
		orderService.addNewAddress(map);
		return JsonResponseResult.createSuccess();
	}
	
	@PostMapping(value = "/updDefault")
	@ResponseBody
	public JsonResponseResult updDefault(@RequestBody HashMap<String, Object> map){
		Integer mid = 1;
		Integer cid = Integer.parseInt(map.get("id").toString());
		Address address = new Address();
		address.setId(cid);
		address.setIsDefault(1);
		orderService.updDefaultAdd(address, mid);
		return JsonResponseResult.createSuccess();
	}
	
	@PostMapping(value = "/delAddress")
	@ResponseBody
	public JsonResponseResult delAddress(@RequestBody HashMap<String, Object> map){
		Integer id = Integer.parseInt(map.get("id").toString());
		orderService.delAddress(id);
		return JsonResponseResult.createSuccess();
	}
	
	@GetMapping(value = "/toModifyAddress/{oid}/{id}")
	public ModelAndView toModifyAddress(@PathVariable(name = "oid") Integer oid, @PathVariable(name = "id") Integer id){
		Address addresses = orderService.findMemberAddressById(id);
		ModelAndView mView = new ModelAndView();
		mView.addObject("data", addresses);
		mView.addObject("oid", oid);
		mView.setViewName("/order/modifyAddress");
		return mView;
	}
	
	@PostMapping(value = "/updAddress")
	@ResponseBody
	public JsonResponseResult updAddress(@RequestBody HashMap<String, Object> map){
		orderService.updAddress(map);
		return JsonResponseResult.createSuccess();
	}
	
	@PostMapping(value = "/doConfirmOrder")
	@ResponseBody
	public JsonResponseResult doConfirmOrder(@RequestBody HashMap<String, Object> map){
		orderService.doConfirmOrder(map);
		return JsonResponseResult.createSuccess();
	}
}
