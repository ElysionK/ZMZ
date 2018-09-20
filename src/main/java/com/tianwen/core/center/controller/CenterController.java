package com.tianwen.core.center.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tianwen.base.controller.BaseController;
import com.tianwen.common.SysConstant;
import com.tianwen.core.backstage.dto.OnlineOrderDetail;
import com.tianwen.core.backstage.entity.TOfflineOrder;
import com.tianwen.core.center.dto.CenterDto;
import com.tianwen.core.center.dto.OfflineOrderDto;
import com.tianwen.core.center.service.CenterService;
import com.tianwen.core.order.entity.Order;
import com.tianwen.core.user.entity.User;

@Scope("prototype")
@Controller
@RequestMapping(value = "center")
public class CenterController extends BaseController {

	@Autowired
	private CenterService centerService;

	@GetMapping(value = "/index")
	public ModelAndView toCenterIndex() {
		// TODO 需要通过 session 获取 userId
		User user = (User) super.getSession().getAttribute(SysConstant.SYS_MEMBER_LOG_SUCC_INFO);
		CenterDto dto = centerService.findCenterDto(user);
		return new ModelAndView("/center/index", "data", dto);
	}

	@GetMapping(value = "/onlineOrder")
	public ModelAndView toOnlineOrder() {
		User user = (User) super.getSession().getAttribute(SysConstant.SYS_MEMBER_LOG_SUCC_INFO);	
		List<Order> orders = centerService.listOnlineOrders(user.getId());
		return new ModelAndView("/center/online_order", "data", orders);
	}
	
	@GetMapping(value = "/toDetail/onlineOrder/{oid}")
	public ModelAndView onlineOrderDetail(@PathVariable Integer oid) {
		OnlineOrderDetail detail = centerService.findOnlineOrderDetailByOid(oid);
		return new ModelAndView("/center/online_order_detail", "data", detail);
	}
	
	@GetMapping(value = "/offlineOrder")
	public ModelAndView toOfflineOrder() {
		User user = (User) super.getSession().getAttribute(SysConstant.SYS_MEMBER_LOG_SUCC_INFO);	
		List<TOfflineOrder> orders = centerService.listOfflineOrders(user.getPhone());
		return new ModelAndView("/center/offline_order", "data", orders);
	}
	
	@GetMapping(value = "/toDetail/offlineOrder/{id}")
	public ModelAndView offlineOrderDetail(@PathVariable Integer id) {
		OfflineOrderDto order = centerService.findOfflineOrderDto(id);
		return new ModelAndView("/center/offline_order_detail", "order", order);
	}

	
	
	
}
