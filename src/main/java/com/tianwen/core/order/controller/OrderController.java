package com.tianwen.core.order.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tianwen.base.controller.BaseController;
import com.tianwen.common.util.JsonResponseResult;
import com.tianwen.core.backstage.entity.Product;
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
		List<Product> products = orderService.findAllProducts();
		
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
		
		return result;
	}
	
	@PostMapping(value = "/addNewOrder")
	@ResponseBody
	public JsonResponseResult addNewOrder(@RequestBody HashMap<String, Object> map){
		JsonResponseResult result = JsonResponseResult.createSuccess();
		
		orderService.addNewOrder(map);
		
		return result;
	}
	
}
