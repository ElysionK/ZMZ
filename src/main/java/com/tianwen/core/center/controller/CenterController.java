package com.tianwen.core.center.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tianwen.base.controller.BaseController;
import com.tianwen.common.util.JsonResponseResult;
import com.tianwen.core.center.dto.CenterDto;
import com.tianwen.core.center.service.CenterService;
import com.tianwen.core.order.entity.Order;

@Scope("prototype")
@Controller
@RequestMapping(value = "center")
public class CenterController extends BaseController {

	@Autowired
	private CenterService centerService;

	@GetMapping(value = "/index")
	public ModelAndView toCenterIndex() {
		// TODO 需要通过 session 获取 userId
		Integer userId = 1;
		CenterDto dto = centerService.findCenterDto(userId);
		return new ModelAndView("/center/index", "data", dto);
	}

	@GetMapping(value = "/onlineOrder")
	public ModelAndView toOnlineOrder() {
		// TODO 需要通过 session 获取 userId
		Integer userId = 1;
		List<Order> onlineOrders = centerService.listOnlineOrders(userId);
		return new ModelAndView("/center/online_order");
	}
	
	@GetMapping(value = "/toDetail/onlineOrder/{oid}")
	public ModelAndView toOnlineOrder(@PathVariable Integer oid) {
		Order order = centerService.findOrderByOid(oid);
		return new ModelAndView("/center/order_detail", "order", order);
	}
	
	@PostMapping(value = "/onlineOrderDetail/{oid}", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public JsonResponseResult ajaxLoadRegistCode(@PathVariable Integer oid) {
		return centerService.listOrderSubDetailByOid(oid);
	}
	
	
	
}
